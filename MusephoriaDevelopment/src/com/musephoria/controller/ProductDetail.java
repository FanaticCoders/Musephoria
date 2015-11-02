package com.musephoria.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.webserviceclient.ProductCatalogServiceClient;

/**
 * Servlet to fetch the product info based on the selected product's cdId.
 */
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method to fetch the product info based on the selected product's cdId.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

}
