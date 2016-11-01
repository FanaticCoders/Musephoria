<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="Header.jsp"%>
<html>

<head>
<script src="${pageContext.request.contextPath}/jquery-1.11.3.min.js"></script>
<script>


$(document).ready(function(){
	

	$("#mydiv").ready(function(){
		
	     $("#table1").hide();
		 
	  });

    $("#active").click(function(){
        $("#table1").show();
	});

});

</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Products</title>
</head>

<body background="Resources/Background.jpg">


		<div align="Right">
			
				<button class="submit-button" id="active" type="submit">View
					As Categories</button>
		
		</div>

		<form action="ProductCatalogue">
			<table id="table1" align="Center">
				<tr>
					<td class="fo">Select Genre :&nbsp;</td>
					<td><select name="Genre" id="dd" class="form-fi">
					        <option value="" class="form-fi" id="All">All</option>
							<c:forEach items="${CategoryList}" var="category">
							<option value="${category}" class="form-fi" id="${category}">${category}</option>
						</c:forEach>
							
					</select></td>
				</tr>
				<tr>
					<td><input class="submit-button"  type="submit" value="Submit" ></td>

				</tr>
			</table>
		</form>
		<form class="prod-container">
		<table border="0" align="center">
			<tr>
				<!-- Reference : http://htmlasks.com/how_to_iterate_data_horizontally_in_jstl		 -->
				
				<c:forEach items="${Product}" var="Product" varStatus="loop">
					<td  align="Center"><a
						href=" ${pageContext.request.contextPath}/ProductDetail?cdId=${Product.cdId}">
							<img src="AlbumArt/${Product.cdId}.jpg" />
					</a><br /> <p class= "cart-header"> Name : ${Product.name} <br /> Price $:${Product.price} <br /></p>
					</td>
					<c:if test="${(loop.index + 1)  % 3  == 0}">
			</tr>
			<tr>
				</c:if>
				</c:forEach>
			</tr>
		</table>
		</form>

</body>
<%@ include file="Footer.jsp"%>
</html>