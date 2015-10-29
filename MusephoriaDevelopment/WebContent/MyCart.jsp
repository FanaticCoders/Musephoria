<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="Header.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="Resources/css/style.css" type="text/css" /> -->

<title>MyCart</title>
</head>
<body>

<br>
<table>
    <c:forEach items="${cartItem}" var="cartItem">
        <tr>
            <td>${cartItem.name}</td>
          
            <td>${cartItem.price}</td>
            
        </tr>
    </c:forEach>
    <tr>
    <td>${totalCartPrice}</td>
    
       

</table>
</body>
<%@ include file="Footer.jsp" %>
</html>
