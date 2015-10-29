<script language="javascript">
function check()
                {
		                                                            
	               if ("${cartItem}"=="")
                    {
	            	   alert("You Cart is empty ");
	            	   document.getElementById("Checkout").style.visibility="hidden";
                    }
	               else
	            	   {
	            	   
	            	   document.getElementById("Checkout").style.visibility="visible";
	            	   
	            	   }
	                                                
                }
window.onload = check;
  </script>

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
<body background="Resources/Background.jpg">

<br>
<table border="1" align="center">

    <c:forEach items="${cartItem}" var="Cart">
        <tr>
            <td> ${Cart.name}</td>
          
            <td>${cartItem.price}</td>
            <td> <input class="submit-button"  type="submit" value="Remove" ></td>
            
        </tr>
    </c:forEach>
    <tr>
    <td>${totalCartPrice}</td>
    
  </table>
  <div align="Center">
  <form action="OrderCheckOut.jsp">
  <input class="submit-button" id="Checkout" type="submit" value="Checkout" >
  </form>
  </div>
</body>
<%@ include file="Footer.jsp" %>
</html>
s