package com.musephoria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.musephoria.webserviceclient.ProductCatalogServiceClient;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductCatalogServiceClient client = new ProductCatalogServiceClient();

		Cd[] resObj  = client.getProductList(StringUtils.EMPTY);

		if (!resObj.equals(null)) {
			request.setAttribute("Product", resObj);
			request.getRequestDispatcher("Product.jsp").forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
