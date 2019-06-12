<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
  	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Responsive Sidebar Navigation | CodyHouse</title>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	
	
	
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/mdb.min.css" rel="stylesheet" />
    <link href="css/style1.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<style type="text/css">
			a{
	text-decoration: none;
	display: inline-block;
	font-family: 'Lobster';
}
 a.active{
    		background-color: gray;
    	}
    .table {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
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




             .table th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color:GREY;
                color: white;
                
                
            } 
            .table td{
            
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


        
	</style>
	
	
	
</head>
<body>


	<header class="cd-main-header">
		
		
		<a href="#0" class="cd-nav-trigger"><span></span></a>

		

		<nav class="cd-nav">
			<ul class="cd-top-nav">
		
		<li >
					<p><a href="logout"><i class="w3-jumbo w3-spin fa fa-male  style=color:orange"></i>Logout</a></p>
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
				

				</nav>
			
			<form action="positemassign" method="post">		
		<div class="content-wrapper">
			
		
	 <div id="StockMaster">
        
            
                   
                </div>
           
            <br>
            <br>

            <div class="container">

                <div class="card">
                    <div class="card-header" style="background-color:orange">

                        <font size="4px" color="white">
                            Stock Master
                        </font>

                    </div>
                    <div class="card-body">


                        <div class="cardpanel">
                            <font color='red'> <span id="error"> </span> </font>
                            <div class="row">

							<div class="col-md-4">
                            <div class="form-group">
                            <b><label for="Item">POS</label></b>
                            <select class="form-control" id="pos" name="pos" v-model="tyre_id">
                          				<c:forEach  var="posid" items="${posid}">
                          					 <option value="${posid.pos}"> ${posid.pos}</option>
                          				 </c:forEach>
  							</select>
                            </div>
                            </div>
                           <div class="col-md-4">
                                    <div class="form-group">
                                        <b><label for="Item">TYRE</label></b>
                                        <div class="form-control">

                                             <div title="" class="multiselect dropdown-toggle " data-toggle="dropdown">
                                                <span class="multiselect-selected-text"class="form-control" >TYRE</span>
											</div>
                                           

                                            <ul class="multiselect-container dropdown-menu">
												   <input value="alltyre" type="checkbox" name="alltyre">All Tyre 
										<c:forEach var="tyreid" items="${tyreid}">
												 <li class="">
                                                    <a tabindex="0">
                                                    
                                                        <input value="${tyreid.tyrepattern}/${tyreid.tyresize}" type="checkbox" name="tyre">${tyreid.tyrepattern}/${tyreid.tyresize}   
                                                     
                                                    </a>
                                                </li>
												</c:forEach>
                                               
                                              </ul>
                                        </div>

                                    </div>
                                </div>
							
							
							 <div class="col-md-2">
							 </div>
							</div>
							     
                                

                                      </div>
                        </div>
                    </div>
                </div>
                 
            </div>
        

            <br>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">

                    <input type="submit" v-on:click="Save" class="btn btn-primary" value="Save">
                </div>

                <div class="col-md-4"></div>
            </div>

			
			 </form>
		</div> <!-- .content-wrapper -->
		
	</main> <!-- .cd-main-content -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
  <script>

        var ob = {};

        var object = c_AJAX.Ajax(webApi, JSON.stringify(ob));
        debugger;
        var webApi = "/api/demo/List";
        var result = c_AJAX.Ajax(webApi);

        new Vue({
            el: '#StockMaster',
            data: {
               
                Sale: {
                    Stock_item: "",
                    Stock_pos: "",
                    
                    


                    ob: object,
                },

                MemberList: result

            },
            mounted: function () {

                debugger;
            },
            methods: {
                Save: function () {
                    debugger;
                    var webApi = "/api/demo/Save";


					

                    var result = c_AJAX.Ajax(webApi, JSON.stringify(Sale));
                    if (result != null) {
                        Success(' Stock Master Entry succesfully');
                    }


                    else {
                        Error(' Stock Master Entry failed');
                    }
                }






            }
        })
    </script>





    <script type="text/javascript">
        $(document).ready(function () {
            $('#example-getting-started').multiselect();
            $("#example-getting-started option:selected").text();
            alert($("#example-getting-started option:selected").text());
        });

    </script>


    <script src="js/jquery-3.3.1.min.js"></script>

    <script src="js/popper.min.js"></script>

    <script src="js/bootstrap.min.js"></script>
    <script src="../js/mdb.min.js"></script>



    

    <script src="../js/jquery.menu-aim.js"></script>

    <script src="../js/main.js"></script> <!-- Resource jQuery -->



</body>
</html>