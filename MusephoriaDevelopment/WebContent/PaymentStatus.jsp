<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ include file="Header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Payment Status</title>
</head>

<body background="Resources/Background.jpg">

<div id="content">
		<br>
		<c:if test="${status !='Success'}">
		<form class="form-container" class="h2">
		<p class="cart-header">Credit Card Authorization Failed</p>
		<a  href="${pageContext.request.contextPath}/ProductCatalogue" class="hyper">Back to Product List</a>
		</form>
		</c:if>
		
		<c:if test="${status =='Success'}">
		<form class="form-container" class="h2">
		<p class="cart-header">Payment Authorization Successful,Order Successfully Completed<br>Thank you for Shopping with us!</p>
		<a  href="${pageContext.request.contextPath}/ProductCatalogue" class="hyper">Back to Product List</a>
		</form>
		</c:if>
</div>

</body>
<%@ include file="Footer.jsp"%>
</html>