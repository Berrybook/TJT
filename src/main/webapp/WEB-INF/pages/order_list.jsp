<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css\reset.css"> 
	<link rel="stylesheet" href="css\style.css">
	<link rel="stylesheet" href="css\table.css">
	<script src="js\modernizr.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Order_List</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
  
        <style>
     
.search-table{
table-layout: fixed; margin:20px auto 0px auto;  overflow-x:scroll; 
}
.search-table, td, th{
border-collapse:collapse; border:1px solid #777;
}
th{
padding:20px 7px; font-size:15px; color:#444; background:lightblue;
}
td{
padding:5px 10px; height:35px;
}
td { 
    overflow: hidden; 
    text-overflow: ellipsis; 
    word-wrap: break-word;
	width:auto;
}
@media only screen and (max-width: 480px) {
    /* horizontal scrollbar for tables if mobile screen */
    .tablemobile {
        overflow-x: auto;
        display: block;
    }
}
.list-group-item-success{
	background-color:lightblue;
	}
	
	
	</style>
	
	<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	.cd-side-nav{
	position:absolute;
	top:-1%;
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
        <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Customer Inquiries</a>
        
        </div>
      </div>
            
			
				</nav>
			<div class="content-wrapper">
			
			 <br>
                    <br>
                     <br>
                     <div class="container">
                       
                            <div class="card-header" style="background-color:lightblue; width:auto">
                                <font size="5px" color="white">
                                  View Order 
                                </font>
                               
                            </div>
                    
                 <div class="search-table-outter wrapper">
                    <table  class="search-table inner"  style="position:absolute;width:1001px;height:auto"  >
                        <thead >
                            <tr>
                           	   	
                                <th><b>Raised_By</b></th>
                                <th><b>Requisition Date</b></th>
								<th><b>Priority</b></th>
                                <th><b>Dealer_Id</b></th>
                                <th><b>Status</b></th>
                                <th><b>Approver</b></th> 
								<th><b>Pattern</b></th>
                                <th><b>Size</b></th>
                                <th><b>Quantity</b></th>
                                <th><b>Approved</b></th>
								<th><b>Cancel</b></th>
								
								 
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="itemprice" items="${orderList}">
							<tr>
							
							<td  >${itemprice.raised_By} </td>
						
							<td>${itemprice.requisation_Date} </td>
							<td>${itemprice.priority} </td>
							<td >${itemprice.dealer_id} </td>
							<td >${itemprice.status} </td>
							<td >${itemprice.approver} </td>
							<td><c:forEach items="${itemprice.pattern }" var="pattern">
							<option>${pattern}</option>
							</c:forEach></td>
							<td><c:forEach items="${itemprice.size }" var="size">
							<option>${size}</option>
							</c:forEach></td>
							<td><c:forEach items="${itemprice.quantity }" var="quantity">
							<option>${quantity}</option>
							</c:forEach></td>
							<c:if test="${itemprice.status =='pending'}">
							<td><a href="updateStatus?order_id=${itemprice.order_id}&status=approved" class="btn btn-danger">Approve</a></td>
							<td><a href="updateStatus?order_id=${itemprice.order_id}&status=cancelled" class="btn btn-danger">Reject</a></td>
                           
						</c:if>
							</tr>
							</c:forEach>
                            </tbody>
                       
                    </table>
				</div>
                
                </div>
</div>
			

 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->



</body>
</html>