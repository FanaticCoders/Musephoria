<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ include file="Header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Login</title>
</head>

<body background="Resources/Background.jpg">
<div id="content">

<form class="form-container" method="post" action="Login" >
<div class="form-title"><h2>Login</h2></div>
<div class="form-title">Username</div>
<input class="form-field" type="text" name="username" required/><br>
<div class="form-title">Password</div>
<input class="form-field" type="password" name="password" required  /><br>
<div class="submit-container">
<button class="submit-button" type="submit">Submit</button>
</form>
<form  method="post" action="Register.jsp" >
<button class="submit-button" type="submit" >New User</button>
</form>
</div>
<br><br><br>
<div class="loginmessage" align="Center" >
<p> ${Message}</p>
</div>
<c:remove var="Message" scope="session" /> 
</body>

<%@ include file="Footer.jsp" %>
</html>