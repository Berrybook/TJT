
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	 <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/reset.css"> 
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/style1.css">
	<link rel="stylesheet" href="css/table.css">
	<script src="js\modernizr.js"></script> 
	<script src="js\validation.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>POS Registration</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>    
      <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>    
       
     <style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>
	
	<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>
	
       
	
	
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
           <!--  <!-- 
            <a href="warehouseRegistration" class="list-group-item">Warehouse Assign</a>
        <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a>-->  -->
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		   <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
        <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Customer Inquiries</a>
        
        </div>
      </div>
				
				

				</nav>
			
				
				 
				 <div class="content-wrapper" >
				 <div class="container">
				  <c:if test="${not empty POS_update}"><script>popup('${POS_update}') </script></c:if>
				 <c:if test="${not empty POS_success}"><script>popup('${POS_success}') </script></c:if>
	 
               
            <br>
            <br>
            <div id="Posreg"> </div>
            <c:choose>
            <c:when test="${POS_REG=='POS_REG' }">
	 <form action="tjtyrePOS" method="POST" name="posreg"  onsubmit="return posvalidate()" >
            

                
                    <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                                    POS Registration
                                </font>
                            </div>
                    


                        
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">

							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="pos">Pos Id</label></b>
                                                <input type="text" class="form-control" id="pos" placeholder="Enter pos Id" name="pos" v-model="pos">
                                            </div>
                                        </div>
										<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="pos">Pos Name</label></b>
                                                <input type="text" class="form-control" id="posname" placeholder="Enter pos Name" name="posName" v-model="Name">
                                            </div>
                                        </div>
                                        
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="location">Password</label></b>
                                                <input type="text" class="form-control" id="password" placeholder="Enter password" name="password" v-model="password" >
                                            </div>
                                        </div>
							
							
							
                    </div>
							
							
							
							
							<div class="row">
							<div class="col-md-4">
                        <div class="form-group">
                            <b><label for="Address1">Address 1</label></b>
                            <textarea class="form-control" id="address1" rows="1" name="address1" ></textarea>
                          	</div>
							</div>
							    <div class="col-md-4">
                    
                            <div class="form-group">
                            <b><label for="Address2">Address 2</label></b>
                            <textarea class="form-control" id="address2" rows="1" name="address2" ></textarea>
                          	</div>
                     </div> 
                     <div class="col-md-4">
                                  <div class="form-group">
                                                <b><label for="pincode">Pincode</label></b>
                                                <input type="text" class="form-control" id="pincode" placeholder="Enter pincode" name="pincode" v-model="pincode"   maxlength="6" onkeypress="return isNumber(event)" >
                                            </div>
                                </div>
                               
                                </div>
								<div class="row">
								 <div class="col-md-4">
                                    <div class="form-group">
                          <b><label for="city">CITY</label></b>
                            <select class="form-control" name="cityname" id="city">
                            <option value="">select city</option>
                                <c:forEach var="city" items="${allCity}">
  					<option value="${city.cityname}">${city.cityname}</option>
 						  </c:forEach>
                            </select>
                         

                        </div>
                                </div>
								</div>
                   
                   
                  
                   <div class="row" >
                   
                    <div id="gstnumber" >Gst Number :</div>
                    <div id="gstNo"></div>
						
							</div>
							
							  <div class="row" >
      						   <p id="gstadd">Gst Address :</p><p id="gstaddress"></p>
                     </div>
                     <div class="row">
                        </div>
                 
               
          
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-2"><input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Insert"> </div>
                <div class="col-md-2">
                   </div>
                   
                   <div class="col-md-2"></div>
            </div>
            
         
            <br>
		</form>
		</c:when>
		<c:when test="${posUpdate=='posUpdate' }">
		<form action="updatePos" method="POST" name="posreg"  onsubmit="return posvalidate()" >
           

                
                    <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                                    POS Update
                                </font>
                            </div>
                    


                        
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">

							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="pos">Pos Id</label></b>
                                                <input type="text" class="form-control" id="pos" placeholder="Enter pos Id" name="pos" v-model="pos" value="${pos_update.pos }"readonly>
                                            </div>
                                        </div>
										<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="pos">Pos Name</label></b>
                                                <input type="text" class="form-control" id="posname" placeholder="Enter pos Name" name="posName" v-model="Name" value="${pos_update.posName }">
                                            </div>
                                        </div>
                                        
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="location">Password</label></b>
                                                <input type="text" class="form-control" id="password" placeholder="Enter password" name="password" v-model="password" value="${pos_update.password }">
                                            </div>
                                        </div>
							
							
							
                    </div>
							
							
							
							
							<div class="row">
							<div class="col-md-4">
                        <div class="form-group">
                            <b><label for="Address1">Address 1</label></b>
                            <textarea class="form-control" id="address1" rows="1" name="address1" >${pos_update.address1 }</textarea>
                          	</div>
							</div>
							    <div class="col-md-4">
                    
                            <div class="form-group">
                            <b><label for="Address2">Address 2</label></b>
                            <textarea class="form-control" id="address2" rows="1" name="address2" >${pos_update.address2 }</textarea>
                          	</div>
                     </div> 
                     <div class="col-md-4">
                                  <div class="form-group">
                                                <b><label for="pincode">Pincode</label></b>
                                                <input type="text" class="form-control" id="pincode" placeholder="Enter pincode" name="pincode" v-model="pincode" maxlength="6" onkeypress="return isNumber(event)" value=" ${pos_update.pincode}">
                                            </div>
                                </div>
                               
                                </div>
								<div class="row">
								 <div class="col-md-4">
                                    <div class="form-group">
                          <b><label for="city">CITY</label></b>
                            <select class="form-control" name="cityname" id="city">
                            <option value="">select city</option>
                                <c:forEach var="city" items="${allCity}">
  					<option value="${city.cityname}">${city.cityname}</option>
 						  </c:forEach>
                            </select>
                         

                        </div>
                                </div>
								</div>
                   
                   
                  
                   <div class="row" >
                   
                    <div id="gstnumber" >Gst Number :</div>
                    <div id="gstNo"></div>
						
							</div>
							
							  <div class="row" >
      						   <p id="gstadd">Gst Address :</p><p id="gstaddress"></p>
                     </div>
                     <div class="row">
                        </div>
                 
               
          
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-2"><input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Update"> </div>
                <div class="col-md-2">
                   </div>
                   
                   <div class="col-md-2"></div>
            </div>
           
            <br>
		</form>
		</c:when>
		</c:choose>
		<table  border="1" class="table" >
		
