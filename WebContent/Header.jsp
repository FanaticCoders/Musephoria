<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
</head>

<body>
	<div class="head-container" align="Right">

		<%
			String username = (String) request.getSession().getAttribute("username");
		%>
		<a href="${pageContext.request.contextPath}/ProductCatalogue"><img
			src="Resources/Header.png" align="left" alt="" /></a>
		<%
			if ((username == null) || (username == "")) {
		%>
		<div class="header">
			<h3 align="right" class="form-title">Welcome Guest</h3>
			<a href="Login.jsp" class="form-title">Login</a>

			<!-- Commented to enable Pay Pal Add to Cart -->
			<!-- <form method="post" action="Cart">
				<a href="MyCart.jsp" class="form-title">MyCart</a>
			</form> -->

			<form target="paypal"
				action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
				<input type="hidden" name="cmd" value="_cart"> <input
					type="hidden" name="business"
					value="nikhil.baadshah-facilitator@gmail.com"> <input
					type="image"
					src="https://www.paypal.com/en_US/i/btn/btn_viewcart_LG.gif"
					border="0" name="submit" alt=""> <img alt="" border="0"
					src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" width="1"
					height="1"> <input type="hidden" name="display" value="1">
			</form>


		</div>

		<%
			} else {
		%>
		<h3 align="right" class="form-title">Welcome ${username}</h3>
		<form action="Logout">
			<a href="Logout" class="form-title">Logout</a>
		</form>

		<!-- Commented to enable Pay Pal Add to Cart -->
		<!-- <form method="post" action="Cart">
			<a href="MyCart.jsp" class="form-title">MyCart</a>
		</form> -->

		<form target="paypal"
			action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
			<input type="hidden" name="cmd" value="_cart"> <input
				type="hidden" name="business"
				value="nikhil.baadshah-facilitator@gmail.com"> <input
				type="image"
				src="https://www.paypal.com/en_US/i/btn/btn_viewcart_LG.gif"
				border="0" name="submit" alt=""> <img alt="" border="0"
				src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" width="1"
				height="1"> <input type="hidden" name="display" value="1">
		</form>


		<%
			}
		%>

	</div>
</body>

</html>