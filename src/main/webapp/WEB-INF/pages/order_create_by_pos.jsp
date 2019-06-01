
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	 <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css\reset.css"> 
	<link rel="stylesheet" href="css\style.css">
	<link rel="stylesheet" href="css\style1.css">
	<link rel="stylesheet" href="css\table.css">
	<script src="js\modernizr.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Request Order</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
   <script src="js\validation.js"></script> 
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> 
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>    
         
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<script src="js\jquery.validate.js"></script>
	<script src="js\jquery.validate.min.js"></script>  
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$(document).ready(function(){
    $('.add').click(function(){
        $("#tes").append('<div class="row"><div class="col-md-3"> <div class="form-group"><b><label for="pattern">pattern</label></b><select class="form-control"  name="LIVINGSTYLE" id="test">'+
                          '<option value="1">Option 1</option>'+
                          '<option value="2">Option 2</option>'+
                          '<option value="3">Option 3</option>'+
                          '<option value="4">Option 4</option>'+
                        '</select></div></div> <div class="col-md-3"><div class="form-group"><b><label for="pattern">size</label></b><select class="form-control" name="LIVINGSTYLE" id="test">'+
                          '<option value="1">Option 1</option>'+
                          '<option value="2">Option 2</option>'+
                          '<option value="3">Option 3</option>'+
                          '<option value="4">Option 4</option>'+
                        '</select></div></div><div class="col-md-3"><div class="form-group"><b><label for="pattern">Quantity</label></b><input type="text" class="form-control"></div></div><div class="col-md-3"><div class="remCF"><button>Remove</button></a></div></div></div>');
    });

	
 $("#tes").on('click','.remCF',function(){
        $(this).parent().parent().remove();
    });

 
});

</script>
<script type="text/javascript">
function successMessage(msg) {

	swal(msg, " ", "success")
}
</script>

         
     <style>
	  .error {
    color: #ff0000;;
  }
  #errmsg
{
color: red;
}

.remCF{
position:absolute;
top:40px;
}
</style>	
</head>
<body>

<div id="content">
</div>

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
			<c:choose>
										<c:when test="${not empty msg}">
											<script>
												successMessage("${msg}")
											</script>
										</c:when>
									</c:choose>
			
				<br>
					<ul>
					<li><a href="createinvoice" style=" text-decoration: none;">New Invoice</a></li>
						<li><a href="saletransaction" style=" text-decoration: none;">Sales Transaction</a></li>
						<li><a href="priceListByPos" style=" text-decoration: none;">PriceList</a></li>
						<li><a href="CurrentMonthsalesReport" style=" text-decoration: none;">Month Report</a></li>
						<li><a href="requestOrderbypos?access=Create Order" style=" text-decoration: none;">Create Order</a></li>
						<li><a href="CustomerInquaryForm" style=" text-decoration: none;">Inquiry Form</a></li>
						<!-- <li><a href="viewOrder?access=View Order" style=" text-decoration: none;">view Order</a></li> -->
						
					</ul>
					</nav>
				 <div class="content-wrapper">
				   <div class="container"> 
			
           
            <br>
            <br>
