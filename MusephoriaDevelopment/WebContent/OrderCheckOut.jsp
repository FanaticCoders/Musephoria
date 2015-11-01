
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="Header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="${pageContext.request.contextPath}/jquery-1.11.3.min.js"></script>
<!-- References: http://stackoverflow.com/questions/6981102/enable-disable-validation-of-certain-hidden-textboxes-in-mvc-2 -->
<script>
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
</script>

</head>
<Title>Order Check Out</Title>
<h1 align="center">Order Check Out</h1>
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
	<br />
	<form class="form-container" method=post name="oco">
		<div class="fo" id="mydiv2" align="Center">
			Enter new Shipping Information<br>
			<br>
			<table id="table2" class="ignore" style="height: 37px; width: 22px;"
				border="0" cellpadding="2" cellspacing="0">
				<tr>
					<td class="fo">Address:</td>&nbsp;
					<td ><input type="text" name="address2"
						style="height: 22px; width: 128px;" size="20" required /></td>

				</tr>
				<tr>
					<td class="fo">City:</td>&nbsp;&nbsp;&nbsp;&nbsp;
					<td><input type="text" name="city2"
						style="height: 22px; width: 128px;" size="20" required/></td>

				</tr>
				<tr>
					<td class="fo">Province:</td>&nbsp;
					<td><input type="text" name="province2"
						style="height: 22px; width: 128px;" size="20" required/></td>

				</tr>
				<tr>
					<td class="fo">Country:</td>&nbsp;&nbsp;
					</td>
					<td><input type="text" name="country2"
						style="height: 22px; width: 128px;" size="20" required/></td>

				</tr>
				<tr>
					<td class="fo">ZIP Code:</td>
					<td><input type="text" name="zip2"
						style="height: 22px; width: 128px;" size="20" required pattern="[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]" placeholder="eg: K1G 3R5" /></td>

				</tr>
				
				<tr>
					<td class="fo">Phone:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td><input type="text" name="phone2"
						style="height: 22px; width: 128px;" size="20" maxlength="12" required pattern="^\d{3}-\d{3}-\d{4}$" placeholder="eg: 123-123-1234" /></td>

				</tr>

			</table>

		</div>

		<div class="fo" id="mydiv" align="center">
			Your Shipping Information:<br>
			<br>
			<table id="table1" style="height: 37px; width: 22px;" border="0"
				cellpadding="2" cellspacing="0">
				<s:iterator items="{$CustomerData}" var="cd">
					<tr>
						<td class="fo">Address:</td>&nbsp;
						<td><input type="text" name="address1"
							value="${CustomerData.address}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">City:</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td><input type="text" name="city1"
							value="${CustomerData.city}" style="height: 22px; width: 128px;"
							size="20" /></td>

					</tr>
					<tr>
						<td class="fo">Province:</td>&nbsp;
						<td><input type="text" name="province1"
							value="${CustomerData.province}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">Country:</td>&nbsp;&nbsp;
						<td><input type="text" name="Country1"
							value="${CustomerData.country}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">ZIP Code:</td>
						<td><input type="text" name="zip1"
							value="${CustomerData.zipCode}"
							style="height: 22px; width: 128px;" size="20" /></td>

					</tr>
					<tr>
						<td class="fo">Phone:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<td><input type="text" name="Phone1"
							value="${CustomerData.phone}" style="height: 22px; width: 128px;"
							size="20" /></td>

					</tr>
				</s:iterator>
			</table>
		</div>

		<p>&nbsp;</p>

		<div align="center">

			<button id="submit" class="submit-button" type="submit"
				formaction="ProceedToPayment">Proceed to Payment</button>

		</div>
		</div>
</body>
</html>
<br>
<br>
<%@ include file="Footer.jsp"%>