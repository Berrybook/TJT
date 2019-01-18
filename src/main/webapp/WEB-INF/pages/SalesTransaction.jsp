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
	<title>Invoice Generation</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<style>
	 .link {
	text-decoration: none;
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
#link1 {
  text-decoration: none;
}
        
	</style>
	
	
</head>

<body>


	<header class="cd-main-header">
		
		
		<a href="#0" class="cd-nav-trigger"><span></span></a>

		

		<nav class="cd-nav">
			<ul class="cd-top-nav">
		
		<li >
					<p><a href="logout"style=" text-decoration: none;"><i class="w3-jumbo w3-spin fa fa-male"></i>Logout</a></p>
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
 <form action="saletransaction" method="post" enctype="multipart/form-data" name="salestransaction"  onsubmit="return salevalidate()">


<div class="container">
 
    <div class="card">
      <div class="card-header">
   
      <font size="5px" color="white">
         Transaction Information
        </font>
      
      </div>
      <div class="card-body">
         

<div class="cardpanel">
           <font color='red'> <span id="error"> </span> </font>
               <div class="row">

                            <div class="col-md-3">
                     <div class="form-group">
                          <b><label for="salespersonid">Sales Person</label></b>
                            <select class="form-control" name="userid" id="userid">
                                <c:forEach var="salesid" items="${salesidlist}">
  <option value="${salesid.userid}">${salesid.userid}(${salesid.userName})</option>
   </c:forEach>
                            </select>


                        </div>

                     </div>
                          
   <div class="col-md-3">
                                <div class="form-group">
                                    <b><label for="receivername">Receiver Name</label></b>
                                    <select class="form-control" id="receiver_name" name="receiver_name" >
                                      <c:forEach var="salesid" items="${salesidlist}">
  									<option value="${salesid.userid}">${salesid.userid}(${salesid.userName})</option>
  									 </c:forEach>
                                   
                                    </select>


                                </div>

                            </div>
 <div class="col-md-3">
                                <div class="form-group">
                                    <b><label for="date">Date</label></b>
                                    <input type="date" class="form-control"  data-date-format="YYYY MM DD"  placeholder="Enter Date"  id="date" name="date" value="${date }">
                                </div>
                                </div>
                           
                           



                        </div>


                        <div class="row">
                         <div class="col-md-3">
                                <div class="form-group">
                                    <b><label for="Amount">Amount</label></b>
                                    <input type="text" class="form-control" placeholder="Enter Amount" id="amount" name="amount" value="${amount }" onkeypress="return validateFloatKeyPress(this,event);">

                                </div>

                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <b><label for="paymentmode">Payment Mode</label></b>
                                    <select class="form-control" name="payment_mode" >
                                        <option>Cash</option>
                                        <option>Cheque</option>
                                        <option>Draft</option>
                                    </select>


                                </div>

                            </div>





                         
                            <div class="col-md-3">
                                <div class="form-group">

                                    <b>Attachment file: <input type="file" name="file_upload"  value="${file_upload}"></b>


                                </div>
                            </div>

                        </div>




  

                   
               
                    
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

<input type="submit"  class="btn btn-primary" value="Submit" ></div>

<div class="col-md-4"></div>
   </div> 
<script type="Text/JavaScript">

function salevalidate(){
	
	if((document.getElementById('date').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Choose a date";
	  salestransaction.date.focus();
	  return(false);
	 }
	if((document.getElementById('amount').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Amount to transfered";
	  salestransaction.amount.focus();
	  return(false);
	 }
	if(document.getElementById('salesmanid').value==document.getElementById('receiver_name').value)
	 {
	  document.getElementById('error').innerHTML = "Sales Person Name and Receiver Name could not same";
	  salestransaction.salesmanid.focus();
	  return(false);
	 }

	
	else
	{
		 return(true);
	 }
	
}
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


<script type="text/javascript">
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

    
    </script>


    </form>
    
  
                   

</div>
 
		<!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>