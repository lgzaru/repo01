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
                          <h5 class="modal-title" id="exampleModalLabel-2">Jobs</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
        				<div class="modal-body">
        				
        				
        				
        				<table id="mytable" class="table">
                     
					  <thead>
 <tr>
                            <th>ID #</th>
                            <th>Job Name</th>
                            <th>Description</th>
                            <th>Priority</th>
                            <th>TimeTaken</th>
                            <th>AssignedDate</th>
                            <th>DateCompleted</th>
                            <th>CLient</th>
                            
                        </tr>
                      </thead>
                      
                      
                      
                      <tbody>
                      
                      <%Connection mysqlConn = null;
						try{
    					mysqlConn = ConMysqlLocalhost.getMySqlConnection();
    					
    					
    					String jid =  session.getAttribute("mycon1").toString();
    					session.setAttribute("mycon2",jid);

						Statement stmt = null;
						stmt = mysqlConn.createStatement();
						ResultSet resultset =null;
						String val = "TRUE";
						String query="select *  from jobs where del_indicator != '"+val+"' AND id = '"+jid+"'   ";
						ResultSet rs=stmt.executeQuery(query);
				
						while(rs.next()){  %>
                        <tr>
                        
                        
                        	<td><%=rs.getString("id") %></td>
        		  			<td><%=rs.getString("jname") %></td>
            	  			<td><%=rs.getString("jobdesc") %></td>
            	  			<td><%=rs.getString("priority") %></td>
            	  			<td><%=rs.getString("timetaken") %></td>
            	  			<td><%=rs.getString("assigneddate") %></td>
            	  			<td><%=rs.getString("datecompleted") %></td>
            	  			<td><%=rs.getString("Client") %></td>
                           
                            <td>
                   
							<%}%>
                                		</tbody>
          					                                
                			</table>
    						<%rs.close();
			    			stmt.close();
    						mysqlConn.close();
    							}
							catch(Exception e){
    							e.printStackTrace();
    			
									}%> 
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                        </div>
        </div>
    </div>
</div>
</body>
</html>



