<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<title>Tyre price list</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
       
	
	
	
</head>
<body>
    <div id="RoleRegistration">
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
                <ul>
						<li><a href="createinvoice" style=" text-decoration: none;">New Invoice</a></li>
						<li><a href="saletransaction" style=" text-decoration: none;">Sales Transaction</a></li>
						<li><a href="priceListByPos" style=" text-decoration: none;">PriceList</a></li>
						
                </ul>
            </nav>
            <div class="content-wrapper">
               
                    <br>
                    <br>
                     <div class="container">
                        
                            <div class="card-header" style="background-color:lightblue">
                              <center>  <font size="5px" color="white">
                                  Tyre price list
                                </font></center>
                            </div>
                            
                       
                    <br>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Pattern</th>
                                <th>Size</th>
								<th>MRP</th>
                                <th>Sales Price</th>
								
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="itemprice" items="${itemPrice}">
							<tr>
							<td >${itemprice.pattern} </td>
							<td >${itemprice.size} </td>
							<td>${itemprice.mrp} </td>
							<td >${itemprice.salePrice} </td>
							</tr>
							</c:forEach>
                            </tbody>
                       
                    </table>
               
                </div>
            </div><!-- .content-wrapper -->
        </main> <!-- .cd-main-content -->
    </div>

</body>
</html>