
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css\reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css\style.css"> <!-- Resource style -->
	<script src="js\modernizr.js"></script> <!-- Modernizr -->
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Tjtyre </title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	
    <script src="js\jquery-3.3.1.min.js"></script>

    <script src="js\popper.min.js"></script>

    <script src="js\bootstrap.min.js"></script>
    <script src="js\mdb.min.js"></script>
    <script src="js\jquery.menu-aim.js"></script>

    <script src="js\main.js"></script> <!-- Resource jQuery -->
	
	
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css\bootstrap.min.css" rel="stylesheet" />
    <link href="css\mdb.min.css" rel="stylesheet" />
    <link href="css\style1.css" rel="stylesheet" />
    <script src="js\bootstrap.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
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
                 background-color:#44a0c9;
                 text-align: center;
            }
            
            #header1 {
                 background-color:orange;
            }
            



            .table tr:nth-child(even) {
                background-color: lightblue;
            }
            .table tr:nth-child(odd) {
                background-color:white;
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



	.form-group{
    margin-top: 10px;
}
.tyre-quantity{
    display: none;
}
.submit-button{
		float:right;
		margin-right:0em;
	}
	</style>
	
	
	
</head>
<body>


	<header class="cd-main-header">
		
		
		<a href="#0" class="cd-nav-trigger"><span></span></a>

		

		<nav class="cd-nav">
			<ul class="cd-top-nav">
		
		<li >
					<p><a href="logout" style=" text-decoration: none;"><i class="w3-jumbo w3-spin fa fa-male  style=color:orange"></i>Logout</a></p>
</li>
	</header> 
</nav>

	<main class="cd-main-content">
	
		<nav class="cd-side-nav">
			
				<br>
					<ul>
					
					
					
					
					<li><a href="role" style=" text-decoration: none;">Role</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration"style=" text-decoration: none;">USER Registration</a></li>
					<li><a href="listtyre" style=" text-decoration: none;">Item</a></li>
					<li><a href="posstockquantity" style=" text-decoration: none;">Stock Transfer</a></li>
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>
						
					</ul>
				

				</nav>
			
				
		<div class="content-wrapper">
			<c:choose>
			<c:when test="${TYRE_HOME=='TYRE_REG' }">
        <form action="tyrecreate" method="post" enctype="multipart/form-data" name="tyrecreate" onsubmit="return salevalidate()"> 
        
         <div class="container"></div>

                <div class="card">
                    <div class="card-header" style="background-color:orange">

                        <font size="4px" color="white">
                            Tyre Entry
                        </font>

                    </div>
                    <div class="card-body">


                        <div class="cardpanel">
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">

							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyrepattern"> Pattern</label></b>
                                                <input type="text" class="form-control" id="tyrepattern" placeholder="Enter tyrepattern" name="tyrepattern" v-model="tyre_pattern">
                                            </div>
                                        </div>
							
							
							
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyresize"> Size</label></b>
                                                <input type="text" class="form-control" id="tyresize" placeholder="Enter tyresize" name="tyresize" v-model="tyre_size">
                                            </div>
                               </div>
                                <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyreprice"> Price</label></b>
                                                <input type="text" class="form-control" id="price" placeholder="Enter tyreprice" name="price" v-model="price" onkeypress="return validateFloatKeyPress(this,event);">
                                            </div>
                                </div>

                               </div>
								<div class="row">
                     		   </div>
                   			 </div>
            			    </div>
          				  </div>
           			 <div class="row">
            	    <div class="col-md-4"></div>
                 	<div class="col-md-4"></div>
               		 <div class="col-md-4">
                    <input type="submit" v-on:click="Save" class="btn btn-primary submit-button" value="Submit">
              	  </div>
          		  </div>
            </form>
		</c:when>
		<c:when test="${updatemode=='UPDATE_MODE' }">
			<form action="updateprocess" method="post" enctype="multipart/form-data" name="salestransaction" onsubmit="return salevalidate()">
            <br>
            <br>
            <div class="container">

                <div class="card">
                    <div class="card-header" style="background-color:orange">

                        <font size="4px" color="white">
                            Tyre Update
                        </font>

                    </div>
                    <div class="card-body">


                        <div class="cardpanel">
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">

							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyrepattern">Pattern</label></b>
                                                <input type="text" class="form-control" id="tyrepattern" name="tyrepattern" placeholder="Enter tyrepattern" readonly="readonly" value="${update.tyrepattern}" v-model="tyre_pattern">
                                            </div>
                                        </div>
							
							
							
							 <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyresize">Size</label></b>
                                                <input type="text" class="form-control" id="tyresize" name="tyresize" value="${update.tyresize}" placeholder="Enter tyresize" readonly="readonly" value  v-model="tyre_size">
                                            </div>
                                        </div>

                                <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="tyreprice">Price</label></b>
                                                <input type="text" class="form-control" id="price" placeholder="Enter tyreprice" value="${update.price }" name="price" v-model="tyreprice" onkeypress="return validateFloatKeyPress(this,event);">
                                            </div>
                                        </div>

                                      </div>
									  <div class="row">
  
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <input type="submit" class="btn btn-primary  submit-button" value="update">
                </div>
            </div>
	</div>
		</form>
		</c:when>
		</c:choose>
		</div> <!-- .content-wrapper -->
	</main> <!-- .cd-main-content -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js\jquery.menu-aim.js"></script>
<script src="js\main.js"></script> <!-- Resource jQuery -->

     <script type="Text/JavaScript">
   	
function  salevalidate(){
	var pattern=document.getElementById('tyrepattern').value;
	var size=document.getElementById('tyresize').value;
	var sizecheck=size.indexOf("/");
	var patterncheck=pattern.indexOf("/");
	if((document.getElementById('tyrepattern').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Tyre Pattern";
	  tyrecreate.tyrepattern.focus();
	  return(false);
	 }
	if(patterncheck>0)
	 {
	  document.getElementById('error').innerHTML = "don't use slash (/)symbol";
	  tyrecreate.tyrepattern.focus();
	  return(false);
	 }
	if(sizecheck>0)
	 {
	  document.getElementById('error').innerHTML = "don't use slash (/)symbol";
	  tyrecreate.tyresize.focus();
	  return(false);
	 }
	if((document.getElementById('tyresize').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter Tyre Size";
	  tyrecreate.tyresize.focus();
	  return(false);
	 }
	if((document.getElementById('Cgst').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter CGST";
	  tyrecreate.Cgst.focus();
	  return(false);
	 }
	if((document.getElementById('Sgst').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter SGST";
	  tyrecreate.Sgst.focus();
	  return(false);
	 }
	if((document.getElementById('igst').value==""))
	 {
	  document.getElementById('error').innerHTML = "Please Enter IGST";
	  tyrecreate.igst.focus();
	  return(false);
	 }
	else 
	{
		 return(true);
	 }
	
}


  
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





</body>
</html>