package com.musephoria.controller;


import com.musephoria.shoppingcart.ShoppingCart;
import com.musephoria.webserviceclient.OrderProcessServiceClient;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class OrderCheckOut
 */
public class OrderCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCheckOut() {
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
		try{
			int flag = (Integer)request.getSession().getAttribute("flag");
	        Result resObj = null;
	        if (flag == 0) {
	            String message = "Please login first to Order";
	            request.getSession().setAttribute("Message",message);
	            request.getRequestDispatcher("Login.jsp").forward(request, response);
	            } 
	        else {
	            String username = (String)request.getSession().getAttribute("username");
	            String password = (String)request.getSession().getAttribute("password");
	            OrderProcessServiceClient opsc = new OrderProcessServiceClient();
	            resObj = opsc.getAccount(username, password, null);
	            if(!resObj.equals(null)){
	            	
	            Customer custObj = (Customer) resObj.getResultList();
	            request.setAttribute("CustomerData", custObj);
	           /* ShoppingCart cartItem = (ShoppingCart)request.getSession().getAttribute("ShoppingCart");
	            Float totalCartPrice = (Float)request.getSession().getAttribute("totalCartPrice");
	            request.getSession().setAttribute("cartItem", cartItem);
	            request.getSession().setAttribute("totalCartPrice", totalCartPrice);*/
	            request.getRequestDispatcher("OrderCheckOut.jsp").forward(request, response);
	             }
	           }
			}
			 catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	    }
	}


