<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import =  "conn.ConMysqlLocalhost" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
          <style>
            table tr:not(:first-child){
                cursor: pointer;transition: all .25s ease-in-out;
            }
            table tr:not(:first-child):hover{background-color: #FFFFFF;}
        </style>
  <title>Contitouch</title>
  <!-- base:css -->
  <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/flag-icon-css/css/flag-icon.min.css">
  <%-- <%@include file = 'fviewprojects.jsp' %> --%>
  
  
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/vertical-layout-light/style.css">
  <link rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.ico" />
  
  
  		 <script>
		 function Log_out()
		 {
		     var hi= confirm("Are you sure you want to logout?");
		     if (hi== true){
		         //alert("Ok");
		         window.location.href = 'logout.jsp';
		         
		     }else{
		         alert("Cancel");

		        window.location.href = 'HomeUser.jsp';
		     }
		 }
		</script>
		
  
</head>
<body class="sidebar-icon-only">
  <div class="container-scroller">
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
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text" id="search">
                  <i class="mdi mdi-magnify"></i>
                  </span>
                </div>
                <input type="text" class="form-control" placeholder="Type to search..." aria-label="search" aria-describedby="search">
              </div>
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
      <!-- partial:partials/_settings-panel.html -->


 <%@include file = '/Views/nav/navigationu.jsp' %>
      
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12">
            
		<%@include file = '/Views/nav/header.jsp' %>	
		<br><br>

              <div class="tab-content tab-transparent-content pb-0">
                <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview-tab">
                    <div class="row">
                        
                      
                <div class="card-body">
                  <h4 class="card-title">Pending Approval Tasks!</h4>
               <!--    <div class="row grid-margin">
                    <div class="col-12">
                      <div class="alert alert-secondary" role="alert">
                          <strong>Completed Project!</strong> This table shows all completed projects.<br><br>
                      </div>
                    </div>
                  </div> -->
                  <div class="row">
                    <div class="col-12">
                      <div class="table-responsive">
                      <form name="form1" id="form1" action="/ContitouchH/ProjectActions"  method="post">
                      
                        <table id="order-listing" class="table ">
                          <thead>
                            <tr class="bg-primary text-white">
                                  <th>Task #</th>
                                <th>Task Name</th>
                                <th>Company</th>
                                <th>Lead-Developer</th>
                                <th>Task-Start</th>
                                <th>Task-End</th>
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
						String val2 = "2";
						String user01 = session.getAttribute("User").toString();
						String query="select *  from tasks where del_indicator != '"+val+"' AND todo_status = '"+val2+"' AND assignedto = '"+user01+"'   ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>
                            <tr>
                        		<td><%=rs.getString("task_id") %></td>
        		  			<td><%=rs.getString("tname") %></td>
            	  			<td><%=rs.getString("client") %></td>
            	  			<td><%=rs.getString("leader") %></td>
            	  			<td><%=rs.getString("assigneddate") %></td>
            	  			<td><%=rs.getString("duedate") %></td>
                     
                                
                                <td>
                                  <label class="badge badge-warning">Pending Approval</label>
                                </td>
                  
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
				</div>
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        </div>
                      </div>

                  
                  <!-- <div class="row">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <div class="d-flex flex-wrap justify-content-between">
                            <h4 class="card-title">Tasks</h4>
                            <div class="dropdown">
                              <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="dropdownMenuSizeButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              2019
                              </button>
                              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuSizeButton3" data-x-placement="bottom-end">
                                <a class="dropdown-item" href="#">2015</a>
                                <a class="dropdown-item" href="#">2016</a>
                                <a class="dropdown-item" href="#">2017</a>
                                <a class="dropdown-item" href="#">2018</a>
                              </div>
                            </div>
                          </div>
                          <div class="container-fluid">
                            <div class="row ticket-card mt-3 pb-2 border-bottom pb-3 mb-3">
                              <div class="col-md-1">
                                <img class="img-sm rounded-circle mb-4 mb-md-0" src="https://via.placeholder.com/37x37" alt="profile image">
                              </div>
                              <div class="ticket-details col-md-9">
                                <div class="d-md-flex">
                                  <h4 class="text-dark mr-2 no-wrap">Dustin Lucas</h4>
                                  <h5 class="mr-1 text-primary">[#46687]</h5>
                                  <p class="font-weight-medium ellipsis">Will The Democrats Be Able To Reverse The Online Gambling Ban</p>
                                </div>
                                <p class="text-gray font-weight-medium">People who have a ticket reservation of the event is automatically mark as interested. Harness The Power Of Words In</p>
                                <div class="row text-muted d-md-flex d-none">
                                  <div class="col-12 d-flex">
                                    <p class="mb-0 mr-2 text-gray text-small">30 Min ago - Due in 1 days</p>
                                  </div>
                                </div>
                              </div>
                              <div class="ticket-actions col-md-2 text-lg-right pr-md-0">
                                <div class="btn-group dropdown">
                                  <button type="button" class="btn btn-success btn-md d-flex">Action</button>
                                </div>
                              </div>
                            </div>
                            <div class="row ticket-card mt-3 pb-2 border-bottom pb-3 mb-3">
                              <div class="col-md-1">
                                <img class="img-sm rounded-circle mb-4 mb-md-0" src="https://via.placeholder.com/37x37" alt="profile image">
                              </div>
                              <div class="ticket-details col-md-9">
                                <div class="d-md-flex">
                                  <h4 class="text-dark mr-2 no-wrap">Ida Manning</h4>
                                  <h5 class="mr-1 text-primary">[#23135]</h5>
                                  <p class="font-weight-medium mb-0 ellipsis">Choosing The Best Audio Player Software For Your Computer</p>
                                </div>
                                <p class="text-muted font-weight-medium">People who have a ticket reservation of the event is automatically mark as interested. Harness The Power Of Words In</p>
                                <div class="row text-muted d-md-flex d-none">
                                  <div class="col-12 d-flex">
                                    <p class="mb-0 mr-2 text-gray text-small">30 Min ago - Due in 2 days</p>
                                  </div>
                                </div>
                              </div>
                              <div class="ticket-actions col-md-2 text-lg-right pr-md-0">
                                <div class="btn-group dropdown">
                                  <button type="button" class="btn btn-success btn-md d-flex">Action</button>
                                </div>
                              </div>
                            </div>
                            <div class="row ticket-card mt-3 pb-2 pb-3 mb-3">
                              <div class="col-md-1">
                                <img class="img-sm rounded-circle mb-4 mb-md-0" src="https://via.placeholder.com/37x37" alt="profile image">
                              </div>
                              <div class="ticket-details col-md-9">
                                <div class="d-md-flex">
                                  <h4 class="text-dark mr-2 no-wrap">Flora Hunter</h4>
                                  <h5 class="mr-1 text-primary">[#23135]</h5>
                                  <p class="font-weight-medium mb-0 ellipsis">A Discount Toner Cartridge Is Better Than Ever And You Will Save 50 Or More</p>
                                </div>
                                <p class="text-muted mb-2 font-weight-medium">People who have a ticket reservation of the event is automatically mark as interested. Harness The Power Of Words In</p>
                                <div class="row text-muted d-md-flex d-none">
                                  <div class="col-12 d-flex">
                                    <p class="mb-0 mr-2 text-gray text-small">30 Min ago - Due in 8 days</p>
                                  </div>
                                </div>
                              </div>
                              <div class="ticket-actions col-md-2 text-lg-right pr-md-0">
                                <div class="btn-group dropdown">
                                  <button type="button" class="btn btn-success btn-md d-flex">Action</button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="users" role="tabpanel" aria-labelledby="users-tab">
                  Tab Item
                </div>
                <div class="tab-pane fade" id="returns-1" role="tabpanel" aria-labelledby="returns-tab">
                  Tab Item
                </div>
                <div class="tab-pane fade" id="more" role="tabpanel" aria-labelledby="more-tab">
                  Tab Item
                </div>
              </div>
            </div>
          </div>
        </div> -->
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        
        <div class="footer-wrapper">
       
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-center text-sm-left d-block d-sm-inline-block">Copyright &copy; 2019. All rights reserved. </span>
              <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Designed by: <a href="#" target="_blank">Contitouch</a>. </span>
            </div>
          </footer>
        </div>
        <!-- partial -->
      <!-- main-panel ends -->
      </div>
    <!-- page-body-wrapper ends -->
    </div>
  </div>
  <!-- container-scroller -->
  <!-- base:js -->
  
    		   <script>
    
                var table = document.getElementById('order-listing');
                
                for(var i = 1; i < table.rows.length; i++)
                {
                    table.rows[i].onclick = function()
                    {
                         //rIndex = this.rowIndex;
                         document.getElementById("first").value = this.cells[0].innerHTML;
                         document.getElementById("second").value = this.cells[1].innerHTML;
                         document.getElementById("third").value = this.cells[2].innerHTML;
                    };
                }
                
    
    
         </script>
         
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="vendors/progressbar.js/progressbar.min.js"></script>
  <script src="vendors/flot/jquery.flot.js"></script>
  <script src="vendors/flot/jquery.flot.resize.js"></script>
  <script src="vendors/flot/curvedLines.js"></script>
  <script src="vendors/chart.js/Chart.min.js"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <script src="js/settings.js"></script>
  <script src="js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="js/dashboard.js"></script>
  <!-- End custom js for this page-->
  
  
  		
		<script src="vendors/datatables.net/jquery.dataTables.js"></script>
  		<script src="vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  		<!-- End plugin js for this page -->
  		<!-- Custom js for this page-->
  		<script src="js/data-table.js"></script>
  
</body>

</html>

