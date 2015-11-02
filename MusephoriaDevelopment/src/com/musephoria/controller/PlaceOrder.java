package com.musephoria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.shoppingcart.ShoppingCart;
import com.musephoria.webserviceclient.OrderProcessServiceClient;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Purchaseorder;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Shipping;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;

/**
 * Servlet implementing the functionality of creating a purchase order.
 */
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method that is used to create a purchase order after the user has viewed
	 * the order summary as well as provided\confirmed his shipping details
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ShoppingCart myCart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
		Purchaseorder po = new Purchaseorder();
		Customer cust = new Customer();
		int resultPoId = 0;
		cust = (Customer) request.getSession().getAttribute("custObject");

		List<Cd> temp = myCart.getCdList();
		List<Integer> cdIdList = new ArrayList<Integer>();

		Iterator<Cd> looper = temp.iterator();

		while (looper.hasNext()) {
			cdIdList.add(looper.next().getCdId());
		}

		// populating purchase order object -po with the collected cart details.

		po.setCustomer(cust);
		po.setTotalQuantity(myCart.totalQuantity);
		po.setTotalPrice(myCart.totalPrice);
		po.setTaxes(myCart.tax);
		po.setPurchaseOrderStatus("Ordered");

		Shipping shippingInfo = new Shipping();

		// populating the shipping information object with the collected
		// shipping details.

		shippingInfo.setAddress(request.getParameter("address"));
		shippingInfo.setCity(request.getParameter("city"));
		shippingInfo.setProvince(request.getParameter("province"));
		shippingInfo.setCountry(request.getParameter("country"));
		shippingInfo.setZipCode(request.getParameter("zip"));
		shippingInfo.setPurchaseorder(po);
		shippingInfo.setPhone(request.getParameter("phone"));
		shippingInfo.setIsShippingActive(true);

		OrderProcessServiceClient client = new OrderProcessServiceClient();

		/*
		 * Invoking Order Creation DAO through web service (Order Process
		 * Service). This returns a resultant unique Purchase Order ID which
		 * sets up association with Customer and Purchase Order Item details.
		 */
		
		resultPoId = client.createOrder(cdIdList, po, shippingInfo);

		request.getSession().setAttribute("resultPoId", resultPoId);
		request.setAttribute("purchaseOrderId", resultPoId);

		request.getRequestDispatcher("Payment.jsp").forward(request, response);

	}

}
