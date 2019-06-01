
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
	
	
<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>
	
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
			<a href="warehouseRegistration" class="list-group-item">Warehouse Registration</a>
			<a href="tyrecreate" class="list-group-item">Item Registration</a>
			<a href="createroleaccess" class="list-group-item">Resource Role Access</a>
          </div>
          <a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Pevilleges Assign <i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i> </a>
          <div class="collapse" id="demo4">
           <!--  <a href="warehouseMasterLink" class="list-group-item">Warehouse Assign</a>
             --><a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a>
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		    <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
        <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Inquiry Form</a>
        
        </div>
      </div>
            
			
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