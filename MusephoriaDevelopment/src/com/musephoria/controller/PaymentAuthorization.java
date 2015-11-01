package com.musephoria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.webserviceclient.*;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Paymentinfo;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Purchaseorder;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Shipping;

/**
 * Servlet implementation class PaymentAuthorization
 */
public class PaymentAuthorization extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentAuthorization() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void processPayment(HttpServletRequest request, HttpServletResponse response, Paymentinfo paymentInfo)
			throws ServletException, IOException {

		Purchaseorder purchaseOrder = new Purchaseorder();
		boolean paymentAuthorizationResult = false;
		OrderProcessServiceClient client = new OrderProcessServiceClient();
		Shipping shippingInfo = null;

		int purchaseOrderId = (int) request.getSession().getAttribute("resultPoId");
		purchaseOrder.setPurchaseOrderId(purchaseOrderId);

		paymentAuthorizationResult = client.confirmOrder(purchaseOrder, shippingInfo, paymentInfo);

		if (paymentAuthorizationResult) {
			request.getRequestDispatcher("PaymentSuccessful.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("PaymentFailure.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		Paymentinfo paymentInfo = new Paymentinfo();
		
		Object counter = request.getSession().getAttribute("counter");

		if (counter == null) {
			request.getSession().setAttribute("counter", 1);
		}
		
		int requestCounter = (int) request.getSession().getAttribute("counter");
		if (requestCounter % 5 != 0){
			paymentInfo.setPaymentInfoStatus("Accepted");
			requestCounter++;
			request.getSession().setAttribute("counter", requestCounter);
			processPayment(request, response, paymentInfo);
		}
		else{
			paymentInfo.setPaymentInfoStatus("Rejected");
			requestCounter++;
			request.getSession().setAttribute("counter", requestCounter);
			processPayment(request, response, paymentInfo);
		}
		
	}
		
}
