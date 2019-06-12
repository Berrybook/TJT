
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>User Registration</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
   <script src="js\validation.js"></script> 
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> 
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>    
         
    
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
					<li><a href="createcity" style=" text-decoration: none;">City Registration</a></li>
					<li><a href="role" style=" text-decoration: none;">Role Registration</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration"style=" text-decoration: none;">User Registration</a></li>
					<li><a href="tyrecreate" style=" text-decoration: none;">Item Registration</a></li>
					<li><a href="item_price_assign" style=" text-decoration: none;">Price Assignment</a></li>
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>	
						
					</ul>
					</nav>
				 <div class="content-wrapper">
				   <div class="container"> 
				 <c:if test="${not empty user_update_result}"><script>popup('${user_update_result}') </script></c:if>
				 <c:if test="${not empty UserRegister}"><script>popup('${UserRegister}') </script></c:if>
			<c:choose>
			<c:when test="${userreg=='userreg' }">
			 <form action="userregistration" method="post" enctype="multipart/form-data" name="userregistration" onsubmit="return uservalidation()">
	 <div id="UserRegistration"> 
                </div>
           
            <br>
            <br>

                 
					 <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                              User Registration
                                </font>
                            </div>
                   


                       
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">
							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="userid">User id</label></b>
                                                <input type="text" class="form-control" id="userid" placeholder="Enter User ID" name="userid" v-model="userid">
                                            </div>
                                        </div>	
										
						
								   
								   <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="username">User Name</label></b>
                                                <input type="text" class="form-control" id="userName" placeholder="Enter UserName" name="userName" v-model="userName">
                                            </div>
                                        </div>
										
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="password">Password</label></b>
                                                <input type="text" class="form-control" id="password" placeholder="Enter password" name="password" v-model="password">
                                            </div>
                                        </div>
							
							</div>
							<div class="row">
							      <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="mobilenumber">Mobile</label></b>
                                                <input type="text" class="form-control" id="mobilenumber" placeholder="Enter mobile number" name="mobilenumber" v-model="mobilenumber"  maxlength="10" onkeypress="return isNumber(event)">
                                            </div>
                                        </div>

                                <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyreprice">Email id</label></b>
                                                <input type="text" class="form-control" id="mailid" placeholder="Enter Email" name="mailid" v-model="mailid">
                                            </div>
                                        </div>

                                      
										  <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="address">Address</label></b>
                                                <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" v-model="address">
                                            </div>
                                        </div>
								   
								   </div>
								   
                                         
                                      <div class="row">
									  <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="idprofe">Identity Proof</label></b>
                                                <input type="file"  id="idprofe" name="idprofe" v-model="idprofe">
                                            </div>
                                        </div>
                  					   <div class="col-md-4">
                 						    <div class="form-group">
                        				  <b><label for="salespersonid">Role</label></b>
                   				       	  <select class="form-control" name="role" id="role">
                   				       	   <option value="null">Select Role</option>
                  			             	 <c:forEach var="role" items="${role}">
 											 <option value="${role.role}">${role.role}</option>
  								 			</c:forEach>
                       				     </select>
                 					    </div>
                  					 </div>
								  <div class="col-md-4">
									   <div class="form-group">
                        			    <b><label for="pos">Pos</label></b>
                        			     <select class="form-control" name="pos"  id="pos">
                        			      <option value="null">Select POS</option>
                        		      	  <c:forEach var="pos" items="${allpos}">
  											<option value="${pos.pos}">${pos.pos}</option>
 										  </c:forEach>
                          				  </select>
                          				
                        			   <%-- <c:forEach var="pos" items="${allpos}">
                        			   <a href="createcity?pos=${pos.pos}">Request Order-no ${pos.pos}/pos name ${pos.pos}</a>
                    			     	</c:forEach> --%>
                    			        </div>
                                        </div>
                                     </div>
              <br>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-2"><input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Insert"> </div>
                <div class="col-md-2">
                   </div>
                   
                   <div class="col-md-2"></div>
            </div>
			 	</form>	
			 	</c:when>
			 	<c:when test="${userUpdate=='userUpdate' }">
			 	<form action="userupdate" method="POST" enctype="multipart/form-data" name="userregistration" onsubmit="return uservalidation()">
	 <div id="UserRegistration">
       
            
                   
                </div>
           
            <br>
            <br>

            <div class="container">

                
                    <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                              User Update
                                </font>
                            </div>
             
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">
							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="userid">User id</label></b>
                                                <input type="text" class="form-control" id="userid" placeholder="Enter User ID" name="userid" v-model="userid"  readonly value="${user_update.userid }">
                                            </div>
                                        </div>	
										
						
								   
								   <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="username">User Name</label></b>
                                                <input type="text" class="form-control" id="userName" placeholder="Enter UserName" name="userName" v-model="userName" value="${user_update.userName }">
                                            </div>
                                        </div>
										
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="password">Password</label></b>
                                                <input type="text" class="form-control" id="password" placeholder="Enter password" name="password" v-model="password" value="${user_update.password }" >
                                            </div>
                                        </div>
							
							</div>
							<div class="row">
							      <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="mobilenumber">Mobile</label></b>
                                                <input type="text" class="form-control" id="mobilenumber" placeholder="Enter mobile number" name="mobilenumber" v-model="mobilenumber"  maxlength="10" onkeypress="return isNumber(event)" value="${user_update.mobilenumber }">
                                            </div>
                                        </div>

                                <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyreprice">Email id</label></b>
                                                <input type="text" class="form-control" id="mailid" placeholder="Enter Email" name="mailid" v-model="mailid" value="${user_update.mailid }">
                                            </div>
                                        </div>

                                      
										  <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="address">Address</label></b>
                                                <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" v-model="address" value="${user_update.address }">
                                            </div>
                                        </div>
								   
								   </div>
								   
                                         
                                      <div class="row">
									  <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="idprofe">Identity Proof</label></b>
                                                <input type="file"id="idprofe" name="idprofe" v-model="idprofe">
                                            </div>
                                        </div>
                  					   <div class="col-md-4">
                 						    <div class="form-group">
                        				  <b><label for="salespersonid">Role</label></b>
                   				       	  <select class="form-control" name="role" id="role">
                   				       	   <option value="null">Select Role</option>
                  			             	 <c:forEach var="role" items="${role}">
 											 <option value="${role.role}">${role.role}</option>
  								 			</c:forEach>
                       				     </select>
                 					    </div>
                  					 </div>
								  <div class="col-md-4">
									   <div class="form-group">
                        			    <b><label for="pos">Pos</label></b>
                        			     <select class="form-control" name="pos"  id="pos">
                        			      <option value="null">Select POS</option>
                        		      	  <c:forEach var="pos" items="${allpos}">
  											<option value="${pos.pos}">${pos.pos}</option>
 										  </c:forEach>
                          				  </select>
                    			        </div>
                                        </div>
                                     </div>
   
            </div>
                <br>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-2"><input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Update"> </div>
                <div class="col-md-2">
                   </div>
                   
                   <div class="col-md-2"></div>
            </div>
			 	</form>	
			 	</c:when>
			 	</c:choose>
			 	<br>
			 	<table class="table"  >
		

