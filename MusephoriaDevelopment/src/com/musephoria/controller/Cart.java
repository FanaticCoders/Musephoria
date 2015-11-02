package com.musephoria.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.musephoria.webserviceclient.*;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;
import com.musephoria.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	public void viewCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart myCart) throws ServletException, IOException{
		
		// Acquiring the list of Cd's as well as their total Cost and binding it to the current session of the user\visitor
		List<Cd> cartItem = myCart.getCdList();
		double totalCartPrice = myCart.getTotalPrice();
		totalCartPrice = Double.parseDouble(new DecimalFormat(".##").format(totalCartPrice));
		request.getSession().setAttribute("cartItem", cartItem);
		request.getSession().setAttribute("totalCartPrice", totalCartPrice);
		/*request.getRequestDispatcher("MyCart.jsp").forward(request, response);*/
		response.sendRedirect("MyCart.jsp");
		
	}
	
	
	public void removeCart(HttpServletRequest request, HttpServletResponse response, ShoppingCart removeMyCart) throws ServletException, IOException{
		
		int check = Integer.parseInt(request.getParameter("cdId"));
		
		
			// call Delete from cart function.
			//ProductCatalogServiceClient client = new ProductCatalogServiceClient();
			removeMyCart.removeFromCart(check);
			
			viewCart(request,response,
					removeMyCart);
		
	}
	

	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	
	
		int flag = (int) request.getSession().getAttribute("flag");
		

		ShoppingCart myCart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");

		// Acquiring Cd object from the current session set in ProductDetail
		Cd cd = (Cd) request.getSession().getAttribute("cddetail");
		
		

		// Checking if cart exists for both visitor as well as registered user
		// If the cart doesn't exit, we create a new cart and add bind it to the
		// current session
		if ((myCart == null) && (flag == 0 || flag == 1)) {

			myCart = new ShoppingCart();
			myCart.addToCart(cd);
			request.getSession().setAttribute("ShoppingCart", myCart);
		}

		// Handling visitor's cart
		else if (myCart != null && flag == 0) {

			myCart.addToCart(cd);

		}

		// Handling registered user's cart
		else if (myCart != null && flag == 1) {

			myCart.addToCart(cd);
		}

		viewCart(request,response,
				myCart);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//Function to delete a CD from the cart
		// We receive the cart from the session object. Now we need to delete a CD from the Cart.
		
		/*String check = request.getParameter("Pro.cdId");
		if(check.startsWith("123")){
			// call Delete from cart function.
			ProductCatalogServiceClient client = new ProductCatalogServiceClient();
			ShoppingCart myCart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
			myCart.removeFromCart(client.getProductInfo(Integer.parseInt(check)));
			
			viewCart(request,response,
				myCart);
		}
		else*/
		

		// Logic implementing adding functionality to a shopping cart.
		// set session flag variable in the home server(1st servlet) for a
		// visitor.
		
		
		String path = request.getServletPath();
		
		
		//out.println(path);
		
		if(path.equals("/AddToCart")){
			addCart(request, response);
		}
		else{
			ShoppingCart myCart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
			removeCart(request, response, myCart);
		}

		
			
			
		}
}
	
	