<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css\reset.css"> 
	<link rel="stylesheet" href="css\style.css">
	<link rel="stylesheet" href="css\table.css">
	<script src="js\modernizr.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Role</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>    
        
     
	
	
</head>
<body>


	<header class="cd-main-header">
		
		
		<a href="#0" class="cd-nav-trigger"><span></span></a>

		

		<nav class="cd-nav">
			<ul class="cd-top-nav">
		
		<li >
					<p><a  href="logout" style=" text-decoration: none;"><i class="fa fa-power-off"></i>Logout</a></p>
</li>
	</header> 
</nav>

	<main class="cd-main-content">
	
		<nav class="cd-side-nav">
			
				<br>
					<ul>
					
					
					
						<!-- <li><a href="createinvoice" style=" text-decoration: none;">New Invoice</a></li>
						<li><a href="saletransaction" style=" text-decoration: none;">Sales Transaction</a></li>
						<li><a href="priceListByPos" style=" text-decoration: none;">PriceList</a></li>
						<li><a href="CurrentMonthsalesReport" style=" text-decoration: none;">Month Report</a></li>
						<li><a href="requestOrder?access=Create Order" style=" text-decoration: none;">Create Order</a></li>
						<li><a href="viewOrder?access=View Order" style=" text-decoration: none;">view Order</a></li>
					 -->
					    <li><a href="createinvoice" style=" text-decoration: none;">New Invoice</a></li>
						<li><a href="saletransaction" style=" text-decoration: none;">Sales Transaction</a></li>
						<li><a href="priceListByPos" style=" text-decoration: none;">PriceList</a></li>
						<li><a href="CurrentMonthsalesReport" style=" text-decoration: none;">Month Report</a></li>
						<li><a href="requestOrderbypos?access=Create Order" style=" text-decoration: none;">Create Order</a></li>
						<!-- <li><a href="viewOrder?access=View Order" style=" text-decoration: none;">view Order</a></li> -->
						
					</ul>
				

				</nav>
			
			
			<div class="content-wrapper">
		<br>
			
			
</div>
			

 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
<table style='color:red;text-align:center'>
<tr style='color:black'>
<td>order_Id</td>
<td>Reased_By</td>
<td>requisation_Date</td>
<td>priority</td>
<td>userId</td>
<td>pattern</td>
<td>size</td>
<td>quantity</td>
</tr>
<c:forEach items="${view_order }" var="vieworder">
<tr style='color:blue'>
<td>${vieworder.order_id }</td>
<td>${vieworder.raised_By }</td>
<td>${vieworder.requisation_Date }</td>
<td>${vieworder.priority }</td>
<td>${vieworder.userId }</td>
<td>
<c:forEach items="${vieworder.pattern  }" var="pattern">
<option>${pattern}</option>
</c:forEach>
</td>
<td>
<c:forEach items="${vieworder.size }" var="size">
<option>${size}</option>
</c:forEach>
</td>
<td>
<c:forEach items="${vieworder.quantity }" var="quantity">
<option>${quantity}</option>
</c:forEach>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>