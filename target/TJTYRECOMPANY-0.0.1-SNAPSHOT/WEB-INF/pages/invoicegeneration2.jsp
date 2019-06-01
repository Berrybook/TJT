<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css\reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css\style.css"> <!-- CSS reset -->
	<script src="js\modernizr.js"></script>
	<script src="js\validation.js"></script>
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Invoice Generation</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
	
	<script type="text/javascript">
	
        function populateDropDown() {

            /* Clear the entire subjects drop down*/
            document.getElementById("pattern").options.length = 0;

            /* adding a Default "Select" option in Subjects Menu*/
            var optn = document.createElement("OPTION");
            optn.text = "Select";
            pattern.options.add(optn);

            /* This can be changed according to the rest of the code instead of hard coded values*/
            var selectedIndexVal = document.getElementById("size").selectedIndex;
            var subjectValList = document.getElementById("size").options[selectedIndexVal].value;
            var subjectValArray = subjectValList.split(",");
            for (var j = 0; j < subjectValArray.length; j++) {
                var optn = document.createElement("OPTION");
                optn.text = subjectValArray[j];
                optn.value = subjectValArray[j];
                pattern.options.add(optn);
            }

        }
		
		
		$(document).ready(function(){
    $("select").change(function(){
        $(this).find("option:selected").each(function(){
            var optionValue = $(this).attr("value");
           
            if(optionValue=="2"){
               /*  $(".add").not("." + optionValue).show();
                $("." + optionValue).show(); */
                
                $(".add").hide();
				 $(".second-row").hide();
              
            }  else if(optionValue=="1"){
            	$(".second-row").hide();
                $(".add").show();
			
				 
            } 
        });
    }).change();
});

    </script>
	
	

	<script>
$(function(){
    $(".add").click(function(){
        $("#pattern1").show();
        $(".second-row").show();
        
    });



 $(".add").click(function(){
        $("#size1").show();
    });

});
</script>
	
	
	
	
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
 background-color:#4289f4;
 height:60px;


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
 <form action="invoicegeneration1" method="post" name="invoice" onsubmit=" return checkinvoice()">
      <br><br>
            
  <div class="container">
 
  <div id="accordion">
    <div class="card">
      <div class="card-header" class="collapsed card-link" data-toggle="collapse" href="#collapseOne" style="cursor: pointer;">
  
      <font size="5px" color="white">
         Customer  Details <i  class='fas fa-user' style='font-size:120%;color:white;margin-left:95%;margin-top:-3%'></i>
        </font>
       
      </div>
      <div id="collapseOne" class="collapse " data-parent="#accordion">
        <div class="card-body">
         

<div class="cardpanel">
           
             <div class="row">
                    
                    
                           <div class="col-md-3">
                     <div class="form-group">
                          <b><label for="salespersonid">Salesman</label></b>
                          
                            <select class="form-control" name="userId" id="userId">
                            	<option value=""> choose User</option>
                                <c:forEach var="salesid" items="${posid}">
 									 <option value="${salesid.userid}">${salesid.userid} (${salesid.userName})</option>
   								</c:forEach>
                            </select>
                        </div>

                     </div>
                   
                     

                   <div class="col-md-3">
                        <div class="form-group">
                           <b><label for="customername">Name</label></b>
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
                           <b><label for="zipcode">Pin Code</label></b>
                            <input type="text" class="form-control" id="zipcode" placeholder="Enter zipcode " name="zipcode" value="${update.zipcode}" maxlength="6" onkeypress="return isNumber(event)">
                              </div>
                    </div>
                            </div>
    		   </div>
     	 </div>
	    </div>
    <div class="card">
      <div class="card-header" class="collapsed card-link" data-toggle="collapse" href="#collapseTwo" style="cursor: pointer;">
        			
     		  			 <font size="5px" color="white">
      						   Vehicle Info<i class="fa fa-car" style="font-size:120%;margin-left:95%;margin-top:-3%"></i>
    		  			  </font>
    			 
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
      <div class="card-header" class="collapsed card-link" data-toggle="collapse" href="#collapseThree" style="cursor: pointer;">
       
         	<font size="5px" color="white">
        	 Tyres Info <i class="fa fa-motorcycle" style="font-size:120%;margin-left:95%;margin-top:-3%"></i>
        	</font>
     
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">   
  		 <div class="cardpanel">
                <div class="row">
                 <div class="col-md-4">
                       		<div class="form-group">
                          <b><label for="paymentmode">pattern</label></b>
                         <select class="form-control" name="tyrepattern" id="tyrepattern" onchange="javascript:populateDropDown(this)">
                                <option value="non">select pattern</option>
                                    <c:forEach var="tyrepatn" items="${tyrepattern}">
                				  <option value="${tyrepatn.pattern}">${tyrepatn.pattern}</option>
                        </c:forEach>
                                </select>
                          	
                        	</div>
                 	 	</div>   
						
						
                   <div class="col-md-4">
                       		<div class="form-group">
                           		
                               		 <b><label for="paymentmode">size</label></b>
                                		
							   
                                <select class ="form-control" class="form-control chosen-select"id="tyresize" name="tyre_size">
                                	<option value="">select tyresize</option>
                                </select>
								 
                          		 </div>
                        	</div>
	
					 <div class="col-md-3">
					 <div class="form-group">
					 <b><label for="paymentmode">Quantity</label></b>
                     <select class="form-control" id="Quantity" name="Quantity">
                      <!--<option value="0">select quantity</option>  -->
                      <option value="1">1</option>
                      <option value="2">2</option>
            
                      </select>
  
   
	</div>
	 </div>
	 <div class="col-md-1">
	  
	  <!--<button class="add material-icons" id="adds" style="margin-top:34px">add</button>-->
	  <input type="button" class="add material-icons" style="margin-top:34px" value="add">

	 </div>
         </div>    
		 
			
 <div class="row second-row">
