<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css\reset.css"> 
	<link rel="stylesheet" href="css\style.css">
	<link rel="stylesheet" href="css\style1.css">
	<link rel="stylesheet" href="css\table.css">
	<script src="js\modernizr.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
   <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Warehouse</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
   <script src="js\validation.js"></script> 
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> 
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="D:\jqueryval\jquery.validate.js"></script>
	<script src="D:\jqueryval\jquery.validate.min.js"></script>     
  
         
     <style>
	  .error {
    color: #ff0000;;
  }
  #errmsg
{
color: red;
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
            <!-- <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a> -->
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		    <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
		    <a href="CustomerInquaryForm" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
        </div>
      </div>
                
        
					</nav>
				 <div class="content-wrapper">
				   <div class="container"> 
			
           
            <br>
            <br>

                 
					 <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                          Resource Role Access
                                </font>
                            </div>
                   
  

                       
                        
							 <form action="createroleaccess" method="POST"  name="Warehouseregistration" enctype="multipart/form-data"  onSubmit="return cityvalidateForm()"">
                            <div class="row">
							
							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="level">Module</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="module_Id"  id="moduleId" >
                                               <option value="null" selected disabled>Select</option>
               						 <c:forEach var="modules" items="${allHierarchyModules}">
 											 <option value="${modules}">${modules}</option>
  								 			</c:forEach>
  								 			
  								 			
                                                </select>
                                            </div>
                                        </div>	
										
						
								   
								   <div class="col-md-4">
                                            <div class="form-group">
                                               <b><label for="level">Level</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="level"  id="level" >
                                               <option value="">select Level</option>
                                               
                                                </select>
                                        </div>
										</div>
										
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="role">Role</label></b>
<select class="form-control" class="form-control chosen-select"  name="role"  id="role" >
                                               <option value="">select Role</option>
                                               
                                                </select>
                                            </div>
                                        </div>
							
							</div>
							<div class="row">
							<div class="col-md-4">
							<b><label for="level">Access</label></b>
							</div>
							<div class="col-md-4">
                                        <div class="form-group">
                                         <input name="access"  type="checkbox" class="custom-control" id="" value="Create Order">Create Order <br>
											
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                          <input name="access" value="50" type="checkbox" class="custom-control" id="" onclick="" value="View Order">View Order<br>  
                                        </div>
                                    </div>
							</div>
							
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-2"><input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Submit"> </div>
                <div class="col-md-2">
                   </div>
                   
                   <div class="col-md-2"></div>
            </div>
			 	</form>	
			 	
			 	 <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Module </th>
                                <th>Level</th>
								<th>role</th>
                               <th>Access</th>
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="roleaccess" items="${allroleAcces}">
							<tr>
							<td>${roleaccess.module_Id}</td>
							<td>${roleaccess.level}</td>
							<td>${roleaccess.role}</td>
							<td>${roleaccess.accesses}</td>
						
						<!-- 	<td><a href="deletecity?"><i class="fa fa-trash w3-large  delete-row"></i></a></td> -->
							
							</tr>
							</c:forEach>
							
							 
                   
							
							
						
                            </tbody>
                       
                    </table>
			 	
				</div>
			 	
</div>
		
		
		
	</main> <!-- .cd-main-content -->
<script>
/* // lable according to module */
$(function(){
	$('#moduleId').on('change', function(){
	
		var module = $('#moduleId').val();
		alert(module)
	debugger;
		 $.ajax({
	            type: "GET",
	            contentType: "application/json; charset=utf-8",
	         	  datatype: "json",
	            url: "${pageContext.request.contextPath}/allLevelByModuleId/"+module+"",
	            success: function (response) {
	                 var label="";
	                
	               
	                 label+="<option value='"+response[i]+"'>Select Lables</option>"
	                  for(var i=0;i<response.length;i++){ 
	                	 
	                	  label+="<option value='"+response[i]+"'>"+response[i]+"</option>"
	                	 $('#level').html(label);
	                	  debugger;
	                	
	                }
	                 
	                 
	            },
	            error: function(e){
	            	 debugger;
	            	console.log("error");
	            }
		 });
	})
	})
	
	
	<!-- // role according to module_id and lable -->

$(function(){
	$('#level').on('change', function(){
		var moduleId = $('#moduleId').val();
		var level = $('#level').val();
	
		 $.ajax({
	            type: "GET",
	            contentType: "application/json; charset=utf-8",
	         	  datatype: "json",
	            url: "${pageContext.request.contextPath}/allRoleByModuleIdAndLevel/"+moduleId+","+level+"",
	            success: function (response) {
	                 var role="";
	                 
	              
	                 role+="<option value='"+response[i]+"'>Select Role</option>"
	                  for(var i=0;i<response.length;i++){ 
	                	 
	                	  role+="<option value='"+response[i]+"'>"+response[i]+"</option>"
	                	 $('#role').html(role);
	                	 
	                }
	                 
	                 
	            },
	            error: function(e){
	            	
	            	
	            	console.log("error");
	            }
		 });
        

	})
	})
</script>
</body>
</html>