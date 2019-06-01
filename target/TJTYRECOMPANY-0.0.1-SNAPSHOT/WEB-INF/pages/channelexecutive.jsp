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
	<title>Channel Executive</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>    
        
     
	
	
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
					
					<li><a href="requestOrder?access=Create Order" style=" text-decoration: none;">Create Order</a></li>
					<li><a href="viewOrderLink" style=" text-decoration: none;">View  Order</a></li>
					
					</ul>
				

				</nav>
			
			
			<div class="content-wrapper">
		<br><br><br><br>
			
			<c:choose>
			<c:when test="${not empty welcome}">
			<center><span style="text-align:center;color: blue">${welcome}</span></center>
			</c:when>
			
			<c:when test="${not empty POS_success}">
			<center><span style="text-align:center;color: blue ">${POS_success}</span></center>
			</c:when>
			<c:when test="${not empty POS_UNsuccess}">
			<center><span style="text-align:center;color: blue ">${POS_UNsuccess}</span></center>
			</c:when>
			
			<c:when test="${not empty UserRegister}">
			<center><span style="text-align:center;color: blue ">${UserRegister}</span></center>
			</c:when>
		
			<c:when test="${not empty TYREREGISTRATION}">
			<center><span style="text-align:center;color: blue">${TYREREGISTRATION}</span></center>
			</c:when>
			
			<c:when test="${not empty TYRE_NOT_SUCCESS}">
			<center><span style="text-align:center;color: blue">${TYRE_NOT_SUCCESS}</span></center>
			</c:when>
			
			<c:when test="${not empty updatemode}">
			<center><span style="text-align:center;color: blue">${updatemode}</span></center>
			</c:when>
			
			<c:when test="${not empty ROLE_FAIL}">
			<center><span style="text-align:center;color: blue">${ROLE_FAIL}</span></center>
			</c:when>
			
			<c:when test="${not empty ROLE_SUCCESS}">
			<center><span style="text-align:center;color: blue">${ROLE_SUCCESS}</span></center>
			</c:when>
			<c:when test="${not empty posstock}">
			<center><span style="text-align:center;color: blue">${posstock}</span></center>
			</c:when>
			
			</c:choose>
			
</div>
			

 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->



</body>
</html>