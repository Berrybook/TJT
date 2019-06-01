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
	<title>Price Assignment</title>
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
	.form-control{
	background-color:lightgray;
	
	}
	
	
	
	</style>
	<style>


</style>
</head>

<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>



<body>
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
               <div id="MainMenu">
        <div class="list-group panel">
         
         
          <a href="#demo3" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Registration<i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i></a>
          <div class="collapse" id="demo3">
          <a href="create_Dealer" class="list-group-item">Dealer Registration</a>
            <a href="createcity" class="list-group-item">City Registration</a>
            <a href="role" class="list-group-item">Role Registration</a>
            <a href="Poscreate" class="list-group-item">POS Registration</a>
			<a href="userregistration" class="list-group-item">User Registration</a>
			<a href="" class="list-group-item">Warehouse Registration</a>
			<a href="tyrecreate" class="list-group-item">Item Registration</a>
			<a href="createroleaccess" class="list-group-item">Resource Role Access</a>
          </div>
          <a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Pevilleges Assign <i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i> </a>
          <div class="collapse" id="demo4">
            <a href="warehouseMasterLink" class="list-group-item">Warehouse Assign</a>
         <!-- <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a>--> 
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		    <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
        <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Customer Inquiries</a>
        
        </div>
      </div>
                
        
              
              
                        </nav>
            <c:if test="${not empty price_assignment}"><script>popup('${price_assignment}') </script></c:if>
            <form action="priceAssignment" method="POST"> 
            <div class="content-wrapper">
            <div class="container">
              
                    <br>
                    <br>
                        <div class="card-header" style="background-color:lightblue; width:100%">
                              <font size="5px" color="white">
                               Pricing
                                </font>
                            </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                         
										 <div class="form-group">
										<b><label for="paymentmode">City</label></b>
   								<select class="form-control" name="cityname" id="cityname">
                           		 <option value="">select city</option>
                             		    <c:forEach var="city" items="${allCity}">
  											<option value="${city.cityname}">${city.cityname}</option>
 						  				</c:forEach>
                            	</select>
                                        </div>
                                        </div>
                                        <div class="col-md-4"></div>
										
										<div class="col-md-4"></div>
                                    
                                        </div>
                                   
                                <br>
                                <br>
<table class="table" id="item_table"  >
  <thead>
    <tr >
      <th>Pattern</th>
      <th>Size</th>
      <th>MRP</th>
      <th>Sales Price</th>
      <!-- <th>Quantity</th> -->
    </tr>
  </thead>
</table>                               
<br>
										<div class="row">
                                        <div class="col-md-4"></div>
                                        <div class="col-md-1"></div>
										 <div class="col-md-1">
                                         <input type="submit" value="Done" class="btn btn-danger">
                                        </div>
										<div class="col-md-1"> </div>
                                        <div class="col-md-5"></div>
                                        </div>
           </div>   
            </div><!-- .content-wrapper -->
              </form>
        </main> <!-- .cd-main-content -->
    </div>
    <script>
    
  $(function () {
	$('#cityname').on('change',function(){
		$("#item_table tbody tr").remove();
		var cityname= $('#cityname').val();
	
		$.ajax({
			type: "GET",
            contentType: "application/json; charset=utf-8",
         	 datatype: "json",
            url: "${pageContext.request.contextPath}/getAllPosItem/"+cityname+"",
            success:function(data){
            	var itemdata='';
            
            	$.each(data,function(index, value) {
            		
            		 itemdata +='<tbody> <tr style="color: white">',
            		 itemdata +="<td ><input type='text' style='width:150px;' name='pattern' value='"+value.pattern+"' readonly /></td>",
            		 itemdata +="<td><input type='text' style='width:150px;' name='size' value='"+value.size+"' readonly /></td>",
            		 itemdata +='<td ><input type="text" style="width:150px;"id="mrp" name="mrp" onkeypress="return validateFloatKeyPress(this,event);" value='+value.mrp+'  /></td>',
            		 itemdata +='<td><input type="text" style="width:150px;" id="salePrice" name="salePrice" onkeypress="return validateFloatKeyPress(this,event);" value='+value.salePrice+' /></td>',
            		
            		 
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