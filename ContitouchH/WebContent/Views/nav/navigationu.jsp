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
                  String todoz =  session.getAttribute("todos_session").toString();
                  int totaltodos = Integer.parseInt(todoz);
                  
                  String useremail2 =  session.getAttribute("User").toString();%>
                   <%out.print(useremail2); %>
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
           
            <span class="menu-title">Projects<span class="badge badge-pill badge-info"><% if(totaltodos != 0){ out.print(totaltodos); }%></span></span>
            <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="general-pages">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="timeline.jsp">My tasks<span class="badge badge-pill badge-info"><%if(totaltodos != 0){ out.print(totaltodos);} %></span> </a></li>
                <li class="nav-item"> <a class="nav-link" href="pending-approval.jsp">Pending Approval </a></li>
                <li class="nav-item"> <a class="nav-link" href="fallprojects.jsp">Completed </a></li>
             
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