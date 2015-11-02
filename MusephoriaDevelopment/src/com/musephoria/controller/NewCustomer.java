package com.musephoria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.musephoria.helper.Helper;
import com.musephoria.util.Constants;
import com.musephoria.util.Types;
import com.musephoria.webserviceclient.OrderProcessServiceClient;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;

/**
 * Servlet implementing Registration for new customer functionality.
 */
public class NewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method that handles the registration of a new customer.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result;
		Customer accountInfo = new Customer();

		// Acquiring parameteres from the Register.jsp form

			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String sex = request.getParameter("sex");
			String userName = request.getParameter("usr");
			String password = request.getParameter("pwd");
			String rePassword = request.getParameter("repwd");
			String dateOfBirth = request.getParameter("dob");
			String address = request.getParameter("addr");
			String city = request.getParameter("city");
			String province = request.getParameter("prov");
			String country = request.getParameter("country");
			String zipCode = request.getParameter("zip");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
	
		// Checking if the re-typed password is same as the original password

		if (!password.equals(rePassword)) {
			request.setAttribute("message", "Passwords do not match, please enter a valid password");
			response.sendRedirect("Register.jsp");
		} else {
			accountInfo.setUserName(userName);
			accountInfo.setPassword(password);
			accountInfo.setCustomerName(firstName + StringUtils.SPACE + lastName);
			accountInfo.setDateOfBirth(Helper.FormatDate(dateOfBirth));
			accountInfo.setSex(sex);
			accountInfo.setAddress(address);
			accountInfo.setCity(city);
			accountInfo.setProvince(province);
			accountInfo.setCountry(country);
			accountInfo.setZipCode(zipCode);
			accountInfo.setEmail(email);
			accountInfo.setPhone(phone);
			accountInfo.setDefaultPaymentInfo(Types.PaymentInfo.Credit.toString());
			accountInfo.setIsCustomerActive(true);

			/*
			 * Invoking Customer DAO through Web Service(Order Process Service)
			 * create an account based on the information given by the customer.
			 * Returning a status message indicating if the user account was
			 * created successfully or not.
			 */
			OrderProcessServiceClient opc = new OrderProcessServiceClient();
			result = opc.createAccount(userName, accountInfo);

			if (result.equals(Constants.accountCreatedMessage)) {
				request.setAttribute("message", "Account Creation Successful,please login with your credentials");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Username Exists, Please select another username");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}

		}

	}
}
