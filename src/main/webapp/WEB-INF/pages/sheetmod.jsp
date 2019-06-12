
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<title>Tracking Sheet</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
<script src="D:\jqueryval\jquery.validate.js"></script>
	<script src="D:\jqueryval\jquery.validate.min.js"></script>  	
 <!--        
	<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT> -->
       
	<script type="text/javascript">
   $(document).ready(function(){
       
   
        $(".delete-row").click(function(){
           
            	
                    $(this).parents("tr").remove();
             
        
        });
    }); 
</script>
	
<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	.form-control{
	background-color:lightgray;
	
	}
		.list-group-item-success{
	background-color:lightblue;
	}
	.cd-side-nav{
	position:absolute;
	top:-1%;
	}
	</style>
	 <style>
	  .error {
    color: #ff0000;
  }
  #errmsg
{
color: red;
}
#errmsg1{
color: red;
}
</style>	  
	

  <style>
     
.search-table{
table-layout: fixed; margin:20px auto 0px auto;  overflow-x:scroll; 
}
.search-table, td, th{
border-collapse:collapse; border:1px solid #777;
}
th{
padding:20px 7px; font-size:15px; color:#444; background:lightblue;
}
td{
padding:5px 10px; height:35px;
}
td { 
    overflow: hidden; 
    text-overflow: ellipsis; 
    word-wrap: break-word;
	width:auto;
}
@media only screen and (max-width: 480px) {
    /* horizontal scrollbar for tables if mobile screen */
    .tablemobile {
        overflow-x: auto;
        display: block;
    }
}
.list-group-item-success{
	background-color:lightblue;
	}
	

	
	</style>
<script type="text/javascript">
function successMessage(msg) {

	swal(msg, " ")
}
</script>

	
	
