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
<link rel="shortcut icon" href="images/favicon.ico" />  
  		  
		  <%@include file = 'sessions.jsp' %>
		  
     <%String userName2 =  session.getAttribute("User").toString();
	

	
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
              <span class="nav-profile-name">Pages</span>
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
      

        
          <div class="row">
           

            <div class="col-md-12 ">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Task Details </h4>
                  <p class="card-description">details...
                  </p>
                  <div class="row">
                    <div class="col-4">
                      <ul class="nav nav-pills nav-pills-vertical nav-pills-info" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <li class="nav-item">
                          <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">
                            <i class="mdi mdi-home-outline"></i>
                            Task Description
                          </a>                          
                        </li>
                        
                        <li class="nav-item">
                          <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">
                            <i class="mdi mdi-pencil-box-outline"></i>
                           Actions
                          </a>                          
                        </li>
                      </ul>
                    </div>
                    
                    
                    <%Connection mysqlConn = null;
						try{
    					mysqlConn = ConMysqlLocalhost.getMySqlConnection();

						Statement stmt = null;
						stmt = mysqlConn.createStatement();
						ResultSet resultset =null;
						String val = "TRUE";
						String taskid = session.getAttribute("newtask_id").toString();

						String query="SELECT * from tasks"
								+ " where task_id = '"+taskid+"' AND del_indicator != '"+val+"'   ";

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
                    
                    
                    
                    <div class="col-8">
                      <div class="tab-content tab-content-vertical" id="v-pills-tabContent" >
                        <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                          <div class="media">
                            <div class="media-body">
                              <h5 class="mt-0">[Task: #<%=rs.getString("task_id") %>, Task Name: <%=rs.getString("tname") %>]</h5>
							  <br>
                              
                              <div class="card">
								<div class="card-body">
									<h4 class="card-title">Summary</h4>
									<ul class="bullet-line-list">
										<li>
											<h6>Task Name - <%=rs.getString("tname") %></h6>
											<p>Task ID: <%=rs.getString("task_id") %> </p><br>
											
										</li>
										<li>
											<h6>Due Date</h6>
											<p class="text-muted mb-4">
												<i class="mdi mdi-clock-outline"></i>
												<code><%=rs.getString("duedate") %></code>
											</p>
										</li>
										<li>
											<h6>Days Left</h6>
											<p class="text-muted">
												<i class="mdi mdi-clock-outline"></i>
												 <code>[<%out.print(dueOn); %> day]s </code>
											</p>
										</li>
									</ul>
								</div>
							</div>
							
							<br>
							<label for="exampleTextarea1"><strong>Task Description</strong></label><br>
                              <p>
                                <%=rs.getString("tdesc") %> 
                              </p>
                              
                            </div>
                          </div>
                        </div>
                      
                        <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                          <div class="media">
                             <div class="media-body">
                             <form name="form1" id="form1" action="/ContitouchH/TaskActions"  method="post">
							<h5 class="mt-0">[Task: #<%=rs.getString("task_id") %>, Task Name: <%=rs.getString("tname") %>]</h5>
								
								<div class="form-group">
								<label for="exampleTextarea1">Add comments...</label><br>
								<textarea class="form-control" id="mycomments" name="mycomments" placeholder="Type something here..." rows="4"><%=rs.getString("usercomments") %></textarea>
								<input type="hidden" name="taskid" id="taskid" value="<%out.print(taskid); %>" >
								</div>
								
								
								
								 <div class="form-check form-check-primary">
                            		<label class="form-check-label">
                              		<input type="checkbox" name="statusval" value="1" class="form-check-input" >
                              		Mark as Completed
                            		<i class="input-helper"></i></label><br>
                          		</div>
                          		
								
								 <button name = "update_addnote" id = "update_addnote" class="btn btn-info btn-icon-text">
									Update
									<i class="mdi mdi-pencil-box btn-icon-append"></i>                                                                              
								</button>
								
								</form>
                            </div>
                          </div>
                        </div>
                        
                        <%}rs.close();
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
            </div>
          
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
        <div class="footer-wrapper">
            <footer class="footer">
              <div class="d-sm-flex justify-content-center justify-content-sm-between">
                <span class="text-center text-sm-left d-block d-sm-inline-block">Copyright &copy; 2019. All rights reserved. </span>
                <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Designed by: <a href="https://www.contitouch.co.zw/" target="_blank">Contitouch</a>. </span>
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
  <script src="../../../../js/tabs.js"></script>
  <!-- End custom js for this page-->
</body>

</html>
