<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="header.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="Resources/css/style.css" type="text/css" /> -->

<title>Login</title>
</head>
<body>

<br>
<table>
    <c:forEach items="${Product}" var="Product">
        <tr>
            <td>${Product.name}</td>
        </tr>
    </c:forEach>

</table>





</body>
<%@ include file="footer.jsp" %>
