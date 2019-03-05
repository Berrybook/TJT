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
					<li><a href="createcity" style=" text-decoration: none;">City Registration</a></li>
					<li><a href="role" style=" text-decoration: none;">Role Registration</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration"style=" text-decoration: none;">User Registration</a></li>
					<li><a href="tyrecreate" style=" text-decoration: none;">Item Registration</a></li>
					<li><a href="item_price_assign" style=" text-decoration: none;">Price Assignment</a></li>
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>	
						
					</ul>
				

				</nav>
		 
		<div class="content-wrapper">
		<br><br>
           <div class="container">
               <form action="listofsalebydate" method="post" name="salereportform" onsubmit="return salereport()">
                
                   <div class="card-header" style="background-color:lightblue">
                                <font size="5px" color="white">
                                    Summary Report
                                </font>
                            </div>
                   
                    
                    
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">
                                 <div class="col-md-4">
                			     <div class="form-group">
                		          <b><label for="posid">POS</label></b>
                			            <select class="form-control" name="posid" id="posid">
                			            <option value="null">Select POS</option>
                   				             <c:forEach var="posid" items="${poslist}">
  												<option value="${posid.pos}">${posid.pos}</option>
   												</c:forEach>
     		                  		     </select>
                      				  </div>
                   				  </div>
                                    <div class="col-md-4">
                                    <div class="form-group">
                                        <b><label for="firstdate">From Date</label></b>
                                            
                                            <input type="date" class="form-control" data-date-format="YYYY MM DD"  id="saledate" name="saledate"  value="${saledate }">
                                    </div>
                                    </div>
                                    <div class="col-md-4">
                                     <div class="form-group">
                                          <b><label for="seconddate">To Date</label></b>
                                            
                                            <input type="date" class="form-control" data-date-format="YYYY MM DD"  id="saledateto" name="saledatesecond"  value="${saledateto }">
                                    </div>
                                    </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                    <div class="col-md-3"></div>
                                    <div class="col-md-3">
                                    <b><label for="date"></label></b>
                                        <a href="Salereport" type="button"  class="btn btn-danger">back</a>
                                           
                                        </div>
                                        <div class="col-md-3">
                                        
                                         <b><label for="date"></label></b>
                                   	  <input type="submit"  class="btn btn-danger" value="search">
                                        </div>
                                        <div class="col-md-3"></div>
                                        </div>
										
										
                                       </form> 
                                      
                                        <div class="row">
										
                                         <c:choose>
                                         <c:when  test="${REPORT=='REPORT_LIST'}">   
                                        <table class="table" >
                                        <c:choose>
                                         <c:when  test="${!empty listreport}">  
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
           </div>
                                        
            
<script type="Text/JavaScript">
   
 
</script>
                    
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->

</body>
</html>