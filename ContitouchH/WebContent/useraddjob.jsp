<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*" import =  "conn.ConMysqlLocalhost"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Contitouch</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
  <%@include file = 'sessions.jsp' %>

<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#myModal").modal('show');
    });
</script>
<%String project =  session.getAttribute("pname_session").toString();
String project_id =  session.getAttribute("pid_session").toString();
String client =  session.getAttribute("cclient").toString();
String lead =  session.getAttribute("llead").toString();

String assignedto =  session.getAttribute("User").toString();

session.setAttribute("pname_session1",project);
session.setAttribute("pid_session1",project_id);

%>

</head>
<body>
<div id="myModal" class="modal fade " >
    <div class="modal-dialog modal-lg" style="width:1200px;">
        <div class="modal-content">
            <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">Task for: [<%out.print(project); %>]</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
        				<div class="modal-body" >
        				
        				
        				
        <div class="card">
                <div class="card-body" style="background-color:#D3D3D3" >
                
                  <h1 class="card-title">Create Task</h1>
                  
                    <p class="card-description">
                      Details...
                    </p>
                    <form class="form-sample" action="/ContitouchH/ProjectActions" method="post" >
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label"><strong>Task Name</strong></label>
                          <div class="col-sm-9">
                            <input type="text" name="tname" id="tname" class="form-control" />
                          </div>
                        </div>
                      </div>
                      
                          
                      <div class="col-md-4">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label"><strong>Priority</strong></label>
                          <div class="col-sm-9">
                            <select name="priority" id="priority" class="form-control" >
                              <option  value="high">High</option>
                              <option  value="low">Low</option>
                            </select>
                          </div>
                        </div>
                      </div>
                   
                      </div>
                      
                      <div class="row">
                      <div class="col-md-6">
                         <div class="form-group row">
                          <label class="col-sm-3 col-form-label"><strong>Assigned To</strong></label>
                          <div class="col-sm-9">
                          
				                <% Connection mysqlConn = null;
								try{
				
				    			mysqlConn = ConMysqlLocalhost.getMySqlConnection();
				
								Statement stmt = null;
								stmt = mysqlConn.createStatement();
								ResultSet resultset =null;
								String val = "User";
								resultset =stmt.executeQuery("select name, email, pnumber from users where userroles = '"+val+"'  ") ;
								%>
                                        
                             
               <select name="assignedto" id="assignedto" class="form-control">
               <option value="">Choose One</option>
               <% while(resultset.next()){ 
             
            	   
               %>
               <option value="<%= resultset.getString("email")%>"><%= resultset.getString("name")%></option>
				<% }%>
                                            
                                         
               </select>
               <% }

			   catch(Exception e){

			   out.println("wrong entry"+e);
               }%> 
                          </div>
                        </div>
                      </div>
                   
                
                      
                          <div class="col-md-4">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label"><strong>Client</strong></label>
                          <div class="col-sm-9">
                            <input type="text" name="client" id="client" value="<%out.print(client); %>" class="form-control" disabled />
                          </div>
                        </div>
                      </div>
                      </div>
                      
                
                <div class="row">
                      
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label"><strong>Due Date</strong></label>
                          <div class="col-sm-9">
                            <input class="form-control" type="date" name="duedate" id="duedate" placeholder="dd/mm/yyyy"/>
                          </div>
                        </div>
                      </div>
                    
                    
 					<div class="col-md-4">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label"><strong>Project Name</strong></label>
                          <div class="col-sm-9">
                            <input type="text"  value="<%out.print(project); %>" class="form-control" name="projectname" id="projectname" disabled />
                             <%-- <input type="hidden"  name="assignedto" id="assignedto" value="<%out.print(assignedto); %>" /> --%>
                          </div>
                        </div>
                      </div>
                    </div>
					  

                 
                     
                     
                   <div class="row">	  
					<div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label"><strong>Task Description</strong></label>
                          <div class="col-sm-9">
                            <textarea class="form-control" id="tdesc" name="tdesc" rows="8"></textarea>
                          </div>
                        </div>
                      </div>
                      
                      </div>
					  
                  <button type="submit" class="btn btn-primary mr-2" name="addj2" id="addj2">Submit</button>
                    <button type="reset" class="btn btn-light">Cancel</button>
                    
                    </div>
                    </form>

                </div>
              </div>
              <div class="modal-footer">
                          <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                        </div>
                        </div>
                        
        </div>
    </div>
</body>
</html>



