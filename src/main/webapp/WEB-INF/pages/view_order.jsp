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
	<title>View Order</title>
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
					
					
					
				
					<li><a href="viewOrder?access=View Order" style=" text-decoration: none;">view Order</a></li>
					
					</ul>
				

				</nav>
			
			
			<div class="content-wrapper">
		<br><br><br>
			
			

			

 
	
<table class="table">
<tr>
<th>order_Id</th>
<th>Reased_By</th>
<th>requisation_Date</th>
<th>priority</th>
<th>userId</th>
<th>pattern</th>
<th>size</th>
<th>quantity</th>
</tr>
<tr>
<td>${view_orders.order_id }</td>
<td>${view_orders.raised_By }</td>
<td>${view_orders.requisation_Date }</td>
<td>${view_orders.priority }</td>
<td>${view_orders.userId }</td>
<td>
<c:forEach items="${view_orders.pattern  }" var="vieworder">
<option>${vieworder}</option>
</c:forEach>
</td>
<td>
<c:forEach items="${view_orders.size }" var="vieworder">
<option>${vieworder}</option>
</c:forEach>
</td>
<td>
<c:forEach items="${view_orders.quantity }" var="vieworder">
<option>${vieworder}</option>
</c:forEach>
</td>
</tr>
</table>

<center>
                                         <input type="submit" value="Shipment" class="btn btn-danger">
                                        </center>
                            






</div>
	<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->

</body>
</html>