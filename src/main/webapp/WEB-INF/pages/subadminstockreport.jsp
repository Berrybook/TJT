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
	<title>Stock Report</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>    

     <script type="text/javascript">
var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table)
    var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
    window.location.href = uri + base64(format(template, ctx))
  }
})()
</script>
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
					
					

					<li><a href="subadminSalereport" style=" text-decoration: none;">Reports</a></li>	

					</ul>
				

				</nav>
		<form action="listofstock" method="post">
<div class="content-wrapper">
<br><br>
            <div class="container">
                <a  style="font-size: 36px;" data-toggle="tooltip"
						data-placement="right" title="Export to Excel"
						class="fa fa-file-excel-o"
						onclick="tableToExcel('testTable', 'W3C Example Table')"></a>
						
                    <div class="card-header" style="background-color:lightblue">
                              <font size="5px" color="white">
                                   Stock Report
                                </font>
                            </div>
                   <br>
                    
                  
                                        <table class="table" id="testTable">
                                        
                                          
   
      <tr>
        <th>POS ID</th>
        <th>Pattern</th>
        <th>Size</th>
        <th>Quantity</th>
       
      </tr>
   
    <c:forEach var="report"  items="${listreport}">
    <tr>
       <td>${report.pos}</td>
        <td>${report.tyrepattern}</td>
        <td>${report.tyresize}</td>
        <td>${report.quantity}</td>
        </tr>
    </c:forEach>
  
   
   
    
      
    
   
  </table>
  
  
 

                                        
                                            

 									</div>
 									<div class="row">
 									<div class=col-md-4></div>
 									<div class=col-md-4>
                                            <b><label for="date"></label></b>
                                            <a href="subadminSalereport"><input type="button"  class="btn btn-danger" value="Back"></a>
                                   </div>
                                   <div class=col-md-4></div>
                                    </div>
 
                        
                        
                        
                    </div>
                    </form>
                   
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->

</body>
</html>