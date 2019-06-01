<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <script src="js\validation.js"></script> 
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <title>Role Registration</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <script src="js\jquery.menu-aim.js"></script>
   <script src="js\main.js"></script> <!-- Resource jQuery -->
    <script type="TJTYRECOMPANY20-12-18\src\main\webapp\js\Ajax.js"> </script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> 
     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
     
     
     <style>
        .list-group-item-success{
        background-color:lightblue;
        }
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
              <div id="MainMenu">
        <div class="list-group panel">
         
         
          <a href="#demo3" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Registration<i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i></a>
          <div class="collapse" id="demo3">
          <a href="create_Dealer" class="list-group-item">Dealer Registration</a>
            <a href="createcity" class="list-group-item">City Registration</a>
            <a href="role" class="list-group-item">Role Registration</a>
            <a href="Poscreate" class="list-group-item">POS Registration</a>
			<a href="userregistration" class="list-group-item">User Registration</a>
			<a href="warehouseMasterLink" class="list-group-item">Warehouse Registration</a>
			<a href="tyrecreate" class="list-group-item">Item Registration</a>
			<a href="createroleaccess" class="list-group-item">Resource Role Access</a>
          </div>
          <a href="#demo4" class="list-group-item list-group-item-success" data-toggle="collapse" data-parent="#MainMenu">Pevilleges Assign <i class="fa fa-angle-double-down" style="font-size:24px;position:absolute;top:16px;left:90%;color:#347C98"></i> </a>
          <div class="collapse" id="demo4">
            <!-- 
            <a href="warehouseRegistration" class="list-group-item">Warehouse Assign</a>
        --> <!-- <a href="createuserrolemappinglink" class="list-group-item">User Role Assign</a>--> 
            <a href="createrolmodulemappinglink" class="list-group-item">Role Module Assign</a>
			<a href="item_price_assign" class="list-group-item">Price Assignment</a>
          </div>
		   <a href="Salereport" class="list-group-item list-group-item-success" data-parent="#MainMenu">Reports</a>
		   <a href="allOrderList" class="list-group-item list-group-item-success" data-parent="#MainMenu">Orders By Dealers</a>
        <a href="customerenquiry" class="list-group-item list-group-item-success" data-parent="#MainMenu">Customer Inquiries</a>
        
        </div>
      </div>
          
                
                
          </nav>
            <div class="content-wrapper">
             <div class="container">
                <form id="RoleRegistration"
                     @click="checkForm"
          action="https://vuejs.org/"
          method="post">
                    <br>
                    <br>
                   
                       
                            <div class="card-header" style="background-color:lightblue">
                              <font size="5px" color="white">
                                     Role Registration
                                </font>
                            </div>
                            
                              
                                    <font color='red'> <span id="error"> </span> </font>
                                    
                                    
                                    <div class="row">
                                        <div class="col-md-4">
                                          <div class="form-group">

                                                <b><label for="Role">Role</label></b>
                                                <input type="text" class="form-control" id="role" placeholder="Role" name="role" v-model="role" id="role">
                                                                                                <span v-show="role.length < 1 && verror" style="color:red;"> Enter role </span>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                    <div class="form-group">
                                                <b><label for="Role Description">Role Description</label></b>
                                                <input type="text" class="form-control" id="roledescription" placeholder="Role Description" name="description" v-model="description">
                                                                                                
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    
                                    
                                    
                               
                           
                        
                    <br>
                    <center>
                        <input type="button" v-on:click="Save" value="Save" class="btn btn-danger">
                  
                    </center>
                    <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Role</th>
                                <th>Description</th>
                            </tr>
                        </thead>
                        <tbody id="tbData">
                            <tr v-for="item in RoleList">
                                <td><span  v-on:click="Load(item)">{{item.role}}</span></td>
                                <!--<td>{{item.role}}</td>-->
                                <td>{{item.description}}</td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                </div>
            </div><!-- .content-wrapper -->
        </main> <!-- .cd-main-content -->
    </div>
    <script>
       
        new Vue({
            el: '#RoleRegistration',
            data: {
                role: "",
                description: "",
               option:[],
                drop: [],
                drop1: [],
                result: "",
                ob: "",
                                errors: [],
                
                                verror : false,
                RoleList: {}
            },
            mounted: function () {
               
                this.List();
              
            },
            methods: {
                        checkForm: function (e) {
                        
                        this.verror = true;
                        if (this.role == '') {                        
                                return false;
                        }
                        
                                return true; //e.preventDefault();          
                },
                Clear:function(){
                this.isupdate=false;
                 this.role = "";
             this.description = "";
             this.verror=false;
            
        },
                
                Save: function () {
                    
                                        var check = this.checkForm();
                                        if(!check) return true;
                                        
                    var ob = {};
                    ob.role = this.role;
                    ob.description = this.description;
                    var result=JSON.stringify(ob);
                    var vm =this;
                    
                    $.ajax({
                        type: "POST",
                        contentType: "application/json; charset=utf-8",
                        datatype: "json",
                        url: "addrole",
                        data: result,
                        success: function (ob) {
                        
                                popup(ob)
                            var result = ob;
                            
                            this.RoleList = ob;
                            vm.List();
                            vm.Clear();
                            this.verror=false;
                            
                        },
                        error: function (e) {
                            
                            console.log("error");
                        }
                    });
                },
                List: function () {
                    var vm = this;
                    
                    var ob = [];
                    ob.role = this.role;
                    ob.description = this.description;
                    
                    $.ajax({
                        type: "GET",
                        contentType: "application/json; charset=utf-8",
                        datatype: "json",
                        url: "listofrole",
                        data: ob,
                        success: function (ob) {
                            var result = ob;
                            
                            vm.RoleList = ob;
                            
                        },
                        error: function (e) {
                            
                            console.log("error");
                        }
                    });
                },
              
            }
        })
    </script>
</body>
</html>