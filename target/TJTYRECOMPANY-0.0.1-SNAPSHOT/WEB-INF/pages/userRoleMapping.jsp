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
	<title>User Role Mapping</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
   <script src="js\validation.js"></script> 
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
   




     <style>
	 
	 
	 


.colors {
 
  display: none;
}


 



.dropdown dd, .dropdown dt {
    margin:0px;
    padding:0px;
}
.dropdown ul {
    margin:0px;
    padding:0px;
}
.dropdown dd {
    position:relative;
    margin:0px;
    padding:0px;
}
.dropdown a, .dropdown a:visited {
    color:green;
    text-decoration:none;
    outline:none;
    margin:0px;
    padding:0px;
    min-height: 20px;
    border-radius: 3px;
}
.dropdown dt a {
    background-color:lightblue;
	width:100%;
	height:35px;
    display:block;
    overflow: hidden;
    
    margin:0px;
    padding:0px;
}
.dropdown dt a span, .multiSel span {
    cursor:pointer;
    display:inline-block;
    margin:0px;
    padding:5px 10px;
}
.dropdown dd ul {
    background-color:lightblue;
    top:1px;
    color:green;
    display:none;
    position:absolute;
    width:100%;
    list-style:none;
    height: 100px;
    overflow: auto;
    margin:0px;
    padding:0px;
}


	 
	 
</style>	
</head>




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
                            User Role  Mapping
                                </font>
                            </div>
                   
  
                             <br><br>
							 
							 
                       
                        
							 <form  method="POST" action="createUserRoleMapping" name="userrolemapping" id="userrolemapping" >
                            <div class="row">
							
					
					
										</div>
						<div class="row">
						
						
						 <div class="col-md-4">
                                            <div class="form-group">
                                               <b><label for="userid">User Id</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="userid"  id="userid">
                                               <option value="">select User Id</option>
                                               <c:forEach var="userids" items="${getallUser}">
 											 <option value="${userids}">${userids}</option>
  								 			</c:forEach>
                                                </select>
                                        </div>
										</div>
					
								   <div class="col-md-4">
								    <div class="form-group">
                                               <b><label for="module">Role</label></b>
								   
								   
								    <dl class="dropdown"> <dt>
    <a href="#">
      <span class="hida ">- - Select role - -</span>    
      <p class="multiSel"></p>  
    </a>
    </dt>

    <dd>
        <div class="mutliSelect">
            <ul>
                <li>
                   <c:forEach items="${getAllRole}" var="roles">
                  <br>
                      <input type="checkbox" value="${roles}" name="role" />${roles}
                   </c:forEach></li>
             
                
                
            </ul>
        </div>
    </dd>
</dl>
								   
								   
								   
								   
								   </div>
								   </div>
								  
										
							
							
							</div>
						
							
  
    
    
      
                                
    
    
  
  

				
				<br>
				<br><br><br><br>
				
				
			     <div class="row">
				 <div class="col-md-2"></div>
				 <div class="col-md-2"></div>
				 <div class="col-md-2">
				 <input type="submit"  class="btn btn-danger submit-button" value="Submit">
				 </div>
				<div class="col-md-2">
				<!-- <input type="submit"  class="btn btn-danger submit-button" value="delete"> -->
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-2"></div>
				</div>
           	</form>	     
				
  </div>
  
  
    <br>
   <table class="table">
                        <thead>
                            <tr>
                                <th>User Id</th>
                                <th>Role</th>
								
                                
								
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="userrole" items="${allUserRole}">
							<tr>
							<td>${userrole.userid}</td>
							<td>${userrole.roles}</td>
							
							
							
							</tr>
							</c:forEach>
							
						
                   
							
							
						
                            </tbody>
                       
                    </table>
  
  
  
  
  
  
</div>
                                     

           
			 
				
		
		
	</main> <!-- .cd-main-content -->

<script>
$(document).ready(function () {
  //called when key is pressed in textbox
  $("#quantity").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
   
   
   
$(".dropdown dt a").on('click', function () {
    $(".dropdown dd ul").slideToggle('fast');
});


   
   
   
   
});
</script>






</body>
</html>
</html>