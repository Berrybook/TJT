<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css\reset.css"> 
	<link rel="stylesheet" href="css\style.css">
	<link rel="stylesheet" href="css\table.css">
	<script src="js\modernizr.js"></script> 
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Role</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>    



<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


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
		margin-right:1.3em;
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
					
					
					
					
						
				<li><a href="createcity" style=" text-decoration: none;">City Registration</a></li>				
				<li><a href="role" style=" text-decoration: none;">Role</a></li>
					<li><a href="Posbyall" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userAll"style=" text-decoration: none;">USER Registration</a></li>
					<li><a href="listtyre" style=" text-decoration: none;">Item</a></li>
				<!-- 	<li><a href="posstockquantity" style=" text-decoration: none;">Stock Transfer</a></li> -->
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>		
					
					</ul>
				

				</nav>
			
			<form action="posstockquantity" method="post">		
		<div class="content-wrapper">
			
		
	 <div id="StockMaster">
        
            
                   
                </div>
           
            <br>
            <br>

            <div class="container">

                <div class="card">
                    <div class="card-header" style="background-color:orange">

                        <font size="4px" color="white">
                           Stock Transfer
                        </font>

                    </div>
                    <div class="card-body">


                        <div class="cardpanel">
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">
							<div class="col-md-3">
                           	 <div class="form-group">
                           		 <b><label for="Item">Pos </label></b>
                           			 <select class="form-control" id="pos" name="pos" v-model="tyre_id">
                          				 <c:forEach  var="posid" items="${posid}">
                          					 <option value="${posid.pos}"> ${posid.pos}</option>
                          				  </c:forEach>
  								 	</select>
                           	 </div>
                            </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <b><label for="Item">Pattern</label></b>
                                        <select class="form-control tyrepattern" id="tyrepattern"  name="tyrepattern" >
                          				 <c:forEach  var="tyreid" items="${tyreid}">
                          					 <option value="${tyreid.tyrepattern}"> ${tyreid.tyrepattern}</option>
                          				  </c:forEach>
  								 	</select>
                                    </div>
                              </div>
							 <div class="col-md-3">
							  <div class="form-group">
                                        <b><label for="Item">Size</label></b>
                                        <select class="form-control" id="pos" name="tyresize" >
                          				 <c:forEach  var="tyreid" items="${tyreid}">
                          					 <option value="${tyreid.tyresize}"> ${tyreid.tyresize}</option>
                          				  </c:forEach>
  								 	</select>
  								 	 <%--<select class ="form-control tyresize" class="form-control chosen-select " id="tyresize" name="tyresize">
                                	<option value="">select tyresize</option>
                                	</select>--%>
                                    </div>
							 
							 </div>
							 
							  <div class="col-md-2">
							   <div class="form-group">
                                        <b><label for="Item">Quantity</label></b>
                                       
                                                <input type="text" class="form-control" id="tyrepattern" placeholder="quantity" name="quantity" >
                                            </div>
											
											
                                    </div>
							  
							  <div class="col-md-1">
							  
							   
	  
	  <!--<button class="add material-icons" id="adds" style="margin-top:34px">add</button>-->
	  <input type="button" class="add material-icons" style="margin-top:43px" value="add">

	
							  
							  
							  </div>
							 </div>
							  <div id="tes">
                               </div>
							 
							 
							 
							 
							 
							</div>
                             </div>
                        </div>
                    </div>
                </div>
               	 <div class="row">
              	  <div class="col-md-4"></div>
              	  <div class="col-md-4">
              	  </div>
                <div class="col-md-4 " style="padding-right:8px;">
                <input type="submit" v-on:click="Save" class="btn btn-primary submit-button" value="TRANSFER">
                </div>
            </div>
                 
            </div>
            <br>
			 </form>
		</div> <!-- .content-wrapper -->
		
	</main> <!-- .cd-main-content -->
	<script>
$(function(){
    $('.add').click(function(){
        $("#tes").append('<br>'
        		+'<div class="row mypatterntyre">'
        			+'<div class="col-md-3"></div><br>'
        		 	+'<div class="col-md-3">'
        		 		+'<div class="form-group">'
        		 			+'<select class="form-control tyrepattern" name="tyrepattern" >'+
                          	' <c:forEach  var="tyreid" items="${tyreid}">'+
                          	'<option value="${tyreid.tyrepattern}"> ${tyreid.tyrepattern}</option>'+
                          	' </c:forEach>'+
  							'</select></div></div><br> '
  							
  					    +'<div class="col-md-3"><div class="form-group">'
  					    	+'<select class="form-control tyreSize" name="tyresize" >'+
                          	' <c:forEach  var="tyreid" items="${tyreid}">'+
                          	'<option value="${tyreid.tyresize}"> ${tyreid.tyresize}</option>'+
                          	' </c:forEach>'+
  							'</select>'+
						'</div></div><br>  <div class="col-md-2"><div class="form-group"><input type="text" placeholder="quantity" name="quantity" class="form-control"></div></div></div>');
        
    });
});
</script>
<script >
$(function(){
	$('#tyrepattern').on('click', function(){
		debugger;
		var tyrepattern = $('.tyrepattern').val();
		debugger;
		 $.ajax({
	            type: "GET",
	            contentType: "application/json; charset=utf-8",
	         	  datatype: "json",
	            url: "${pageContext.request.contextPath}/tyresize/"+tyrepattern+"",
	            success: function (response) {
	                 var tyresize="";
	                 debugger;
	                 if(tyrepattern=='non'){
	                	 tyresize+="<option value="+response[i]+">Select TyreSize</option>"
	                	 $('#tyresize').empty();
	                	 $('#tyresize').html(tyresize);
	                	
	                 }
	                 else{
	                 tyresize+="<option value="+response[i]+">Select TyreSize</option>"
	                  for(var i=0;i<response.length;i++){ 
	                	 
	                	 tyresize+="<option value="+response[i]+">"+response[i]+"</option>"
	                	 $('.tyresize').html(tyresize);
	                	 debugger;
	                }
	                 debugger; 
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
</script>


    
</body>
</html>