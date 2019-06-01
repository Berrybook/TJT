
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
	<title>Dealer regisation</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
   <script src="js\validation.js"></script> 
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> 
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
    <script type="text/javascript">
function successMessage(msg) {

	swal(msg, " ", "success")
}
</script>   
         
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
	
	<style>
	.list-group-item-success{
	background-color:lightblue;
	}
	</style>
	
	
</head>
<body>
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
            <!-- <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a> -->
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		       <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
		       <a href="CustomerInquaryForm" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
		       <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Inquiry Form</a>
        </div>
      </div>
                
                         </nav>
            <div class="content-wrapper">
			 <form action="create_Dealer" method="POST" id="form1" name="CITYregistration"  enctype="multipart/form-data"  onSubmit="return validateForm()"">
	             
               
                    <br>
                    <br>
                    <c:choose>
										<c:when test="${not empty msg}">
											<script>
												successMessage("${msg}")
											</script>
										</c:when>
									</c:choose>
                    
                    
                        
                            <div class="card-header" style="background-color:lightblue">
                              <center>  <font size="5px" color="white">
                                   Dealer registration
                                </font></center>
                            </div>
                            <div class="card-body">
                                <div class="cardpanel">
                                    <div class="row">
                                        <div class="col-md-4">
                                          <div class="form-group">
                                                <b><label for="dealerMailId">dealer Mail Id</label></b>
                                                <input type="email" class="form-control" id="email" placeholder="Mail Id" name="dealer_Mail_Id" required pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}">
												 <style="color:red;"> <span id="errmsg2"></span></style>
                                            </div>
                                        </div>
                                       
                                        
                                        <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Dealername">Dealer name</label></b>
                                                <input type="text"  class="form-control" id="Dealername" placeholder="Dealer name" name="dealer_Name" required>
												
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="password ">password </label></b>
                                                <input type="text" class="form-control" id="password" placeholder="password"  name="password " required>
												
                                            </div>
                                        </div>
										
										
										
										
                                    </div>
									
									<div class="row">
									<div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Mobilenumber">Mobile number</label></b>
                                                <input type="text" class="form-control" id="Mobilenumber" placeholder="Mobile number" name="phone_number" required maxlength="10">
												<br><i style="color:red; font-size:20px;" id="mub"></i>
                                            </div>
                                        </div>
									<div class="col-md-4">
									<div class="form-group">
                                                <b><label for="">Address</label></b>
                                                <textarea class="form-control" id="Address" placeholder="Address" name="address" > </textarea required>
												<br><i style="color:red; font-size:11px;" id="GstAddres"></i>
                                            </div>
									
									</div>
									
							
                             
							 <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="City">City</label></b>
                                                <input type="text" class="form-control" id="City" placeholder="City" name="city" required>
												<br><i style="color:red; font-size:20px;" id="cty"></i>
                                            </div>
                                        </div>
							           
									</div>
									<div class="row">
									
									<div class="col-md-4">
									<div class="form-group">
                                                <b><label for="State">State</label></b>
                                                <input type="text" class="form-control" id="State" placeholder="State" name="state" required>
												<br><i style="color:red; font-size:20px;" id="stat"></i>
                                    </div>
									</div>
							<div class="col-md-4">
                             <div class="form-group">
                             <b><label for="pincode">pincode</label></b>
                                                <input type="text" class="form-control"  id="pincode" placeholder="pincode" name="pincode" required maxlength="6">
												<br><i style="color:red; font-size:20px;" id="gstno"></i>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4">
                             <div class="form-group">
                             <b><label for="channel Executive">Channel Executive</label></b>
                                                 <select class="form-control" class="form-control chosen-select"  name="channelExecutive"  id="channelExecutive" >
                                               <option value="">select Channel Executive</option>
                                               <c:forEach var="ce" items="${chhanelExecutive }">
                                                <option value="${ ce.userid}">${ce.userid}/${ce.userName}</option>
                                               </c:forEach>
                                                </select>
												<br><i style="color:red; font-size:20px;" id="gstno"></i>
                                            </div>
                                        </div>
									</div>
									
                                   
                                    <div class="row">
                                        <div class="col-md-4"></div>
                                        <div class="col-md-1">
                                         <input type="submit" value="Done" class="btn btn-danger">
                                        </div>
										<div class="col-md-1">
                                         <input type="reset" value="Reset" class="btn btn-danger" >
                                        </div>
										
                                        <div class="col-md-5"></div>
                                        </div>
                                    
                                    
                                </div>
                            </div>
                       </form>
                       </div>
                    
                    <center>
                       
                  
                    </center>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>dealer Mail Id</th>
                                <th>Dealer name</th>
								<th>password</th>
                                <th>Mobile number</th>
								<th>Address</th>
								<th>City</th>
								<th>State</th>
								<th>pincode</th>
                            </tr>
							 </thead>
							 <tbody>
							<c:forEach var="city" items="${alldealer}">
							<tr>
							<td>${city.dealer_Mail_Id}</td>
							<td>${city.dealer_Name}</td>
							<td>${city.phone_number}</td>
							<td>${city.address}</td>
							<td>${city.city}</td>
							<td>${city.state}</td>
							<td>${city.pincode}</td>
							<td>${city.channelExecutive}</td>
							</tr>
							</c:forEach>
							
							  <spring:url value="/deletecity" var="deleteUrl"/>
                   
							
							
						
                            </tbody>
                       
                    </table>
                
            </div><!-- .content-wrapper -->
        </main> <!-- .cd-main-content -->
    </div>

	
<script>
$(document).ready(function () {  
   $('form1').validate( {debug: true} );
   $("form1").css({ 'color': 'red' });
   });
   
   //city validation
   $(document).ready(function () {
  $('#City').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
            return true;
        }
        else
        {
        $("#cty").html("characters Only").show().fadeOut("slow");
		 $("#cty").css({ 'color': 'red' });
        return false;
        }
    });
	});
   //state validation
   $(document).ready(function () {
  $('#State').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
            return true;
        }
        else
        {
        $("#stat").html("characters Only").show().fadeOut("slow");
		 $("#stat").css({ 'color': 'red' });
        return false;
        }
    });
	});


	
	$("#Mobilenumber").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#mub").html("Digits Only").show().fadeOut("slow");
		$("#mub").css({ 'color': 'red' });
               return false;
    }
   });

	$("#pincode").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#gstno").html("Digits Only").show().fadeOut("slow");
		$("#gstno").css({ 'color': 'red' });
               return false;
    }
   });
	
	
	
	
</script>
	<script>
	
	
	</script>
	
	
	
	
</body>
</html>