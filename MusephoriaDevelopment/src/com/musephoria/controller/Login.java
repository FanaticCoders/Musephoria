package com.musephoria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.util.Constants;
import com.musephoria.webserviceclient.*;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer custObj = null;
		int custId;
		
		String username = request.getParameter("username");		
		String password= (String) request.getParameter("password");
		String checkusr= (String) request.getSession().getAttribute("username");
		try {
		if (checkusr=="" || checkusr==null){
		
		OrderProcessServiceClient client = new OrderProcessServiceClient();
		Result resObj = client.getAccount(username, password, null);
		if(!resObj.equals(null)){
		 if (resObj.getStatusMessage().equals(Constants.userNamePasswordMismatch)){
			 request.getSession().setAttribute("Message",Constants.userNamePasswordMismatch);
			 request.getRequestDispatcher("Login.jsp").forward(request, response);
		 }
		
		 else if (resObj.getStatusMessage().equals(Constants.userNameDoesntExist)){
		 		 request.getSession().setAttribute("Message",Constants.userNameDoesntExist);
		     	 request.getRequestDispatcher("Login.jsp").forward(request, response);
		 }
		 
		 
		 else {   
			 custObj = (Customer) resObj.getResultList();			 
			 custId=custObj.getCustomerId();
			 request.getSession().setAttribute("custId",custId);
             request.getSession().setAttribute("username", username);
             request.getSession().setAttribute("password", password);
			 request.getRequestDispatcher("Home.jsp").forward(request, response);
		 }
		}
		else{
			
			 request.getRequestDispatcher("Home.jsp").forward(request, response);
	     	}
		}
	}	
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
			
 }
}