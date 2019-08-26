<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <%String useremail =  session.getAttribute("User").toString();
     			 //String duetoday_notify = session.getAttribute("duetoday").toString();
     			 
        		  String overduetasks_notify = session.getAttribute("overduetasks").toString();
        		  String tototaloverdueprojects = session.getAttribute("totalcancelled").toString();
        		  
                  int overduetasksadmin = Integer.parseInt(overduetasks_notify);
                  int tototaloverdue = Integer.parseInt(tototaloverdueprojects);

                  
                  %>
          <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <div class="nav-link d-flex">
                <div class="profile-image">
                   <img src="images/favicon.ico" alt="image">
                 </div>
                <div class="profile-name">
                  <p class="name">
                	Logged in as
                   <%-- <%out.print(useremail); %> --%>
                  </p>
                  <p class="designation">
                    Administrator
                  </p>
                </div>
              </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="HomeAdmin.jsp">
            <i class="mdi mdi-shield-check menu-icon"></i>
            <span class="menu-title">Dashboard</span>
            </a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="client.jsp">
            <i class="mdi mdi-checkbox-multiple-marked-circle-outline menu-icon"></i>
            <span class="menu-title">Easy Nav </span>
            </a>
          </li>
          
                    <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#general-pages" aria-expanded="false" aria-controls="general-pages">
            <i class="mdi mdi-view-quilt menu-icon"></i>
            <span class="menu-title">Project n Tasks</span>
            <i class="menu-arrow"></i>
            </a>
            
            <div class="collapse" id="general-pages">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="project.jsp">Create Project</a></li>
                 <li class="nav-item"> <a class="nav-link" href="addtask.jsp">Create Task</a></li>
                 <li class="nav-item"> <a class="nav-link" href="project-tasks.jsp">All Tasks/Project</a></li>
                 <li class="nav-item"> <a class="nav-link" href="alltasks.jsp">All Tasks </a></li>
                 <li class="nav-item"> <a class="nav-link" href="approve-d.jsp">Approve/Decline Tasks </a></li>
                <li class="nav-item"> <a class="nav-link" href="allprojects.jsp">Project Stats </a></li>
                <li class="nav-item"> <a class="nav-link" href="alloverdue.jsp">Overdue Tasks<span class="badge badge-pill badge-danger"><% if(overduetasksadmin != 0){ out.print(overduetasksadmin); } else{}%> </span></a></li>
				<li class="nav-item"> <a class="nav-link" href="allprojects.jsp">Overdue Projects<span class="badge badge-pill badge-danger"><% if(tototaloverdue != 0){ out.print(tototaloverdue); } else{}%> </span></a></li>
				             
              </ul>
            </div>
         
          </li>
        

          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
            <i class="mdi mdi-view-headline menu-icon"></i>
            <span class="menu-title">Jobs <span class="badge badge-pill badge-info"></span></span>
            <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
              <ul class="nav flex-column sub-menu">
               <!--  <li class="nav-item"><a class="nav-link" href="job.jsp">Create</a></li> -->
                <li class="nav-item"><a class="nav-link" href="alljobs.jsp">View All</a></li>
                <!-- <li class="nav-item"><a class="nav-link" href="uaddjob.jsp">Pin Job to Project </a></li> -->
               <!--  <li class="nav-item"><a class="nav-link" href="alljobsvu.jsp">View pinned Jobs</a></li> -->
                
              </ul>
            </div>

          </li>
     
         
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
            <i class="mdi mdi-emoticon-excited-outline menu-icon"></i>
            <span class="menu-title">Clients</span>
            <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="icons">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="client.jsp">Add Client</a></li>
                <li class="nav-item"> <a class="nav-link" href="clientbrief.jsp">Client Brief</a></li>
                <li class="nav-item"> <a class="nav-link" href="allclients.jsp">View All</a></li>
                
              
              </ul>
            </div>
          </li>

          
          
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
            <i class="mdi mdi-account-circle menu-icon"></i>
            <span class="menu-title">Users</span>
            <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="auth">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="createuser.jsp"> Create </a></li>
                <li class="nav-item"> <a class="nav-link" href="allusers.jsp">Update </a></li>
             
              </ul>
            </div>
          </li>
          
          
          
          <li class="nav-item">
            <a class="nav-link" onClick="javascript:Log_out()">
            <i class="mdi mdi-power menu-icon"></i>
            <span class="menu-title">Signout</span>
            </a>
          </li>
          
          
      

         
          
        </ul>
      </nav>


</html>