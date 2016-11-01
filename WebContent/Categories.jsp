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
<title>Categories</title>
</head>

<body background="Resources/Background.jpg">
<div id="content" align="center">


<table>
                <tr>
					<td class="form-title">Select Genre  :&nbsp;</td>
					<td>
						<select name="Genre" class="form-fi" >
  						<option value="Rock" class="form-fi" id="Rock" >Rock</option>
  						<option value="Pop" class="form-fi" id="Pop">Pop</option>
  						<option value="Country" class="form-fi" id="Country">Country</option>
						</select>
					</td>			
				</tr>
</table>				


</div>
</body>
<%@ include file="Footer.jsp" %>
</html>