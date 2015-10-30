package com.musephoria.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.dao.CdHome;
import com.musephoria.webserviceclient.ProductCatalogServiceClient;

/**
 * Servlet implementation class ProductDetail
 */
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetail() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		int cdId = Integer.parseInt(request.getParameter("cdId"));
		
		int flag = (int) request.getSession().getAttribute("flag");
		PrintWriter out = response.getWriter();
		
		out.println(flag);

		ProductCatalogServiceClient client = new ProductCatalogServiceClient();
		// Adding Cd into a session object corresponding to it's cdID
		request.getSession().setAttribute("cddetail", client.getProductInfo(cdId));
		
		request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);

		/*
		 * request.setAttribute("cddetail", cdob.getProductInfo(cdId));
		 * response.sendRedirect("ProductDetail.jsp");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

	}

}