<tr  id="heder">
<th><b>POS Id</b></th>
<th><b>POS Name</b></th>
<th><b>Address</b></th>
<th><b>Address1</b></th>
<th><b>PinCode</b></th>
<th><b>City</b></th>
<th><b>Edit</b></th>
</tr>
<c:forEach var="list" items="${listpos}">
<tr style="color:black;text-align: center;">
<td>${list.pos}</td>
<td>${list.posName}</td>
<td>${list.address1 }</td>
<td>${list.address2 }</td>
<td>${list.pincode }</td>
<td>${list.cityname}</td>
<td><a href="PosById?posId=${list.pos}"><i class="fa fa-edit"></i></a></td>
</tr>
</c:forEach>

</table>
		</div> 
		</div> <!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
       <script>
       
     //get tyreprice when tyrepattern and tyreprice is selected 
     $(document).ready(function(){
    	 $('#gstnumber').hide();
    	 $('#gstadd').hide();
     });
   	
  	 $(function(){
  	$('#city').on('change', function(){
  	
  	
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
  	               $('#gstnumber').show();
  	               $('#gstNo').text(gstno);
  	             	
  	                
  	            	/*  $('#gstaddress').val(gstaddress); */
  	            $('#gstadd').show();
  	            $('#gstaddress').text(gstaddress);
  	         
  	            	
  	            },
  	            error: function(e){
  	            	
  	            
  	            	console.log("error");
  	            }
  		 });
          

  	})
  	})
          </script>
          <script>
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