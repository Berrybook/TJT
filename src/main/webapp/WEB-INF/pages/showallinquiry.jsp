<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	
</head>
<body>
	
<table  border="1" class="table" >
		

		<tr  id="heder">
		<th><b>Customer Name</b></th>
		<th><b>Phone Number</b></th>
		<th><b>Date</b></th>
		<th><b>Vehicle</b></th>
		<th><b>Vehicle Model</b></th>
		<th><b>Tyre Size</b></th>
		<th><b>Meter Reading</b></th>
		<th><b>Comment</b></th>
		</tr>
		<c:forEach var="val" items="${val}">
		<tr>
		
		
			<th><b>${val.customerName}</b></th>
		 <th><b>${val.phoneNumber}</b></th>
		  <th><b>${val.tentadate}</b></th> 
		<th><b>${val.vehicle}</b></th>
		<th><b>${val.vehicleModel}</b></th>
				<th><b>${val.tyreSize}</b></th>
			<th><b>${val.meterReading}</b></th>
		<th><b>${val.comments}</b></th>
		
	
		
		</tr>
			</c:forEach>
		
		</table>
</body>
</html>