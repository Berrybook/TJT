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
	<title>Responsive Sidebar Navigation | CodyHouse</title>
	
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
                 background-color:#44a0c9;
                 text-align: center;
            }
            
            #header1 {
                 background-color:orange;
            }
            



            .table tr:nth-child(even) {
                background-color: lightblue;
            }
            .table tr:nth-child(odd) {
                background-color:white;
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

        
	</style>
	
	
	
</head>
<body>


	<header class="cd-main-header">
		
		
		<a href="#0" class="cd-nav-trigger"><span></span></a>

		

		<nav class="cd-nav">
			<ul class="cd-top-nav">
		
		<li >
					<p><a style=" text-decoration: none;"><i class="w3-jumbo w3-spin fa fa-male"></i>Logout</a></p>
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
		 <form action="listofsalebydate" method="post" name="salereportform" onsubmit="return salereport()">
<div class="content-wrapper">
<br><br>
            <div class="container">
                <div class="card">
                
                    <div class="card-header" style="background-color:orange">
                        <font size="4px" color="white">
                           Summary Report
                        </font>
                    </div>
                   
                    
                    <div class="card-body">

                        <div class="cardpanel">
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
                                        <b><label for="firstdate">FROM DATE</label></b>
                                            
                                            <input type="date" class="form-control" data-date-format="YYYY MM DD"  id="saledate" name="saledate"  value="${saledate }">
                                    </div>
                                    </div>
                                    <div class="col-md-4">
                                     <div class="form-group">
                                          <b><label for="seconddate">TO DATE</label></b>
                                            
                                            <input type="date" class="form-control" data-date-format="YYYY MM DD"  id="saledateto" name="saledatesecond"  value="${saledateto }">
                                           
                                       
                                    </div>
                                    </div>
                                    </div>
                                    <div class="row">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-4">
                                        
                                            <b><label for="date"></label></b>
                                   	  <center><input type="submit"  class="btn btn-primary" value="SEARCH"></center>
                                        </div>
                                        </div>
                                        <br>
                                      
                                        <div class="row">
                                         <c:choose>
                                         <c:when  test="${REPORT=='REPORT_LIST'}">   
                                        <table class="table table-striped">
                                        <c:choose>
                                         <c:when  test="${!empty listreport}">  
    <thead>
      <tr>
      <th>POS Name</th>
     <th>Sale Date</th>
        <th>Tyre Pattern</th>
        <th>Tyre Size</th>
        <th>Quantity</th>
        <th>Sales Amount</th>
        <th>Payment Mode</th>
      </tr>
    </thead>
    <c:forEach var="report"  items="${listreport}">
    <tr>
    <td>${POS} </td>
       <td>${report.saledate}</td>
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
		</div>
											<div class="row">
                                            <b><label for="date"></label></b>
                                            <a href="Salereport"><input type="button"  class="btn btn-primary" value="Back"></a>
                                        	</div>
                        </div>
                    </div>
                        <script type="Text/JavaScript">
   
function  salereport(){
	
	if((document.getElementById('posid').value=="null"))
	 {
	  document.getElementById('error').innerHTML = "Please Choose POS";
	  salereportform.posid.focus();
	  return(false);
	 }
	if((document.getElementById('saledate').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Choose From Date";
	  salereportform.saledate.focus();
	  return(false);
	 }
	if((document.getElementById('saledateto').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Choose To Date";
	  salereportform.saledateto.focus();
	  return(false);
	 }
	
		else 
	{
		 return(true);
	 }
	
}


  
</script>
                    </form>
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>