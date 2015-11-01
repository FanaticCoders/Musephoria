<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ include file="Header.jsp" %> --%>
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
<Title>Order Check Out</Title>
<h1 align="center"> Order Check Out </h1><br>

<!-- <body background="Resources/Background.jpg"> -->
<div id="content">
<br>
  <table border="1" align="center">
<tr>
    <th>Name</th>
    <th>Price</th>    
    </tr>
    <c:forEach items="${cartItem}" var="Pro">
       <tr>
            <td> ${Pro.name}</td>
          
            <td>${Pro.price}</td>
            
        </tr>
    </c:forEach>
    <tr>
    <td>Total Price :${totalCartPrice}</td>
    
  </table>

		
        <br>
    <div align="Center" style="height: 28px; width: 1100px" >
     <p>   Want to enter a new Shipping Address? Yes<input id="Radio1" name="R1" type="radio" value="V1" />No<input id="Radio2"  name="R2" type="radio" checked="checked" value="V1" /> </p>
        </div>
            <br />
        <form class="form-container" method=post name="oco" >   
    <div  class="fo" id = "mydiv" align="Center" >
	Enter new Shipping Information<br><br>
            <table id="table 2" style="height: 37px; width: 22px; "  border="0" cellpadding="2" cellspacing="0" >
                <tr>
                    <td class="fo">Address:</td>&nbsp;
                        <td><input type="text" name="address2" style="height: 22px; width: 128px; " size="20"   /></td>

                </tr>
                <tr>
                    <td class="fo">City:</td>&nbsp;&nbsp;&nbsp;&nbsp;
                       <td> <input type="text" name="city2" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="fo">Province:</td>&nbsp;
                     <td>   <input type="text" name="province2"  style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="fo">Country:</td>&nbsp;&nbsp;</td>
                     <td>   <input type="text" name="country2" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="fo">ZIP Code: </td>
                    <td><input type="text" name="zip2" style="height: 22px; width: 128px; " size="20" " /></td>

                </tr>
                <tr>
                    <td class="fo">Email:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <td><input type="text" name="email2" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="fo">Phone:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <td> <input type="text" name="phone2" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>

                </table>
                
    </div>
       
		<div class="fo" id="mydiv2" align="center">
		Your Shipping Information:<br><br>
     <table id="table 1" style="height: 37px; width: 22px; "  border="0" cellpadding="2" cellspacing="0" >
        <s:iterator items="{$CustomerData}" var="cd">
                <tr>
                    <td class="fo">Address:</td>&nbsp;
                        <td><input type="text" name="address" value="${CustomerData.address}" style="height: 22px; width: 128px; " size="20"  /></td>

                </tr>
                <tr>
                    <td class="fo">City:</td>&nbsp;&nbsp;&nbsp;&nbsp;
                       <td> <input type="text" name="city" value="${CustomerData.city}" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Province:</td>&nbsp;
                     <td>   <input type="text" name="province" value="${CustomerData.province}"  style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Country:</td>&nbsp;&nbsp;
                     <td>   <input type="text" name="Country" value="${CustomerData.country}"style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">ZIP Code: </td>
                    <td><input type="text" name="zip" value="${CustomerData.zipCode}"style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Email:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                    <td><input type="text" name="Email" value="${CustomerData.email}"style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
                <tr>
                    <td class="fo">Phone:</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <td> <input type="text" name="Phone" value="${CustomerData.phone}" style="height: 22px; width: 128px; " size="20" /></td>

                </tr>
</s:iterator>
                </table>
				  </div>
       
            <p>&nbsp;</p>
    
        <div align="center">  
        
   <button class="submit-button" type="submit" formaction="PlaceOrder">Proceed to Payment </button>
   
        </div>
        </div>
        </div>
            </body>
</html>
<br>
<br>
<%-- <%@ include file="Footer.jsp" %> --%>