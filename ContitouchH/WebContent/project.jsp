<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*" import =  "conn.ConMysqlLocalhost"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
  <link rel="shortcut icon" href="images/favicon1.png" />
  <%@include file = 'sessions.jsp' %>
  
  
  		 <script>
		 function Log_out()
		 {
		     var hi= confirm("Are you sure you want to logout?");
		     if (hi== true){
		         //alert("Ok");
		         window.location.href = 'login.jsp';
		         
		     }else{
		         alert("Cancel");
		         window.location.href = 'project.jsp';
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
          <a class="navbar-brand brand-logo-mini" href="index.html"><img src="images/logo-mini.svg" alt="logo"/></a> 
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
		
 <div class="content-wrapper">
    
          <!--vertical wizard-->
          <div class="col-12 grid-margin">
              <div class="card">
                <div class="card-body" style="background-color:#E5E4E2">
                  <h4 class="card-title">Create Project</h4>
                  <form class="form-sample" action="/ContitouchH/CreateProject" method="post">
                    <p class="text-danger">
                              <i class="mdi mdi-alert-octagon mr-2"  ></i><a href="#"  data-toggle="modal" data-target="#exampleModal-2">Click to populate Client Brief.</a>
                              <br><br>
                            </p>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Project Name</label>
                          <div class="col-sm-9">
                            <input type="text" name="pname" id="pname" class="form-control" />
                          </div>
                        </div>
                      </div>
                      <div class="col-md-6">
                         <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Status</label>
                          <div class="col-sm-9">
                          <select name="pstatus" id="pstatus" class="form-control">
                              <option value="Pending">Pending</option>
                              <option value="In Studio">In Studio</option>
                              <option value="Waiting Details">Waiting Further Details From Client</option>
                              <option value="In Photography">In Photography</option>
                              <option value="Waiting Approval">Waiting Approval</option>
                              <option value="Waiting Feedback">Waiting Feedback</option>
                              <option value="Client Still Reviewing">Client Still Reviewing</option>
                            </select>

                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Time</label>
                          <div class="col-sm-9">
                          <input type="text" name="time" id="time" class="form-control" />

                          </div>
                        </div>
                      </div>
                      
                      
                      
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Priority</label>
                          <div class="col-sm-9">
							  <select name="priority" id="priority" class="form-control">
                              <option value="High">High</option>
                              <option value="Low">Medium</option>
                              <option value="Low">Low</option>
                            </select>                          
                            </div>
                        </div>
                         
                      </div>
                      
   
                    </div>
                    <div class="row">

                      
                          <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Requester</label>
                          <div class="col-sm-9">
                            <input name="requester" id="requester" type="text" class="form-control" />
                          </div>
                        </div>
                      </div>
                      
            
					  
           
					  
					<div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Project/ Recurring</label>
                          <div class="col-sm-9">
 							  <select name="prore" id="prore" class="form-control">
                              <option value="Project">Project</option>
                              <option value="Recurring">Recurring</option>
                            </select>                          
                            </div>
                        </div>
                      </div>
					  

                    </div>
					
					<div class="row">
                  
					  
					<div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Request Received Date</label>
                          <div class="col-sm-9">
                            <input class="form-control" type="date" id="rrd" name="rrd">
                          </div>
                        </div>
                      </div>
                      
                      
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Required End Date</label>
                          <div class="col-sm-9">
                            <input class="form-control" type="date" id="red" name="red">
                          </div>
                        </div>
                      </div>
					
                    </div>
                    
                 <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Project Start Date</label>
                          <div class="col-sm-9">
                            <input name="project_start" id="project_start" type="date" class="form-control" />
                          </div>
                        </div>
                      </div>
					  
					<div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Project End Date</label>
                          <div class="col-sm-9">
                            <input class="form-control" id="project_end" name="project_end" type="date">
                          </div>
                        </div>
                      </div>
					  
                    </div>

                 <div class="row">
                 
                     <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Responsibility</label>
                          <div class="col-sm-9">
                            <input class="form-control" id="responsibility" name="responsibility" type="text">
                          </div>
                        </div>
                      </div>
                      
                
                
                
                                    <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Lead</label>
                          <div class="col-sm-9">
    			<%
    			Connection mysqlConn = null;
				try{

    			mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				Statement stmt = null;
				stmt = mysqlConn.createStatement();
				ResultSet resultset =null;
				String val = "User";
				resultset =stmt.executeQuery("select * from users where userroles = '"+val+"' ") ;
				%>
                            
               <select name="lead" id="lead" class="form-control">
               <option value="">Choose One</option>
               <% while(resultset.next()){ %>
               <option value="<%= resultset.getString("email") %>"><%= resultset.getString("name")%></option>
				<% }%>
                                            
                                         
               </select>
               <% }

			   catch(Exception e){

			   out.println("wrong entry"+e);
               }%> 
                          </div>
                        </div>
                      </div>
                      
                
                    
                    </div>		
                    
                    <div class="row">
                    
                    
                                        
                      
                      
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Company</label>
                          <div class="col-sm-9">
 							  
    			<%
    			
				try{

    			mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				Statement stmt = null;
				stmt = mysqlConn.createStatement();
				ResultSet resultset =null;

				resultset =stmt.executeQuery("select id,name from clients ") ;
				%>
                                        
                                        
                                        
                                        
                                        
               <select name="company" id="company" class="form-control">
               <option value="">Choose One</option>
               <% while(resultset.next()){ %>
               <option><%= resultset.getString("name")%></option>
				<% }%>
                                            
                                         
               </select>
               <% }

			   catch(Exception e){

			   out.println("wrong entry"+e);
               }%>                          
                            </div>
                        </div>
                      </div>
					  
                   
                       <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Comments</label>
                          <div class="col-sm-9">
                            <textarea name="comments" id="comments" type="text" rows="8" class="form-control" /></textarea>
                          </div>
                        </div>
                      </div>
                      
                      
                      </div>
                      

					  
                    
                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                    <button type="reset" class="btn btn-light">Cancel</button>
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
    
    
    
    	<div class="card">
               <form action="/ContitouchH/PopulateClientBrief" method="post">
                  <div class="modal fade" id="exampleModal-2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel-2" aria-hidden="true" style="display: none;">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">Select Project to Populate</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                          </button>
                        </div>
                        
                  <div class="modal-body">
                    <%
    			//Connection mysqlConn = null;
				try{

    			mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				Statement stmt = null;
				stmt = mysqlConn.createStatement();
				ResultSet resultset =null;
				resultset =stmt.executeQuery("select * from clientbrief ") ;
				%>
                            
               <select name="clientbrief" id="clientbrief" class="form-control">
               <option value="">Choose One</option>
               <% while(resultset.next()){ %>
               <option value="<%= resultset.getString("id")%>"><%= resultset.getString("projectname")%></option>
				<% }%>
                                            
                                         
               </select>
               <% }

			   catch(Exception e){

			   out.println("wrong entry"+e);
               }%> 
                  </div>
                  
                        <div class="modal-footer">
                          <button type="submit" class="btn btn-success">Populate</button>
                          <button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  </form>
                  <!-- Modal Ends -->
                </div>
           
    
    
    
    
    
    
    
    
    
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
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