<form action="createOrderByPOS" method="post" name="createorderbypos" id="createorderbypos">
                 
					 <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                              Request Order
                                </font>
                            </div>
                   
  

                       
                        
							 
                            <div class="row">
							
								
										
						
								   
								  
									
							 <div class="col-md-3">
                                            <div class="form-group">
                                                 <b><label for="raisedby">Raised By</label></b>
                   				       	  <input type='text' style='width:150px;' name='raised_By' id="raised_By" value='${posname }' readonly />
                                            </div>
                                        </div>
                                         <div class="col-md-3">
                                            <div class="form-group">
                                            
                                        <b><label for="date">Current Date</label></b>
                                    <input type="date" class="form-control"  data-date-format="YYYY MM DD"  placeholder="Enter Date" id="requisation_Date" name="requisation_Date" value="">
                                            </div>
										</div>
										
										
										 <div class="col-md-3">
                                            <div class="form-group">
                                               <b><label for="date">Expected Date</label></b>
                                    <input type="date" class="form-control"  data-date-format="YYYY MM DD"  placeholder="Enter Date" id="expected_Date" name="expected_Date" value="">
                                            </div>
                                        </div>
										<div class="col-md-3">
										
										<div class="form-group">
                        				  <b><label for="orderpriority">Order Priority</label></b>
                   				       	 <select class="form-control" class="form-control chosen-select"  name="orderpriority"  id="orderpriority" >
                                               <option value="">select Priority</option>
                                               <option value="lower">lower</option>
                                               <option value="medium">medium </option>
                                               <option value="high">high </option>
                                                </select>
                 					    </div>
										
										
										
										</div>
							
							</div>
							<table class="table" id="item_table"  >

    <tr >
      <th>Pattern</th>
      <th>Size</th>
      <th>Quantity</th>
    </tr>
   <c:forEach var="items" items="${tyres }">
   <tr>
   <td><input type='text' style='width:150px;' name='pattern' id="pattern" value='${items.tyrepattern }' readonly /></td>
  <td><input type='text' style='width:150px;' name='size' id="size" value='${items.tyresize }' readonly /></td>
  <td><input type='text' style='width:150px;' name="quantity" id="quantity" /></td>
   </tr>
   
   </c:forEach>
 
</table>
                                         
                                      <div class="row">
									 
                  					
									 <div class="col-md-4">
                 						    
                  					 </div>
									 
									 <div class="col-md-1">
									
									 
									 </div>
									  <div class="col-md-2">
									  
									  
									  </div>
					
										</div>
										
                                     
             
 
    <div id="tes">




</div>
	

     
              
			  
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-2"></div>
                <div class="col-md-2"><input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Place Order"> </div>
                <div class="col-md-2">
                   </div>
                   
                   <div class="col-md-2"></div>
            </div>
			 	</form>
				
				 <table class="table">
                        <thead>
                            <tr>
                                <th>Order id</th>
                                <th>Requisation Date</th>
							<!-- 	<th>Dealer id</th> -->
								<th>Approver</th>
								<th>Status</th>
                                <th>Pattern</th>
								<th>Size</th>
								<th>Quantity</th>
								
								<th>Edit</th>
								
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="order" items="${orderdetails}">
							<tr>
							<td>${order.order_id}</td>
							<td>${order.requisation_Date}</td>
							<%-- <td>${order.dealer_id}</td> --%>
							<td>${order.approver}</td>
							<td>${order.status}</td>
							<td><c:forEach items="${order.pattern }" var="pattern">
							<option>${pattern}</option>
							</c:forEach></td>
							<td><c:forEach items="${order.size }" var="size">
							<option>${size}</option>
							</c:forEach></td>
							<td><c:forEach items="${order.quantity }" var="quantity">
							<option>${quantity}</option>
							</c:forEach></td>
							<td><a href="#"><i class="fa fa-edit"></i></a></td>
							
							</tr>
							</c:forEach>
                            </tbody>
                       
                    </table>			   
				
				 
					
				
				
				
				
				</div>
			 	</div>

		
		
		
	</main> <!-- .cd-main-content -->
	<script>
$(function() {
  
  $("form[name='createorderbypos']").validate({
   
    rules: {
      
      raised_By: "required",
	  requisation_Date:"required",
      expected_Date: "required",
	  orderpriority: "required",
	  pattern: "required",
	  size: "required",
	 
	  
    },
   
    messages: {
      raised_By: "Please enter raised_By",
	   requisation_Date: "Please enter  requisation_Date",
	    expected_Date: "Please enter expected_Date",
		 orderpriority: "Please enter orderpriority",
		  pattern: "Please enter pattern",
		   size: "Please enter size",
		   
      
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
  $("#quantity").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg").html("Digits Only").show().fadeOut("slow");
               return false;      
    }
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
document.getElementById('requisation_Date').value  = today;



</script>

</body>
</html>