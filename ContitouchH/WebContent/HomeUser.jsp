<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import =  "conn.ConMysqlLocalhost" import="functions.UserDash" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="refresh" content="60 url=HomeUser.jsp">
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
  <%@include file = 'sessions.jsp' %>
 
  
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
<body >
  <div class="container-scroller">
   			<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-left navbar-brand-wrapper d-flex align-items-center justify-content-between">
          <a class="navbar-brand brand-logo" href="HomeUser.jsp"><img src="images/contitouch-logo-white.png" alt="logo"/></a>
          <a class="navbar-brand brand-logo-mini" href="HomeUser.jsp"><img src="images/contitouch-logo-white.png" alt="logo"/></a> 
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
		
		<!-- --------Home User dashboard----- -->
		<div class="row">
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h3 class="card-title">Todo Tasks</h3>
                      <div class="d-flex justify-content-between">
                        <h5 class="text-muted">Total: <%out.print(todos); %></h5>
                      </div>
                      <div class="progress progress-md">
					  <div class="progress-bar bg-warning" role="progressbar" style="width: <%out.print(todos); %>%" aria-valuenow="<%out.print(todos); %>" aria-valuemin="0" aria-valuemax="100"></div>   
					  </div>
                    </div>
                  </div>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">InProgress Tasks</h4>                      
                      <div class="d-flex justify-content-between">
                        <h5 class="text-muted">Total: <%out.print(inprogress); %></h5>
                      </div>
                      <div class="progress progress-md">
					  <div class="progress-bar bg-primary" role="progressbar" style="width: <%out.print(inprogress); %>%" aria-valuenow="<%out.print(inprogress); %>" aria-valuemin="0" aria-valuemax="100"></div>   
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                    
                      <h4 class="card-title">Completed Tasks</h4>
                      <div class="d-flex justify-content-between">
                        <h5 class="text-muted">Total:<%out.print(completed); %></h5>
                      </div>
                      <div class="progress progress-md">
					  <div class="progress-bar bg-info" role="progressbar" style="width: <%out.print(completed); %>%" aria-valuenow="<%out.print(completed); %>" aria-valuemin="0" aria-valuemax="100"></div>   
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-xl-3 grid-margin stretch-card">
                  <div class="card ">
                    <div class="card-body">
                      <h4 class="card-title">Tasks Pending Approval</h4>
                      <div class="d-flex justify-content-between">
                        <h5 class="text-muted">Total: <%out.print(totalpaproval); %></h5>
                      </div>
                      <div class="progress progress-md">
					  <div class="progress-bar bg-danger" role="progressbar" style="width: <%out.print(totalpaproval); %>%" aria-valuenow="<%out.print(totalpaproval); %>" aria-valuemin="0" aria-valuemax="100"></div>   
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              
            <!--   ---------------End user dash------- -->

            		<div class="card">
            <div class="card-body">
              <h4 class="card-title">Tasks Pending Action</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                  <form name="form1" id="form1" action="/ContitouchH/TaskActions"  method="post">
                    <table id="order-listing" class="table table-dark">
                     
					  <thead>
                        <tr>
                            <th>Task-ID#</th>
                            <th>Task Name</th>
                            <!-- <th>AssignedTo</th> -->
                            <th>Lead</th>
                            <!-- <th>AssignedDate</th> -->
                            <th>DueDate</th>
                             <th>Priority</th>
                            <!--<th>ProjectName</th>
                            <th>CLient</th> -->
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
						String val = "TRUE", vall = "0";
						String myuser = session.getAttribute("User").toString();
						
						
						/* String query="SELECT users.name FROM tasks INNER JOIN users ON tasks.assignedto=users.email WHERE tasks.task_id = 8"; */
						
						String query="SELECT users.name, tasks.task_id, tasks.tname,tasks.assigneddate,tasks.duedate, tasks.priority, tasks.todo_status"
						+	" FROM tasks INNER JOIN users ON tasks.leader=users.email"
						+	" where tasks.todo_status = '"+vall+"' AND tasks.del_indicator != '"+val+"' AND tasks.assignedto = '"+myuser+"'  "
						+	" order by tasks.task_id DESC ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){ 
							String status = rs.getString("tasks.todo_status");
							int statusp = Integer.parseInt(status);
							%>
							
                        <tr>
                        
                        
                        	<td><%=rs.getString("tasks.task_id") %></td>
        		  			<td><%=rs.getString("tasks.tname") %></td>
            	  			<td><%=rs.getString("users.name") %></td>
            	  			<%-- <td><%=rs.getString("tasks.assigneddate") %></td> --%>
            	  			<td><%=rs.getString("tasks.duedate") %></td>
            	  			 <td><%=rs.getString("priority") %></td>
            	  			<%--<td><%=rs.getString("project_name") %></td>
            	  			<td><%=rs.getString("client") %></td> --%>
                           
                            <td>
                            
                            
                            
                            	   <!-- get table values -->						
	  							 <input type="hidden" name="first" id="first" >
       							 <input type="hidden" name="second" id="second">
       							 <input type="hidden" name="third" id="third">
	  							 <!------------buttons ------ -->
                              <!-- <button class="btn btn-outline-primary" onclick="window.location.href = 'alljobs.jsp';">View</button> -->
                              <!-- <button  class="btn btn-info" name="viewtasks" id="viewtasks">View</button> -->
                            
                            
                         
                              <button class="btn btn-outline-info" name="todo_addnote" id="todo_addnote" >Pick</button>
                         
                            
                              
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
								System.out.println(e); 
    							
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
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
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

