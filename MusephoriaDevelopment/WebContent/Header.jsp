<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
</head>
<div class="submit-button" align="Right">

<body>
<% String username="" ;%>
  <!--   String username = (String)request.getParameter("username");     -->
	
	
			<a href="Home.jsp"><img src="Resources/gangesh.png" align="left" alt="" /></a>		
	
	
	
		
<%
if ((username== null) || (username == "")){
%>
	<div class="header"	>
    <h3 align="right"> Welcome Guest</h3>  
    <a href="Login.jsp">Login</a> 
       
       <form method="post" action="mycart">
       <a href="Mycart">MyCart</a>
       </form>
     </div>
     
<%}else{
%>
    <h3 align="right"> Welcome </h3>  
    <a href="Logout">Logout</a> 
       
       <form method="post" action="mycart">
       <a href="Mycart">MyCart</a>
       </form>
       <% }
%>
     </div>
	
</body>
</html>