<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Logout</title>
</head>

<body background="Resources/Background.jpg">

<div id="content">
		<br>
			<form class="form-container" class="h2">
		<p class="cart-header">You have been logged out successfully!!!</p>
		<a  href="${pageContext.request.contextPath}/ProductCatalogue" class="hyper">Back to Home</a>
		</form>
		
</div>

</body>
<%@ include file="Footer.jsp"%>
</html>