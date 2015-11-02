<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="Resources/css/style.css" type="text/css" />
<title>Musephoria</title>
</head>

<body background="Resources/Background.jpg">
	<div id="content">
	<form action="PaymentAuthorization" method="post">
					<table class="form-container" border="0" align="center">
									<td colspan="3"> 
									<div class="abc" align="center">
											<div class="form-title"><h4>Payment</h4></div>
											<div class="form-title"><h4>Card Details</h4></div>				
									</div>
									</td>
										
									
	
					<tr>
					
						<td></td>	
						<td width="25%"><br><b><font size="2" class="form-title" face="arial">Payment Type :</font></b><br></td>
						<td width="25%"><br>
							    <select class="form-fi" name="paymentType" style="height: 25px; width: 200px; font-size: 14px;">
                                                          
                                                            <option   value="Debit Card">Debit Card</option>
                                                            <option    value="Credit Card">Credit Card </option>
                                                            <option   value="INTERNET_BANKING">Internet Banking </option>
                                                            </select>      
                                                                   
                                                 </td>
                                                 
                                          </tr>
								
					  <tr>
						    <td ></td>
						    <td><br><b><font size="2" class="form-title" color="black" face="arial">Card Number :</font></b><br></br></td>
					            <td width="15%"><br><input required class="form-fi" type="text"  style="height: 20px; width: 200px; font-size: 14px;" pattern="^\d{4}-\d{4}-\d{4}-\d{4}$" placeholder="eg: 1234-1234-1234-1234"><br></br></td>
					  </tr>
								
                                          <tr>
						        <td width="5%"></td>
							<td><b><font size="2" class="form-title" color="black" face="arial">Name on Card:</font></b><br></br></td>
						        <td><input required class="form-fi" type="text" style="height: 20px; width: 200px; font-size: 14px;"/><br></br></td>
					  </tr>
								
					   <tr>				
                 <td colspan="3" align="center"><br /> <input class="submit-button" type="reset" style="height: 30px; width: 90px; font-size: 10pt;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																									
                 <input class="submit-button" type="submit" value="Submit"  style="height: 30px; width: 90px; font-size: 10pt;" /> <br /> <br /></td>
					   </tr>

								   
					 </table>
			</form>		 	
					 <br>
					 <br>
					 <br>
					 <br>
					 <br>
					 <br>
					  </div>
	               </body>
	              
	               
	               <%@ include file="Footer.jsp" %>
	                   </html>