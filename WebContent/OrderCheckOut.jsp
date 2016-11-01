
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="Header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<Title>Order CheckOut</Title>

	
	<body background="Resources/Background.jpg">
		<br>

			<form id="table" class="form-container">

					<legend> Order Details </legend>
					<table table border="3" bordercolor="Black" align="center">

						<tr>
							<th class="cart-header">CD Name</th>
							<th class="cart-header">Price</th>
						</tr>
						<c:forEach items="${cartItem}" var="Pro">

							<tr>
								<td class="fo">${Pro.name}</td>

								<td class="fo">${Pro.price}</td>

							</tr>
						</c:forEach>
						<tr>
						<td class="cart-header">Total Price</td>
							<td class="fo">${totalCartPrice}</td>
					</tr>
					</table>
			</form>
			<br><br>
		<form class="form-container" class="h2">
		<a  href="${pageContext.request.contextPath}/ProductCatalogue" class="hyper">Back to Product List</a>
		</form>
		<br><br>
			<form class="form-container" method="post">
			<legend>Shipping information</legend>
			<table>
				<s:iterator items="{$CustomerData}" var="cd">
					<tr>
						<td class="fo">Address:</td>&nbsp;
						<td><input type="text" name="address"
							value="${CustomerData.address}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">City:</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td><input type="text" name="city"
							value="${CustomerData.city}" style="height: 22px; width: 128px;"
							size="20" /></td>

					</tr>
					<tr>
						<td class="fo">Province:</td>&nbsp;
						<td><input type="text" name="province"
							value="${CustomerData.province}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">Country:</td>&nbsp;&nbsp;
						<td><input type="text" name="country"
							value="${CustomerData.country}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">ZIP Code:</td>
						<td><input type="text" name="zip"
							value="${CustomerData.zipCode}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">Phone:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<td><input type="text" name="phone"
							value="${CustomerData.phone}" style="height: 22px; width: 128px;"
							size="20" /></td>

					</tr>
				</s:iterator>
				<tr>
				
				<td></td>
				<td>
				<button class="submit-button" type="submit"
				formaction="PlaceOrder">Proceed to Payment</button>
				</td>
				
				</tr>
			</table>
			</form>

		<p>&nbsp;</p>

</body>
</html>
<br>
<br>
<%@ include file="Footer.jsp"%>