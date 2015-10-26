package com.musephoria.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.helper.Helper;
import com.musephoria.util.Constants;
import com.musephoria.util.Types;
import com.musephoria.webserviceclient.OrderProcessServiceClient;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;

/**
 * Servlet implementation class NewCustomer
 */
public class NewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		OrderProcessServiceClient opc = new OrderProcessServiceClient();
		String result;
		Customer accountInfo = new Customer();

		// Acquiring parameteres from the Register.jsp form.
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String sex = request.getParameter("sex");
		String usr = request.getParameter("usr");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");
		String addr = request.getParameter("addr");
		String city = request.getParameter("city");
		String prov = request.getParameter("prov");
		String country = request.getParameter("country");
		String zip = request.getParameter("zip");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		// Checking if the re-typed password is same as the original password
		if (!pwd.equals(repwd)) {
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("sex", sex);
			request.setAttribute("usr", usr);
			request.setAttribute("addr", addr);
			request.setAttribute("city", city);
			request.setAttribute("prov", prov);
			request.setAttribute("country", country);
			request.setAttribute("zip", zip);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			request.setAttribute("message", "Passwords do not match, please enter a valid password");
			out.println("Passwords do not match, please enter a valid password");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		} else {
			accountInfo.setUserName(usr);
			accountInfo.setPassword(pwd);
			accountInfo.setCustomerName(fname + lname);
			accountInfo.setDateOfBirth(Helper.FormatDate("1989/01/25"));
			accountInfo.setSex(sex);
			accountInfo.setAddress(addr);
			accountInfo.setCity(city);
			accountInfo.setProvince(prov);
			accountInfo.setCountry(country);
			accountInfo.setZipCode(zip);
			accountInfo.setEmail(email);
			accountInfo.setPhone(phone);
			accountInfo.setDefaultPaymentInfo(Types.PaymentInfo.Credit.toString());
			Date today = new Date();
			accountInfo.setTimeStamp(new Timestamp(today.getTime()));
			accountInfo.setIsCustomerActive(true);

			// Calling the client class for OrderProcess Web Service
			result = opc.createAccount(usr, accountInfo);
			if (result.equals(Constants.accountCreatedMessage)) {
				request.setAttribute("message", "Account Creation Successful,please login with your credentials");
				out.println("Account Creation Successful,please login with your credentials");
				request.getRequestDispatcher("Login.jsp").forward(request, response);

			} else {
				request.setAttribute("message", "Username Exists, Please select another username");
				out.println("Username Exists, Please select another username");
				request.getRequestDispatcher("Register.jsp").forward(request, response);

			}

		}
	}
}