<tr>
<th><b>UserName</b></th>
<th><b>MobileNumber</b></th>
<th><b>Mail</b></th>
<th><b>Role</b></th>
<th><b>POS</b></th>
<th><b>Edit</b></th>
</tr>
<c:forEach var="list" items="${listUser}">
<tr >
<td>${list.userName }</td>
<td>${list.mobilenumber }</td>
<td>${list.mailid }</td>
<td>${list.role }</td>
<td>${list.pos }</td>
<td><a href="userupdate?userId=${list.userid}"><i class="fa fa-edit"></i></a></td>

</tr>
</c:forEach>

</table>
</div>
		</div> <!-- .content-wrapper -->
		
		
	</main> <!-- .cd-main-content -->
		

       <script>
     //get tyreprice when tyrepattern and tyreprice is selected 
   	
  	 $(function(){
  	$('#city').on('click', function(){
  	
  		var  city = $('#city').val();
  	
  		 $.ajax({
  			 
  	            type: "GET",
  	            contentType: "application/json; charset=utf-8",
  	         	  datatype: "json",
  	            url: "${pageContext.request.contextPath}/findgstno/"+city+"",
  	            
  	            success: function (result) {
  	            
  	             	var gstno=result[0];
  	             	var gstaddress=result[1];
  	                 $('#gstNo').val(gstno);
  	              
  	            	 $('#gstaddress').val(gstaddress);
  	            	
  	            },
  	            error: function(e){
  	            	
  	            	
  	            	console.log("error");
  	            }
  		 });
          

  	})
  	})
  

       
          </script>
          <script type="text/javascript">
          function isNumber(evt) {
    	      evt = (evt) ? evt : window.event;
    	      var charCode = (evt.which) ? evt.which : evt.keyCode;
    	      if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    	          return false;
    	      } 
    	      return true;
    	  }
          </script>

</body>
</html>