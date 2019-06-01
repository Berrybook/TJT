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
	<title>WAREHOUSE REGISTRATION </title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
   <script src="js\validation.js"></script> 
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
   




     	
</head>


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
					<ul>
					<li><a href="create_Dealer" style=" text-decoration: none;">Dealer Registration</a></li>
                	<li><a href="createcity" style=" text-decoration: none;">City Registration</a></li>
					<li><a href="role" style=" text-decoration: none;">Role Registration</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration"style=" text-decoration: none;">User Registration</a></li>
					<li><a href="tyrecreate" style=" text-decoration: none;">Item Registration</a></li>
					<li><a href="item_price_assign" style=" text-decoration: none;">Price Assignment</a></li>
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>	
					<li><a href="createuserrolemappinglink" style=" text-decoration: none;">User Role Assign</a></li>
					<li><a href="warehouseMasterLink" style=" text-decoration: none;">Warehouse Registration</a></li>	
					<li><a href="createrolmodulemappinglink" style=" text-decoration: none;">Role Module Assign</a></li>
					<li><a href="createroleaccess" style=" text-decoration: none;">Resource Role Access</a></li>
					<li><a href="warehouseRegistration" style=" text-decoration: none;">warehouse user asgn</a></li>	
            
					</ul>
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
                                                <input type="text" class="form-control" id="warehouseName" placeholder="Enter warehouse Name" name="name" required>
                                            </div>
										</div>
										
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="warehouseid">Location</label></b>
                                                <input type="textarea" class="form-control" id="Location" placeholder="Enter Location" name="location" required>
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
                   				       	  <select class="form-control" class="form-control"  name="warehouse_type"  id="City" required>
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
				
		<table class="table">
                        <thead>
                            <tr>
                                <th>name</th>
                                <th>location</th>
                                <th>city name</th>
                                <th>warehouse type</th>
                            </tr>
                        </thead>
                        <tbody id="tbData">
                            <tr v-for="item in WarehouseMasterList">
                            	<td>{{item.name}}</td>
                            	<td>{{item.location}}</td>
                                <td><span  v-on:click="Load(item)">{{item.cityname}}</span></td>
                                <!--<td>{{item.role}}</td>-->
                                <td>{{item.warehouse_type}}</td>
                            </tr>
                        </tbody>
                    </table>
				
		</form>			
			 	
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