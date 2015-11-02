
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="Header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="${pageContext.request.contextPath}/jquery-1.11.3.min.js"></script>
<!-- References: http://stackoverflow.com/questions/6981102/enable-disable-validation-of-certain-hidden-textboxes-in-mvc-2 -->
<!-- <script>
	$(document).ready(function() {

		$("#mydiv").ready(function() {

			$("#mydiv2").hide();
		});
		$("#submit").click(function() {
			if ($("#mydiv").is(":visible")) {
				$("#table2").remove();
			}
		});

		$("#Radio1").click(function() {
			$("#mydiv2").show();
			$("#mydiv").hide();
			$('#Radio2').not('#Radio1').removeAttr('checked');
		});
		$("#Radio2").click(function() {
			$("#mydiv2").hide();
			$("#mydiv").show();
			$('#Radio1').not('#Radio2').removeAttr('checked');

		});

	});
</script> -->

</head>
<Title>Order Check Out</Title>
<%-- <h1 align="center">Order Check Out</h1>
<br>
<body background="Resources/Background.jpg">
<div id="content">
	<br>
	<table border="1" align="center">
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${carItem}" var="cart">
			<tr>
				<td>${cart.name}</td>

				<td>${cart.price}</td>

			</tr>
		</c:forEach>
		<tr>
			<td>Total Price :${totalCartPrice}</td>
	</table>


	<br>
	<div align="Center" style="height: 28px; width: 1100px">
		<p>
			Want to enter a new Shipping Address? Yes<input id="Radio1" name="R1"
				type="radio" value="V1" />No<input id="Radio2" name="R2"
				type="radio" checked="checked" value="V1" />
		</p>
	</div>
	<br /> --%>
	
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