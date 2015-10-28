<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="Header.jsp" %>
<html>

<head>
		
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Login</title>
</head>

<body background="Resources/proj1.jpg">



<div id="content">


<div align="Right">

 <form method="post" action="Categories.jsp">
<button class="submit-button" id="active" type="submit" >View As Categories</button>
</form>
</div>
<table border="1" align="center">
    <c:forEach items="${Product}" var="Product">
        <tr>
       <td color="orange" align="Center" ><a href=" ${pageContext.request.contextPath}/ProductDetail?cdId=${Product.cdId}" >
       <img src="Resources/icon.jpg" /></a> </td>
        </tr>
        <tr>
        <td align="center">Name : ${Product.name}</td>
         </tr>
         <tr>
         <td align="center"> Price $:${Product.price}</td>
         </tr>
    </c:forEach>
    <br><br>

</table>

</div>
</body>
<%@ include file="Footer.jsp" %>
</html>