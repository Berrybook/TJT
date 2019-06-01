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
	.form-control{
	background-color:lightgray;
	
	}
	
	
	
	</style>
	<style>


</style>
</head>
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
                <ul>
                <li><a href="demoadhoc" style=" text-decoration: none;">Adhoc Salesman Assign</a></li>
                   <!-- <li><a href="create_Dealer" style=" text-decoration: none;">Dealer Registration</a></li>
                	<li><a href="createcity" style=" text-decoration: none;">City Registration</a></li>
					<li><a href="role" style=" text-decoration: none;">Role Registration</a></li>
					<li><a href="Poscreate" style=" text-decoration: none;">POS Registration</a></li>
					<li><a href="userregistration"style=" text-decoration: none;">User Registration</a></li>
					<li><a href="tyrecreate" style=" text-decoration: none;">Item Registration</a></li>
					<li><a href="item_price_assign" style=" text-decoration: none;">Price Assignment</a></li>
					<li><a href="Salereport" style=" text-decoration: none;">Reports</a></li>	
					<li><a href="createuserrolemappinglink" style=" text-decoration: none;">User Role Assign</a></li>
					<li><a href="warehouseMasterLink" style=" text-decoration: none;">Warehouse Registration</a></li>	
					<li><a href="createrolmodulemappinglink" style=" text-decoration: none;">Role Module Assign</a></li>
					<li><a href="createroleaccess" style=" text-decoration: none;">Resource Role Access</a></li>
					<li><a href="warehouseRegistration" style=" text-decoration: none;">warehouse user asgn</a></li> -->	
            
                </ul>
            </nav>
            <c:if test="${not empty price_assignment}"><script>popup('${price_assignment}') </script></c:if>
            <form action="priceAssignment" method="POST" id="form1" onSubmit="return validateForm()"> 
            <div class="content-wrapper">
            <div class="container">
              
                    <br>
                    
                    <br>
                        <div class="card-header" style="background-color:lightblue; width:100%">
                              <font size="5px" color="white">
                               Adhoc SalesMan
                                </font>
                            </div>
                               
                                   
                                <br>
                                <br>
 <table  border="1" class="table" >
		
<tr  id="heder">
<th><b>ID</b></th>
<th><b>NAME</b></th>
<th><b>POS</b></th>
<th><b>Adhoc Pos</b></th>
<th><b>Start date</b></th>
<th><b>End Date</b></th>
</tr>
<c:forEach var="listdto" items="${listdto}">
		<tr>
		
		
			<td>${listdto.userid}</td>
		 <td>${listdto.username}</td>
		<td>${listdto.pos}</td>
		<td>${listdto.adhocPos}</td>
		<td>${listdto.startDate}</td>
	 <td>${listdto.endDate}</td>
			
		
	
		
		</tr>
			</c:forEach>

</table>                               
<br>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
<div class="card-header" style="background-color:lightblue">
                              <center>  <font size="5px" color="white">
                                    Salesman Assign
                                </font></center>
                            </div>
        <div class="modal-body">
        
		
		
		
                            <div class="row">
							
								<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="userid">Salesman Id</label></b>
                            <input type="text" class="form-control" id="userid" placeholder=" Enter Id" name="userid">
							</div>
							</div>
							<div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="username">Name</label></b>
                            <input type="text" class="form-control" id="username" placeholder=" Enter Name" name="username">
							</div>
							</div>
										
					             <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="pos">Pos Name</label></b>
                            <input type="text" class="form-control" id="pos" placeholder=" Enter Pos Name" name="pos">
							</div>
							</div>
									
							 
										
										
										 
										
							
							</div>
							<div class="row">
							      
                                <div class="col-md-4">
                                            <div class="form-group">
                                                <b><label for="adhocPos">Adhoc Pos</label></b>
<select class="form-control" class="form-control"  name="adhocPos"  id="adhocPos" required>
                                               <option value="">select AdhocPos</option>
                                              
                                                </select>
                                            </div>
                                        </div>

                                      
										  <div class="col-md-4">
                                            <div class="form-group">
                                               <b><label for="StartDate">Start Date</label></b>
                                    <input type="date" class="form-control"  data-date-format="DD MM YYYY"  placeholder="Enter start Date" id="startDate" name="startDate" required >
                                            </div>
                                        </div>
										
										 <div class="col-md-4">
                                            <div class="form-group">
                                               <b><label for="Enddate">End Date</label></b>
                                    <input type="date" class="form-control"  data-date-format="YYYY MM DD"  placeholder="Enter End Date" id="endDate" name="endDate" required>
                                            </div>
                                        </div>
										
										 
										
								   
								   </div>
		
		     
			 <br>
            <div class="row">
                <div class="col-md-4"></div>
				<div class="col-md-1"></div>
				<div class="col-md-2">
				
				<input type="submit" v-on:click="Save" class="btn btn-danger submit-button" value="Assign">
				</div>
                <div class="col-md-1">
				
				</div>
				
                <div class="col-md-4">
                
                   
                   
            </div>
		
		</div>
		
		
        </div>
        
          
        
      </div>
    </div>
  </div>











										<div class="row">
                                        <div class="col-md-4"></div>
                                        <div class="col-md-1"></div>
										 <div class="col-md-1">
                                         
                                        </div>
										<div class="col-md-1">

    
										</div>
                                        <div class="col-md-5"></div>
                                        </div>
           </div>   
            </div><!-- .content-wrapper -->
              </form>
        </main> <!-- .cd-main-content -->
    </div>
    <script>
	
	
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
            url: "${pageContext.request.contextPath}/salesmanByCity/"+cityname+"",
            success:function(data){
            	var itemdata='';
            
            	$.each(data,function(index, value) {
            		
            		 itemdata +='<tbody> <tr style="color: white">',
            		 itemdata +="<td ><input type='text' style='width:150px;' name='userid' value='"+value.userid+"' readonly /></td>",
            		 itemdata +="<td><input type='text' style='width:150px;' name='username' value='"+value.username+"' readonly /></td>",
            		 itemdata +="<td ><input type='text' style='width:150px;' name='pos' value='"+value.pos+"' readonly /></td>",
            		 itemdata +="<td ><input type='text' style='width:150px;' name='adhocPos' value='"+value.adhocPos+"' readonly /></td>",
            		 itemdata +="<td><input type='text' style='width:150px;' name='startDate' value='"+value.startDate+"' readonly /></td>",
            		 itemdata +="<td ><input type='text' style='width:150px;' name='endDate' value='"+value.endDate+"' readonly /></td>",
            		itemdata +='<td><input type="submit" value="Done" class="btn btn-danger"></td>',
            		
            		
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