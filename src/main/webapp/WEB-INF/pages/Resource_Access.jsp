<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
head>
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  <script type="text/javascript">
    $('#module').change(function(){
    var moduleID = $(this).val();    
    if(moduleID){
        $.ajax({
           type:"GET",
           url:"{{url('allModule')}}?module_id="+moduleID,
           success:function(res){               
            if(res){
                $("#level").empty();
                $("#level").append('<option>Select</option>');
                $.each(res,function(key,value){
                    $("#level").append('<option value="'+key+'">'+value+'</option>');
                });
           
            }else{
               $("#level").empty();
            }
           }
        });
    }else{
        $("#level").empty();
        $("#role").empty();
    }      
   });
    $('#level').on('change',function(){
    var levelID = $(this).val();    
    if(levelID){
        $.ajax({
           type:"GET",
           url:"{{url('allLevelByModuleId/{moduleId}')}}?level_id="+levelID,
           success:function(res){               
            if(res){
                $("#role").empty();
                $.each(res,function(key,value){
                    $("#role").append('<option value="'+key+'">'+value+'</option>');
                });
           
            }else{
               $("#role").empty();
            }
           }
        });
    }else{
        $("#role").empty();
    }
        
   });
</script>
         
     <style>
	  .error {
    color: #ff0000;;
  }
  #errmsg
{
color: red;
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
                          Resource Role Access
                                </font>
                            </div>
                   
  

                       
                        
							 <form  method="POST"  name="warehouse" id="warehouse" >
                            <div class="row">
							
							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="level">Module</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name=""  id="Module_Id" >
                                               <option value="null" selected disabled>Select</option>
               						 <c:forEach  items="${allHierarchyModule}" var="modules">
 											 <option value="${modules}">${modules}</option>
  								 			</c:forEach>
  								 			
  								 			
                                                </select>
                                            </div>
                                        </div>	
										
						
								   
								   <div class="col-md-4">
                                            <div class="form-group">
                                               <b><label for="level">Level</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name=""  id="level" >
                                               <option value="">select Level</option>
                                               
                                                </select>
                                        </div>
										</div>
										
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="role">Role</label></b>
<select class="form-control" class="form-control chosen-select"  name=""  id="role" >
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
                                         <input name=""  type="checkbox" class="custom-control" id="" onclick="">Create Order <br>
											
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                          <input name="" value="50" type="checkbox" class="custom-control" id="" onclick="">View Order<br>  
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
				</div>
			 	
</div>
		
		
		
	</main> <!-- .cd-main-content -->
	<script>
$(function() {
  
  $("form[name='warehouse']").validate({
   
    rules: {
      
      warehouseid: "required",
	  level:"required",
      parentid: "required",
	  role: "required",
	 
	 
     
	  
    },
   
    messages: {
        warehouseid: "Please enter    warehouseid",
	   level: "Please choose  level",
	    parentid: "Please enter  parentid",
		 role: "Please choose role",
		  
			   
      
     
      
    },
    
    submitHandler: function(form) {
      form.submit();
    }
  });
});

</script>
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
});
</script>

</body>
</html>