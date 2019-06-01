<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	 <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css\reset.css"> 
	<link rel="stylesheet" href="css\style.css">
	<link rel="stylesheet" href="css\style1.css">
	<link rel="stylesheet" href="css\table.css">
	<script src="js\modernizr.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>WAREHOUSE Registration </title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
   <script src="js\validation.js"></script> 
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
   




     	
</head>
<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>



<style>


</style>


<body>

<div id="content">
</div>

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
					 <div id="MainMenu">
        <div class="list-group panel">
         
         
          <a href="#demo3" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Registration<i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i></a>
          <div class="collapse" id="demo3">
          <a href="create_Dealer" class="list-group-item">Dealer Registration</a>
            <a href="createcity" class="list-group-item">City Registration</a>
            <a href="role" class="list-group-item">Role Registration</a>
            <a href="Poscreate" class="list-group-item">POS Registration</a>
			<a href="userregistration" class="list-group-item">User Registration</a>
			<a href="warehouseMasterLink" class="list-group-item">Warehouse Registration</a>
			<a href="tyrecreate" class="list-group-item">Item Registration</a>
			<a href="createroleaccess" class="list-group-item">Resource Role Access</a>
          </div>
          <a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Pevilleges Assign <i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i> </a>
          <div class="collapse" id="demo4">
           <!--  <a href="warehouseMasterLink" class="list-group-item">Warehouse Registration</a>
         --> <!--  <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a> -->
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		     <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
       <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Inquiry Form</a>
        
        </div>
      </div>
                
        
					
					</nav>
				 <div class="content-wrapper">
				   <div class="container"> 
			
           
            <br>
            <br>

                 
					 <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                              WAREHOUSE REGISTRATION
                                </font>
                            </div>
                   
  

                       
                      
							 <form  method="POST"  name="requisitionorder" id="WAREHOUSEREGISTRATION" action="createwarehouses">
                            <div class="row">
							
							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="warehouseid">warehouse ID</label></b>
                                                <input type="text" class="form-control" id="warehouseid" placeholder="Enter warehouse ID" name="warehouse_Id" required>
                                            </div>
                                        </div>	
										
						
								   
								   <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="warehouseName">warehouse Name</label></b>
                                                <input type="text" class="form-control" id="name" placeholder="Enter warehouse Name" name="name" required>
                                            </div>
										</div>
										
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="warehouseid">Location</label></b>
                                                <input type="textarea" class="form-control" id="location" placeholder="Enter Location" name="location" required>
                                            </div>
                                        </div>
							
							</div>
							<div class="row">
							      <div class="col-md-4">
                                            <div class="form-group">
                                                 <b><label for="Role">City</label></b>
                   				       	  <select class="form-control" class="form-control"  name="cityname"  id="City" required>
                                               <option value="">select city</option>
                                              <c:forEach var="cityname" items="${citydropdown}">
                                              <option value="${cityname.cityname}">${cityname.cityname}</option>
                                              </c:forEach>
											   
                                               </select>
                                            </div>
                                             <div class="form-group">
                                                 <b><label for="Role">Warehouse Type</label></b>
                   				       	  <select class="form-control" class="form-control"  name="warehouse_type"  id="warehouse_type" required>
                                               <option value="">select Warehouse Type</option>
											   <option value="City Warehouse">City Warehouse</option>
											   <option value="Factory Warehouse">Factory Warehouse</option>
                                               </select>
                                            </div>
                                        </div>

                                
								   
								   </div>


           
			 	
				
				
				
				
				<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-2"></div>
			    <div class="col-md-2">
                <input type="submit"  class="btn btn-danger submit-button" value="Save"></div>
                <div class="col-md-2">
				<input type="submit"  class="btn btn-danger submit-button" value="Cancel"></div>
				<div class="col-md-2"></div>
				</div>
				</div>
				</form>
				
		<table class="table">
                        <thead>
                            <tr>
                                <th> Name</th>
                                <th>Location</th>
								<th>City Name</th>
                                <th>Warehouse Type</th>
								<th>Delete</th>
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="wh" items="${warehousemast}">
							<tr>
							<td>${wh.name}</td>
							<td>${wh.location}</td>
							<td>${wh.cityname}</td>
							<td>${wh.warehouse_type}</td>
							<td><a href="deletecity?cityname=${city.cityname}"><i class="fa fa-trash w3-large  delete-row"></i></a></td>
							
							</tr>
							</c:forEach>
							
							  <spring:url value="/deletecity" var="deleteUrl"/>
                   
							
							
						
                            </tbody>
                       
                    </table>		
			 	
</div>
	</div>	
		
		
	</main> <!-- .cd-main-content -->
	
<script>
$(document).ready(function () {  
   $('form').validate( {debug: true} );
});
</script>



</body>
</html>