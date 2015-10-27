<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="Header.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="Resources/css/style.css" type="text/css" /> -->

<title>Login</title>
</head>
<body>

<br>
<table>
        <tr>
            <td>${cddetail.name}</td>
            <td>${cddetail.description}</td>
            <td>${cddetail.price}</td>
            <td>${cddetail.genre}</td>
            <td>${cddetail.artist}</td>
            <td>${cddetail.year}</td>
            <td>${cddetail.rating}</td>
            <td>${cddetail.review}</td>
            <td>${cddetail.language}</td>
        </tr>

</table>
</body>
<%@ include file="Footer.jsp" %>
