
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css\reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css\style.css"> <!-- Resource style -->
	<script src="js\modernizr.js"></script> <!-- Modernizr -->
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Tjtyre Role</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	
    <script src="js\jquery-3.3.1.min.js"></script>

    <script src="js\popper.min.js"></script>

    <script src="js\bootstrap.min.js"></script>
    <script src="js\mdb.min.js"></script>
    <script src="js\jquery.menu-aim.js"></script>

    <script src="js\main.js"></script> <!-- Resource jQuery -->
	
	
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css\bootstrap.min.css" rel="stylesheet" />
    <link href="css\mdb.min.css" rel="stylesheet" />
    <link href="css\style1.css" rel="stylesheet" />
    <script src="js\bootstrap.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<style type="text/css">
			a{
	text-decoration: none;
	display: inline-block;
	
}
 a.active{
    		background-color: gray;
    	}
    .table {
          
            border-collapse: collapse;
            width: 100%;
        }



            .table td {
                border: 1px solid #ddd;
                padding: 8px;
            }
            
            #heder {
                 background-color:fuchsia;
            }
            
            #header1 {
                 background-color:navy;
            }
            



            .table tr:nth-child(even) {
                background-color: gray;
            }
            .table tr:nth-child(odd) {
                background-color:maroon;
            }
        .header {
  padding: 20px 20px;
  background:#44a0c9;
height:85px;
  color:brown;
}






.card-header{
 background-color:orange;
 height:80px;


}

::-webkit-scrollbar { 
    display: none; 
}



       .cardpanel {
            
            left: 500px;
            margin: 20px;
            
            padding: 16px;
            background-color: lightblue;
              }



       

.card-body
{
background-color:lightblue;
}

 
        
body {
  background-color:#e6f0fa;
  width:100%;
}

a {
    text-decoration: none;
    display: inline-block;
    
    padding: 8px 16px;
}


.previous {
    background-color: #4CAF50;
    color: black;
}



	.form-group{
    margin-top: 10px;
}
.tyre-quantity{
    display: none;
}

	.submit-button{
		float:right;
		margin-right:1.3em;
	}
	

        
	</style>
	
	
	
</head>
<body>



	<header class="cd-main-header">
		
		
		<a href="#0" class="cd-nav-trigger"><span></span></a>

		

		<nav class="cd-nav">
			<ul class="cd-top-nav">
		
		<li >
					<p><a href="logout"><i class="w3-jumbo w3-spin fa fa-male  style=color:orange"></i>Logout</a></p>
</li>
	</header> 
</nav>

	<main class="cd-main-content">
	
		<nav class="cd-side-nav">
			
				<br>
					<ul>
					
					
					<!-- Poscreate posstockquantity-->
					
					
					<li><a href="role" style=" text-decoration: none;">Role</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration" style=" text-decoration: none;">USER Registration</a></li>
					<li><a href="listtyre" style=" text-decoration: none;">Item</a></li>
					<li><a href="posstockquantity" style=" text-decoration: none;">Stock Transfer</a></li>	
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>
						
					</ul>
				

				</nav>
			
				
				 
				 <div class="content-wrapper">
			
			 <form action="userregistration" method="post" enctype="multipart/form-data" name="userregistration" onsubmit="return userregi()">
	 <div id="UserRegistration">
       
            
                   
                </div>
           
            <br>
            <br>

            <div class="container">

                <div class="card">
                    <div class="card-header" style="background-color:orange">

                        <font size="4px" color="white">
                            User Registration
                        </font>

                    </div>
                    <div class="card-body">


                        <div class="cardpanel">
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
                    			        </div>
                                        </div>
                                     </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <input type="submit" v-on:click="Save" class="btn btn-primary submit-button" value="Submit">
                </div>
            </div>
			 	</form>	 
		</div> <!-- .content-wrapper -->
		
		</div>
	</main> <!-- .cd-main-content -->
		
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js\jquery.menu-aim.js"></script>
<script src="js\main.js"></script> <!-- Resource jQuery -->

       <script>
     //get tyreprice when tyrepattern and tyreprice is selected 
   	
  	 $(function(){
  	$('#city').on('click', function(){
  		debugger;
  		var  city = $('#city').val();
  		debugger;
  		 $.ajax({
  			 
  	            type: "GET",
  	            contentType: "application/json; charset=utf-8",
  	         	  datatype: "json",
  	            url: "${pageContext.request.contextPath}/findgstno/"+city+"",
  	            
  	            success: function (result) {
  	            	debugger;
  	             	var gstno=result[0];
  	             	var gstaddress=result[1];
  	                 $('#gstNo').val(gstno);
  	            	debugger;    
  	            	 $('#gstaddress').val(gstaddress);
  	            	
  	            },
  	            error: function(e){
  	            	
  	            	debugger;
  	            	console.log("error");
  	            }
  		 });
          

  	})
  	})
  

       
          </script>

<script type="Text/JavaScript">
   
function  userregi(){

	if((document.getElementById('userid').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter User ID";
	  userregistration.userid.focus();
	  return(false);
	 }
	if((document.getElementById('userName').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter User Name";
	  userregistration.userName.focus();
	  return(false);
	 }
	if((document.getElementById('password').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Password";
	  userregistration.password.focus();
	  return(false);
	 }
	if((document.getElementById('mobilenumber').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Mobile Number";
	  userregistration.mobilenumber.focus();
	  return(false);
	 }
	if((document.getElementById('mailid').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Mail ID";
	  userregistration.mailid.focus();
	  return(false);
	 }
	if((document.getElementById('address').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Address";
	  userregistration.address.focus();
	  return(false);
	 }
	if((document.getElementById('role').value=="null"))
	 {
	  document.getElementById('error').innerHTML = "Please choose Role";
	  userregistration.role.focus();
	  return(false);
	 }
	if((document.getElementById('pos').value=="null"))
	 {
	  document.getElementById('error').innerHTML = "Please choose POS";
	  userregistration.pos.focus();
	  return(false);
	 }
	else 
	{
		 return(true);
	 }
	
}

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    	document.getElementById('error').innerHTML = "Please Enter digit only";
  	  userregistration.mobilenumber.focus();
        return false;
    }
    return true;
}
  
</script>






</body>
</html>