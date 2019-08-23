<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*" import =  "conn.ConMysqlLocalhost" import="functions.UserDash" import= "java.time.LocalDate"
    import="java.time.Month" import="java.time.temporal.ChronoUnit" import="java.util.*" import ="java.util.Date"%>   
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
  
    <link rel="stylesheet" href="vendors/select2/select2.min.css">
  <link rel="stylesheet" href="vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/vertical-layout-light/style.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon1.png" />
  <%@include file = 'sessions.jsp' %>
    <% UserDash obj = new UserDash();
	obj.getUserDash(request, response); 
	
	
	
	String totaljobs =  session.getAttribute("totaljobs_session").toString();	
	String completed =  session.getAttribute("completed_session").toString();	
	String inprogress =  session.getAttribute("inprogress_session").toString();	
	String todos =  session.getAttribute("todos_session").toString();
	
	%>
  
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
                
                
                <div class="mt-4 py-2 border-top border-bottom">
                        <ul class="nav profile-navbar">
                          <li class="nav-item">
                            <a class="nav-link active" href="#">
                              <i class="mdi mdi-checkbox-blank-circle-outline"></i>
                              ToDo Tasks : <%out.print(todos); %>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link active" href="#">
                              <i class="mdi mdi-check"></i>
                              In Progress: <%out.print(inprogress); %>
                            </a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link active" href="#">
                              <i class="mdi mdi-check-all"></i>
                              Completed Tasks:<%out.print(completed); %>
                            </a>
                          </li>
                         <%--  <li class="nav-item">
                            <a class="nav-link active" href="#">
                              <i class="mdi mdi-check-circle"></i>
                              Total Jobs:<%out.print(totaljobs); %>
                            </a>
                          </li> --%>
                        </ul>
                      </div>
                
                
                
                
                
                 
                </div>
              </div>
            </div>