</head>
 <BODY onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">


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
						<li><a href="CurrentMonthsalesReport" style=" text-decoration: none;">Month Report</a></li>
					<!-- 	<li><a href="requestOrderbypos?access=Create Order" style=" text-decoration: none;">Create Order</a></li> -->
						<li><a href="CustomerInquaryForm" style=" text-decoration: none;">Inquiry Form</a></li>
						<li><a href="trackingsheet" style=" text-decoration: none;">Track Sheet</a></li>
						<!-- <li><a href="viewOrder?access=View Order" style=" text-decoration: none;">view Order</a></li> -->
						
					</ul>
				</nav>
            <div class="content-wrapper">
            <div class="container">
           <!--  <c:if test="${not empty city_registration}"><script>popup('${city_registration}') </script></c:if>
			<c:if test="${not empty delete_mode}"><script>popup('${delete_mode}') </script></c:if> -->
			 <form action="submitsheet" method="POST"  name="CustomerEnquiry" id="CustomerEnquiry" enctype="multipart/form-data"  onSubmit="return cityvalidateForm()"">
	            
               
                    <br>
                    <br>
                    <c:choose>
										<c:when test="${not empty msg}">
											<script>
												successMessage("${msg}")
											</script>
										</c:when>
									</c:choose>
                    
                        
                            <div class="card-header" style="background-color:lightblue">
                              <font size="5px" color="white">
                                   Tracking Sheet
                                </font>
                            </div>
                            
                               
                                    <div class="row">
                                        <div class="col-md-4">
                                          <div class="form-group">
                                                <b><label for="salesman">Salesman</label></b>
                                                <select  
									class="form-control" required="required" name="salesman" id="salesman">
									<option value="">Select Salesman</option>
									<c:forEach var="val" items="${val}">
										<option value="${val.userid}">${val.userid}</option>
									</c:forEach>
								</select>
                                            </div>
                                        </div>
                                        
                                         <input type="text" hidden="hidden" name="pos" value="${pos}">
                                        <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Timeslot">Time Slot</label></b>
                                                <select  
									class="form-control" required="required" name="timeslot" id="timeslot">
									<option value="">Select Time Slot</option>
									<option value="8am-10am">8am-10am</option>
									<option value="10am-12pm">10am-12pm</option>
									<option value="12pm-2pm">12pm-2pm</option>
									<option value="2pm-4pm">2pm-4pm</option>
									<option value="4pm-6pm">4pm-6pm</option>
									<option value="6pm-8pm">6pm-8pm</option>
									<option value="8pm-10pm">8pm-10pm</option>
									<!-- <option value="5pm-7pm">5pm-7pm</option> -->
								<!-- 	<option value="7pm-9pm">7pm-9pm</option>
									<option value="9pm-11pm">9pm-11pm</option>
									<option value="11pm-1am">11pm-1am</option> -->
								</select>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
									<div class="form-group">
                                                <b><label for="noofcustomer">Customer Approach</label></b>
                                                <input type="text" class="form-control"  required="required" id="customerapp" placeholder="Enter number of customers" name="customerapp">
												<span id="errmsg3"></span>
                            
                                            </div>
									</div>
                                     <!--    <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Activity">Activity</label></b>
                                                 <select  
									class="form-control" required="required" name="activity" id="activity">
									<option value="">Select Activity</option>
									<option value="Customer Approached">Customer Approached</option>
									<option value="Inquiries At Kiosk">Inquiries At Kiosk</option>
									<option value="Tyre Sold">Tyre Sold</option>
									
								</select>
                            
                                            </div>
                                        </div> -->
										
										
										
										
                                    </div>
									
									
									
									
									
									
									<div class="row">
									<!-- <div class="col-md-4">
									<div class="form-group">
                                                <b><label for="noofcustomer">Number Of Customer</label></b>
                                                <input type="text" class="form-control"  required="required" id="noofcustomer" placeholder="Enter number of customers" name="noofcustomer">
												<span id="errmsg1"></span>
                            
                                            </div>
									</div> -->
									
									
			<!-- 						<div class="col-md-4">
									<div class="form-group">
                                                <b><label for="noofcustomer">Customer Approach</label></b>
                                                <input type="text" class="form-control"  required="required" id="noofcustomer" placeholder="Enter number of customers" name="customerapp">
												<span id="errmsg1"></span>
                            
                                            </div>
									</div> -->
									
									<div class="col-md-4">
									<div class="form-group">
                                                <b><label for="noofcustomer">Customer Inquiry</label></b>
                                                <input type="text" class="form-control"  required="required" id="customerinq" placeholder="Enter number of customers" name="customerinq">
												<span id="errmsg2"></span>
                            
                                            </div>
									</div>
									
									<div class="col-md-4">
									<div class="form-group">
                                                <b><label for="noofcustomer">Tyre Sale</label></b>
                                                <input type="text" class="form-control"  required="required" id="tyresale" placeholder="Enter number of customers" name="tyresale">
												<span id="errmsg1"></span>
                            
                                            </div>
									</div>
									
									
									
									
									<div class="col-md-4" hidden="hidden">
									<div class="form-group">
                                                <b><label for="current time">Current Time</label></b>
                                                <input type="time" class="form-control" value="now" required="required" id="currenttime" placeholder="Enter time" name="curtime">
												
                                            </div>
									</div>
								
									
									<div class="col-md-4" hidden="hidden">
									<div class="form-group">
                                                <b><label for="current Date">Current Date</label></b>
                                                <input type="date" class="form-control"  id="currentdate" required="required" placeholder="Enter Date" name="date">
												
                                            </div>
									</div>
									</div>
									
									</div>
									
                                    <br>
                                    <center>
                                         <input type="submit" value="Done" class="btn btn-danger">
                                        </center>
                            
                       </form>
                        <br>
						
             </div>   
            </div><!-- .content-wrapper -->
        </main> <!-- .cd-main-content -->
<script>
$(function() {
  
  $("form[name='CustomerEnquiry']").validate({
   
    rules: {
      
      salesman: "required",
	  timeslot:"required",
      customerapproached: "required",
	  inquiry: "required",
	  tyresold: "required",
	  currenttime: "required",
	  currentdate: "required",
	  activity:"required",
	  noofcustomer:"required",
	 
     
	  
    },
   
    messages: {
      salesman: "Please Choose Salesman",
	   timeslot: "Please choose timeslot",
	    customerapproached: "Please enter your no.of Customer Approached",
		 inquiry: "Please enter no.of Persons Enquired ",
		  tyresold: "Please enter Tyre Sold",
		   currenttime: "Please enter time",
		    currentdate: "Please enter Date",
			  activity: "Please Choose Activity",
			   noofcustomer: "Please enter Number of Customer",
			 
			   
      
     
      
    },
    
    submitHandler: function(form) {
      form.submit();
    }
  });
});

</script>
<script>
$(document).ready(function () {
  //called when key is pressed in textbox
  $("#customerapp").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg3").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
});
</script>
<script>
$(document).ready(function () {
  //called when key is pressed in textbox
  $("#customerinq").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg2").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
});
</script>
<script>
$(document).ready(function () {
  //called when key is pressed in textbox
  $("#tyresale").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg1").html("Digits Only").show().fadeOut("slow");
               return false;
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
document.getElementById('currentdate').value  = today;



</script>

</body>
</html>