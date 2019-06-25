<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css\reset.css">
<link rel="stylesheet" href="css\style.css">
<link rel="stylesheet" href="css\style1.css">
<link rel="stylesheet" href="css\table.css">
<script src="js\modernizr.js"></script>
<script src="js\validation.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Tracking Report </title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js\jquery.menu-aim.js"></script>
<script src="js\main.js"></script>
<!-- Resource jQuery -->
<script type="js\Ajax.js"> </script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="js\jquery.validate.js"></script>
	<script src="js\jquery.validate.min.js"></script>  
<script>
$(document).ready(function(){
$("#choice").change(function(){
  $(".table tbody tr").hide();
  $(".table tbody tr."+$(this).val()).show('fast');
});

//this JS calls the tablesorter plugin that we already use on our site
$("#table").tablesorter( {sortList: [[0,0]]} );

}); 
</script>

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

<style>
 .error {
    color: #ff0000;;
  }
  #errmsg
{
color: red;
}
.form-control {
	background-color: lightgray;
}

.search-table {
	table-layout: fixed;
	margin: 20px auto 0px auto;
	overflow-x: scroll;
}

.search-table, td, th {
	border-collapse: collapse;
	border: 1px solid #777;
}

th {
	padding: 20px 7px;
	font-size: 15px;
	color: #444;
	background: lightblue;
}

td {
	padding: 5px 10px;
	height: 35px;
}

td {
	overflow: hidden;
	text-overflow: ellipsis;
	word-wrap: break-word;
	width: auto;
}

