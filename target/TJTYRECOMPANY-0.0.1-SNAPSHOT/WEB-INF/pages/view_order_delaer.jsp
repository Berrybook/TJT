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
	<title>DEALER</title>
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
					
					<!-- <li><a href="createuserrolemappinglink" style=" text-decoration: none;">User Role Mapping</a></li>
					<li><a href="warehouseMasterLink" style=" text-decoration: none;">warehouse Master</a></li>
				 -->
					</ul>
					<li><a href="viewDealer" style=" text-decoration: none;">View Order</a></li>
				</nav>
			<div class="content-wrapper">
			
			 <br>
                    <br>
                     <div class="container">
                        
                            <div class="card-header" style="background-color:lightblue">
                              <center>  <font size="5px" color="white">
                                  View Order 
                                </font>
                                </center>
                            </div>
                            
                       
                    <br>
                    
                    <table class="table">
                        <thead>
                            <tr>
                            
                                <th>Raised_By</th>
                                <th>Requisation_Date</th>
								<th>Priority</th>
                                <th>Dealer_Id</th>
                                <th>Status</th>
                                <th>Approver</th>
								<th>Pattern</th>
                                <th>Size</th>
                                <th>Quantity</th>
                                <th>accept</th>
								<th>reject</th>
								
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="itemprice" items="${viewOrderByDealer}">
							<tr>
							<td >${itemprice.raised_By} </td>
							<td >${itemprice.requisation_Date} </td>
							<td>${itemprice.priority} </td>
							<td >${itemprice.dealer_id} </td>
							<td >${itemprice.status} </td>
							<td >${itemprice.approver} </td> 
							<td><c:forEach items="${itemprice.pattern }" var="pattern">
							<option>${pattern}</option>
							</c:forEach></td>
							<td><c:forEach items="${itemprice.size }" var="size">
							<option>${size}</option>
							</c:forEach></td>
							<td><c:forEach items="${itemprice.quantity }" var="quantity">
							<option>${quantity}</option>
							</c:forEach></td>
							<c:if test="${itemprice.status =='approved'  }">
							<td><a href="dealerupdateStatus?order_id=${itemprice.order_id}&status=accepted" class="btn btn-danger">Accept</a></td>
							<td><a href="dealerupdateStatus?order_id=${itemprice.order_id}&status=rejected" class="btn btn-danger">Reject</a></td>
							</c:if>
							</tr>
							</c:forEach>
                            </tbody>
                    </table>
               
                </div>
</div>
			

 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->



</body>
</html>