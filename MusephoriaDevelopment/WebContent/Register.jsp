<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
</head>
<div id="background">
	<img src="Resources/proj1.jpg" class="stretch">
</div>
<body>
	<script language="javascript">
	
	
	
    		 
	function checkPass()
	{
		if((document.form.pwd.value) != (document.form.repwd.value))
			{
			alert("Passwords do not match ");
            document.form.repwd.focus();
            return false;
			
			}
		return true;
	}
	
	</script>
	
	
 	<%-- <%
	String msg=request.getAttribute("message").toString();
	if(!msg.equals("")&& msg.equals("Passwords do not match, please enter a valid password"))
	{
	%>
		alert("Passwords do not match, please enter a valid password");
	<%
	} %>
	<%
	if(!msg.equals("")&& msg.equals("Username Exists, Please select another username"))
	{
	%>
		alert("!Username Exists, Please select another username");
	<%}
	%>
	<%
	if(!msg.equals("")&& msg.equals("Account Creation Successful,please login with your credentials")) 
	{
	%>
		alert("Account Creation Successful,please login with your credentials");
	<%}
	%> --%>
	
	
	
	
				 			
		
			<form class="form-container" action="NewCustomer" method="post" onsubmit="return checkPass()">
			<fieldset><legend> Customer Information Form </legend>
			<table>
				<tr>
					<td class="fo">First Name  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="fname" maxlength="20" pattern="[a-zA-Z]+" required title="Please enter only alphabets">
				</tr>
				<tr>
					<td class="fo">Last Name  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="lname"  maxlength="20" pattern="[a-zA-Z]+" required title="Please enter only alphabets">
				</tr>
				<tr>
					<td class="fo">Gender  :&nbsp;</td>
					<td>
						<select name="sex" class="form-fi">
  						<option value="Male" class="form-fi">Male</option>
  						<option value="Female" class="form-fi">Female</option>
  						<option value="Other" class="form-fi">Other</option>
						</select>
					</td>			
				</tr>
				<tr>
					<td class="fo">Username  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="usr" maxlength="15" required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,}$" title="Username must contain an Alphabet and a number with min length 5">
					<td>&nbsp;</td>			
				</tr>
				<tr>
					<td class="fo">Password  :&nbsp;</td>
					<td><input class="form-fi" type="password" name="pwd" size="20" maxlength="15" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$" title="Password must contain an Upper,Lower case,number with min length 6"></td>			
				</tr>
				<tr>
					<td class="fo">Reconfirm Password  :&nbsp;</td>
					<td><input class="form-fi" type="password" name="repwd" size="20" maxlength="15" required ></td>			
				</tr>
				<tr>
					<td class="fo">DOB  :&nbsp;</td>
					<td><input class="form-fi" type="date" name="dob" required/></td>			
				</tr>
				<tr>
					<td class="fo">Address  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="addr" required/></td>			
				</tr>
				<tr>
					<td class="fo">City  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="city" required/></td>			
				</tr>
				<tr>
					<td class="fo">Province  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="prov" required/></td>			
				</tr>
				<tr>
					<td class="fo">Country  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="country" required/></td>			
				</tr>
				<tr>
					<td class="fo">ZIP Code  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="zip" required pattern="[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]" placeholder="eg: K1G 3R5"/></td>			
				</tr>
				<tr>
					<td class="fo">Email  :&nbsp;</td>
					<td><input class="form-fi" type="email" name="email" required placeholder="Enter a valid email address"></td>			
				</tr>
				<tr>
					<td class="fo">Phone  :&nbsp;</td>
					<td><input class="form-fi" type="text" name="phone" maxlength="12" required pattern="^\d{3}-\d{3}-\d{4}$" placeholder="eg: 123-123-1234"/></td>			
				</tr>
				<tr>
				    <td class="fo">&nbsp;</td>
					<td><input class="submit-button" type="Submit" value="Submit" /></td>		
				</tr>
				
			</table>
			</fieldset>
			</form>
</body>
</html>
