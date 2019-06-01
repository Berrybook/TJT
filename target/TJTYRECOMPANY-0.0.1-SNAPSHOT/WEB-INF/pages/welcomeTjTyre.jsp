<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Home Page</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
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




            /* .table th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            } */
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
					<ul>
					
						<li><a href="createinvoice" style=" text-decoration: none;">New Invoice</a></li>
						<li><a href="saletransaction" style=" text-decoration: none;">Sales Transaction</a></li>
						<li><a href="priceListByPos" style=" text-decoration: none;">PriceList</a></li>
						<li><a href="CurrentMonthsalesReport" style=" text-decoration: none;">Month Report</a></li>
						<li><a href="requestOrderbypos?access=Create Order" style=" text-decoration: none;">Create Order</a></li>
						<!-- <li><a href="viewOrder?access=View Order" style=" text-decoration: none;">view Order</a></li> -->
						
					</ul>
				</nav>
			
				
		<div class="content-wrapper">
		<br><br><br><br>
			<c:choose>
			<c:when test="${not empty mail}">
			<center><span style="text-align:center;color: blue">${mail}</span></center>
			</c:when>
			<c:when test="${not empty transaction}">
			<center><span style="text-align:center;color: blue">${transaction}</span></center>
			</c:when>
			</c:choose>
</div>
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>