package com.musephoria.controller;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.webserviceclient.OrderProcessServiceStub.*;
import javafx.scene.control.Alert;

import javax.servlet.RequestDispatcher;
import com.musephoria.util.Constants;
import com.musephoria.webserviceclient.*;
//import com.musephoria.RegisterDAO // CreateAccount web service has to be called in this.

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		OrderProcessServiceClient opc = new OrderProcessServiceClient();
		String result;
		Customer cust = new Customer();
		Customerdetail custdet = new Customerdetail();
		
		
		// Acquiring parameteres from the Register.jsp form.		
		String fname =request.getParameter("fname");
		String lname =request.getParameter("lname");
		String sex =request.getParameter("sex");
		String usr =request.getParameter("usr");
		String pwd =request.getParameter("pwd");
		String repwd =request.getParameter("repwd");
		String addr =request.getParameter("addr");
		String city =request.getParameter("city");
		String prov =request.getParameter("prov");
		String country =request.getParameter("country");
		String zip=request.getParameter("zip");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		//Checking if the re-typed password is same as the original password
		if(pwd=="" || pwd!=repwd)
		{
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
			 request.setAttribute("message","Passwords do not match, please enter a valid password");
			 out.println("Passwords do not match, please enter a valid password");
			 request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		else
		{	// Creating customer and customerdetail objects with the details provided by the new customer.
			custdet.setCustomerName( fname+lname );
			cust.setSex(sex);
			cust.setUserName(usr);
			cust.setPassword(pwd);
			custdet.setAddress(addr);
			custdet.setCity(city);
			custdet.setProvince(prov);
			custdet.setCountry(country);
			custdet.setZipCode(zip);
			custdet.setEmail(email);
			custdet.setPhone(phone);
			// Calling the client class for OrderProcess Web Service
			result = opc.createAccount(usr, cust, custdet);
			if(result == Constants.successMessage)
			{
				request.setAttribute("message","Account Creation Successful,please login with your credentials");
				out.println("Account Creation Successful,please login with your credentials");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				
			}
			else
			{
				request.setAttribute("message","Username Exists, Please select another username");
				out.println("Username Exists, Please select another username");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				
			}
			
		}
		
	}

}
