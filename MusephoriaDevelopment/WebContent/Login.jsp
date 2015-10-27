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
<div id="content">
<body background="Resources/proj1.jpg">
<form class="form-container" method=post >
<div class="form-title"><h2>Login</h2></div>
<div class="form-title">Username</div>
<input class="form-field" type="text" name="username" /><br>
<div class="form-title">Password</div>
<input class="form-field" type="text" name="password" /><br>
<div class="submit-container">
<button class="submit-button" type="submit" formaction="LoginServlet">Submit</button>
<button class="submit-button" type="submit" formaction="Register.jsp">New User</button>
</div>
</form>

</body>
</div>

<%@ include file="Footer.jsp" %>
</html>