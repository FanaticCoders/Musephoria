<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="Header.jsp"%>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Login</title>

<script language="javascript" type="text/javascript">
	function check() {

		if ("${message}" == "Username and Password doesn't match") {
			alert("Username and Password doesn't match");

		}

		if ("${message}" == "User Dosent Exist") {
			alert("User Dosent Exist");
		}

	}
	window.onload = check;
</script>

</head>


<body background="Resources/Background.jpg">
	<div id="content">

		<form id="form" class="form-container" method=post action="Login">
			<div class="form-title">
				<h2>Login</h2>
			</div>
			<div class="form-title">Username</div>
			<input class="form-field" type="text" name="username"><br>
			<div class="form-title">Password</div>
			<input class="form-field" type="password" name="password"><br>

			<div class="submit-container">
				<button class="submit-button" type="submit">Submit</button>
				<button class="submit-button" formaction="Register.jsp"
					type="submit">New User</button>
			</div>
			<br>
			<br>
			<br>
		</form>
		<!-- <c:remove var="Message" scope="session" />  -->
	</div>
</body>
</html>
<%@ include file="Footer.jsp"%>