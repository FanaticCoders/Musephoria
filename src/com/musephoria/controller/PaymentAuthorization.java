package com.musephoria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.util.Constants;
import com.musephoria.webserviceclient.*;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Paymentinfo;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Purchaseorder;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Shipping;

/**
 * Servlet implementing Payment Authorization functionality for the site.
 */
public class PaymentAuthorization extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method that is used to finalize a purchase order and category specified
	 * otherwise displays the list of products based on the specified category.
	 * @param request
	 * @param response
	 * @param paymentInfo
	 * @throws ServletException
	 * @throws IOException
	 */

	private void processPayment(HttpServletRequest request, HttpServletResponse response, Paymentinfo paymentInfo)
			throws ServletException, IOException {

		Purchaseorder purchaseOrder = new Purchaseorder();
		boolean paymentAuthorizationResult = false;
		OrderProcessServiceClient client = new OrderProcessServiceClient();
		Shipping shippingInfo = null;

		int purchaseOrderId = (int) request.getSession().getAttribute(Constants.purchaseOrderId);
		purchaseOrder.setPurchaseOrderId(purchaseOrderId);

		/*
		 * Invoking Purchase Order DAO through Web Service(Order Process
		 * Service) to get the confirmation of the payment based on the payment
		 * info given by the user and returning result object containing the
		 * authentication status message.
		 */

		paymentAuthorizationResult = client.confirmOrder(purchaseOrder, shippingInfo, paymentInfo);

		if (paymentAuthorizationResult) {
			request.getSession().removeAttribute(Constants.shoppingCart);
			request.getSession().removeAttribute(Constants.cartItem);
			request.getSession().removeAttribute(Constants.totalCartPrice);
			request.getSession().setAttribute(Constants.paymentStatus, Constants.successMessage);
			response.sendRedirect("PaymentStatus.jsp");

		} else {
			request.getSession().setAttribute(Constants.paymentStatus, Constants.errorMessage);
			response.sendRedirect("PaymentStatus.jsp");
		}

	}

	/**
	 * Method that gets invoked when user enters his payment details and returns
	 * the success or failure of a payment based on the authentication message
	 * received from the Purchase Order DAO
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Paymentinfo paymentInfo = new Paymentinfo();

		Object counter = request.getSession().getAttribute(Constants.paymentCounter);

		if (counter == null) {
			request.getSession().setAttribute(Constants.paymentCounter, 1);
		}
		/**
		 * Handling of hard coding the 5th request to be rufused on the website
		 */

		int requestCounter = (int) request.getSession().getAttribute(Constants.paymentCounter);
		if (requestCounter % 5 != 0) {
			paymentInfo.setPaymentInfoStatus("Approved");
			requestCounter++;
			request.getSession().setAttribute(Constants.paymentCounter, requestCounter);
			processPayment(request, response, paymentInfo);
		} else {
			paymentInfo.setPaymentInfoStatus("Rejected");
			requestCounter++;
			request.getSession().setAttribute(Constants.paymentCounter, requestCounter);
			processPayment(request, response, paymentInfo);
		}

	}

}
