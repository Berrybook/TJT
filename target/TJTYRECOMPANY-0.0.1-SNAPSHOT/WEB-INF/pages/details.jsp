<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<title>Invoice</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
<style>
table, td, th {
  border: 1px solid black;
}

table {
  border-collapse: collapse;
  width: 70%;
}

td {
  height: 60px;
  vertical-align: bottom;
  font-size: 15px;
}


p.groove {border:1px solid black;}
</style>
</head>
<body>
<center>
<h2><b>TAX INVOICE</h2>
<div class="row">
<div class="col-md-5">
<img src="image/logo.jpg" alt="logo" style="width:90px; height:90px;">

</div>
<div class="col-md-2"></div>
<div class="col-md-5">
</div>
</div>

 <p>TYCHEEJUNO SPECIALITY TYRES PVT. LTD. <br>

4781, 18th street, Vidyut Nagar, New Mig Colony, Ramachandrapuram<br>

Telengana - 517520, India</p>
<br>
<table>
  
  <tr>
    <td colspan="5" style="height:190px;"><h5><ins>Bill To:-</ins></h5><br><h6>${result.customerName},<br>${result.address1},
${result.address2},<br>${result.city}<br>
Cell No: ${result.contactNumber}<br>
E-Mail ID: ${result.email}</h6></td>
    <th   style="width:300px;">Invoice Number: ${result.invoice_Number}<br><h6>Invoice Date:${result.saledate}</h6><br>
	<br><br><br><br></th>
     
  </tr>
  <tr style="border:3px solid black;">
    <th>Sl.No.</th>
    <th>Description of Goods</th>
    <th>HSN Code</th>
    <th>Quantity</th>
    <th>Rate</th>
    <th>Amount</th>
  </tr>

  <c:if test="${result.quantity==1 }">
   <tr>
    <td><p>1</td>
    <c:forEach var="item"  begin="0" end="${fn:length(result.tyresizes) - 1}" >
    <td>${result.tyresizes[item]} ${result.tyrepatterns[item]}</td>
    <td>40114010</td>
    <td>${result.quantity}</td>
    <td>${result.basicPrices[item]}</td>
    <td>${result.basicPrices[item]}</td>
    
    </c:forEach>
</tr>
  </c:if>
   <c:if test="${result.quantity=='2'}">
  <c:choose>
  <c:when test="${(result.tyrepatterns[0]==result.tyrepatterns[1])&&(result.tyresizes[0]==result.tyresizes[1]) }"> 
  	<tr>
  	<td><p>1</td>
  	<td>${result.tyresizes[0]} ${result.tyrepatterns[0]}</td>
    <td>40114010</td>
    <td>${result.quantity}</td>
    <td>${result.basicPrices[0]}</td>
    <td>${result.basicPrice}</td>
    </tr>
    
  </c:when>
 
  <c:otherwise>
 	<tr>
 	<td>1</td>
 		<td>${result.tyresizes[0]} ${result.tyrepatterns[0]}</td>
  	 <td>40114010</td>
    <td>1</td>
    <td>${result.basicPrices[0]}</td>
    <td>${result.basicPrices[0]}</td>
    </tr>
    <tr>
    <td>2</td>
  	<td>${result.tyresizes[1]} ${result.tyrepatterns[1]}</td>
  	 <td>40114010</td>
    <td>1</td>
    <td>${result.basicPrices[1]}</td>
    <td>${result.basicPrices[1]}</td>
 	</tr>
  </c:otherwise>
 
  </c:choose>
   </c:if>
   <tr>
   <td colspan='4' rowspan='4' ></td>
    		<td >Discount</td>
    <td >${result.discount}</td>
   </tr>
  <tr>
    <td>Taxable Amount</td>
    <td>${result.taxble_amount}</td>
   
  </tr>
  
   <tr>
    <td >CGST @ 14%</td>
    <td>${result.total_cgst}</td>
   
  </tr>
  
   <tr>
    <td >SGST @ 14%</td>
    <td>${result.total_sgst}</td>
   
  </tr>
   <tr>
    <td colspan="4">Amount in Words:${result.price_in_word} </td>
    <td>Total Amount</td>
    <td>${result.total_price}</td>
    
  </tr>
   <tr>
    <td colspan="6">The Aforesaid Tax is not payable on reverse charge mechanism.</td>
    
	
	
  </tr>
  <tr>
<td  colspan="6">*This is a System generated Invoice. No stamp or Signature is required.</td>

</tr>
  
</table>



<div class="container">
  <button type="button" class="btn btn-outline-primary"  onclick="window.location.href='pdfgeneration'">PDF Download</button>
 	<button type="button" class="btn btn-outline-primary"  onclick="window.location.href='send'">Send Mail</button>
</div>
</center>

</body>
</html>
