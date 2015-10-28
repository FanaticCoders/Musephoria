package com.musephoria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musephoria.dao.CdHome;

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

		CdHome cdob = new CdHome();
		// Adding Cd into a session object corresponding to it's cdID
		request.getSession().setAttribute("cddetail", cdob.getProductInfo(cdId));
		request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
		
		/*request.setAttribute("cddetail", cdob.getProductInfo(cdId));
		response.sendRedirect("ProductDetail.jsp");*/
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	}

}
