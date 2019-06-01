
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
			
				<br>
					<ul>
					<li><a href="requestOrder?access=Create Order" style=" text-decoration: none;">Create Order</a></li>
					<li><a href="viewOrderLink" style=" text-decoration: none;">View  Order</a></li>
					
					</ul>
					</nav>
				 <div class="content-wrapper">
				   <div class="container"> 
			
           
            <br>
            <br>
<form action="createOrder" method="post">
                 
					 <div class="card-header" style="background-color:lightblue">
                             <font size="5px" color="white">
                              Request Order
                                </font>
                            </div>
                   
  

                       
                        
							 
                            <div class="row">
							
								
										
						
								   
								  
									
							 <div class="col-md-3">
                                            <div class="form-group">
                                                 <%-- <b><label for="raisedby">Raised By</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="raised_By"  id="raisedby" >
                                               <option value="">Raised By</option>
                                               <c:forEach var="alldealer" items="${allDealer }">
                                               <option value="${alldealer.dealer_Mail_Id }">${alldealer.dealer_Mail_Id }/${alldealer.dealer_Name }</option>
                                               </c:forEach>
                                               
                                                </select>
                                            </div> --%>
                                            
                                            <b><label for="raisedby">Raised By</label></b>
                   				       	  <input type='text' style='width:150px;' name='raised_By' value='${posname }' readonly />
                                            </div>
                                        </div>
                                         <div class="col-md-3">
                                            <div class="form-group">
                                            
                                        <b><label for="date">current Date</label></b>
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
                   				       	 <select class="form-control" class="form-control chosen-select"  name="priority"  id="orderpriority" >
                                               <option value="">select Priority</option>
                                               <option value="lower">lower</option>
                                               <option value="medium">medium </option>
                                               <option value="high">high </option>
                                                </select>
                 					    </div>
										
										
										
										</div>
							
							</div>
							
							<div class="row">
								
							<div class="col-md-6">
							<div class="form-group">
                                                 <b><label for="raisedby">Raised For Dealer</label></b>
                   				       	  <select class="form-control" class="form-control chosen-select"  name="dealer_id"  id="dealer_id" >
                                               <option value="">Choose Dealer</option>
                                               <c:forEach var="alldealer" items="${allDealer }">
                                               <option value="${alldealer.dealer_Mail_Id }">${alldealer.dealer_Mail_Id }/${alldealer.dealer_Name }</option>
                                               </c:forEach>
                                               
                                                </select>
                                            </div>
							</div>	
							<div class="col-md-6">
							
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
   <td><input type='text' style='width:150px;' name='pattern' value='${items.tyrepattern }' readonly /></td>
  <td><input type='text' style='width:150px;' name='size' value='${items.tyresize }' readonly /></td>
  <td><input type='text' style='width:150px;' name='quantity' /></td>
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
				
				
				
				 
					
				
				
				
				
				</div>
			 	</div>

		
		
		
	</main> <!-- .cd-main-content -->
	<script>
$(function() {
  
  $("form[name='requisitionorder']").validate({
   
    rules: {
      
      sourceid: "required",
	  role:"required",
      raisedby: "required",
	  expecteddate: "required",
	  tyrepattern: "required",
	  tyresize: "required",
	 quantity: "required",
	  orderpriority: "required",
	 
     
	  
    },
   
    messages: {
       sourceid: "Please enter your  sourceid",
	   role: "Please enter  role",
	    raisedby: "Please enter your raisedby",
		 expecteddate: "Please enter expecteddate",
		  tyrepattern: "Please enter your tyrepattern",
		  tyresize: "Please enter your tyresize",
		    vehicleno: "Please enter your vehicleno",
			 quantity: "Please enter your quantity",
			  orderpriority: "Please enter orderpriority",
			   
      
     
      
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


</body>
</html>