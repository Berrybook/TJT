<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>Summary Report</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>    
        
       
	
	
	
	
</head>


<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>


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
            <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a>
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
		<br><br>
           <div class="container">
               
                                      
                                      
    <thead>
      <tr>
     	 <th>POS Id</th>
    	 <th>Sale Date</th>
        <th>Pattern</th>
        <th>Size</th>
        <th>Quantity</th>
        <th>Sales Amount</th>
        <th>Payment Mode</th>
      </tr>
    </thead>
    <c:forEach var="report"  items="${listreport}">
    <tr>
    <td>${POS} </td>
       <td style="width:50px;">${report.saledate}</td>
        <td>${report.tyrepattern}</td>
        <td>${report.tyresize}</td>
        <td>${report.quantity}</td>
        <td>${report.totprice}</td>
        <td>${report.paymentmode}</td>
        </tr>
    </c:forEach>
<tbody>
      
    </tbody>
   
  </table>
\

                                     
           </div> 
           </div>
           </div>
                                        
            
<script type="Text/JavaScript">
   
 
</script>
                    
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->

</body>
</html>