
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
	<script src="js\validation.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>City Registration</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>    
        
	<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
       
	<script type="text/javascript">
   $(document).ready(function(){
       
   
        $(".delete-row").click(function(){
           
            	
                    $(this).parents("tr").remove();
             
        
        });
    }); 
</script>
	
<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>


	
	
</head>
 <BODY onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">


         <header class="cd-main-header">
        
       
            <a href="#0" class="cd-nav-trigger"><span></span></a>
            <nav class="cd-nav">
                <ul class="cd-top-nav">
                    <li>
                        <p><a  href="logout" style=" text-decoration: none;"><i class="fa fa-power-off"></i>Logout</a></p>
                    </li>
                </ul>
            </nav>
        </header>
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
           <!--  
            <a href="warehouseRegistration" class="list-group-item">Warehouse Assign</a>
         --><!-- <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a>--> 
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		   <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
        <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Customer Inquiries</a>
        
        </div>
      </div>
            </nav>
            <div class="content-wrapper">
            <div class="container">
            <c:if test="${not empty city_registration}"><script>popup('${city_registration}') </script></c:if>
			<c:if test="${not empty delete_mode}"><script>popup('${delete_mode}') </script></c:if>
			 <form action="addcity" method="POST"  name="CITYregistration" enctype="multipart/form-data"  onSubmit="return cityvalidateForm()"">
	            
               
                    <br>
                    <br>
                    
                    
                        
                            <div class="card-header" style="background-color:lightblue">
                              <font size="5px" color="white">
                                    City Registration
                                </font>
                            </div>
                            
                               
                                    <div class="row">
                                        <div class="col-md-4">
                                          <div class="form-group">
                                                <b><label for="cityname">City</label></b>
                                                <input type="text" class="form-control" id="City Name" placeholder="Enter City" name="cityname" >
												 <br><i style="color:red; font-size:11px;" id="city"></i>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Role Description">Description</label></b>
                                                <textarea class="form-control" id="Description" placeholder="Description" name="descrption"></textarea>
												
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="state">State</label></b>
                                                <input type="text" class="form-control" id="statename" placeholder="Enter State" name="state">
												<br><i style="color:red; font-size:11px;" id="state"></i>
                                            </div>
                                        </div>
										
										
										
										
                                    </div>
									
									<div class="row">
									<div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Role Description">GST Number</label></b>
                                                <input type="text" class="form-control" id="GstNumber" placeholder="Enter GSTNumber" name="gstno">
												<br><i style="color:red; font-size:11px;" id="gstno"></i>
                                            </div>
                                        </div>
									<div class="col-md-4">
									<div class="form-group">
                                                <b><label for="">GST Address</label></b>
                                                <input type="text" class="form-control" id="GstAddress" placeholder="Enter GSTAddress" name="gstaddres">
												<br><i style="color:red; font-size:11px;" id="GstAddres"></i>
                                            </div>
									
									</div>
									</div>
									
                                    <br>
                                    <center>
                                         <input type="submit" value="Done" class="btn btn-danger">
                                        </center>
                            
                       </form>
                        <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>City Name</th>
                                <th>State Name</th>
								<th>GST Number</th>
                                <th>GST Address</th>
								<th>Delete</th>
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="city" items="${allCity}">
							<tr>
							<td>${city.cityname}</td>
							<td>${city.state}</td>
							<td>${city.gstno}</td>
							<td>${city.gstaddres}</td>
							<td><a href="deletecity?cityname=${city.cityname}"><i class="fa fa-trash w3-large  delete-row"></i></a></td>
							
							</tr>
							</c:forEach>
							
							  <spring:url value="/deletecity" var="deleteUrl"/>
                   
							
							
						
                            </tbody>
                       
                    </table>
            
                 
             </div>   
            </div><!-- .content-wrapper -->
        </main> <!-- .cd-main-content -->

</body>
</html>