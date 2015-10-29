<%@ include file="Header.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="${pageContext.request.contextPath}/jquery-1.11.3.min.js"></script>
<script>


$(document).ready(function(){
	

	$("#mydiv").ready(function(){
		
	     $("#mydiv").hide();
		 
	  });

    $("#Radio1").click(function(){
        $("#mydiv").show();
		$("#mydiv2").hide();
		$('#Radio2').not('#Radio1').removeAttr('checked');
	});
	$("#Radio2").click(function(){
        $("#mydiv").hide();
		$("#mydiv2").show();
		$('#Radio1').not('#Radio2').removeAttr('checked');
		
	});

});

</script>
    
</head>

<body background="Resources/Background.jpg">
<div id="content">
         <div  id="title"  align="center">
        Order Checkout Page
		</div><br>
		<div id="productTitle"  align="left" >
		Product Title:
		</div>
		<div id="productQuantity"  align="center" >
	     Quantity :
		</div>
		<div id="orderTotal"  align="Right" >
		Order total :
		</div>
		
		
        <br>
        
    <div align="center" style="height: 28px; width: 1100px" >
        Want to enter a new Shipping Address? Yes<input id="Radio1" name="R1" type="radio" value="V1" />No<input id="Radio2"  name="R2" type="radio" checked="checked" value="V1" /> </p>
        </div>
            <br />
        <form class="form-container" method=post >   
    <div  class="fo" id = "mydiv" align="Center" >
	Enter new Shipping Information<br><br>
            <table id="table 2" style="height: 37px; width: 22px; "  border="0" cellpadding="2" cellspacing="0" >
                <tr>
                    <td class="fo">Address:</td>&nbsp;
                        <td><input type="text" name="address2" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="fo">City:</td>&nbsp;&nbsp;&nbsp;&nbsp;
                       <td> <input type="text" name="city2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Province:</td>&nbsp;
                     <td>   <input type="text" name="province2"  style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Country:</td>&nbsp;&nbsp;
                     <td>   <input type="text" name="Country1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">ZIP Code: </td>
                    <td><input type="text" name="zip1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Email:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                    <td><input type="text" name="Phone3" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Phone:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <td> <input type="text" name="Phone2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>

                </table>
                
    </div>
        
		<div class="fo" id="mydiv2" align="center">
		Your Shipping Information:<br><br>
     <table id="table 2" style="height: 37px; width: 22px; "  border="0" cellpadding="2" cellspacing="0" >
                <tr>
                    <td class="fo">Address:</td>&nbsp;
                        <td><input type="text" name="address2" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="fo">City:</td>&nbsp;&nbsp;&nbsp;&nbsp;
                       <td> <input type="text" name="city2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Province:</td>&nbsp;
                     <td>   <input type="text" name="province2"  style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Country:</td>&nbsp;&nbsp;
                     <td>   <input type="text" name="Country1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">ZIP Code: </td>
                    <td><input type="text" name="zip1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Email:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                    <td><input type="text" name="Phone3" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Phone:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <td> <input type="text" name="Phone2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>

                </table>
				  </div>
       
            <p>&nbsp;</p>
    
        <div align="center">  
    
          <form  method="get">
           <a href="Payment.jsp"><input class="submit-button" type="button" id="Button2" value="Proceed to Payment" /></a>
           </form>
   
        </div>
        </div>
            </body>
</html>
<%@ include file="Footer.jsp" %>