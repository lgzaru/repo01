<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="functions.UserDash" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

          <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <div class="nav-link d-flex">
                <div class="profile-image">
                   <img src="images/favicon.ico" alt="image">
                 </div>
                <div class="profile-name">
                  <p class="name">
                  <% 
                  

                  UserDash obj = new UserDash();
	     			obj.getUserDash(request, response); 
	     			
                  String todos =  session.getAttribute("todos_session").toString();
                  int totaltodos = Integer.parseInt(todos);
                  
                  String useremail2 =  session.getAttribute("User").toString();%>
                   <%out.print(useremail2); 
                   
                   
	     			
	     			
	     			
	     			String totaljobs =  session.getAttribute("totaljobs_session").toString();
	     			int totaljobz = Integer.parseInt(totaljobs);
	     			
	     			String completed =  session.getAttribute("completed_session").toString();
	     			int completedz = Integer.parseInt(completed);
	     			
	     			String inprogress =  session.getAttribute("inprogress_session").toString();	
	     			int inprogresz = Integer.parseInt(inprogress);
	     			
	     			String totalpaproval =  session.getAttribute("totalpaproval_session").toString();
	     			int totalpaprovalz = Integer.parseInt(totalpaproval);
	     			
	     			String tasksonhold =  session.getAttribute("tasksonhold_session").toString();
	     			int tasksonholdz = Integer.parseInt(tasksonhold);
                   
                   
                   %>
                  </p>
                  <p class="designation">
                    Standard User
                  </p>
                </div>
              </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="HomeUser.jsp">
            <i class="mdi mdi-shield-check menu-icon"></i>
            <span class="menu-title">Dashboard</span>
            </a>
          </li>
          
                    <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#general-pages" aria-expanded="false" aria-controls="general-pages">
            <i class="mdi mdi-view-quilt menu-icon"></i>
           
            <span class="menu-title">Tasks</span>
            <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="general-pages"> 
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="usertasks.jsp">My tasks<span class="badge badge-pill badge-warning"><%if(totaltodos != 0){ out.print(totaltodos);} %></span> </a></li>
                <li class="nav-item"> <a class="nav-link" href="usertasksinprogress.jsp">In Progress<span class="badge badge-pill badge-warning"><%if(inprogresz != 0){ out.print(inprogresz);} %></span></a></li>
                <li class="nav-item"> <a class="nav-link" href="pending-approval.jsp">Pending Approval<span class="badge badge-pill badge-info"><%if(totalpaprovalz != 0){ out.print(totalpaprovalz);} %></span> </a></li>
                <li class="nav-item"> <a class="nav-link" href="fallprojects.jsp">Completed Tasks<span class="badge badge-pill badge-info"><%if(completedz != 0){ out.print(completedz);} %></span> </a></li>
             
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
   				<li class="nav-item"><a class="nav-link" href="job.jsp">Create</a></li>
                <li class="nav-item"><a class="nav-link" href="managealljobs.jsp">View All</a></li>             
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