<div class="col-md-4" >
<div id="pattern1" style="display:none">
<div class="form-group">

<b><label for="paymentmode">pattern</label></b>
<select class="form-control" name="tyrepattern" id="tyrepattern1">
                                <option value="non">select tyrepattern</option>
                                    <c:forEach var="tyrepatn" items="${tyrepattern}">
                  <option value="${tyrepatn.pattern}">${tyrepatn.pattern}</option>
                        </c:forEach>
                                </select>

</div>
</div>
</div>
<div class="col-md-4">
<div id="size1" style="display:none">
<div class="form-group">
<b><label for="paymentmode">size</label></b>
<select class="form-control" class="form-control chosen-select"  name="tyre_size"  id="tyresize1" >
                                               <option value="">select tyresize</option>
                                               
                                                </select>

</div>
</div>
	<div class="col-md-4">
	<input type="hidden" class="form-control" id="tyreprice" name="basicPrice" placeholder=" Enter Price" onChange="return calculation()" >
	<input type="hidden" class="form-control" id="tyreprice1" name="basicPrice" placeholder=" Enter Price" onChange="return calculation()" >
	</div>
	</div>			
                 
 
                   </div>
                </div>
                 </div>
                </div>
                </div>
  <div class="card">
      <div class="card-header" class="collapsed card-link" data-toggle="collapse" href="#collapsefore" style="cursor: pointer;">
       
         <font size="5px" color="white">
         Payment  Info  <i class='fas fa-copy' style='font-size:120%;margin-left:95%;margin-top:-3%'></i>
        </font>
      
      </div>
      <div id="collapsefore" class="collapse" data-parent="#accordion" style="cursor: pointer;">
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
                          
                                <input type="hidden" class="form-control" id="aftergst"  readonly >
								<input type="hidden" class="form-control" id="beforgst"  readonly >
                            </div>
                             
                        <div class="form-group">
                                <input type="hidden" class="form-control" id="totalgst" name="total_gst" readonly >
                                <input type="hidden" class="form-control" id="cgst" name="total_cgst" readonly >
                                <input type="hidden" class="form-control" id="sgst" name="total_sgst" readonly >
                                <input type="hidden" class="form-control" id="taxble" name="taxble_amount" readonly >
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
                            <b><label for="discountamount">Discount</label></b>
                            <input type="text" class="form-control" id="discountshow" name="discount" placeholder="Discount Amount" value="${update.discount }" readonly >
                        </div>
                    </div>
                            
					<div class="col-md-3">
                        <div class="form-group">
                            <div class="form-group">
                                <b><label for="paymentmode">Payment</label></b>
                                <select class="form-control" name="payment_mode">
                                    <option value="Cash">Cash</option>
                                    <option value="UPI">UPI</option>
                                    <option value="Paytm">Paytm</option>
                                    <option value="CreditCard">Credit Card</option>
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
	document.getElementById('saledate').value  = today;
	
	
