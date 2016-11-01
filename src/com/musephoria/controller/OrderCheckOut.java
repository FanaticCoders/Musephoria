package com.musephoria.controller;

import com.musephoria.util.Constants;
import com.musephoria.webserviceclient.OrderProcessServiceClient;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementing checkout option given in the cart
 */
public class OrderCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method implementing the checkout option when user decides to finally
	 * place an order
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int flag = (Integer) request.getSession().getAttribute(Constants.userOrVisitorFlag);
			Result resObj = null;
			if (flag == 0) {
				String message = "Please login first to Order";
				request.getSession().setAttribute(Constants.message, message);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				String username = (String) request.getSession().getAttribute(Constants.username);
				String password = (String) request.getSession().getAttribute(Constants.password);

				/*
				 * Invoking Customer DAO through Web Service(Order Process
				 * Service) to get account information based on the username and
				 * password given by the user and returning result object
				 * containing the account information and authentication status
				 * message.
				 */

				OrderProcessServiceClient opsc = new OrderProcessServiceClient();
				resObj = opsc.getAccount(username, password, null);
				if (!resObj.equals(null)) {

					Customer custObj = (Customer) resObj.getResultList();
					request.setAttribute("CustomerData", custObj);
					request.getRequestDispatcher("OrderCheckOut.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
