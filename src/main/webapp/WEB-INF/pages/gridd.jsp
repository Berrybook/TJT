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
<title>Customer Enquiry</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js\jquery.menu-aim.js"></script>
<script src="js\main.js"></script>
<!-- Resource jQuery -->
<script type="js\Ajax.js"> </script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

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
			<div id="MainMenu">
				<div class="list-group panel">


					<a href="#demo3" class="list-group-item list-group-item-success"
						data-toggle="collapse" data-parent="#MainMenu">Registration<i
						class="fa fa-angle-double-down"
						style="font-size: 24px; position: absolute; top: 16px; left: 90%; color: #347C98"></i></a>
					<div class="collapse" id="demo3">
						<a href="create_Dealer" class="list-group-item">Dealer
							Registration</a> <a href="createcity" class="list-group-item">City
							Registration</a> <a href="role" class="list-group-item">Role
							Registration</a> <a href="Poscreate" class="list-group-item">POS
							Registration</a> <a href="userregistration" class="list-group-item">User
							Registration</a> <a href="warehouseMasterLink"
							class="list-group-item">Warehouse Registration</a> <a
							href="tyrecreate" class="list-group-item">Item Registration</a> <a
							href="createroleaccess" class="list-group-item">Resource Role
							Access</a>
					</div>
					<a href="#demo4" class="list-group-item list-group-item-success"
						data-toggle="collapse" data-parent="#MainMenu">Pevilleges
						Assign <i class="fa fa-angle-double-down"
						style="font-size: 24px; position: absolute; top: 16px; left: 90%; color: #347C98"></i>
					</a>
					<div class="collapse" id="demo4">
						<a href="warehouseMasterLink" class="list-group-item">Warehouse
							Assign</a> <a href="createuserrolemappinglink"
							class="list-group-item">User Role Assign</a> <a
							href="createrolmodulemappinglink" class="list-group-item">Role
							Module Assign</a> <a href="item_price_assign" class="list-group-item">Price
							Assignment</a>
					</div>
					<a href="Salereport"
						class="list-group-item list-group-item-success"
						data-parent="#MainMenu">Reports</a> <a href="allOrderList"
						class="list-group-item list-group-item-success"
						data-parent="#MainMenu">Orders By Dealers</a> <a
						href="customerenquiry"
						class="list-group-item list-group-item-success"
						data-parent="#MainMenu">Customer Inquires</a>
				</div>
			</div>




		</nav>
		<c:if test="${not empty price_assignment}">
			<script>popup('${price_assignment}') </script>
		</c:if>
		<form action="priceAssignment" method="POST">
			<div class="content-wrapper">
				<div class="container">

					<br> <br>
					<br>
					<br> <br>
					<br>

					<!-- 	<button   data-toggle="tooltip" data-placement="right" title="Export to Excel"   onclick="tableToExcel('testTable', 'W3C Example Table')" Export to Excel<i class="fa fa-file-excel-o" style="font-size:40px;color:red;position:absolute;top:18%;left:30%;"></i> </button> <p><a  style="position:absolute;top:17%;left:41%;color:blue;text-decoration:none;font-size:20px;" href="findbydate">Upcomong Tyre Changes</a></p>
 -->
					<a style="font-size: 36px;" data-toggle="tooltip"
						data-placement="right" title="Export to Excel"
						class="fa fa-file-excel-o"
						onclick="tableToExcel('testTable', 'W3C Example Table')"></a>
					<p>
						<a
							style="color: blue; text-decoration: underline; font-size: 20px;"
							href="findbydate">Upcomong Tyre Changes</a>
					</p>

					<div class="card-header"
						style="background-color: lightblue; width: 100%">
						<font size="5px" color="white"> Upcoming Inquiries </font>
					</div>
					<br>
					<div class="search-table-outter wrapper">
						<table border="1" class="table" id="testTable">

							<tr id="heder">
								<th><b>Customer Name</b></th>
								<th><b>Contact</b></th>
								<th><b>Vehicle</b></th>
								<th><b>Inquiry Date</b></th>
								<th><b>Inquiry Time</b></th>
								<th><b>POS</b></th>
								<th><b>Salesman Name</b></th>
								<th><b>Vehicle Model</b></th>
								<th><b>Tyre Size</b></th>
								<th><b>OdoMeter Reading</b></th>
								<th><b>Tentative Date</b></th>
								<th><b>Comment</b></th>
							</tr>
							<c:forEach var="val" items="${val}">
								<tr>


									<td>${val.customerName}</td>
									<td>${val.phoneNumber}</td>
									<td>${val.vehicle}</td>
									<td>${val.dateofinqu}</td>
									<td>${val.time}</td>
									<td>${val.pos}</td>
									<td>${val.salesman}</td>
									<td>${val.vehicleModel}</td>
									<td>${val.tyreSize}</td>
									<td>${val.meterReading}</td>
									<td>${val.tentadate}</td>
									<td>${val.comments}</td>



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
		<!-- .cd-main-content -->
	</div>