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

		        window.location.href = 'allprojects.jsp';
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
<%@include file = '/Views/nav/navigationf.jsp' %>
          <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
		
		
		
<%@include file = '/Views/nav/header.jsp' %>		



<!--                 <div class="card-body">
                  <h4 class="card-title">Report Filter</h4>
                  <p class="card-description">
                    Use these <code>filters</code> to search and generate reports
                  </p>
                  <form action="/ContitouchH/ProjectReports" method="post" class="form-inline">
                    <input type="text" class="form-control mb-2 mr-sm-2" id="pname" name="pname" placeholder="Project Name">
                    
                    <input type="text" class="form-control mb-2 mr-sm-2" id="status" name="status" placeholder="Status">
                    
                    <input type="date" class="form-control mb-2 mr-sm-2" id="date1" name="date1" placeholder="Date From:" required>
                    
                    <input type="date" class="form-control mb-2 mr-sm-2" id="date2" name="date2" placeholder="Date To:" required>
                  
                    <div class="input-group-prepend">
                    <button type="submit" class="btn btn-primary mb-2 ">Search</button>
                    </div>
                    
                    
                    
                    <button type="submit" class="btn btn-outline-info btn-icon-text">
                          Search
                          <i class="mdi mdi-account-search btn-icon-append"></i>                                                                              
                        </button>
                   
                    
                  </form>
                </div> -->
             					

								
	
		<br><br><br>		
		<div class="card">
            <div class="card-body">
              <h4 class="card-title">View all Projects</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                  <form name="form1" id="form1" action="/ContitouchH/ProjectActions"  method="post">
                    <table id="order-listing" class="table">
                     
					  <thead>
                        <tr>
                            <th>ID #</th>
                            <th>Project Name</th>
                            <th>Company</th>
                            <th>AssignedTo</th>
                            <th>Lead</th>
                            <th>Priority</th>
                            <th>StartDate</th>
                            <th>EndDate</th>
                            <th>Status</th>
                        </tr>
                      </thead>
                      
                      
                      
                      <tbody>
                      
                      <%Connection mysqlConn = null;
						try{
    					mysqlConn = ConMysqlLocalhost.getMySqlConnection();

						Statement stmt = null;
						stmt = mysqlConn.createStatement();
						ResultSet resultset =null;
						String val = "TRUE";
						String query="select *  from projects where del_indicator != '"+val+"'   ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>
                        <tr>
                        
                        
                        	<td><%=rs.getString("id") %></td>
        		  			<td><%=rs.getString("pname") %></td>
            	  			<td><%=rs.getString("company") %></td>
            	  			<td><%=rs.getString("assignedto") %></td>
            	  			<td><%=rs.getString("lead") %></td>
            	  			<td><%=rs.getString("priority") %></td>
            	  			<td><%=rs.getString("project_start") %></td>
            	  			<td><%=rs.getString("project_end") %></td>
            	  			<td><%=rs.getString("status") %></td>
                           

                        </tr>
                   
							<%}%>
                                		</tbody>
          					                                
                			</table>
    						<%rs.close();
			    			stmt.close();
    						mysqlConn.close();
    							}
							catch(Exception e){
    							e.printStackTrace();
    			
									}%> 
									
									</form>
					
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          								<br><br>
          								 <div class="card col-lg-2">
												<form action="/ContitouchH/ProjectReports" method="post" class="form-inline">
												<div class="d-inline-flex">
													<button class="btn d-flex align-items-center">
													<i class="mdi mdi-download mr-1"></i>
													<span class="text-left font-weight-medium">
													Download Report
													</span>
													</button>
													<!-- <button class="btn d-flex align-items-center">
													<i class="mdi mdi-file-pdf  mr-1"></i>
													<span class="font-weight-medium text-left">
													PDF reports
													</span>
													</button> -->
													
												</div>
												</form>
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

  <script src="vendors/datatables.net/jquery.dataTables.js"></script>
  <script src="vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="js/data-table.js"></script>
    <script src="js/modal-demo.js"></script>
    
    
      <script src="vendors/sweetalert/sweetalert.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="js/alerts.js"></script>
  
  <!-- End custom js for this page-->
  <!-- End custom js for this page-->
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
