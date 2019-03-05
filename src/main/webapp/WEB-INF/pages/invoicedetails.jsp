<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Confirmation</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
#customers {
   
    border-collapse: collapse;
    width: 50%;
}

#customers td, #customers th {
     border: 0px solid #ddd; 
    padding: 0px;
}

#customers tr:nth-child(odd){background-color: #f2f2f2;}
/* #customers tr:nth-child(even){background-color: #f2f2f2;} */

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 8px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>

</head>
<body>

<table align="center"  style="green"  id="customers">
<tr><th style="text-align: center" colspan="4">TjTyre Invoice Report</th></tr>
<c:choose>
<c:when test="${!empty invoice}">
<tr>
<td colspan="3">Sales Person  :</td>
<td> ${invoice.userId}</td>
</tr>
<tr>
<td colspan="3">Customer Name  :</td>
<td>${invoice.customerName}</td>
</tr>

<tr>
<td colspan="3">Contact Number  :</td>
<td>${invoice.contactNumber}</td>
</tr>
<tr>
<td colspan="3">Email  :</td>
<td>${invoice.email}</td>
</tr>
<tr>
<td colspan="3">Address  :</td>
<td>${invoice.address1}</td>
</tr>
<tr>
<td colspan="3">Address  :</td>
<td>${invoice.address2}</td>
</tr>
<tr>
<td colspan="3">city  :</td>
<td>${invoice.city}</td>
</tr>
<tr>
<td colspan="3">Vehicle Make:</td>
<td>${invoiceVehicle.vehiclemake}</td>
</tr>
<tr>
<td colspan="3">Vehicle Model:</td>
<td>${invoiceVehicle.vehiclemodel}</td>
</tr>
<tr>
<td colspan="3">Vehicle Number:</td>
<td>${invoiceVehicle.vehiclenumber}</td>
</tr>
<tr>
<td colspan="3">Vehicle K.M.:</td>
<td>${invoiceVehicle.vehiclekm}</td>
</tr>
<tr>
<td colspan="3">Vehicle Type:</td>
<td>${invoiceVehicle.vehicletype}</td>
</tr>
<td colspan="3">Tyre Pattern:</td>
<td>
  <c:forEach var="pattern" items="${invoiceItem.tyrepattern}">
	<option value="">${pattern}</option>
  </c:forEach>
  </td>
<tr>
<td colspan="3">Tyre Size:</td>
<td>
	 <c:forEach var="size" items="${invoiceItem.tyre_size}">
		<option value="">${size}</option>
 	</c:forEach>
</td>
</tr> 

<tr>
<td colspan="3">Total Price:</td>
<td>${invoice.total_price}</td>
</tr>
<tr>
<td colspan="3">Discount:</td>
<td>${invoice.discount}</td>
</tr>
<tr>
<td colspan="3">Payment Mode:</td>
<td>${invoice.payment_mode}</td>
</tr>
<tr>
<td colspan="3">Date:</td>
<td>${invoice.saledate}</td>
</tr>





</c:when>
</c:choose>
</table><br>

<div class="container">
<center> 
<button type="button" class="btn btn-outline-primary"  onclick="window.location.href='invoiceedit'">Back</button>
 <button type="button" class="btn btn-outline-primary"  onclick="window.location.href='createinvoiceconform'">Generate invoice</button>
</center>
</div>

</body>
</html>
