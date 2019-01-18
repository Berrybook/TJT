<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css\reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css\style.css"> <!-- CSS reset -->
	<script src="js\modernizr.js"></script> <!-- Modernizr -->
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>invoice generation</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
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
body{
width:100%
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
	
						<li><a href="createinvoice" style=" text-decoration: none;">New Invoice</a></li>
						<li><a href="saletransaction" style=" text-decoration: none;">Sales Transaction</a></li>
						
						
					</ul>
				

				</nav>
			
				
		<div class="content-wrapper">
		
            <br><br>
 <form action="invoicegeneration1" method="post" name="invoice" onsubmit=" return checkinvoice()">
      <br><br>
            
  <div class="container">
 
  <div id="accordion">
    <div class="card">
      <div class="card-header">
   <a class="collapsed card-link" data-toggle="collapse" href="#collapseOne">
      <font size="5px" color="white">
         Customer  Details
        </font>
        </a>
      </div>
      <div id="collapseOne" class="collapse " data-parent="#accordion">
        <div class="card-body">
         

<div class="cardpanel">
           
             <div class="row">
                    
                    
                           <div class="col-md-3">
                     <div class="form-group">
                          <b><label for="salespersonid">Sales PersonID</label></b>
                            <select class="form-control" name="userId">
                                <c:forEach var="salesid" items="${posid}">
 									 <option value="${salesid.userid}">${salesid.userName} (${salesid.userName})</option>
   								</c:forEach>
                            </select>
                        </div>

                     </div>
                   
                     

                   <div class="col-md-3">
                        <div class="form-group">
                           <b><label for="customername">Customer Name</label></b>
                            <input type="text" class="form-control" id="customerName" placeholder="Enter CustomerName" name="customerName" value="${update.customerName }">
                        	
                         </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                           <b><label for="phoneno">Contact No</label></b>
                          
                             <input type="text" class="form-control" id="contactNumber" placeholder="Enter ContactNumber" name="contactNumber" value="${update.contactNumber }" maxlength="10" onkeypress="return isNumber(event)">
                       		
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                           <b><label for="email">Email</label></b>
                            <input type="text" class="form-control" id="Email" placeholder="Enter Email" name="Email" value=${update.email }>
                        	
                         </div>
                    </div>
                    </div>
                        
               
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <b><label for="Address">Address 1</label></b>
                            <textarea class="form-control rounded-0" id="address1" rows="2" name="address1" >${update.address1 }</textarea>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <b><label for="Address">Address 2</label></b>
                            <textarea class="form-control rounded-0" id="address2" rows="2" name="address2" >${update.address2 }</textarea>
                        </div>
                    </div>

                     <div class="col-md-3">
                     <div class="form-group">
                          <b><label for="city">City</label></b>
                             <input type="text" class="form-control" id="city" placeholder="Enter city " name="city" value=${update.city }>
                        </div>
                     </div>
                       <div class="col-md-3">
                        <div class="form-group">
                           <b><label for="zipcode">Zip Code</label></b>
                            <input type="text" class="form-control" id="zipcode" placeholder="Enter zipcode " name="zipcode" value="${update.zipcode}" maxlength="6" onkeypress="return isNumber(event)">
                              </div>
                    </div>
                            </div>
    		   </div>
     	 </div>
	    </div>
    <div class="card">
      <div class="card-header">
        			<a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
     		  			 <font size="5px" color="white">
      						   Vehicle Info
    		  			  </font>
    			  </a>
    		  </div>
    		  <div id="collapseTwo" class="collapse" data-parent="#accordion">
       			 <div class="card-body">
  				<div class="cardpanel">
   
                <div class="row">



                    <div class="col-md-4">
                        <div class="form-group">
                            <b><label for="vehiclemake">Vehicle Make</label></b>
                    
							<input type="text" class="form-control" id="vehiclemake" placeholder="Enter Vehicle Make" name="vehiclemake" value="${updateVehicle.vehiclemake }">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <b><label for="vehiclemodel">Vehicle Model</label></b>
                            <input type="text" class="form-control" id="vehiclemodel" placeholder=" Enter Vehicle Model" name="vehiclemodel" value="${updateVehicle.vehiclemodel }">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <b><label for="vehiclenumber">Vehicle Number</label></b>
                       		<input type="text" class="form-control" id="vehiclenumber" placeholder="  Enter VehicleNumber" name="vehiclenumber" value="${updateVehicle.vehiclenumber }">
                        </div>
                    </div>
            </div>
            <div class="row">
  			<div class="col-md-4">
                        <div class="form-group">
                            <b><label for="vehiclekm">Vehicle KM</label></b>
                            <input type="text" class="form-control" id="vehiclekm" placeholder=" Enter Vehicle KM run" name="vehiclekm" value="${updateVehicle.vehiclekm }" onkeypress="return isNumber(event)">
                        </div>
                    </div>
                    <div class="col-md-4">
                     <div class="form-group">
                          <b><label for="vehicletype">Vehicle type</label></b>
                            <select class="form-control" name="vehicletype" >
                                <option value="Scooter">Scooter</option>
                                <option value="Motor Cycle">Motor Cycle</option>
                            </select>
                        </div>
                     </div>
				</div>
            </div>
	</div>
        </div>
      </div>
    
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
         <font size="5px" color="white">
         Tyres Info
        </font>
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
         
   <div class="cardpanel">
            
                
                <div class="row">



                   <div class="col-md-4">
                        <div class="form-group">
                            <div class="form-group">
                                <b><label for="tyretype">Pattern</label></b>
                                <select class="form-control" name="tyrepattern" id="tyrepattern">
                                <option value="non">select tyrepattern</option>
                                    <c:forEach var="tyrepatn" items="${tyrepattern}">
                  <option value="${tyrepatn.tyrepattern}">${tyrepatn.tyrepattern}</option>
                        </c:forEach>
                                </select>


                            </div>
                        </div>
                    </div>
                     <div class="col-md-4">
                                        <div class="form-group">
                                            <div class="form-group">
                                                <b><label for="tyresize">Size</label></b>
                                                
                                                <select class="form-control" class="form-control chosen-select"  name="tyresize"  id="tyresize" >
                                               <option value="">select tyresize</option>
                                               
                                                </select>
                                              
                         
                                            </div>
                                        </div>
                                    </div>
                     
                                    
                    
                    <div class="col-md-4">
                        <div class="form-group">
                           
                            <input type="hidden" class="form-control" id="tyreprice" name="basicPrice" placeholder=" Enter Price" onChange="return calculation()" >
                        </div>
                    </div>
                   </div>

                </div>
                 </div>
                </div>
                </div>

  <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapsefore">
         <font size="5px" color="white">
         Payment  Info
        </font>
        </a>
      </div>
      <div id="collapsefore" class="collapse" data-parent="#accordion">
        <div class="card-body">
         
   <div class="cardpanel">
            
                
                <div class="row">
			<div class="col-md-4">
                                <div class="form-group">
                                    <b><label for="date">Date</label></b>
                                    <input type="date" class="form-control"  data-date-format="YYYY MM DD"  placeholder="Enter Date" id="saledate" name="saledate" value="${update.saledate }">
                                </div>
                                </div>
                   <div class="col-md-3">
                        <div class="form-group">
                            <div class="form-group">
                          
                                <input type="hidden" class="form-control" id="aftergst" readonly >

                            </div>
                             
                        <div class="form-group">
                                <input type="hidden" class="form-control" id="totalgst" name="total_gst" readonly >
                        </div>
                        </div>
                    </div> 
                    </div>
                    <div class="row">
                    <div class="form-group">
                    <div class="col-md-12">
                    <b><label for="coupon">Coupon code</label></b>
                    </div>
                   
    
                    </div>
                    </div>
                    <div class="row">

                                    <div class="col-md-2">
                                        <div class="form-group">
                                         <input name="product" value="50" type="checkbox" class="custom-control" id="c1" onclick="total()">Like Our Page in Facebook <br>
											
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                          <input name="product" value="50" type="checkbox" class="custom-control" id="c2" onclick="total()">Posted in Facebook<br>  
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                     <input name="product" value="50" type="checkbox" class="custom-control" id="c3" onclick="total()">Posted in Twitter
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <input name="product" value="50" type="checkbox" class="custom-control" id="c4" onclick="total()"> Posted in Instagram<br>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <input name="product" value="50" type="checkbox" class="custom-control" id="c5" onclick="total()"> Posted in LinkedIn<br>
                                        </div>
                                    </div>
                                  
                                    </div>
                              
                    <div class="row">    
                         <div class="col-md-3">
                        <div class="form-group">
                            <b><label for="totalprice">Total Price</label></b>
                            <input type="text" class="form-control" id="totalprice" placeholder=" Your total Price" readonly name="total_price"  value="${update.total_price }">
                        </div>
                    </div>
                  
                   <div class="col-md-3">
                   <div class="form-group">
                            <b><label for="discountamount">Discount Amount</label></b>
                            <input type="text" class="form-control" id="discountshow" name="discount" placeholder="Discount Amount" value="${update.discount }" readonly >
                        </div>
                    </div>
                            
					<div class="col-md-3">
                        <div class="form-group">
                            <div class="form-group">
                                <b><label for="paymentmode">Mode of Payment</label></b>
                                <select class="form-control" name="payment_mode">
                                    <option value="Cash">Cash</option>
                                    <option value="Paytm">Paytm</option>
                                    <option value="UPI">UPI</option>
                                     <option value="Credit_Card">Credit Card</option>
                                </select>
                            </div>
                        </div>
                    </div>         
</div>
                </div>
                 </div>
                </div>
                </div>
                </div>

                                <!--  <a href="#" class="previous">&laquo; Previous</a> -->
  </div>
</div>
  <br>

<script type="Text/JavaScript">
   
function  checkinvoice(){ 
	if((document.getElementById('customerName').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Customer Name";
	  invoice.customerName.focus();
	  return(false);
	 }
	if((document.getElementById('contactNumber').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Contact Number";
	  invoice.contactNumber.focus();
	  return(false);
	 }
	if((document.getElementById('contactNumber').value.length>10))
	 {
	  document.getElementById('error').innerHTML = "Please Enter 10 digit mobile number";
	  invoice.contactNumber.focus();
	  return(false);
	 }
	if((document.getElementById('contactNumber').value.length<10))
	 {
	  document.getElementById('error').innerHTML = "Please Enter 10 digit mobile number";
	  invoice.contactNumber.focus();
	  return(false);
	 }
	if((document.getElementById('Email').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Email ID";
	  invoice.Email.focus();
	  return(false);
	 }
	var email = document.getElementById('Email');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email.value)) {
    	 document.getElementById('error').innerHTML = "Please Enter Valid Email ID";
    invoice.Email.focus();
    return(false);
 }
	if((document.getElementById('address1').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Addres";
	  invoice.address1.focus();
	  return(false);
	 }
	if((document.getElementById('zipcode').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Zipcode";
	  invoice.zipcode.focus();
	  return(false);
	 }
	if((document.getElementById('zipcode').value.length<6))
	 {
	  document.getElementById('error').innerHTML = "Zipcode Must be with in 6 digit";
	  invoice.zipcode.focus();
	  return(false);
	 }
	if((document.getElementById('zipcode').value.length>6))
	 {
	  document.getElementById('error').innerHTML = "Zipcode Must be with in 6 digit";
	  invoice.zipcode.focus();
	  return(false);
	 }
	if((document.getElementById('vehiclemake').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Vehicle Make";
	  invoice.vehiclemake.focus();
	  return(false);
	 }
	if((document.getElementById('vehiclemodel').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Vehicle Model";
	  invoice.vehiclemodel.focus();
	  return(false);
	 }
	if((document.getElementById('vehiclenumber').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Vehicle Number";
	  invoice.vehiclenumber.focus();
	  return(false);
	 }
	if((document.getElementById('vehiclekm').value==""))
	 {
		  document.getElementById('error').innerHTML = "Please Enter Vehicle KM";
		  invoice.vehiclekm.focus();
		  return(false);
		 }
	if((document.getElementById('tyrepattern').value==""))
	 {
		  document.getElementById('error').innerHTML = "please choose tyre Pattern";
		  invoice.tyrepattern.focus();
		  return(false);
		 }
	if((document.getElementById('totalprice').value<=0.0))
	 {
		  document.getElementById('error').innerHTML = "Please choose Tyresize";
		  invoice.vehiclekm.focus();
		  return(false);
		 }
	if((document.getElementById('saledate').value==""))
	 {
		  document.getElementById('error').innerHTML = "Please Choose Date";
		  invoice.saledate.focus();
		  return(false);
		 }
	else 
	{
		 return(true);
	 }
}
	/* <!-- For current date--> */
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
	document.getElementById('saledate').value  = today;
	
  function maxLengthCheck(object) {
    if (object.value.length > object.max.length)
      object.value = object.value.slice(0, object.max.length)
  }
    
  function isNumeric (evt) {
    var theEvent = evt || window.event;
    var key = theEvent.keyCode || theEvent.which;
    key = String.fromCharCode (key);
    var regex = /[0-9]|\./;
    if ( !regex.test(key) ) {
      theEvent.returnValue = false;
      if(theEvent.preventDefault) theEvent.preventDefault();
    }
  }
  
  function total() {
	  var input = document.querySelectorAll("input[name='product']:checked")  
	  document.getElementById('totalprice').value = document.getElementById('aftergst').value -
	  (input.length * (input.length =50))
	
	 
	document.getElementById('discountshow').value = document.getElementById('aftergst').value - document.getElementById('totalprice').value;
	  
	}
  </script>
  
  
  <script>
  
  function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    } 
	    return true;
	}
  
</script>




  <script>
                    /* get tyresize when tyrepattern is select  */
                    
                    $(function(){
                    	$('#tyrepattern').on('click', function(){
                    		debugger;
                    		var tyrepattern = $('#tyrepattern').val();
                    		debugger;
                    		 $.ajax({
                    	            type: "GET",
                    	            contentType: "application/json; charset=utf-8",
                    	         	  datatype: "json",
                    	            url: "${pageContext.request.contextPath}/tyresize/"+tyrepattern+"",
                    	            success: function (response) {
                    	                 var tyresize="";
                    	                 
                    	                 if(tyrepattern=='non'){
                    	                	 tyresize+="<option value="+response[i]+">Select TyreSize</option>"
                    	                	 $('#tyresize').empty();
                    	                	 $('#tyresize').html(tyresize);
                    	                	
                    	                 }
                    	                 else{
                    	                 tyresize+="<option value="+response[i]+">Select TyreSize</option>"
                    	                  for(var i=0;i<response.length;i++){ 
                    	                	 
                    	                	 tyresize+="<option value="+response[i]+">"+response[i]+"</option>"
                    	                	 $('#tyresize').html(tyresize);
                    	                }
                    	                 }
                    	            	debugger;      
                    	            },
                    	            error: function(e){
                    	            	
                    	            	debugger;
                    	            	console.log("error");
                    	            }
                    		 });
                            

                    	})
                    	})
                    	
                    	//get tyreprice when tyrepattern and tyreprice is selected 
                    	
                    	 $(function(){
                    	$('#tyresize').on('click', function(){
                    		debugger;
                    		var  tyresize = $('#tyresize option:selected').text(); 
                    		var tyrepattern =  $('#tyrepattern option:selected').val();
                    		
                    		debugger;
                    		 $.ajax({
                    			 
                    	            type: "GET",
                    	            contentType: "application/json; charset=utf-8",
                    	         	  datatype: "json",
                    	            url: "${pageContext.request.contextPath}/tyreprice/"+tyrepattern+","+tyresize+"",
                    	            
                    	            success: function (result) {
                    	            	debugger;
                    	             
                    	                 $('#tyreprice').val(result);
                    	            	debugger;    
                    	            	
                    	            	var sst=result*14/100;
                    	            	var cst=result*14/100;
                    	            	
                    	            	debugger;
                    	            	var gst=sst+cst;
                    	            	
                    	            	debugger;
                    	            	var totalprice=result+gst;
                    	            	 var tot = Math.round(totalprice*100)/100;
                    	            	 
                    	            	$('#totalgst').val(gst);
                     	            	$('#aftergst').val(tot);
                     	            	$('#totalprice').val(tot);
                    	            
                    	            	debugger;
                    	            },
                    	            error: function(e){
                    	            	
                    	            	debugger;
                    	            	console.log("error");
                    	            }
                    		 });
                            

                    	})
                    	})
                    
                  
                    	
</script><div class="row">
<div class="col-md-2"></div>
<font color='red'> <span id="error"> </span> </font>
</div>
           <center>   <input type="submit" class="btn btn-primary" value="SUBMIT"></center>
     
</form>
  
                   

</div>
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->


<script src="js\jquery.menu-aim.js"></script>
<script src="js\main.js"></script> <!-- Resource jQuery -->
</body>
</html>