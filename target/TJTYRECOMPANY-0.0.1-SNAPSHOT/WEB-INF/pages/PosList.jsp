
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>Role</title>
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
					
					
				<li><a href="createcity" style=" text-decoration: none;">City Registration</a></li>		
				<li><a href="role" style=" text-decoration: none;">Role</a></li>
					<li><a href="Posbyall" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userAll"style=" text-decoration: none;">USER Registration</a></li>
					<li><a href="listtyre" style=" text-decoration: none;">Item</a></li>
	<!-- 				<li><a href="posstockquantity" style=" text-decoration: none;">Stock Transfer</a></li> -->
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>		
						
					</ul>
				</nav>
				
		<div class="content-wrapper">
		<br><br>
		<c:choose>
			<c:when test="${not empty POS_update}">
			<center><span style="text-align:center;color: blue">${POS_update}</span></center>
			</c:when>
			<c:when test="${not empty POS_success}">
			<center><span style="text-align:center;color: blue">${POS_success}</span></center>
			</c:when>
		</c:choose>
		<div>
			 <a class="button" style="background-color:orange;" href="Poscreate">+New POS</a>
		</div>
	
		<div class="card-header" style="background-color:orange; height:40px;weight:100%; ">
                                <font size="4px" color="white">
                                   <center> POS Registration</center>
                                </font>
                            </div>
		
		<table  border="1" class="table" >
		
<tr  id="heder">
<th style="color: white;text-align: center;"><b>POS Id</b></th>
<th style="color: white;text-align: center;"><b>POS Name</b></th>
<th style="color: white;text-align: center;"><b>Address</b></th>
<th style="color: white;text-align: center;"><b>Address1</b></th>
<th style="color: white;text-align: center;"><b>PinCode</b></th>
<th style="color: white;text-align: center;"><b>city</b></th>
<th style="color: white;text-align: center;"><b>Edit</b></th>
</tr>
<c:forEach var="list" items="${listpos}">
<tr style="color:black;text-align: center;">
<td>${list.pos}</td>
<td>${list.posName}</td>
<td>${list.address1 }</td>
<td>${list.address2 }</td>
<td>${list.pincode }</td>
<td>${list.cityname}</td>
<td><a href="PosById?posId=${list.pos}">edit</a></td>
</tr>
</c:forEach>

</table>
	
</body>
</html>