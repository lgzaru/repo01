<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import =  "conn.ConMysqlLocalhost" import="functions.AdminDash" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="refresh" content="60  url=HomeAdmin.jsp">

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
		<link rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css">
		
		<!-- endinject -->
		<link rel="shortcut icon" href="images/favicon.ico" />
		
		 <%@include file = 'sessions.jsp' %>
		 
		 <%@include file = 'charts.jsp' %>
		 
		
		 <script>
		 function Log_out()
		 {
		     var hi= confirm("Are you sure you want to logout?");
		     if (hi== true){
		         //alert("Ok");
		         window.location.href = 'logout.jsp';
		         
		     }else{
		         alert("Cancel");

		        window.location.href = 'HomeAdmin.jsp';
		     }
		 }
		</script>
		 
<%-- 		  <%
		  AdminDash obj = new AdminDash();
			obj.getAdminDash(request, response);
		  
		  String totalcomp =  session.getAttribute("totalcomp").toString();
		  String totalpending =  session.getAttribute("totalpending").toString();
		  String totalopen =  session.getAttribute("totalopen").toString();
		  String totalcompleted =  session.getAttribute("totalcompleted").toString();
		  
		  %>  --%>
		  
		

		

		 
	</head>
	<body>
		<div class="container-scroller">
			<!-- partial:partials/_navbar.html -->
			<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-left navbar-brand-wrapper d-flex align-items-center justify-content-between">
          <a class="navbar-brand brand-logo" href="HomeAdmin.jsp"><img src="images/contitouch-logo-white.png" alt="logo"/></a>
          <a class="navbar-brand brand-logo-mini" href="HomeAdmin.jsp"><img src="images/contitouch-logo-white.png" alt="logo"/></a> 
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
   
        <!-- partial -->
				<!-- partial:partials/_sidebar.html -->
				<%@include file = '/Views/nav/navigation.jsp' %>

				<!-- partial -->
				<div class="main-panel">
					<div class="content-wrapper">
						<div class="row">
							<div class="col-md-12">
							
								<!-- ------header--------- -->
								
							 <%@include file = '/Views/nav/header.jsp' %> 
								
									<br>		
									<div class="row">
							            <div class="col-lg-6 grid-margin stretch-card">
							              <div class="card">
							                <div class="card-body">
							                  <h4 class="card-title">Projects</h4><!-- Donut  Chart -->
							                  <div class="google-chart-container">
							                    <div id="Donut-chart" class="google-charts"></div>
							                  </div>
							                </div>
							              </div>
							            </div>
							            <div class="col-lg-6 grid-margin stretch-card">
							              <div class="card">
							                <div class="card-body">
							                  <h4 class="card-title">Tasks</h4>  <!-- Bar chart -->
							                  <div class="google-chart-container d-flex align-items-center justify-content-center h-100">
							                    <div id="Bar-chart" class="google-charts"></div>
							                  </div>
							                </div>
							              </div>
							            </div>
							          </div>						
								
								
								
							<div class="row">
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Completed Projects</h4>
                      <div class="d-flex justify-content-between">
                        <p class="text-muted">Total Projects</p>
                        <p class="text-muted">total:<%out.print(totalcomp); %></p>
                      </div>
                      <div class="progress progress-md">
                        <div class="progress-bar bg-info w-25" role="progressbar" aria-valuenow="<%out.print(totalcomp); %>" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Pending Project</h4>                      
                      <div class="d-flex justify-content-between">
                        <p class="text-muted">Total Pending Projects</p>
                        <p class="text-muted">total: <%out.print(totalpending); %></p>
                      </div>
                      <div class="progress progress-md">
                        <div class="progress-bar bg-success w-25" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">OverDue Tasks</h4>
                      <div class="d-flex justify-content-between">
                        <p class="text-muted">Total Tasks</p>
                        <p class="text-muted">total:<%out.print(overduetasksadmin); %></p>
                      </div>
                      <div class="progress progress-md">
                        <div class="progress-bar bg-danger w-25" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Closed Tasks</h4>
                      <div class="d-flex justify-content-between">
                        <p class="text-muted">Total Tasks</p>
                        <p class="text-muted">total: <%out.print(totalcompleted); %>
                      </div>
                      <div class="progress progress-md">
                        <div class="progress-bar bg-warning w-25" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
							</div>
						</div>
						
		<!-- Graphs start -->				
    <!--      <div class="row">
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                  <h4 class="card-title">Line chart</h4>
                  <canvas id="lineChart" width="868" height="434" class="chartjs-render-monitor" style="display: block; width: 868px; height: 434px;"></canvas>
                </div>
              </div>
            </div>
            <div class="col-lg-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                  <h4 class="card-title">Bar chart</h4>
                  <canvas id="barChart" width="868" height="434" class="chartjs-render-monitor" style="display: block; width: 868px; height: 434px;"></canvas>
                </div>
              </div>
            </div>
          </div> -->
          
          <!-- Graph ends -->
          
				
        <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Completed Projects!</h4>
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
                      
                        <table id="order-listing" class="table table-hover">
                          <thead>
                            <tr class="bg-primary text-white">
                                <th>Project #</th>
                                <th>Project Name</th>
                                <th>Company</th>
                                <th>Lead-Developer</th>
                                <th>Project-Start</th>
                                <th>Project-End</th>
                                <th>Status</th>
                                <th>Actions</th>
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
						String val2 = "Completed";
						String query="select *  from projects where del_indicator != '"+val+"' and status = '"+val2+"'   ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>
                            <tr>
                        	<td><%=rs.getString("id") %></td>
        		  			<td><%=rs.getString("pname") %></td>
            	  			<td><%=rs.getString("company") %></td>
            	  			<td><%=rs.getString("lead") %></td>
            	  			<td><%=rs.getString("project_start") %></td>
            	  			<td><%=rs.getString("project_end") %></td>
                                
                                <td>
                                  <label class="badge badge-info">Completed</label>
                                </td>
                                <td class="text-right">
                                  <!-- Hidden field with table id -->
                                  <input type="hidden" name="first" id="first" >
                                  <button class="btn btn-light" name="view" id="view">
                                    
                         
                                    <i class="mdi mdi-eye text-primary"></i>View
                                  </button>
                                  
                             
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
		
		
		
		<!-- base:js -->
		<script src="vendors/js/vendor.bundle.base.js"></script>
		<!-- endinject -->
		<!-- Plugin js for this page-->
		<script src="vendors/progressbar.js/progressbar.min.js"></script>
		<script src="vendors/flot/jquery.flot.js"></script>
		<script src="vendors/flot/jquery.flot.resize.js"></script>
		<script src="vendors/flot/curvedLines.js"></script>
<!-- 		<script src="vendors/chart.js/Chart.min.js"></script>
 -->		<!-- End plugin js for this page-->
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
		
		
  		<script src="https://www.gstatic.com/charts/loader.js"></script>
   		<script src="https://www.gstatic.com/charts/loader.js"></script>
  		<script src="js/google-charts.js"></script>
		
	
		
		<script src="js/data-table.js"></script>
		<script src="vendors/datatables.net/jquery.dataTables.js"></script>
  		<script src="vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  		<!-- End plugin js for this page -->
  		<!-- Custom js for this page-->
  		
  		   
  		   
  		 
  		
	</body>
</html>







