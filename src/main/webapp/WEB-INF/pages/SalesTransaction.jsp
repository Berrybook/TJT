<!DOCTYPE>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>Transaction Information</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>    
	<style>
	#userid,#receiver_name,#date,#payment_mode
{

  background-color : #d1d1d1; 

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
						
					</ul>
				

				</nav>
			
				
		<div class="content-wrapper">
		
            <br><br>
 <form action="saletransaction" method="post" enctype="multipart/form-data" name="salestransaction"  onsubmit="return saletransactionvalidate()">


<div class="container">
 
   
      <div class="card-header" style="background-color:lightblue">
                              <font size="5px" color="white">
                                   Transaction Information
                                </font>
                            </div>
      
           <font color='red'> <span id="error"> </span> </font>
               <div class="row">

                            <div class="col-md-4">
                     <div class="form-group">
                          <b><label for="salespersonid">Sales Person</label></b>
                            <select class="form-control" name="userid" id="userid">
                                <c:forEach var="salesid" items="${salesidlist}">
  <option value="${salesid.userid}">${salesid.userid}(${salesid.userName})</option>
   </c:forEach>
                            </select>


                        </div>

                     </div>
                          
   <div class="col-md-4">
                                <div class="form-group">
                                    <b><label for="receivername">Receiver Name</label></b>
                                    <select class="form-control" id="receiver_name" name="receiver_name" >
                                      <c:forEach var="salesid" items="${salesidlist}">
  									<option value="${salesid.userid}">${salesid.userid}(${salesid.userName})</option>
  									 </c:forEach>
                                   
                                    </select>


                                </div>

                            </div>
 <div class="col-md-4">
                                <div class="form-group">
                                    <b><label for="date">Date</label></b>
                                    <input type="date" class="form-control"  data-date-format="YYYY MM DD"  placeholder="Enter Date"  id="date" name="date" value="${date }">
                                </div>
                                </div>
                           
                           



                        </div>


                        <div class="row">
                         <div class="col-md-4">
                                <div class="form-group">
                                    <b><label for="Amount">Amount</label></b>
                                    <input type="text" class="form-control" placeholder="Enter Amount" id="amount" name="amount" value="${amount }" onkeypress="return validateFloatKeyPress(this,event);">

                                </div>

                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <b><label for="paymentmode">Payment Mode</label></b>
                                    <select class="form-control" name="payment_mode" id="payment_mode" >
                                        <option>Cash</option>
                                        <option>Cheque</option>
                                        <option>Draft</option>
                                    </select>


                                </div>

                            </div>





                         
                            <div class="col-md-4">
                                <div class="form-group">

                                    <b>Attachment file: <input type="file" name="file_upload"  value="${file_upload}"></b>


                                </div>
                            </div>

                        </div>

        
                    
         
</div>
<!--  &nbsp &nbsp  &nbsp &nbsp &nbsp  &nbsp &nbsp <a href="#" class="previous">&laquo; Previous</a>
 -->
 
 <br>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4">

<input type="submit"  class="btn btn-danger" value="Submit" ></div>

<div class="col-md-4"></div>
   </div> 
   
<!-- current date  -->
<script type="Text/JavaScript">
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
document.getElementById("date").value  = today;

</script>

<!-- <script type="text/javascript">
    function validateFloatKeyPress(el, evt) {
        var charCode = (evt.which) ? evt.which : event.keyCode;
        var number = el.value.split('.');
        if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
            return false;
        }
        //just one dot
        if(number.length>1 && charCode == 46){
             return false;
        }
        //get the carat position
        var caratPos = getSelectionStart(el);
        var dotPos = el.value.indexOf(".");
        if( caratPos > dotPos && dotPos>-1 && (number[1].length > 1)){
            return false;
        }
        return true;
    }


    function getSelectionStart(o) {
    	if (o.createTextRange) {
    		var r = document.selection.createRange().duplicate()
    		r.moveEnd('character', o.value.length)
    		if (r.text == '') return o.value.length
    		return o.value.lastIndexOf(r.text)
    	} else return o.selectionStart
    }

    
    </script> -->


    </form>
    
  
                   

</div>
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
</body>
</html>