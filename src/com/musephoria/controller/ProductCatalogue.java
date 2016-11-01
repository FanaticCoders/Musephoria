package com.musephoria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.musephoria.util.Constants;
import com.musephoria.webserviceclient.ProductCatalogServiceClient;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;

/**
 * Product Catalogue servlet for fetching the list of all products if no
 * category specified otherwise displays the list of products based on the
 * specified category.
 */
public class ProductCatalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method to fetch the list of products.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cd[] resObj = null;
		String genre = request.getParameter(Constants.genre);

		Object flag = request.getSession().getAttribute(Constants.userOrVisitorFlag);
		if (flag == null) {
			request.getSession().setAttribute(Constants.userOrVisitorFlag, 0);
		}

		ProductCatalogServiceClient client = new ProductCatalogServiceClient();

		if (genre == null || genre.isEmpty()) {
			resObj = client.getProductList(StringUtils.EMPTY);
		} else {
			resObj = client.getProductList(genre);
		}

		String[] categoryList = client.getCategoryList();
		
		if (!resObj.equals(null) && !categoryList.equals(null)) {
			request.setAttribute(Constants.productWithSelectedCategory, resObj);
			request.setAttribute(Constants.categoryList, categoryList);
			request.getRequestDispatcher("Product.jsp").forward(request, response);
		}

	}

}
