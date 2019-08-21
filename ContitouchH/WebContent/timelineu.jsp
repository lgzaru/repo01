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
		         window.location.href = 'logout.jsp';
		         
		     }else{
		         alert("Cancel");
		         window.location.href = 'timeline.jsp';
		     }
		 }
		</script>
  
  
  
</head>

<body>
  <div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
       <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-left navbar-brand-wrapper d-flex align-items-center justify-content-between">
          <a class="navbar-brand brand-logo" href="HomeUser.jsp"><img src="images/contitouch-logo-white.png" alt="logo"/></a>
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
                <a class="dropdown-item" href="HomeUser.jsp">
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
   
      <!-- partial:../../partials/_sidebar.html -->
<%@include file = '/Views/nav/navigationu.jsp' %>
          <!-- partial -->
      <div class="main-panel">          
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                
                
                
                
                
                 
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                
                
                
                
                
                  
                </div>
              </div>
            </div>


 


   
          </div>
          
          
          <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Task Manager</h4>
                  <p class="card-description">
                    Shows ToDo/InProgress
                  </p>
                  <div class="row">
                    <div class="col-md-6">
                      <h6 class="card-title">Todo</h6>
                      <div id="dragula-event-left" class="py-2">
                      
                      
                        <%Connection mysqlConn = null;
                        
                		String username =  session.getAttribute("User").toString();	
                		//System.out.println("Testing"+username);

						try{
    					mysqlConn = ConMysqlLocalhost.getMySqlConnection();

						Statement stmt = null;
						stmt = mysqlConn.createStatement();
						ResultSet resultset =null;
						String val = "TRUE";
						String val2 = "Completed";
						String query="select *  from tasks groupby    ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>

                        <div class="card rounded border mb-2">
                          <div class="card-body p-3">
                            <div class="media">
                              <i class="mdi mdi-check icon-sm text-primary align-self-center mr-3"></i>
                              <div class="media-body">
                                <h6 class="mb-1">Task Name:<%=rs.getString("tname") %></h6>
                                <h6 class="text-danger">Lead:<%=rs.getString("lead") %></h6>
                                <h6 class="text-warning">Project:<%=rs.getString("project_name") %></h6>
                                
                                <p class="mb-0 text-info">
                                  Description:<%=rs.getString("tdesc") %> 
                                                                
                                </p>
                                
 								
                                 
                                <div align="right">
                                <form id="mytaskid" action="/ContitouchH/TaskActions" method="post">
                                
                                 
                                <button type="button" name="todo_addnote" align="center" class="btn btn-outline-info btn-icon-text " data-toggle="modal" data-target="#exampleModal">Add Note<i class="mdi mdi-file-check btn-icon-append"></i> </button>
                                <input type="text" value="<%=rs.getString("task_id") %>" name="taskid" id="taskid" >
                                </form>
                                </div>
                              
                                
                                
                              </div>                              
                            </div> 
                          </div>
                        </div>
                        
                        <%
						}
                     rs.close();
		    			stmt.close();
						mysqlConn.close();
							}
						catch(Exception e){
							e.printStackTrace();
			
								}%>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <h6 class="card-title mt-4 mt-md-0">In progress</h6>
                      <div id="dragula-event-right" class="py-2">
                        

                        <div class="card rounded border mb-2">
                          <div class="card-body p-3">
                            <div class="media">
                              <i class="mdi mdi-check-all icon-sm text-success align-self-center mr-3"></i>
                              <div class="media-body">
                                <h6 class="mb-1">Meeting with client</h6>
                                <p class="mb-0 text-muted">
                                  New project meeting                              
                                </p>
                              </div>                              
                            </div> 
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              
              
              
              
              
          
                    
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">Project Name: Additional Notes</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                         <form action="">
                         
                       <textarea class="form-control" id="usercomments" name="usercomments" rows="10"></textarea>
                      
                       
                         
                      <div class="modal-footer">
                          <button type="button" name="todo" class="btn btn-success">Start Working on...</button>
                          <button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
                      </div>
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