<!--             <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                
                
                
                
                
                
                
                
                  
                </div>
              </div>
            </div> -->


 


   
          </div>
          
          
          <div class="content-panel">
                <div class="card-body">
                  <h3 class="card-title">Task Manager</h3>
                  <p class="card-description">
                    Shows ToDo/InProgress
                  </p>
                  <div class="row">
                    <div class="col-md-6">
                      <h3 class="card-title" align="center"><u>Todo</u></h3>
                      <div id="dragula-event-left" class="py-2">
                      
                      
                        <%Connection mysqlConn = null;
                        
                		String username =  session.getAttribute("User").toString();	
                		System.out.println("Testing"+username);

						try{
    					mysqlConn = ConMysqlLocalhost.getMySqlConnection();

						Statement stmt = null;
						stmt = mysqlConn.createStatement();
						ResultSet resultset =null;
						String val = "0";
						String val2 = "Completed";
						String query="select *  from tasks where assignedto = '"+username+"' AND todo_status='"+val+"' AND complete_status ='"+val+"' GROUP BY task_id DESC     ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>

                        <div class="card rounded border mb-2">
                          <div class="card-body p-3">
                            <div class="media">
                              <i class="mdi mdi-check icon-sm text-primary align-self-center mr-3"></i>
                              <div class="media-body">
                                <h6 class="text-secondary">Task Name: <%=rs.getString("tname") %></h6>
                                <h6 class="text-secondary">Assigned On: <%=rs.getString("assigneddate") %></h6>
                                <h6 class="text-danger">Due On: <%=rs.getString("duedate") %></h6>
                                <h6 class="text-info">Lead: <%=rs.getString("leader") %></h6>
                                <h6 class="text-warning">Project: <%=rs.getString("project_name") %></h6>
                                
                                <p class="mb-0 text-info">
                                  Description: <%=rs.getString("tdesc") %> 
                                                                
                                </p>
                                
                                <p class="mb-0 text-warning">
                                  <a href="<%=rs.getString("fileurl") %> "><%=rs.getString("filename") %> </a>
                                                                
                                </p>
                                
 								
                                 
                                <div align="right">
                                <form id="mytaskid" action="/ContitouchH/TaskActions" method="post">
                                
                                <input type="hidden" value="<%=rs.getString("task_id") %>" name="taskid" id="taskid" >
                                <button type="submit" name="todo_addnote" align="center" class="btn btn-outline-warning btn-icon-text " >Pick<i class="mdi mdi-file-check btn-icon-append"></i> </button>
                                
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
                      <h3 class="card-title mt-4 mt-md-0" align="center"><u>In Progress</u></h3>
                      <div id="dragula-event-right" class="py-2">
                       
                      <%
                        
                		//String username =  session.getAttribute("User").toString();	
                		System.out.println("hw far:"+username);

						try{
    					mysqlConn = ConMysqlLocalhost.getMySqlConnection();

						Statement stmt = null;
						stmt = mysqlConn.createStatement();
						ResultSet resultset =null;
						String val = "1";
						String val2 = "1";
						String query="select *  from tasks where assignedto = '"+username+"' AND todo_status='"+val+"' AND complete_status !='"+val2+"' GROUP BY task_id DESC     ";
						ResultSet rs=stmt.executeQuery(query);
						
						
						
						
				
						while(rs.next()){ 
							
					 		Date dueDate = rs.getDate("duedate");
							Date startDate = rs.getDate("taskstartdate");
							
							long daysBetween = dueDate.getTime() -  startDate.getTime();
							long dueOn = (daysBetween / (1000*60*60*24));
							
							System.out.println("--------------------");

							System.out.println("first date:"+dueDate);
							System.out.println("second date:"+startDate);
							System.out.println("Days left:"+dueOn); 
							%>
						
			
                      
                        

 						<div class="card rounded border mb-2">
                          <div class="card-body p-3">
                            <div class="media">
                              <i class="mdi mdi-check-all icon-sm text-primary align-self-center mr-3"></i>
                              <div class="media-body">
                                <h6 class="text-primary" align="center">Task Name: <%=rs.getString("tname") %></h6>
                                <pre class="text-danger">Due On: <%=rs.getString("duedate") %>
                                <br>Days Left: <%out.print(dueOn); %>
                                <br><a class="text-primary">Description: <%=rs.getString("tdesc") %></a> 
                                </pre>
                                <h6 class="text-info">Lead: <%=rs.getString("leader") %></h6>
                                <h6 class="text-secondary">Project:<%=rs.getString("project_name") %></h6>
                                
                                <p class="text-secondary">
                                  Description: <%=rs.getString("tdesc") %> 
                                                                
                                </p>
                                
                                <p class="text-primary">
                                 <a href="<%=rs.getString("fileurl") %> "><%=rs.getString("filename") %> </a>
                                                                
                                </p>
                                
 								

                 <div class="mt-4">
                    <div class="accordion" id="accordion" role="tablist">            
                                
                      <div class="card">
                        <div class="card-header" role="tab" id="heading-2">
                          <h6 class="mb-0">
 							<!-- same here ....the below java snippet is being use by the accordian to colapse items individually -->
                            <a class="collapsed" data-toggle="collapse" href="#collapse-<%=rs.getString("task_id") %>" aria-expanded="false" aria-controls="collapse-<%=rs.getString("task_id") %>">
                              <code>Tasks Notes</code>
                            </a>
                          </h6>
                        </div>
                        <!-- same here ....the below java snippet is being use by the accordian to colapse items individually -->
                        <div id="collapse-<%=rs.getString("task_id") %>" class="collapse" role="tabpanel" aria-labelledby="heading-2" data-parent="#accordion">
                          <div class="card-body">
                          
                          <!-- new code here -->
                         
                         
                                                          
                                
                                <form id="mytaskid" action="/ContitouchH/TaskActions" method="post">
                                
                                 
                               <input type="hidden" value="<%=rs.getString("task_id") %>" name="taskid" id="taskid" >
                               <textarea class="text-danger form-control" id="mycomments" name="mycomments" rows="6"  ><%=rs.getString("usercomments") %></textarea><br>
                               
                           <div class="row">     
                           <div class="form-check form-check-primary">
                            <label class="form-check-label">
                              <input type="checkbox" name="statusval" class="form-check-input" >
                              Completed
                            <i class="input-helper"></i></label>
                          </div>
                          &nbsp;&nbsp;&nbsp;
                          <!--  <div class="form-check form-check-danger">
                            <label class="form-check-label">
                              <input type="checkbox" class="form-check-input">
                              Cancel
                            </label>
                          </div> -->
                 
                         
                          </div>
                          
                          <div align="right"><button type="submit" name="update_addnote" align="center" class="btn btn-outline-info btn-icon-text " >Update<i class="mdi mdi-file-check btn-icon-append"></i> </button></div>
                          
                            
                                </form>
                                
                                 <!-- end new code -->
                         
                            <p class="text-success">
                              <i class="mdi mdi-alert-octagon mr-2"></i>All completed tasks will not appear in the In Progress section.
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
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <script src="js/settings.js"></script>
  <script src="js/todolist.js"></script>
  <!-- endinject -->
  <!-- plugin js for this page -->
  <!-- plugin js for this page -->
  <script src="vendors/typeahead.js/typeahead.bundle.min.js"></script>
  <script src="vendors/select2/select2.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="js/file-upload.js"></script>
  <script src="js/typeahead.js"></script>
  <script src="js/select2.js"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
