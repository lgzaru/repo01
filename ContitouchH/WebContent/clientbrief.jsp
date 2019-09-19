<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*" import =  "conn.ConMysqlLocalhost"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <style>
            table tr:not(:first-child){
                cursor: pointer;transition: all .25s ease-in-out;
            }
            table tr:not(:first-child):hover{background-color: #ddd;}
        </style>
        

        
        
        
<title>Contitouch</title>

  <!-- base:css -->
  <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/flag-icon-css/css/flag-icon.min.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.ico" />
   <link rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css">
   
   

		  
		  <%@include file = 'sessions.jsp' %>
		  
		     		  <%String userName2 =  session.getAttribute("User").toString();%>
		  
		  
		<script>
		 function Log_out()
		 {
		     var hi= confirm("Are you sure you want to logout?");
		     if (hi== true){
		         //alert("Ok");
		         window.location.href = 'login.jsp';
		         
		     }else{
		         alert("Cancel");

		        window.location.href = 'client.jsp';
		     }
		 }
		</script>

</head>

<body>
  <div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
			<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-left navbar-brand-wrapper d-flex align-items-center justify-content-between">
          <a class="navbar-brand brand-logo" href="index.html"><img src="images/contitouch-logo-white.png" alt="logo"/></a>
          <a class="navbar-brand brand-logo-mini" href="index.html"><img src="images/contitouch-logo-white.png" alt="logo"/></a> 
          <button class="navbar-toggler align-self-center" type="button" data-toggle="minimize">
          <span class="mdi mdi-menu"></span>
          </button>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
          <ul class="navbar-nav">
            <li class="nav-item  dropdown d-none align-items-center d-lg-flex d-none">
              <a class="dropdown-toggle btn btn-outline-secondary btn-fw"  href="#" data-toggle="dropdown" id="pagesDropdown">
              <span class="nav-profile-name">Ctrl Links</span>
              </a>
              <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="pagesDropdown">
                <a class="dropdown-item" href="HomeAdmin.jsp">
                <i class="mdi mdi-settings text-primary"></i>
                Home
                </a>
                <a class="dropdown-item" onClick="javascript:Log_out()">
                <i class="mdi mdi-logout text-primary"></i>
                Logout
                </a>
              </div>
            </li>
     
           
          </ul>
          <ul class="navbar-nav navbar-nav-right">
            <li class="nav-item nav-search d-none d-lg-flex">
            
            </li>
           
           
            
            <li class="nav-item nav-settings d-none d-lg-flex">
              <a class="nav-link" href="#">
              <i class="mdi mdi-dots-horizontal"></i>
              </a>
            </li>
          </ul>
          <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
          </button>
        </div>
      </nav>
       <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:../../partials/_settings-panel.html -->

        
      <!-- partial -->
      <!-- partial:../../partials/_sidebar.html -->
<%@include file = '/Views/nav/navigation.jsp' %>
          <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
        
<%@include file = '/Views/nav/header.jsp' %>							
<br><br><br>
		
		 <div class="row grid-margin">
            <div class="col-lg-10">
              <div class="card">
                <div class="card-body" >
                  <h4 class="card-title">Client Brief</h4><br>
                  <form class="cmxform" action="/ContitouchH/MyRedirect" id="clientForm" method="post" >
                    <fieldset>
                    <div class="row">
                   	<% Connection mysqlConn = null;
				try{

    			mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				Statement stmt = null;
				stmt = mysqlConn.createStatement();
				ResultSet resultset =null;

				resultset =stmt.executeQuery("select * from clients ") ;
				%>
                                        
                                        
                                        
               <div class="col-md-6">
                                     
                <div class="form-group">
               <label for="clients">Client Name</label>                        
               <select name="client_id" id="client_id" class="form-control">
               <% while(resultset.next()){ %>
               <option value="<%= resultset.getString("name")%>"><%= resultset.getString("name")%></option>
				<% }%>
                                            
                                         
               </select>
               <% }

			   catch(Exception e){

			   System.out.println("wrong entry"+e);
               }%>                      </div>
               </div>
                      
                      <div class="col-md-6">
                      <div class="form-group">
                        <label for="projectname">Project Name*</label>
                        <input id="projectname" class="form-control" name="projectname" maxlength="100" type="text" required>
                      </div>
                      </div>
                   
                      </div>
                      
                      
                      
                     <div class="row">
                     
                      <div class="col-md-6">
                      <div class="form-group">
                        <label for="summary">Summary*</label>
                        <textarea id="summary" class="form-control" type="text" name="summary" maxlength="1000" rows="10" required></textarea>
                      </div>
                      </div>
                      
                       <div class="col-md-6">
                      <div class="form-group">
                        <label for="datereceived">Date Received*</label>
                        <input id="datereceived" class="form-control" name="datereceived"  type="date" >
                      </div>
                      </div>
                     
                     
                      </div>
                   
                      
                      
                      <input class="btn btn-primary" type="submit" value="Next">
					  <input class="btn btn-secondary" type="reset" value="Cancel">
                    </fieldset>
                  </form>
                </div>
              </div>
            </div>
          </div>
		

		
		
	
		
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
        <div class="footer-wrapper">
            <footer class="footer">
              <div class="d-sm-flex justify-content-center justify-content-sm-between">
                <span class="text-center text-sm-left d-block d-sm-inline-block">Copyright &copy; 2019. All rights reserved. </span>
                <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Designed by: <a href="#" target="_blank">Contitouch</a>. </span>
              </div>
            </footer>
          </div>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- base:js -->
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <script src="js/settings.js"></script>
  <script src="js/todolist.js"></script>
  <!-- endinject -->
    <!-- plugin js for this page -->
  <script src="vendors/jquery-validation/jquery.validate.min.js"></script>
  <script src="vendors/bootstrap-maxlength/bootstrap-maxlength.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="js/form-validation.js"></script>
  <script src="js/bt-maxLength.js"></script>
</body>

</html>
