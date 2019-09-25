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
		  
		     		  <%String userName2 =  session.getAttribute("User").toString();
		     	
		     		  %>
		  
		  
		<script>
		 function Log_out()
		 {
		     var hi= confirm("Are you sure you want to logout?");
		     if (hi== true){
		         //alert("Ok");
		         window.location.href = 'login.jsp';
		         
		     }else{
		         alert("Cancel");

		        window.location.href = 'alltasks.jsp';
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
<%@include file = '/Views/nav/navigationu.jsp' %>
          <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
		
		
		
<%@include file = '/Views/nav/header.jsp' %>	

         <div class="mt-4 py-2 border-top border-bottom">
                        <ul class="nav profile-navbar">
                          <li class="nav-item">
                            <a class="nav-link active" href="usertasks.jsp">
                              <i class="mdi mdi-checkbox-blank-circle-outline"></i>
                              ToDo Tasks : <%out.print(todos); %>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link active" href="usertasksinprogress.jsp">
                              <i class="mdi mdi-check"></i>
                              In Progress: <%out.print(inprogress); %>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link active" href="fallprojects.jsp">
                              <i class="mdi mdi-check-all"></i>
                              Completed Tasks:<%out.print(completed); %>
                            </a>
                          </li>
                          
                          <li class="nav-item">
                            <a class="nav-link active" href="pending-approval.jsp">
                              <i class="mdi mdi-av-timer"></i>
                              Pending Approval: <%out.print(totalpaproval); %>
                            </a>
                          </li>
                          
                          
                          <li class="nav-item">
                            <a class="nav-link active" href="#">
                              <i class="mdi mdi-clock-start"></i>
                              On Hold: <%out.print(tasksonhold); %>
                            </a>
                          </li>
                      
                        </ul>
           </div>	


		<br><br>		
		<div class="card">
            <div class="card-body">
              <h4 class="card-title">Tasks Pending Action</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                  <form name="form1" id="form1" action="/ContitouchH/TaskActions"  method="post">
                    <table id="order-listing" class="table">
                     
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
						String val = "TRUE", vall = "1";
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
                            
                            
                         
                              <button class="btn btn-outline-info" name="todo_addnote" id="todo_addnote" >View</button>
                         
                            
                              
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
