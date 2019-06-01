
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<title>View Orders</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
       
	
	
	
</head>
<body>
        <header class="cd-main-header">
        
       
            <a href="#0" class="cd-nav-trigger"><span></span></a>
            <nav class="cd-nav">
                <ul class="cd-top-nav">
                    <li>
                        <p><a  href="logout" style=" text-decoration: none;"><i class="fa fa-power-off"></i>Logout</a></p>
                    </li>
                </ul>
            </nav>
        </header>
        <main class="cd-main-content">
            <nav class="cd-side-nav">
                <br>
                <ul>
                   <li><a href="requestOrder?access=Create Order" style=" text-decoration: none;">Create Order</a></li>
					<li><a href="viewOrderLink" style=" text-decoration: none;">View  Order</a></li>
					
                </ul>
            </nav>
            <div class="content-wrapper">
			
               
                    <br>
                    <br>
                    
                    
                        
                            <div class="card-header" style="background-color:lightblue">
                              <center>  <font size="5px" color="white">
                                    View RO By Channel Executive 
                                </font></center>
                            </div>
                            <br>
                      
                    
                   
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Order id</th>
                                <th>Requisation Date</th>
								<th>Dealer id</th>
								<th>Approver</th>
								<th>Status</th>
                                <th>Pattern</th>
								<th>Size</th>
								<th>Quantity</th>
								
								<th>Edit</th>
								
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="order" items="${orderdetails}">
							<tr>
							<td>${order.order_id}</td>
							<td>${order.requisation_Date}</td>
							<td>${order.dealer_id}</td>
							<td>${order.approver}</td>
							<td>${order.status}</td>
							<td><c:forEach items="${order.pattern }" var="pattern">
							<option>${pattern}</option>
							</c:forEach></td>
							<td><c:forEach items="${order.size }" var="size">
							<option>${size}</option>
							</c:forEach></td>
							<td><c:forEach items="${order.quantity }" var="quantity">
							<option>${quantity}</option>
							</c:forEach></td>
							<td><a href="#"><i class="fa fa-edit"></i></a></td>
							
							</tr>
							</c:forEach>
							
							
                   
							
							
						
                            </tbody>
                       
                    </table>
					
					
					<div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-2"><!-- <input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Edit">  --></div>
                <div class="col-md-2">
                   </div>
                   
                   <div class="col-md-2"></div>
            </div>
			
                
            </div><!-- .content-wrapper -->
			
        </main> <!-- .cd-main-content -->
    </div>


	
	
</body>
</html>