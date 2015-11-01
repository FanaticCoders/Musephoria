package com.musephoria.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.musephoria.webserviceclient.ProductCatalogServiceClient;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.*;

/**
 * Servlet implementation class PlaceOrder
 */
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ShoppingCart myCart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
		Purchaseorder po = new Purchaseorder();
		Customer cust = new Customer();
		int resultPoId = 0;
		int customerId = (int)request.getSession().getAttribute("custId");
		
		cust.setCustomerId(customerId);
		
		List<Cd> temp = myCart.getCdList();
		List<Integer> cdIdList = new ArrayList<Integer>();
		
		Iterator<Cd> looper = temp.iterator();
		
		while(looper.hasNext()){
			cdIdList.add(looper.next().getCdId());
		}
		
		po.setCustomer(cust);
		po.setTotalQuantity(myCart.totalQuantity);
		po.setTotalPrice(myCart.totalPrice);
		po.setTaxes(myCart.tax);
		po.setPurchaseOrderStatus("Ordered");
		
		
		Shipping shippingInfo = new Shipping();
		
		shippingInfo.setAddress(request.getParameter("address"));
		shippingInfo.setCity(request.getParameter("city"));
		shippingInfo.setProvince(request.getParameter("province"));
		shippingInfo.setCountry(request.getParameter("country"));
		shippingInfo.setZipCode(request.getParameter("zip"));
		shippingInfo.setPurchaseorder(po);
		shippingInfo.setPhone(request.getParameter("phone"));
		shippingInfo.setIsShippingActive(true);
		
		
		OrderProcessServiceClient client = new OrderProcessServiceClient();
		resultPoId = client.createOrder(cdIdList, po, shippingInfo);
		request.getSession().setAttribute("resultPoId", resultPoId);
		
		PrintWriter out = response.getWriter();
		out.print(resultPoId);
		
		request.setAttribute("purchaseOrderId", resultPoId);
		
		request.getRequestDispatcher("Payment.jsp").forward(request, response);
		
		
	}

}
