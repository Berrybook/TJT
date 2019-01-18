<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TJTYRE INVOICE </title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 50%;
}

#customers td, #customers th {
     border: 0px solid #ddd; 
    padding: 8px;
}

#customers tr:nth-child(odd){background-color: #f2f2f2;}
/* #customers tr:nth-child(even){background-color: #f2f2f2;} */

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
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
<c:when test="${!empty result}">
<br>
<br>

<tr>

<td colspan="2">Date :</td>
<td colspan="2">${result.saledate}</td>
</tr>

<tr>

<td colspan="2">salesPersion :</td>
<td colspan="2">${result.userid}</td>
</tr>
<tr>
<td colspan="2">customerName :</td>
<td colspan="2">${result.customerName}</td>
</tr>

<tr>
<td colspan="2">contactNumber :</td>
<td colspan="2">${result.contactNumber}</td>
</tr>
<tr>
<td colspan="2">email :</td>
<td colspan="2">${result.email}</td>
</tr>
<tr>
<td>CGST :</td>
<td >14%</td>
<td>SGST :</td>
<td >14%</td>
</tr>

<tr>
<td colspan="2">total price :</td>
<td colspan="2">${result.total_price}</td>
</tr>
</c:when>
</c:choose>
</table><br>

<div class="container">
<center>  <button type="button" class="btn btn-outline-primary"  onclick="window.location.href='pdfgeneration'">PDF Download</button>
 	<button type="button" class="btn btn-outline-primary"  onclick="window.location.href='send'">Send Mail</button>

</div>

</body>
</html>