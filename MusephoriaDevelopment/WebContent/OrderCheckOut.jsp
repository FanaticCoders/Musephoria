
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
<body>
         <div id="title" align="center">
        Order Checkout Page
		</div><br>
		<div id="productTitle" align="left" >
		Product Title:
		</div>
		<div id="productQuantity" align="center" >
	     Quantity :
		</div>
		<div id="orderTotal" align="Right" >
		Order total :
		</div>
		
		
        <br>
        <br>
        <br>
        <br>
    <div align="center" style="height: 28px; width: 1100px" >
        Want to enter a new Shipping Address? Yes<input id="Radio1" name="R1" type="radio" value="V1" />No<input id="Radio2"  name="R2" type="radio" checked="checked" value="V1" /> </p>
        </div>
            <br />
    <div id = "mydiv" align="Center" >
	Enter new Shipping Information<br><br>
            <table id="table 2" style="height: 37px; width: 22px; "  border="1" cellpadding="2" cellspacing="0" >
                <tr>
                    <td class="auto-style2">Address:&nbsp;
                        <input type="text" name="address2" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="auto-style1">City:&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" name="city2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style1">Province:&nbsp;
                        <input type="text" name="province2"  style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style1">Country:&nbsp;&nbsp;
                        <input type="text" name="Country1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style1">ZIP Code: <input type="text" name="zip1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style1">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="Phone3" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style4">Phone:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" name="Phone2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>

                </table>
    </div>
        
		<div id="mydiv2" align="center">
		Your Shipping Information:<br><br>
   <table id="table1"  style="height: 280px; width: 141px" width="100%" border="1" cellpadding="2" cellspacing="0">
                <tr>
                    <td class="auto-style5">Address:&nbsp;
                        <input type="text" name="address2" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="auto-style6">City:&nbsp;<br />
&nbsp;<input type="text" name="city2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style6">Province:&nbsp;
                        <input type="text" name="province2"  style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style6">Country:&nbsp;&nbsp;
                        <input type="text" name="Country1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style6">ZIP Code: <input type="text" name="zip1" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style6">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="Phone3" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="auto-style7">Phone:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" name="Phone2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>

                  </table>
				  </div>
       
            <p>
                &nbsp;</p>
    
        <div align="center">  
      <a>
          <form action="abc">
            <input id="Button2" type="button" value="Proceed to Payment" />
         </a>   
           </form>
    <a>
        <form action="abcd">
            <input id="Button3" type="button" value="Back" /></a>
            </form>
        </div>
       
            </body>
</html>