</script>
  <script>
                    /* get tyresize when tyrepattern is select  */
                    
                    $(function(){
                    	$('#tyrepattern').on('change', function(){
                    	
                    		var tyrepattern = $('#tyrepattern').val();
                    	
                    		 $.ajax({
                    	            type: "GET",
                    	            contentType: "application/json; charset=utf-8",
                    	         	  datatype: "json",
                    	            url: "${pageContext.request.contextPath}/tyresizes/"+tyrepattern+"",
                    	            success: function (response) {
                    	                 var tyresize="";
                    	                 
                    	                 if(tyrepattern=='non'){
                    	                	 tyresize+="<option value='"+response[i]+"'>Select TyreSize</option>"
                    	                	 $('#tyresize').empty();
                    	                	 $('#tyresize').html(tyresize);
                    	                	
                    	                 }
                    	                 else{
                    	                 tyresize+="<option value='"+response[i]+"'>Select TyreSize</option>"
                    	                  for(var i=0;i<response.length;i++){ 
                    	                	 
                    	                	 tyresize+="<option value='"+response[i]+"'>"+response[i]+"</option>"
                    	                	 $('#tyresize').html(tyresize);
                    	                }
                    	                 }
                    	                 
                    	            },
                    	            error: function(e){
                    	            	
                    	            
                    	            	console.log("error");
                    	            }
                    		 });
                            

                    	})
                    	})
                    	
                    	
                    	
                    	
                    	 $(function(){
                    	$('#tyresize').on('change', function(){
                    		
                    		/* var  tyresize = $('#tyresize option:selected').text(); 
                    		var tyrepattern =  $('#tyrepattern option:selected').val(); */
                    		
                    		var tyrepattern = $('#tyrepattern').val();
                    		var  tyresize = $('#tyresize').val(); 
                    		var tyreprice1=$('#tyreprice1').val();
                    	
                    		 $.ajax({
                    			 
                    	            type: "GET",
                    	            contentType: "application/json; charset=utf-8",
                    	         	  datatype: "json",
                    	            url: "${pageContext.request.contextPath}/tyreprice/"+tyrepattern+","+tyresize+"",
                    	            
                    	            success: function (result) {
                    	            
                    	             
                    	                 $('#tyreprice').val(result);
                    	            
                    	                 var basicprice=0.0;
                    	                 if(tyreprice1=="" && result!=""){
                    	                	 basicprice=parseFloat(result)+tyreprice1;
                    	                 }
                    	                 else if(tyreprice1!="" && result==""){
                    	                	  basicprice=result+parseFloat(tyreprice1); 
                    	                 }
                    	                 else{
                    	                	 basicprice=parseFloat(result)+parseFloat(tyreprice1);
                    	                 }
                    	                 var cgst = basicprice*14/100;
                     	            	var sgst =basicprice*14/100;
                     	            	var gst=sgst+cgst;
                    	            	
                    	            
                    	            	var totalprice=parseFloat(basicprice)+parseFloat(gst);
                    	            	 var aftergst = Math.round(totalprice*100)/100;
                    	            	 $('#discountshow').val(null);
                       	            	$("#c1").prop("checked", false);
                       	            	$("#c2").prop("checked", false);
                       	            	$("#c3").prop("checked", false);
                       	            	$("#c4").prop("checked", false);
                       	            	$("#c5").prop("checked", false);
                    	            
                     	            	$('#beforgst').val(basicprice);
                     	            	$('#totalprice').val(aftergst);
                     	            	$('#aftergst').val(aftergst);
                     	           		$('#totalgst').val(Math.round(gst*100)/100);
                   	            		$('#sgst').val(Math.round(sgst*100)/100);
                   	            		$('#cgst').val(Math.round(cgst*100)/100);
                       	            	$('#taxble').val(basicprice);
                    	            
                     	          
                    	            },
                    	            error: function(e){
                    	            
                    	            	console.log("error");
                    	            }
                    		 });
                            

                    	})
                    	})
                    
                    
                    	$(function(){
                        	$('#tyrepattern1').on('change', function(){
                        		
                        		var tyrepattern = $('#tyrepattern1').val();
                        	
                        		 $.ajax({
                        	            type: "GET",
                        	            contentType: "application/json; charset=utf-8",
                        	         	  datatype: "json",
                        	            url: "${pageContext.request.contextPath}/tyresizes/"+tyrepattern+"",
                        	            success: function (response) {
                        	                 var tyresize="";
                        	                 
                        	                 if(tyrepattern=='non'){
                        	                	 tyresize+="<option value='"+response[i]+"'>Select TyreSize</option>"
                        	                	 $('#tyresize1').empty();
                        	                	
                        	                	 $('#tyresize1').html(tyresize);
                        	                	 $('#tyresize1').html(tyresize);
                        	                	
                        	                 }
                        	                 else{
                        	                 tyresize+="<option value='"+response[i]+"'>Select TyreSize</option>"
                        	                  for(var i=0;i<response.length;i++){ 
                        	                	 
                        	                	 tyresize+="<option value='"+response[i]+"'>"+response[i]+"</option>"
                        	                	 $('#tyresize1').html(tyresize);
                        	                }
                        	                 }
                        	                 
                        	            },
                        	            error: function(e){
                        	            
                        	            	console.log("error");
                        	            }
                        		 });
                                

                        	})
                        	})
                        	
                        	//get tyreprice when tyrepattern and tyreprice is selected 
                        	
                        	 $(function(){
                        	$('#tyresize1').on('change', function(){
                        		
                        		/* var  tyresize = $('#tyresize1 option:selected').text(); 
                        		var tyrepattern =  $('#tyrepattern1 option:selected').val(); */
                        		
                        		var tyrepattern = $('#tyrepattern1').val();
                        		var  tyresize = $('#tyresize1').val(); 
                        		var tyreprice=$('#tyreprice').val();
                        		
                        		 $.ajax({
                        			 
                        	            type: "GET",
                        	            contentType: "application/json; charset=utf-8",
                        	         	  datatype: "json",
                        	            url: "${pageContext.request.contextPath}/tyreprice/"+tyrepattern+","+tyresize+"",
                	            
                        	            success: function (result) {
                        	            	
                        	             
                        	                 $('#tyreprice1').val(result);
                        	                
                        	            	var totalbaseprice=0.0;
                        	            	if(tyreprice=="" && result!=""){
                        	            	totalbaseprice=parseFloat(result)+ tyreprice;
                        	            	}
                        	            	else if(tyreprice!="" && result==""){
                        	            		totalbaseprice=result+ parseFloat(tyreprice);
                        	            	}
                        	            	else{
                        	            		totalbaseprice=parseFloat(result)+ parseFloat(tyreprice);
                        	            	}
                        	            	var cgst = totalbaseprice*14/100;
                        	            	var sgst = totalbaseprice*14/100;
                        	            	var gst=sgst+cgst;
                        	            	debugger;
                        	            	var totalprice=parseFloat(totalbaseprice)+parseFloat(gst);
                        	            	 var tot2 = Math.round(totalprice*100)/100;
                        	            	 debugger;
                        	            	 $('#discountshow').val(null);
                           	            	$("#c1").prop("checked", false);
                           	            	$("#c2").prop("checked", false);
                           	            	$("#c3").prop("checked", false);
                           	            	$("#c4").prop("checked", false);
                           	            	$("#c5").prop("checked", false);
                        	            
                         	            	$('#beforgst').val(totalbaseprice);
                         	            	$('#totalprice').val(tot2);
                         	            	$('#aftergst').val(tot2);
                         	            	$('#totalgst').val(Math.round(gst*100)/100);
                           	            	$('#sgst').val(Math.round(sgst*100)/100);
                           	            	$('#cgst').val(Math.round(cgst*100)/100);
                           	            	$('#taxble').val(totalbaseprice);
                        	            
                        	            	
                        	            },
                        	            error: function(e){
                        	            	
                        	            	
                        	            	console.log("error");
                        	            }
                        		 });
                        	})
                        	})
                    //tyreprice entry 
                    $(function(){
                    	$('#Quantity').on('change', function(){
                    		
                    		var  tyreprice = $('#tyreprice').val(); 
                    		var  tyreprice1 = $('#tyreprice1').val();
                    		var Quantity=$('#Quantity').val();
                    		
                    		if(Quantity==2){
								
              	            	var price=tyreprice*2;
              	
              	            	var cgst = price*14/100;
            	            	var sgst = price*14/100;
            	            	var gst=parseFloat(cgst)+parseFloat(sgst);
            	        
              	            	var totalprice=parseFloat(price)+parseFloat(gst);
              	            	 var tot = Math.round(totalprice*100)/100;
              	            	$('#discountshow').val(null);
              	            	$("#c1").prop("checked", false);
              	            	$("#c2").prop("checked", false);
              	            	$("#c3").prop("checked", false);
              	            	$("#c4").prop("checked", false);
              	            	$("#c5").prop("checked", false);
               	            	$('#aftergst').val(tot);
               	            	$('#totalprice').val(tot);
               	            	$('#beforgst').val(price);
               	            	$('#totalgst').val(Math.round(gst*100)/100);
               	            	$('#sgst').val(Math.round(sgst*100)/100);
               	            	$('#cgst').val(Math.round(cgst*100)/100);
               	            	$('#taxble').val(price);
               	            	$('#tyrepattern1').val(null);
               	            	$('#tyresize1').val(null);
               	            	$('#tyreprice1').val(null);
              	            	
                    		}
                    		else if(Quantity==1){
                    			
              	            	var price=tyreprice*1;
              	            	var cgst = price*14/100;
            	            	var sgst = price*14/100;
            	            	var gst=sgst+cgst;
              	            
              	            	var totalprice=price+gst;
              	            	 var tot1 = Math.round(totalprice*100)/100;
              	            	$('#discountshow').val(null);
              	            	$("#c1").prop("checked", false);
              	            	$("#c2").prop("checked", false);
              	            	$("#c3").prop("checked", false);
              	            	$("#c4").prop("checked", false);
              	            	$("#c5").prop("checked", false);
              	            	
               	            	$('#aftergst').val(tot1);
               	            	$('#beforgst').val(price);
               	            	$('#totalprice').val(tot1);
               	            	$('#totalgst').val(Math.round(gst*100)/100);
               	            	$('#sgst').val(Math.round(sgst*100)/100);
               	            	$('#cgst').val(Math.round(cgst*100)/100);
               	            	$('#taxble').val(price);
               	            	$('#tyrepattern1').val(null);
               	            	$('#tyresize1').val(null);
               	            	$('#tyreprice1').val(null);
                    		}
                    	})
                    	})
                    
                  
                    	
