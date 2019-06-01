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
                   <br><br>
             
                  
           <div class="container">



<div class="card-header" style="background-color:lightblue">
                              <center>  <font size="5px" color="white">
                                 Monthly Sales Report
                                </font></center>
                            </div>
<br>
										
                                         <c:choose>
                                         <c:when  test="${REPORT=='REPORT_LIST'}">   
                                        <table class="table" >
                                        <c:choose>
                                         <c:when  test="${!empty listreport}">  
    <thead>
      <tr>
      	 <th>Sale Date</th>
     	 <th>User Id</th>
        <th>Quantity</th>
        <th>Sales Amount</th>

      </tr>
    </thead>
    <c:forEach var="report"  items="${listreport}">
    <tr>
      		<td >${report.saledate}</td>
   			<td>${report.userId} </td>
       		<td>${report.quantity}</td>
      	    <td>${report.totprice}</td>

        </tr>
    </c:forEach>
<tbody>
      
    </tbody>
    </c:when>
     <c:otherwise>
    
     
    <Center>NO sale on this date</Center>
    
    </c:otherwise>
  </c:choose>
  </table>
  </c:when>
  </c:choose>

                                     
           </div> 
           </div>
        
                                        
            
<script type="Text/JavaScript">
   
 
</script>
                    
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->

</body>
</html>