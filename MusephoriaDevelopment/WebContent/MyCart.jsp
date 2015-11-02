
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@ include file="Header.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />

<title>MyCart</title>

<!-- <script language="javascript">
	function check() {

		if ("${cartItem}" == "") {
			document.getElementById("table").style.visibility = "hidden";
			document.getElementById("Checkout").style.display = "none";
			alert("You Cart is empty ");

		} else {
			document.getElementById("Checkout").style.visibility = "visible";
		}

	}
	window.onload = check;
</script>
 -->
</head>
<body background="Resources/Background.jpg">
	<div id="content">
		<br>
		<c:if test="${not empty cartItem}">

			<form id="table" class="form-container" action="RemoveFromCart"
				method="post">

					<legend> Cart Details </legend>
					<table table border="3" bordercolor="Black" align="center">

						<tr>
							<th class="cart-header">CD Name</th>
							<th class="cart-header">Price</th>
						</tr>
						<c:forEach items="${cartItem}" var="Pro">
							<input type="hidden" name="cdId" value="${Pro.cdId}" />

							<tr>
								<td class="fo">${Pro.name}</td>

								<td class="fo">${Pro.price}</td>
							
								<td><input type="submit" class="submit-button"
									value="Remove"></td>

							</tr>
						</c:forEach>
						<tr>
						<td class="cart-header">Total Price</td>
							<td class="fo">${totalCartPrice}</td>
							<td>
					 <button  id="Checkout"
					formaction="OrderCheckOut" class="checkout-button">Checkout</button>
					</td>
					</tr>
					</table>
			</form>
			<div align="Center">	
		<!-- <button  id="Checkout" class="submit-button"
					formaction="OrderCheckOut">Checkout</button> -->
			</div>	
		</c:if>
		<form class="form-container" class="h2">
		<a  href="${pageContext.request.contextPath}/ProductCatalogue" class="hyper">Back to Product List</a>
		</form>
	</div>
</body>
<%@ include file="Footer.jsp"%>
</html>