
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
	<!-- <meta charset="UTF-8"> -->
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
   

<script type="text/javascript">

function wareHouseValidation(){
		if((document.getElementById('warehouse_Id').value==""))
		 {
		  document.getElementById('error').innerHTML = "Please enter  warehouse_Id";
		  Warehouseregistration.warehouse_Id.focus();
		  return(false);
		 }
		
		else 
		{
			 return(true);
		 }
		
	}
</script>


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
    min-height: 30px;
    border-radius: 3px;
}
.dropdown dt a {
    background-color:lightblue;
	width:32%;
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
    width:32%;
    list-style:none;
    height: 100px;
    overflow: auto;
    margin:0px;
    padding:0px;
}
.dropdown span.value {
    display:none;
    border-radius: 3px;
    margin:0px;
    padding:0px;
}
.dropdown dd ul li a {
    display:block;
    margin:0px;
    padding:0px;
}
.dropdown dd ul li a:hover {
  
    margin:0px;
    padding:0px;
}

.btn{
position:absolute;
right:40%;

}
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
				   
		<c:if test="${not empty warehouse_registration}"><script>popup('${warehouse_registration}') </script></c:if>
			
           
            <br>
            <br>

                 
					 <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                              WAREHOUSE REGISTRATION 
                                </font>
                            </div>
                   
					
								 <form action="createwarehouse" method="POST"  name="Warehouseregistration" enctype="multipart/form-data"  onsubmit="return wareHouseValidation()">
							 
                            <div class="row">
							
							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="warehouseid">warehouse ID</label></b>
                                              <!--   <input type="text" class="form-control" id="warehouseID" placeholder="Enter warehouse ID" id="warehouse_Id" name="warehouse_Id" > -->
                                          <select class="form-control" class="form-control chosen-select"  name="warehouse_Id"  id="warehouse_Id" >
                                           <option value="">select WareHouse</option>
                                               	<c:forEach var="warehouse" items="${allWareHouseId}">
										<option value="${warehouse.warehouse_Id}">${warehouse.warehouse_Id}(${warehouse.warehouse_type})</option>
									</c:forEach>
									
								</select>
                                            </div>
                                        </div>	
										
						
								   
								   <div class="col-md-4">
                                            <div class="form-group">
                                               <b><label for="module">Module</label></b>
                                               
                   				       	  <select class="form-control" class="form-control chosen-select"  name="module_Id"  id="module" >
                                           <option value="">select Module</option>
                                               	<c:forEach var="moduleID" items="${allHierarchyModule}">
										<option value="${moduleID}">${moduleID}</option>
									</c:forEach>
									
								</select>
				
                               
                                        </div>
										</div>
										
							 <div class="col-md-4">
                                            <div class="form-group">
                                                 <b><label for="raisedby">Lable</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="label"  id="label" >
                                               <option value="">select Lable</option>
                                              
                                               </select>
                                            </div>
                                        </div>
							
							</div>
							<div class="row">
							      <div class="col-md-4">
                                            <div class="form-group">
                                                 <b><label for="role">Role</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="role"  id="role" >
                                               <option value="">select Role</option>
                                           
                                               
                                               </select>
                                            </div>
                                        </div>

                                <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="userId">User id</label></b>
                                            <select class="form-control" class="form-control chosen-select"  name="userid"  id="userID" >
                                               <option value="">select User id</option>
                                               
                                                </select>
                                            </div>
                                        </div>

                                      
										  <div class="col-md-4">
                                            <div class="form-group  dropdown">
                                                <b><label for="size">Level</label></b>
<select class="form-control" class="form-control chosen-select"  name="level"  id="level" >
                                               <option value="">select Level</option>
                                           									   
                                                </select>

                                            </div>
                                        </div>
								   
								   </div>
								   
                                     <br>    
                                      <div class="output">
  <div id="red" class="colors">  
  
    
    <dl class="dropdown"> <dt>
    <a href="#">
      <span class="hida ">- - Select city child - -</span>    
      <p class="multiSel"></p>  
    </a>
    </dt>

    <dd>
        <div class="mutliSelect">
            <ul>
                <li>
                    <input type="checkbox" value="city1" />city1</li>
                <li>
                    <input type="checkbox" value="city2" />city2</li>
                <li>
                    <input type="checkbox" value="city3" />city3</li>
                <li>
                    <input type="checkbox" value="city4" />city4</li>
                <li>
                    <input type="checkbox" value="city5" />city5</li>
                
            </ul>
        </div>
    </dd>
</dl>
    
   </div> 
    
  
    
    
    
    
  
  
  <div id="yellow" class="colors yellow">
  
  
  <dl class="dropdown"> <dt>
    <a href="#">
      <span class="hida">- Select city warehouse-</span>    
      <p class="multiSel"></p>  
    </a>
    </dt>

    <dd>
        <div class="mutliSelect">
            <ul>
                <li>
                    <input type="checkbox" value=" warehouse1" /> warehouse1</li>
                <li>
                    <input type="checkbox" value=" warehouse2" /> warehouse2</li>
                <li>
                    <input type="checkbox" value=" warehouse3" /> warehouse3</li>
                <li>
                    <input type="checkbox" value=" warehouse4" /> warehouse4</li>
                <li>
                    <input type="checkbox" value=" warehouse5" /> warehouse5</li>
                <li>
                    <input type="checkbox" value=" warehouse6" /> warehouse6</li>
            </ul>
        </div>
    </dd>
</dl>
    
    
  
  
  </div>
  
