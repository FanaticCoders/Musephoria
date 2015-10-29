<!--  References
http://stackoverflow.com/questions/42763/is-there-a-max-number-of-options-values-in-html-drop-down-control -->

<%-- <script src="${pageContext.request.contextPath}/jquery-1.11.3.min.js"></script>
<script>
	$(document).ready(function() {
		for (var i = 1; i <= ${cddetail.quantity}; i++) {
			var name = i;
			var sel = document.getElementById("list");
			sel.options[sel.options.length] = new Option(name, i);
		}
	});
</script> --%>

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

	<br>
	<div >
	<form method="post" action="Cart">
	<table  border="1" bordercolor="black" align="center">
		<tr>
			<td> <img src="AlbumArt/${cddetail.cdId}.jpg"  width="150px" /></td>
		</tr>
		<tr>
			<td>Name: ${cddetail.name}</td>
		</tr>
		<tr>
			<td Width="370px">Description: ${cddetail.description}</td>
		</tr>
		<tr>
			<td>Price $:${cddetail.price}</td>
		<tr />
		<tr>
			<td>Genre: ${cddetail.genre}</td>
		</tr>
		<tr>
			<td>Artist: ${cddetail.artist}</td>
		</tr>
		<tr>
			<td>Year: ${cddetail.year}</td>
		</tr>
		<tr>
			<td>Rating: ${cddetail.rating}</td>
		</tr>
		<tr>
			<td>Review: ${cddetail.review}</td>
		</tr>
		<tr>
			<td>Language: ${cddetail.language}</td>
		</tr>
		<!-- <tr>
			<td>Quantity:<select id="list" class="form-fi">
					<option class="form-fi">--Select--</option>
			</select></td>

		</tr> -->
		<tr>
			<td align="center"><input type="submit" value="Add to Cart"
				></td>
		</tr>

	</table>
	</form>
	</div>
</body>
<%@ include file="Footer.jsp"%>