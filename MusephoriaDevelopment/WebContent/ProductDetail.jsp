<!--  References
http://stackoverflow.com/questions/42763/is-there-a-max-number-of-options-values-in-html-drop-down-control -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<%@ include file="Header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Login</title>
</head>

<body background="Resources/Background.jpg">
<div id="content">
	<br>
	
	<form class="form-container"  method="post" action="AddToCart">
	<table  border="3" bordercolor="Black" align="center">
		<tr>
			<td> <img src="AlbumArt/${cddetail.cdId}.jpg"  width="150px" /></td>
		</tr>
		<tr>
			<td><font color="white">Name: ${cddetail.name}</font></td>
		</tr>
		<tr>
			<td Width="370px"><font color="white">Description: ${cddetail.description}</font></td>
		</tr>
		<tr>
			<td><font color="white">Price $:${cddetail.price}</font></td>
		<tr />
		<tr>
			<td><font color="white">Genre: ${cddetail.genre}</font></td>
		</tr>
		<tr>
			<td><font color="white">Artist: ${cddetail.artist}</font></td>
		</tr>
		<tr>
			<td><font color="white">Year: ${cddetail.year}</font></td>
		</tr>
		<tr>
			<td><font color="white">Rating: ${cddetail.rating}</font></td>
		</tr>
		<tr>
			<td><font color="white">Review: ${cddetail.review}</font></td>
		</tr>
		<tr>
			<td><font color="white">Language: ${cddetail.language}</font></td>
		</tr>
		
		<tr>
			<td align="center"><input type="submit" class ="submit-button" value="Add to Cart"
				></td>
		</tr>

	</table>
	</form>
	
	</div>
	
</body>
<%@ include file="Footer.jsp"%>
</html>