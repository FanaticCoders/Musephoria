<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="Header.jsp"%>
<html>

<head>
<script language="javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Login</title>
</head>

<body background="Resources/proj1.jpg">



	<div id="content">
		<div align="Right">
			<form method="post" action="Categories.jsp">
				<button class="submit-button" id="active" type="submit">View
					As Categories</button>
			</form>
		</div>

		<form method="post" action="ProductCatalogue">
			<table>
				<tr>
					<td class="fo">Select Genre :&nbsp;</td>
					<td><select name="Genre" id="dd" class="form-fi">
							<option value="Rock" class="form-fi" id="Rock">Rock</option>
							<option value="Pop" class="form-fi" id="Pop">Pop</option>
							<option value="Country" class="form-fi" id="Country">Country</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>

				</tr>
			</table>
		</form>
		<table border="0" align="center">
			<tr>
				<!-- Reference : http://htmlasks.com/how_to_iterate_data_horizontally_in_jstl		 -->
				<c:forEach items="${Product}" var="Product" varStatus="loop">
					<td color="orange" align="Center"><a
						href=" ${pageContext.request.contextPath}/ProductDetail?cdId=${Product.cdId}">
							<img src="AlbumArt/${Product.cdId}.jpg" />
					</a> <br /> Name : ${Product.name} <br /> Price $:${Product.price} <br />
					</td>
					<c:if test="${(loop.index + 1)  % 3  == 0}">
			</tr>
			<tr>
				</c:if>
				</c:forEach>
			</tr>
		</table>


	</div>
</body>
<%@ include file="Footer.jsp"%>
</html>