</div>
                                     

           
			 	
				
				
				
				
				
			
                <input type="submit"  class="btn btn-danger submit-button" value="Save"><br><br>
                
                
				</form>
				
				
				
				
				 <table class="table">
                        <thead>
                            <tr>
                                <th>warehouseID </th>
                                <th>module</th>
						
                                <th>role</th>
                                <th>userID</th>
                        
								
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="wh" items="${allWarehouse}">
							<tr>
							<td>${wh.warehouse_Id}</td>
							<td>${wh.module_Id}</td>
							
							<td>${wh.role}</td>
							<td>${wh.userid}</td>
							
							
							</tr>
							</c:forEach>
							
							  <spring:url value="/deletecity" var="deleteUrl"/>
                   
							
							
						
                            </tbody>
                       
                    </table>
            
                 
            
				
				</div>
				
				
		
				
				
			 	
</div>
		
		
		
	</main> <!-- .cd-main-content -->
	<script>
$(function() {
  
  $("form[name='requisitionorder']").validate({
   
    rules: {
      
    	module: "required",
    	label:"required",
      role: "required",
      userID: "required",
	  level: "required",
	  
	 
     
	  
    },
   
    messages: {
    	module: "Please enter your  sourceid",
    	label: "Please enter  role",
    	role: "Please enter your raisedby",
    	userID: "Please enter expecteddate",
    	level: "Please enter your tyrepattern",
		  
			
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



<script>
$(function() {
  $('#colorselector').change(function(){
    $('.colors').hide();
    $('#' + $(this).val()).show();
  });
});
// [forked from](http://jsfiddle.net/FvMYz/)
// [show-hide-based-on-select-option-jquery)(http://stackoverflow.com/questions/2975521/show-hide-div-based-on-select-option-jquery/2975565#2975565)


$(".dropdown dt a").on('click', function () {
    $(".dropdown dd ul").slideToggle('fast');
});

$(".dropdown dd ul li a").on('click', function () {
    $(".dropdown dd ul").hide();
});

function getSelectedValue(id) {
    return $("#" + id).find("dt a span.value").html();
}

$(document).bind('click', function (e) {
    var $clicked = $(e.target);
    if (!$clicked.parents().hasClass("dropdown")) ;
});


$('.mutliSelect input[type="checkbox"]').on('click', function () {

    var title = $(this).closest('.mutliSelect').find('input[type="checkbox"]').val(),
        title = $(this).val() + ",";

    if ($(this).is(':checked')) {
        var html = '<span title="' + title + '">' + title + '</span>';
        $('.multiSel').append(html);
        $(".hida").hide();
    } else {
        $('span[title="' + title + '"]').remove();
        
        

    }
});

$(document).ready(function(){
    $('.add').click(function(){
        $("#tes").append('<br><div class="row"><div class="col-md-3"></div><br> <div class="col-md-3"><select name="LIVINGSTYLE" id="test">'+
                          '<option value="1">Option 1</option>'+
                          '<option value="2">Option 2</option>'+
                          '<option value="3">Option 3</option>'+
                          '<option value="4">Option 4</option>'+
                        '</select></div><br> <div class="col-md-3"><select name="LIVINGSTYLE" id="test">'+
                          '<option value="1">Option 1</option>'+
                          '<option value="2">Option 2</option>'+
                          '<option value="3">Option 3</option>'+
                          '<option value="4">Option 4</option>'+
                        '</select></div><br>  <div class="col-md-3"><input type="text"></div> <div><a href="javascript:void(0);" class="remCF">Remove</a></div></div>');
    });



 
});





</script>
<script>
// lable according to module
$(function(){
	$('#module').on('change', function(){
	
		var module = $('#module').val();
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
	                	 $('#label').html(label);
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
	
	
	// role according to module_id and lable
	
$(function(){
	$('#label').on('change', function(){
		var module = $('#module').val();
		var label = $('#label').val();
	
		 $.ajax({
	            type: "GET",
	            contentType: "application/json; charset=utf-8",
	         	  datatype: "json",
	            url: "${pageContext.request.contextPath}/allRoleByModuleIdAndLevel/"+module+","+label+"",
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
	
	// user_id according to role 
		$(function(){
	$('#role').on('change', function(){
	
		var role = $('#role').val();
	debugger;
		 $.ajax({
	            type: "GET",
	            contentType: "application/json; charset=utf-8",
	         	  datatype: "json",
	            url: "${pageContext.request.contextPath}/allUserIdByRole/"+role+"",
	            success: function (response) {
	                 var userID="";
	   	
	                 userID+="<option value='"+response[i]+"'>Select Lables</option>"
	                  for(var i=0;i<response.length;i++){ 
	                
	                	  userID+="<option value='"+response[i]+"'>"+response[i]+"</option>"
	                	 $('#userID').html(userID);
	                
	                	
	                }
	                 
	                 
	            },
	            error: function(e){
	            	
	        
	            	console.log("error");
	            }
		 });
        

	})
	})
	
	
	$(function(){
		$('#userID').on('change', function(){
		
			var level = $('#label').val();
		debugger;
			 $.ajax({
		            type: "GET",
		            contentType: "application/json; charset=utf-8",
		         	  datatype: "json",
		            url: "${pageContext.request.contextPath}/allLevelByLevelPath/"+level+"",
		            success: function (response) {
		                 var userID="";
		   	
		                 userID+="<option value='"+response[i]+"'>Select Lables</option>"
		                  for(var i=0;i<response.length;i++){ 
		                
		                	  userID+="<option value='"+response[i]+"'>"+response[i]+"</option>"
		                	 $('#level').html(userID);
		                
		                	
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










