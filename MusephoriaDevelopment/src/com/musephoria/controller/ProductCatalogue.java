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
import com.musephoria.dao.*;
import com.musephoria.entity.*;

/**
 * Servlet implementation class ProductCatalogue
 */
public class ProductCatalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCatalogue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Cd> resobj;
		
		CdHome cdhome = new CdHome();
		
		/*if(request.getParameter("genre").equals(""))
		{
			resobj = cdhome.getProductList("");
			
		}
		else
		{
			genre=request.getParameter("genre");
			resobj = cdhome.getProductList("genre");
		}*/
		
		
		resobj = cdhome.getProductList("");
		
		if(!resobj.isEmpty()){
			request.setAttribute("Product", resobj);
			//System.out.println(resobj.get(0).getName());
			
		}
		
		/*Iterator<Cd> looper = resobj.iterator();
		while(looper.hasNext()){
			out.println(looper.next().getName());
		}*/
		
	
		request.getRequestDispatcher("Product.jsp").forward(request, response);
		
		//response.sendRedirect("Product.jsp");
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
