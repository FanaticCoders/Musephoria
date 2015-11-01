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
		<a href="Home.jsp"><img src="Resources/Header.png" align="left"
			alt="" /></a>
		<%
			if ((username == null) || (username == "")) {
		%>
		<div class="header">
			<h3 align="right" class="form-title">Welcome Guest</h3>
			<a href="Login.jsp" class="form-title">Login</a>

			<form method="post" action="Cart">
				<a href="MyCart.jsp" class="form-title">MyCart</a>
			</form>
		</div>

		<%
			} else {
		%>
		<h3 align="right" class="form-title">Welcome ${username}</h3>
		<form method="post" action="Logout">
			<a href="Logout" class="form-title">Logout</a>
		</form>
		<form method="post" action="Cart">
			<a href="MyCart.jsp" class="form-title">MyCart</a>
		</form>
		<%
			}
		%>
	
</div>
</body>

</html>