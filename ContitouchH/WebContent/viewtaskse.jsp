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
                          <h5 class="modal-title" id="exampleModalLabel-2">Edit Tasks</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
        				<div class="modal-body">
        				
        				
        				<form name="form1" id="form1" action="/ContitouchH/ProjectActions"  method="post">
        				<table id="mytable1" class="table">
                     
					  <thead>
                        <tr>
                             <th>Task-ID#</th>
                            <th>AssignedTo</th>
                            <th>Lead</th>
                            <th>ProjectName</th>
                            <th>Client</th>
                            <th>TaskName</th>
                            <th>AssignedDate</th>
                            <th>DueDate</th>
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
						String query="select *  from tasks where del_indicator != '"+val+"' and task_id = '"+jid+"'   ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>
                        <tr>
                        
                        
                        	<td><input class=" form-control type="text" name="taskid"  value="<%=rs.getString("task_id") %>" disabled></td>
        		  			<td><input class=" form-control type="text" name="assignedto" value="<%=rs.getString("assignedto") %>" disabled ></td>
        		  			<td><input class=" form-control type="text" name="lead" value="<%=rs.getString("lead") %>" disabled ></td>
        		  			<td><input class="form-control type="text" name="project_name" value="<%=rs.getString("project_name") %>" disabled></td>
            	  			<td><input class=" form-control type="text" name="client" value="<%=rs.getString("client") %>" disabled ></td>
        		  			<td><input class=" form-control type="text" name="tname" value="<%=rs.getString("tname") %>"  ></td>
        		  			
        		  			<td><input class=" form-control type="text" name="assigneddate" value="<%=rs.getString("assigneddate") %>"  ></td>
            	  			<td><input class=" form-control type="text" name="duedate" value="<%=rs.getString("duedate") %>"  ></td>
            	  			<td>
            	  			<select name="priority" id="priority" class="form-control" >
                              <option  value="high"><%=rs.getString("priority") %></option>
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
                          <button type="submit" name="updatetask" class="btn btn-success" >Update</button>
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



