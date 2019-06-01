<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tjtyre Login </title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


<style>
.header {
  padding: 13px 20px;
  background:#44a0c9;
  color:brown;
font-size:20px;
height:85px;

}


body {
  background-color:#e8f3ff;
}
.contain {
    position: absolute;
    right:30px;
    margin:20px;
    max-width:300px;
    padding: 30px;
   background-color: lightblue;
background-size: cover;
border: 5px solid white;
}
</style>

</head>
<body>

<form action="login" method="post" >
<div class="header" id="myHeader">

<img src="image/logo.jpg" alt="logo" style="width:70px; height:70px;">

</div>
<br><div class="row">
<div class="col-md-2"></div>
<div class="col-md-6">
</div>
	
	<div class="col-md-2"></div>
	</div>
	
<div class="contain">
 <center> <h2 style="color:blue; font-size:25px;"> LOGIN</h2></center>
   <br>
   <%-- <div class="form-group">
     
      <select class="form-control" name="role" id="role">
                            	<option value=""> choose role</option>
                                <c:forEach  items="${loginByRole}" var="roles">
 									 <option value="${roles}">${roles}</option>
   								</c:forEach>
                            </select>
    </div> --%>
     <br>
   
   
    <div class="form-group">
     
      <input type="text" class="form-control" id="posid"  name="pos">
    </div>
     <br>
    <div class="form-group">
      
      <input type="password" class="form-control" id="pwd" name="password">
    </div>
    <c:choose>
	<c:when test="${not empty login }">
		<span style="color:red;">${login}</span>
	</c:when>
	
	<c:when test="${not empty logout }">
   <span style="color: red"> ${logout}</span>
    </c:when>
    <c:when test="${not empty SessionTimeOut }">
   <span style="color: red"> ${SessionTimeOut}</span>
    </c:when>
	</c:choose>
	 
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="submit" value="login" class="btn btn-primary">Submit</button>
 </div>


 <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
 
</form>

</body>
</html>