@media only screen and (max-width: 480px) {
	/* horizontal scrollbar for tables if mobile screen */
	.tablemobile {
		overflow-x: auto;
		display: block;
	}
}
 @media only screen and (max-width: 479px) {
#search{
position:absolute;
bottom:10px;


}
} 

 @media only screen and (min-width:760px) and (max-width: 1024px) {
 #search{
position:absolute;

top:40%;

}
} 
@media only screen and (min-width:360px) and (max-width: 640px) {
 #search{
position:absolute;
text-wrap:fixed;
top:40%;
width:50%;
height:200%;
}
} 
 @media only screen and (min-width:876px) and (max-width: 1440px) {
 #search{
position:absolute;

top:40%;

}
} 
@media only screen and (min-width:768px) and (max-width: 1024px) {
 #search{
position:absolute;



</style>

</head>


<style>
.list-group-item-success {
	background-color: lightblue;
}

.cd-side-nav {
	position: absolute;
	top: -1%;
}
</style>

<body>
	<div id="RoleRegistration">
		<header class="cd-main-header">


			<a href="#0" class="cd-nav-trigger"><span></span></a>
			<nav class="cd-nav">
				<ul class="cd-top-nav">
					<li>
						<p>
							<a href="logout" style="text-decoration: none;"><i
								class="fa fa-power-off"></i>Logout</a>
						</p>
					</li>
				</ul>
			</nav>
		</header>
		<main class="cd-main-content">
		<nav class="cd-side-nav">
			
				<br>
								<ul>
					
					

					<li><a href="subadminSalereport" style=" text-decoration: none;">Reports</a></li>	

					</ul>

				</nav>
		<c:if test="${not empty price_assignment}">
			<script>popup('${price_assignment}') </script>
		</c:if>
		<form action="subadminviewreportsalesman" method="get" name="track" id="track"  onSubmit="return validateForm()">
		
			<div class="content-wrapper">
				<br><br><div class="container">
				<a style="font-size: 36px;" data-toggle="tooltip"
						data-placement="right" title="Export to Excel"
						class="fa fa-file-excel-o"
						onclick="tableToExcel('testTable', 'W3C Example Table')"></a>

					<div class="card-header"
						style="background-color: lightblue; width: 100%">
						<font size="5px" color="white"> Salesman Tracker </font>
					</div>

 <div class="row">
                                        <div class="col-md-3">
                                         
										 <div class="form-group">
										 
										<b><label for="pos">POS</label></b>
   								<select class="form-control" name="pos" id="pos" >
                           		 <option value="">Select POS</option >
                             		      <c:forEach var="pos" items="${listpos}">
										<option value="${pos.pos}">${pos.pos}</option>
									</c:forEach>
                            	</select>
                            	<br>
                            	
                            	 
                            	
                                        </div>
                                        </div>
                                        <div class="col-md-3">
                                         
										 <div class="form-group">
										 
										<b><label for="salesman">Salesman</label></b>
   								<select class="form-control" name="salesman" id="salesman">
                           		 <option value="">Select Salesman</option>
                             		     
                            	</select>
                            	<br>
                            	
                            	 
                            	
                                        </div>
                                        </div>
										 <div class="col-md-3">
                                            <div class="form-group">
                                               <b><label for="Date">Date</label></b>
                                  <!--   <input type="date" placeholder="Date" class="form-control"  data-date-format="DD MM YYYY"  placeholder="Enter start Date" id="startDate" name="startDate" required >  -->
								  <input placeholder="Date" class="form-control" type="text" onfocus="(this.type='date')" name="date" id="date"> 
                                            </div>
                                        </div>
										  <div class="col-md-3">
                       <div class="form-group">
                    <input type="Submit"  id="search" value="Search" name="Search">

</div>
									</form>	
										<div class="col-md-4"></div>
                                    
                                        </div>
										</div>
					<!-- 	<button   data-toggle="tooltip" data-placement="right" title="Export to Excel"   onclick="tableToExcel('testTable', 'W3C Example Table')" Export to Excel<i class="fa fa-file-excel-o" style="font-size:40px;color:red;position:absolute;top:18%;left:30%;"></i> </button> <p><a  style="position:absolute;top:17%;left:41%;color:blue;text-decoration:none;font-size:20px;" href="findbydate">Upcomong Tyre Changes</a></p>
 -->
					
					<br>
					<div class="search-table-outter wrapper">
						<table border="1" class="search-table inner"  style="position:absolute;width:1030px;height:auto"  id="testTable">

							<tr id="heder">
							 <th width="10%"><b>Date</b></th>
							 <th width="10%"><b>Pos</b></th>
							<th width="10%"><b>Salesman</b></th>
							<th width="10%"><b>Time-Slot</b></th>
								<th width="10%"><b>Customer Approached</b></th>
								<th width="10%"><b>Inquiries</b></th>
								<th width="10%"><b>Tyres Sold</b></th>
								<th width="10%"><b>Comment</b></th>
				               
								<!-- <th><b>Contact</b></th>
								
								<th><b>POS</b></th>
								<th width="10%"><b>Salesman Name</b></th>
								<th><b>Vehicle</b></th>
								<th><b>Vehicle Model</b></th>
								<th><b>Tyre Size</b></th>
								<th width="10%"><b>OdoMeter Reading</b></th>
								<th><b>Inquiry Date</b></th>
								<th><b>Inquiry Time</b></th>
								<th width="10%"><b>Tentative Date</b></th>
								<th width="10%"><b>Comment</b></th> -->
							</tr>
							<c:forEach var="val" items="${val}">
								<tr>


									<!-- <%-- <td>${val.activity}</td> --%> -->
									<td width="10%">${val.date}</td>
									<td width="10%">${val.pos}</td>
							    <td width="10%">${val.salesman}</td>
							 	 <td width="10%">${val.timeslot}</td>
								<td width="10%">${val.customerapp}</td>
								<td width="10%">${val.customerinq}</td>
								<td width="10%">${val.tyresale}</td>
                                <td width="10%">${val.comment}</td>


								</tr>
							</c:forEach>

						</table>
					</div>
					<br> <br> <br> <br> <br> <br> <br>
					<br>
					<br>



					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-1"></div>
						<div class="col-md-1"></div>
						<div class="col-md-1"></div>
						<div class="col-md-5"></div>
					</div>
				</div>
			</div>
			<!-- .content-wrapper -->
		</form>
		</main>
		<script>
$(function() {
  
  $("form[name='track']").validate({
   
    rules: {
      
   /*    pos: "required", */
	  
   
	  
    },
   
    messages: {
      pos: "Please choose POS ",
	   date: "Please enter  Date",
	   
      
     
      
    },
    
    submitHandler: function(form) {
      form.submit();
    }
  });
});
$(function(){
 	$('#pos').on('change', function(){
 		
 	
 		var  pos = $('#pos option:selected').val();
 		debugger;
 		
 		 $.ajax({
 	            type: "GET",
 	            contentType: "application/json; charset=utf-8",
 	         	  datatype: "json",
 	            url: "${pageContext.request.contextPath}/salesmanbypos/"+pos+"",
 	            
 	            success: function (result) {
 	            	debugger;
 	            	var vehicle="";
 	            	vehicle+="<option value="+result[i]+">Select Vehicle</option>"
	                  for(var i=0;i<result.length;i++){ 
	                	vehicle+="<option value="+result[i]+">"+result[i]+"</option>"
	                	 $('#salesman').html(vehicle);
	                	debugger;
	                	
	                }
	                  
 	              
 	            	
 	            },
 	            }); })
 })
</script>
<!-- <script>

$(document).ready(function () {  
	   $('track').validate( {debug: true} );
	   
	   });          
</script> -->
	</body></html>