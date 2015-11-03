package com.musephoria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.util.Constants;
import com.musephoria.webserviceclient.OrderProcessServiceClient;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;

/**
 * Servlet implementing Login functionality for the site
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method implementing the login functionality by accepting username and
	 * password from the user, and giving status messages based on the
	 * authentication
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer custObj = null;
		int custId;

		String username = request.getParameter(Constants.username);
		String password = request.getParameter(Constants.password);
		String checkusr = (String) request.getSession().getAttribute(Constants.username);

		try {
			if (checkusr == "" || checkusr == null) {
				/*
				 * Invoking Customer DAO through Web Service(Order Process
				 * Service) to get account information based on the username and
				 * password given by the user and returning result object
				 * containing the account information and authentication status
				 * message.
				 */

				OrderProcessServiceClient client = new OrderProcessServiceClient();
				Result resObj = client.getAccount(username, password, null);

				if (!resObj.equals(null)) {
					if (resObj.getStatusMessage().equals(Constants.userNamePasswordMismatch)) {
						request.setAttribute(Constants.message, Constants.userNamePasswordMismatch);
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					} else if (resObj.getStatusMessage().equals(Constants.userNameDoesntExist)) {
						request.setAttribute(Constants.message, Constants.userNameDoesntExist);
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					}

					else {
						if (!resObj.getResultList().equals(null)) {
							custObj = (Customer) resObj.getResultList();
							custId = custObj.getCustomerId();
							request.getSession().setAttribute(Constants.userOrVisitorFlag, 1);
							request.getSession().setAttribute(Constants.customerId, custId);
							request.getSession().setAttribute(Constants.customerObject, custObj);
							request.getSession().setAttribute(Constants.username, username);
							request.getSession().setAttribute(Constants.password, password);
							request.getRequestDispatcher("Home.jsp").forward(request, response);
						}
					}
				} else {

					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
}