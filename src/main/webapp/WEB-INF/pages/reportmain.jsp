<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
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
	<title>Tjtyre User Registration</title>
	
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
.button  {
    background-color:#44a0c9;
    color:white;
    border: 2px solid #4CAF50;
    padding: 10px 20px;
    text-align: center;
    text-decoration:none;
    display: inline-block;
    font-size: 18px;
   
}
        
	</style>
	
	
	
</head>
<body>


	<header class="cd-main-header">
		
		
		<a href="#0" class="cd-nav-trigger"><span></span></a>

		

		<nav class="cd-nav">
			<ul class="cd-top-nav">
		
		<li >
					<p><a href="logout" style=" text-decoration: none;"><i class="w3-jumbo w3-spin fa fa-male"></i>Logout</a></p>
</li>
	</header> 
</nav>

	<main class="cd-main-content">
	
		<nav class="cd-side-nav">
			
				<br>
					<ul>
					
					
					<li><a href="role" style=" text-decoration: none;">Role</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration" style=" text-decoration: none;">USER Registration</a></li>
					<li><a href="listtyre" style=" text-decoration: none;">Item</a></li>
					<li><a href="posstockquantity" style=" text-decoration: none;">Stock Transfer</a></li>	
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>
					
					
						
						
					</ul>
				

				</nav>
			
				
		<div class="content-wrapper">
			
			
	 <div id="TyreEntry">
        <form action="saletransaction" method="post" enctype="multipart/form-data" name="salestransaction" onsubmit="return salevalidate()">
            
                   
                </div>
           
            <br>
            <br>

            <div class="container">

                <div class="card">
                    <div class="card-header" style="background-color:orange">

                        <font size="5px" color="white">
                            Report 
                        </font>

                    </div>
                    <div class="card-body">
                        <div class="cardpanel">
                            <div class="row">

							<div class="col-md-6">
                                 <a class="button" style=" text-decoration: none;" href="Salereportbydate">Report Summary</a>
                                  </div>     
							<div class="col-md-6">
							   <a class="button" style=" text-decoration: none;" href="listofstock">Stock  Report</a>
							</div>
						
						</div>
						<br>
						
							     
                                









                        </div>
                    </div>
                </div>
            </div>
            <!--  &nbsp &nbsp  &nbsp &nbsp &nbsp  &nbsp &nbsp <a href="#" class="previous">&laquo; Previous</a>
             -->

            <br>
            
			
			
		</div> <!-- .content-wrapper -->
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>