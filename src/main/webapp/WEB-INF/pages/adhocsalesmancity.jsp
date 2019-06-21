<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!DOCTYPE> 
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<title>Adhoc SalesMan</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="js\Ajax.js"> </script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
     
	<script>
$(document).ready(function(){
$("#choice").change(function(){
  $(".table tbody tr").hide();
  $(".table tbody tr."+$(this).val()).show('fast');
});

//this JS calls the tablesorter plugin that we already use on our site
$("#table").tablesorter( {sortList: [[0,0]]} );

}); 
</script>
	
<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	

	 @media only screen and (max-width: 479px) {
#search{
position:absolute;
bottom:10px;


}
} 

 @media only screen and (min-width:760px) and (max-width: 1024px) {
 #search{
position:absolute;

top:40%;

}
} 
 @media only screen and (min-width:876px) and (max-width: 1440px) {
 #search{
position:absolute;

top:40%;

}
} 
@media only screen and (min-width:768px) and (max-width: 1024px) {
 #search{
position:absolute;



}
} 
@media only screen and (min-width:360px) and (max-width: 640px) {
 .table{
position:absolute;
top:62%;
left:10%;


}
} 

@media only screen and (min-width:411px) and (max-width: 731px) {
 .table{
position:absolute;
top:4%;
left:10%;


}
} 
@media only screen and (min-width:375px) and (max-width: 812px) {
 .table{
position:absolute;
top:40%;
left:10%;


}
} 
@media only screen and (min-width:360px) and (max-width: 640px) {
 .table{
position:absolute;
top:62%;
left:10%;


}
} 
@media only screen and (min-width:360px) and (max-width: 640px) {
 .table{
position:absolute;
top:62%;
left:10%;


}
} 
@media only screen and (min-width:360px) and (max-width: 640px) {
 .table{
position:absolute;
top:62%;
left:10%;


}
} 
@media only screen and (min-width:768px) and (max-width: 1024px) {
 .table{
position:absolute;
top:40%;
left:21%;


}
} 
@media only screen and (min-width:1024px) and (max-width: 1366px) {
 .table{
position:absolute;
top:40%;
left:17%;


}
} 
@media only screen and (min-width:1030px) and (max-width: 1366px) {
 .table{
position:absolute;
top:45%;
left:21%;


}
} 

@media only screen and (min-width:768px) and (max-width: 1024px) {
 .cd-side-nav{
position:absolute;
top:-1%;



}
} 

	</style>
</head>
<body>
<form action="salesmanByCitydemo" method="get">
    <div id="RoleRegistration">
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
					
					
					
					<li><a href="createcity" style=" text-decoration: none;">City Registration</a></li>
					<li><a href="role" style=" text-decoration: none;">Role Registration</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration"style=" text-decoration: none;">User Registration</a></li>
					<li><a href="tyrecreate" style=" text-decoration: none;">Item Registration</a></li>
					<li><a href="item_price_assign" style=" text-decoration: none;">Price Assignment</a></li>
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>	
					<li><a href="demoadhoc" style=" text-decoration: none;">Adhoc Salesman Assign</a></li>	
					<li><a href="customerenquiry" style=" text-decoration: none;" >Customer Inquiries</a></li>
					</ul>
				

				</nav>
          
            <c:if test="${not empty price_assignment}"><script>popup('${price_assignment}') </script></c:if>
             
            <div class="content-wrapper">
            <div class="container">
              
                    <br>
                    <br>
                    
                        <div class="card-header" style="background-color:lightblue; width:100%">
                              <font size="5px" color="white">
                               Adhoc SalesMan
                                </font>
                            </div>
                                    <div class="row">
                                        <div class="col-md-3">
                                         
										 <div class="form-group">
										 
										<b><label for="paymentmode">City</label></b>
   								<select class="form-control" name="cityname" id="cityname">
                           		 <option value="">select city</option>
                             		      <c:forEach var="city" items="${listpos}">
										<option value="${city.cityname}">${city.cityname}</option>
									</c:forEach>
                            	</select>
                            	<br>
                            	
                            	 
                            	
                                        </div>
                                        </div>
										
                                        <div class="col-md-3">
                       <div class="form-group">
                    <input type="Submit" id="search" value="Search" name="Search">

</div>
										
										<div class="col-md-4"></div>
                                    
                                        </div>
                                  
                               
<table  border="1" class="table" style="width:70%;" >
		
<tr  id="heder">
<th ><b>ID</b></th>
<th ><b>User Name</b></th>
<th ><b>POS</b></th>
<th ><b>Assign</b></th>
</tr>
<c:forEach var="listadhoc" items="${listadhoc}">
<tr style="color:black;text-align: center;">
<td>${listadhoc.userid}</td>
<td>${listadhoc.username}</td>
<td>${listadhoc.pos}</td>
<td><a href="salesmanByIddemo?id=${listadhoc.userid}"><input type="button" value="Assign" class="btn btn-danger"></a></td>
</tr>
</c:forEach>

</table>
        
      </div>
    </div>
  </div>











										           </div>   
            </div><!-- .content-wrapper -->
              
        </main> <!-- .cd-main-content -->
    </div>
</form>
  <!--   <script>
	
	
	$(document).ready(function () {  
   $('form1').validate( {debug: true} );
   $("form1").css({ 'color': 'red' });
   });
    
  $(function () {
	$('#cityname').on('change',function(){
		$("#item_table tbody tr").remove();
		var cityname= $('#cityname').val();
	
		$.ajax({
			type: "GET",
            contentType: "application/json; charset=utf-8",
         	 datatype: "json",
            url: "${pageContext.request.contextPath}/salesmanByCity	/"+cityname+"",
            success:function(data){
            	var itemdata='';
            
            	$.each(data,function(index, value) {
            		
            		 itemdata +='<tbody> <tr style="color: white">',
            		 itemdata +="<td ><input type='text' style='width:150px;' name='userid' value='"+value.userid+"' readonly /></td>",
            		 itemdata +="<td><input type='text' style='width:150px;' name='username' value='"+value.username+"' readonly /></td>",
            		 itemdata +="<td ><input type='text' style='width:150px;' name='pos' value='"+value.pos+"' readonly /></td>",
            		itemdata +="<td><a href=salesmanById?id=akash><input type='button' value='Assign' class='btn btn-danger'></td>",
            		
            	
            		 itemdata +=" </tr></tbody>"
            		 
            	});
            	$('#item_table').append(itemdata);
            
            },
            error:function(e){
            	
            	console.log("error");
            }
            	
		});
	}) 
	})
   
    	
    </script> -->
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