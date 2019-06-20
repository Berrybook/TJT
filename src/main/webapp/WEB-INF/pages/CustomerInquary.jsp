<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/reset.css"> 
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/table.css">
<script src="js\modernizr.js"></script> 
<script src="js\validation.js"></script> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Customer Inquiry</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
     
      <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>    
    
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

.input-con {

  display: flex;
    width: 100%;
  margin-bottom: 15px;
}

.icon {
  padding: 10px;
  background: dodgerblue;
  color: white;
  min-width: 50px;
  text-align: center;
}

.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid dodgerblue;
}


/* Set a style for the submit button */
.btn {
  background-color: dodgerblue;
  color: white;
  padding: 25px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
 
}

.btn:hover {
  opacity: 1;
}

</style>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
					<!-- 	<li><a href="requestOrderbypos?access=Create Order" style=" text-decoration: none;">Create Order</a></li> -->
						<li><a href="CustomerInquaryForm" style=" text-decoration: none;">Inquiry Form</a></li>
						<li><a href="trackingsheet" style=" text-decoration: none;">Track Sheet</a></li>
						<!-- <li><a href="viewOrder?access=View Order" style=" text-decoration: none;">view Order</a></li> -->
						
					</ul>
				</nav>
			
				<c:choose>
										<c:when test="${not empty msg}">
											<script>
												successMessage("${msg}")
											</script>
										</c:when>
									</c:choose>
		<div class="content-wrapper">
	
			<c:choose>
			<c:when test="${not empty mail}">
			<center><span style="text-align:center;color: blue">${mail}</span></center>
			</c:when>
			<c:when test="${not empty transaction}">
			<center><span style="text-align:center;color: blue">${transaction}</span></center>
			</c:when>
			</c:choose>
<br>
<br>
 <form action="savacustomerdata" style="max-width:500px;margin:auto" method="POST">
<div class="row">
<div class="col-md-12">
   <button type="submit" style="margin-top:1.5% "  class="btn" ><center><h2 style="position:absolute;top:1%;left:20%;">Customer Inquiry Form</h2></center></button>
   </div>
   </div>
   &nbsp;
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="Customer Name" name="customerName" id="customerName"  required>
    <br><i style="color:red; font-size:20px;" id="stat"></i>
  </div>

  <div class="input-container">
    <i class="fa fa-phone icon"></i>
    <input class="input-field" type="text" placeholder="Customer PhoneNumber" name="phoneNumber" id="phoneNumber"  maxlength="10" onkeypress="return isNumber(event)"  required>
    
    <span id="err1"></span>
  </div>
  
  <div class="input-container">
    <i class="fa fa-motorcycle icon"></i>
    <input class="input-field" type="text" placeholder="Vehicle" name="vehicle" required>
  </div>


  <div class="input-container">
    <i class="fa fa-motorcycle icon"></i>
    <input class="input-field" type="text" placeholder="Vehicle Model" name="vehicleModel" required>
  </div>


  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="text" placeholder="TyreSize" name="tyreSize" required>
  </div>


  <div class="input-con">
    <i class="fa fa-tachometer icon"></i>
    <input class="input-field" type="text" placeholder="MeterReading" name="meterReading" >
</div>


  <div class="input-con">
    <i class="fa fa-calendar icon"></i>
    <input placeholder="Tentative Date" class="form-control" type="text" onfocus="(this.type='date')"  name="tentadate" id="date1" required>
   <!--  <input class="input-field" type="date" style="background-color:#d1d1d1" placeholder="Tentative Date" name="tentadate"  data-toggle="tooltip" data-placement="right" title="Tentative Date For Tyre Change" required>
 -->  </div>
 <!--  <div class="input-con"> -->
    <!-- <i class="fa fa-calendar icon"></i> -->
    <input class="input-field" type="date" placeholder="Enquiry Date" style="background-color:#d1d1d1"  name="dateofinqu" id="enquirydate" hidden="hidden"  data-toggle="tooltip" data-placement="right" title="Enquiry Date" required>
  <!-- </div> -->
   <!-- <div class="input-con"> -->
    <!-- <i class="fa fa-clock-o icon"></i> -->
    <input class="input-field" type="time" placeholder="Enter Time" style="background-color:#d1d1d1"  name="time" hidden="hidden" value="now" id="time" required="required" data-toggle="tooltip" data-placement="right" title="Time" required>
 <!--  </div> -->
  <input type="text" hidden="hidden" name="pos" value="${pos}">
 <div class="input-con">
    <i class="fa fa-user icon"></i>
   <select style="background-color:#d1d1d1" 
									class="form-control" required="required" name="salesman" id="salesman">
									<option value="">Select Salesman</option>
									<c:forEach var="val" items="${val}">
										<option value="${val.userid}">${val.userid}</option>
									</c:forEach>
								</select>
  </div>
  
  <div class="input-con">
    <i class="fa fa-edit icon"></i>
    <input class="input-field" type="text" placeholder="Comments" name="comments" required maxlength="120">
  </div>


 



 <div class="row" >
<div class="col-md-12" >
   <button type="submit"   class="btn" ><center><h3 style="position:absolute;top:3%;left:40%;">Submit</h3></center></button>
   </div>
   </div>
   &nbsp;
</form>
</div>

		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->






<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
    {
    return false;
    } 
    return true;
}
$(document).ready(function () {
 $('#customerName').keypress(function (e) {
	 var inputValue = event.charCode;
     if(!(inputValue >= 65 && inputValue <= 122) && (inputValue != 32 && inputValue != 0)){
         event.preventDefault();
       }
   });
});




</script>
<script>
$(function(){     
  var d = new Date(),        
      h = d.getHours(),
      m = d.getMinutes();
  if(h < 10) h = '0' + h; 
  if(m < 10) m = '0' + m; 
  $('input[type="time"][value="now"]').each(function(){ 
    $(this).attr({'value': h + ':' + m});
  });
});
</script>

<script>
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1;
var yyyy = today.getFullYear();

if(dd<10) {
    dd = '0'+dd
} 

if(mm<10) {
    mm = '0'+mm
} 
today =  yyyy+'-'+ mm + '-' + dd ;
document.getElementById('enquirydate').value  = today;



</script>

</body>


</html>