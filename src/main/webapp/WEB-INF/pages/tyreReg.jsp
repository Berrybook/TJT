
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
	<script src="js\validation.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Item Registration</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
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
				<c:if test="${not empty TYREREGISTRATION}"><script>popup('${TYREREGISTRATION}') </script></c:if>
				 <c:if test="${not empty updatemode}"><script>popup('${updatemode}') </script></c:if>
				  <c:if test="${not empty TYRE_NOT_SUCCESS}"><script>popup('${TYRE_NOT_SUCCESS}') </script></c:if>
		<br>
			<c:choose>
			<c:when test="${TYRE_HOME=='TYRE_REG' }">
        <form action="tyrecreate" method="post" enctype="multipart/form-data" name="tyrecreate" onsubmit="return tyrevalidate()"> 
        
        
 
                <br>
                     <div class="card-header" style="background-color:lightblue">
                                <font size="5px" color="white">
                                    Tyre Entry
                                </font>
                            </div>
                    


                        
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">

							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyrepattern"> Pattern</label></b>
                                                <input type="text" class="form-control" id="tyrepattern" placeholder="Enter tyrepattern" name="tyrepattern" v-model="tyre_pattern">
                                            </div>
                                        </div>
							
							
							
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyresize"> Size</label></b>
                                                <input type="text" class="form-control" id="tyresize" placeholder="Enter tyresize" name="tyresize" v-model="tyre_size">
                                            </div>
                               </div>
                                <div class="col-md-4">
                                            <div class="form-group">
                                                <!-- <b><label for="tyreprice"> Price</label></b>
                                                <input type="text" class="form-control" id="price" placeholder="Enter tyreprice" name="price" v-model="price" onkeypress="return validateFloatKeyPress(this,event);"> -->
                                          		<!-- <input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="insert">  -->
                                            </div>
                                </div>

                               </div>
								<div class="row">
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
		
		</c:choose>
		
		<br>
		<br>
		<table  border="1" class="table" >
		

		<tr  id="heder">
		<th style="color: white;text-align: center;"><b>Pattern</b></th>
		<th style="color: white;text-align: center;"><b>Size</b></th>
		</tr>
		<c:forEach var="list" items="${listDto}">
		<tr style="color:black;text-align: center;">
		<td>${list.tyrepattern }</td>
		<td>${list.tyresize }</td>
		</tr>
		</c:forEach>
		</table>
		</div>
		</div> <!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->

</body>
</html>