</script><div class="row">
<div class="col-md-2"></div>
<font color='red'> <span id="error"> </span> </font>
</div>
           <center>   <input type="submit"  class="btn btn-danger" value="submit"></center>
     
</form>
  
                   

</div>
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->


<script src="js\jquery.menu-aim.js"></script>
<script src="js\main.js"></script> <!-- Resource jQuery -->
<script>
/* Invoice Validation  */
function  checkinvoice(){ 
	if((document.getElementById('userId').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Choose UserName and Id";
	  invoice.userId.focus();
	  return(false);
	 }
	
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
	if((document.getElementById('tyrepattern').value=="non"))
	 {
		
		  document.getElementById('error').innerHTML = "please choose tyre Pattern";
		
		  return(false);
	}
	if((document.getElementById('tyresize').value=="undefined"))
	 {
		
		  document.getElementById('error').innerHTML = "please choose tyre size";
		 
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

  
  //calculate discount without gst in basic price 
  function total() {
	  var input = document.querySelectorAll("input[name='product']:checked") 
	  var quantity=document.getElementById('Quantity').value;
	  var tyreprice=document.getElementById('tyreprice').value;
	  var tyreprice1=document.getElementById('tyreprice1').value;
	  
	  if(quantity==2){
	  var taxble_amount= document.getElementById('beforgst').value -
	  ((input.length * (input.length =50*2))/1.28);
	  	document.getElementById('totalprice').value=total_gst(taxble_amount);
	 
	  	var descount = document.getElementById('aftergst').value - document.getElementById('totalprice').value;
	  	document.getElementById('discountshow').value=parseInt(descount);
	  }
	  else if(quantity==1 && tyreprice1 !=""){
		  var taxble_amount= document.getElementById('beforgst').value -
		  ((input.length * (input.length =50*2))/1.28);
			document.getElementById('totalprice').value=total_gst(taxble_amount);
			
			var descount = document.getElementById('aftergst').value - document.getElementById('totalprice').value;
		  	document.getElementById('discountshow').value=parseInt(descount);
	  }
	  else{
		  var taxble_amount= document.getElementById('beforgst').value -
		  ((input.length * (input.length =50))/1.28);
		  var total_price=total_gst(taxble_amount);
		 
		  document.getElementById('totalprice').value=total_gst(taxble_amount);
		  var descount = document.getElementById('aftergst').value - document.getElementById('totalprice').value;
		  	document.getElementById('discountshow').value=parseInt(descount);
	  }
	}
</script>
</body>
</html>