package com.musephoria.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;
import com.musephoria.shoppingcart.ShoppingCart;
import com.musephoria.util.Constants;

/**
 * Servlet implementing Cart functionality for the site.
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method to view the contents existent in the cart.
	 * 
	 * @param request
	 * @param response
	 * @param myCart
	 * @throws ServletException
	 * @throws IOException
	 */

	public void viewCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart myCart)
			throws ServletException, IOException {

		// Acquiring the list of Cd's as well as their total Cost and binding it
		// to the current session of the user\visitor
		List<Cd> cartItem = myCart.getCdList();
		double totalCartPrice = myCart.getTotalPrice();
		totalCartPrice = Double.parseDouble(new DecimalFormat(".##").format(totalCartPrice));
		request.getSession().setAttribute(Constants.cartItem, cartItem);
		request.getSession().setAttribute(Constants.totalCartPrice, totalCartPrice);
		response.sendRedirect("MyCart.jsp");

	}

	/**
	 * Method to remove the selected product from the Cart.
	 * 
	 * @param request
	 * @param response
	 * @param removeMyCart
	 * @throws ServletException
	 * @throws IOException
	 */

	public void removeCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart removeMyCart)
			throws ServletException, IOException {

		int check = Integer.parseInt(request.getParameter(Constants.cdId));

		// call Delete from cart function.
		// ProductCatalogServiceClient client = new
		// ProductCatalogServiceClient();
		removeMyCart.removeFromCart(check);

		viewCart(request, response, removeMyCart);

	}

	/**
	 * Method to add the selected product to the Cart.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int flag = (int) request.getSession().getAttribute(Constants.userOrVisitorFlag);

		ShoppingCart myCart = (ShoppingCart) request.getSession().getAttribute(Constants.shoppingCart);

		// Acquiring Cd object from the current session set in ProductDetail
		Cd cd = (Cd) request.getSession().getAttribute(Constants.cddetail);

		// Checking if cart exists for both visitor as well as registered user
		// If the cart doesn't exit, we create a new cart and add bind it to the
		// current session
		if ((myCart == null) && (flag == 0 || flag == 1)) {

			myCart = new ShoppingCart();
			myCart.addToCart(cd);
			request.getSession().setAttribute(Constants.shoppingCart, myCart);
		}

		// Handling visitor's cart
		else if (myCart != null && flag == 0) {

			myCart.addToCart(cd);

		}

		// Handling registered user's cart
		else if (myCart != null && flag == 1) {

			myCart.addToCart(cd);
		}

		viewCart(request, response, myCart);

	}

	/**
	 * Method to remove the selected product from the Cart.
	 * 
	 * @param request
	 * @param response
	 * @param removeMyCart
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Logic implementing addition and removal functionality of Cd's in the
		 * shopping cart by invoking methods(Add/Remove) on the basis of the
		 * Servlet path.
		 */

		String path = request.getServletPath();

		if (path.equals("/AddToCart")) {
			addCart(request, response);
		} else {
			ShoppingCart myCart = (ShoppingCart) request.getSession().getAttribute(Constants.shoppingCart);
			removeCart(request, response, myCart);
		}

	}
}
