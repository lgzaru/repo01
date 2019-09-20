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
</head>
<body>
<div id="myModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">Edit Projects</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
        				<div class="modal-body">
        				
        				
        				<form name="form1" id="form1" action="/ContitouchH/ProjectActions"  method="post">
        				<table id="mytable1" class="table">
                     
					  <thead>
                        <tr>
                            <th>ID #</th>
                            <th>Project Name</th>
                            <th>Company</th>
                            <!-- <th>AssignedTo</th> -->
                            <th>Lead</th>
                            <th>StartDate</th>
                            <th>EndDate</th>
                            <th>Status</th>
                            <th>Priority</th>
                            
                        </tr>
                      </thead>
                      
                      
                      
                      <tbody>
                      
                      <%Connection mysqlConn1 = null;
						try{
    					mysqlConn1 = ConMysqlLocalhost.getMySqlConnection();
    					
    					
    					String jid =  session.getAttribute("mycon1").toString();
    					session.setAttribute("mycon2",jid);
    					
						Statement stmt = null;
						stmt = mysqlConn1.createStatement();
						ResultSet resultset =null;
						String val = "TRUE";
						//String query="select *  from projects where del_indicator != '"+val+"' and id = '"+jid+"'   ";
						String query="select projects.id, projects.pname,projects.company,users.name, projects.project_start, projects.project_end,projects.status,projects.priority from projects INNER JOIN users ON projects.leader=users.email where projects.del_indicator != '"+val+"' AND projects.id = '"+jid+"'   ";

						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>
                        <tr>
                        
                        
                        	<td><input class=" form-control" type="text" name="id"  value="<%=rs.getString("projects.id") %>" disabled></td>
        		  			<td><input class=" form-control" type="text" name="pname" value="<%=rs.getString("projects.pname") %>" disabled ></td>
            	  			<td><input class=" form-control" type="text" name="company" value="<%=rs.getString("projects.company") %>" disabled ></td>
            	  			
            	  			
                            
            	  			<%-- <td><input class=" form-control" type="text" name="assignedto" value="<%=rs.getString("assignedto") %>" disabled ></td> --%>
            	  			<td><input class=" form-control" type="text" name="lead" value="<%=rs.getString("users.name") %>"disabled ></td>
            	  			<td><input class="form-control" type="date" name="project_start" value="<%=rs.getString("projects.project_start") %>" ></td>
            	  			           	  			
            	  			
            	  			<td><input class=" form-control" type="date" name="project_end" value="<%=rs.getString("projects.project_end") %>"  ></td>
            	  			<td>
            	  			<select name="status" id="status" class="form-control" >
                              <option  value="<%=rs.getString("projects.status") %>">Status</option>
                              <option value="1">Pending Action</option>
            	  			 <option value="8">In Progress</option>
                              <option value="2">In Studio</option>
                              <option value="3">Waiting Further Details From Client</option>
                              <option value="4">In Photography</option>
                              <option value="5">Waiting Approval</option>
                              <option value="6">Waiting Feedback</option>
                              <option value="7">Client Still Reviewing</option>
							  <option value="9">Completed</option>
							   <option value="10">UAT</option>
							    <option value="11">On Hold</option>
                            </select>
            	  			</td>
            	  			
            	  			
            	  			<td>
            	  			<select name="priority" id="priority" class="form-control" >
                              <option  value="high"><%=rs.getString("projects.priority") %></option>
                              <option  value="high">High</option>
                              <option  value="low">Low</option>
                            </select>
                            </td>
            	  			
  						
            	  			
                        </tr>
                   
							<%}%>
                                		</tbody>
          					                                
                			</table>
                			
                			<div class="modal-footer">
                          <button type="button"  class="btn btn-default" data-dismiss="modal">Close</button>
                          <button type="submit" name="update1" class="btn btn-success" >Update</button>
                        </div>
									
						</form>
                			
                			
    						<%rs.close();
			    			stmt.close();
    						mysqlConn1.close();
    							}
							catch(Exception e){
    							e.printStackTrace();
    			
									}%> 
									
						<div class="modal-footer">
                <!--           <button type="button"  class="btn btn-default" data-dismiss="modal">Close</button>
                          <button type="submit" name="update1" class="btn btn-success" data-dismiss="modal">Update</button> -->
                        </div>
									
						</form>
                        </div>
                       
        </div>
    </div>
</div>
</body>
</html>



