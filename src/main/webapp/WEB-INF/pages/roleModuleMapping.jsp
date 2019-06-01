<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
	<title>Role Module Mapping</title>
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
    background-color:lightgray;
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
    background-color:white;
    top:1px;
	border: 1px dotted black;
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


<style>
	.list-group-item-success{
	background-color:lightblue;
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
					 <div id="MainMenu">
        <div class="list-group panel">
         
         
          <a href="#demo3" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Registration<i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i></a>
          <div class="collapse" id="demo3">
          <a href="create_Dealer" class="list-group-item">Dealer Registration</a>
            <a href="createcity" class="list-group-item">City Registration</a>
            <a href="role" class="list-group-item">Role Registration</a>
            <a href="Poscreate" class="list-group-item">POS Registration</a>
			<a href="userregistration" class="list-group-item">User Registration</a>
			<a href="" class="list-group-item">Warehouse Registration</a>
			<a href="tyrecreate" class="list-group-item">Item Registration</a>
			<a href="createroleaccess" class="list-group-item">Resource Role Access</a>
          </div>
          <a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Pevilleges Assign <i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i> </a>
          <div class="collapse" id="demo4">
            <a href="warehouseMasterLink" class="list-group-item">Warehouse Assign</a>
          <!--   <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a> -->
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		    <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
		    
        </div>
      </div>
                
        
					
					
						</nav>
				 <div class="content-wrapper">
				   <div class="container"> 
			
           
            <br>
            <br>

                 
					 <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                             Role Module Mapping
                                </font>
                            </div>
                   
  
                             <br><br>
							 
							 
                       
                        
							 <form  method="POST" action="createRoleModuleMapping" name="rolemodule" id="rolemodule" >
                            <div class="row">
							
					
					
										</div>
										
										
										
										
										
										
										
										
										
						<div class="row">
								   <div class="col-md-4">
								    
									
									
										<div class="form-group">
                                               <b><label for="module">Module</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="module"  id="module" >
                                               <option value="">select Module</option>
                                             <c:forEach items="${ allModuleDropdown}" var="modules">
                                             <option value="${modules.module_Id }">${modules.module_Id }</option>
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
                 <c:forEach items="${allRoleDropdown}" var="roles">
                  <br>
                      <input type="checkbox" value="${roles}" name="role" />${roles}
                   </c:forEach>
                   </li> 
             
                
            </ul>
        </div>
    </dd>
</dl>
								   
								   
								   
								   
								   </div>
									   
										</div>
										
							<!-- <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Role Description">Description</label></b>
                                                <textarea class="form-control" id="Description" placeholder="Description" name="descrption"></textarea>
												
                                            </div>
                                        </div> -->
							
							</div>
						
							
  
    
    
      
                                
    
    
  
  

				
				<br>
				<br>
				<br>
				<br>
				
			     <div class="row">
				 <div class="col-md-2"></div>
				 <div class="col-md-2"></div>
				 <div class="col-md-2">
				 <input type="submit"  class="btn btn-danger submit-button" value="Submit">
				 </div>
				<div class="col-md-2">
				<!-- <input type="submit"  class="btn btn-danger submit-button" value="delete" >-->
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
                                <th>Module</th>
                                <th>Role</th>
								
                                
								
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="userrole" items="${rolemodulemapping }">
							<tr>
							<td>${userrole.module}</td>
							<td>${userrole.roles}</td>
							
							
							
							</tr>
							</c:forEach>
							
							  <spring:url value="/deletecity" var="deleteUrl"/>
                   
							
							
						
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