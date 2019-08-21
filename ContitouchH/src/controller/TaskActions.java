package controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.ConMysqlLocalhost;
import functions.SendEmail;

/**
 * Servlet implementation class TaskActions
 */
@WebServlet("/TaskActions")
public class TaskActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskActions() { 
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		java.sql.Connection mysqlConn = null;
		PrintWriter out = response.getWriter();
		

		
		
 if (request.getParameter("update_addnote") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				
				String mycomments = request.getParameter("mycomments");
				String statusval = request.getParameter("statusval");
				System.out.println("mycomments is="+mycomments);
				System.out.println("statusval is="+statusval);
				
				String taskid = request.getParameter("taskid");
				HttpSession session = request.getSession(true);
				String username = session.getAttribute("User").toString();

				//String val2 = "1";
				String todo_status = "1";
				
				System.out.println("taskid is="+taskid);
				
				switch(String.valueOf(statusval)) {
				
				//(String.valueOf(value)
					
				case "1":
					
					stmt.executeUpdate("UPDATE tasks SET usercomments='"+mycomments+"',todo_status='"+todo_status+"',complete_status='"+statusval+"', taskenddate=CURDATE()    WHERE  task_id ='"+taskid+"'   ");
					System.out.print("Task completed Successfully!");
					
					
					ResultSet rs = null;
					rs = stmt.executeQuery("select * from tasks where assignedto = '"+username+"'    ");
					if (rs.next()) {
						
						String adminemail = rs.getString("createdby");
						String taskname = rs.getString("tname");
						String projectname = rs.getString("project_name");
						String useremail = rs.getString("assignedto");
						
						SendEmail.SendMailTaskCompleted(adminemail, taskname, projectname,useremail, request, response);
					
						
						out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('auto-close')        ");
						out.println("});");
						out.println("</script>");
						
						RequestDispatcher rd = request.getRequestDispatcher("timeline.jsp");
						rd.include(request, response);
						
						System.out.print("Email sent successfully to admin!");
					
						
					}
					
					else {
						
						out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('warning-message-and-cancel')  ");
						out.println("});");
						out.println("</script>");
						response.sendRedirect("timeline.jsp");
						
					}
					
			
					
					
					break;
					
				case "null":
					
					stmt.executeUpdate("UPDATE tasks SET usercomments='"+mycomments+"',todo_status='"+todo_status+"'    WHERE  task_id ='"+taskid+"'   ");
					System.out.print("Note Added Successfully!");
										
					out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('auto-close')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("timeline.jsp");
					
					break;
				
				
				
				}
				
				

				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			     
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close if condition = true
	    	
	    }
 
 
/* else if (request.getParameter("update_addnote") != null) {
     //delete button is clicked
     //Do the delete action or forward the request to the servlet to do delete action
	

	try{

		
	    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

		
		java.sql.Statement stmt = null;
		stmt = mysqlConn.createStatement();
		
		
		String mycomments = request.getParameter("mycomments");
		System.out.println("testing id="+jid);
		
		//String val = "TRUE";
		
		stmt.executeUpdate("UPDATE tasks SET usercomments='"+mycomments+"'   WHERE  task_id ='"+jid+"'  ");
		System.out.print(" Noted added Successfull!");
		response.sendRedirect("alltasks.jsp");
		
	}

	catch(Exception e){
	
	      System.out.println(e); 
	     
	}

	finally {		
		try {
			mysqlConn.close();
		}
		catch (Exception ignore) {
		}
	}//close if condition = true
	
}*/
	    
	    
	    
	    else if (request.getParameter("todo_addnote") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	
	    		String taskid = request.getParameter("taskid");
		
				System.out.print("Success view:"+taskid);
			    //response.sendRedirect("timelineu.jsp");
			
			
			
			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
		
				
				String val = "1";
				
				stmt.executeUpdate("UPDATE tasks SET todo_status='"+val+"',taskstartdate = CURDATE()   WHERE  task_id ='"+taskid+"'  ");
				System.out.print("Update Successfull!");
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')  ");
				out.println("});");
				out.println("</script>");
				
				response.sendRedirect("timeline.jsp");
				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			     
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close if condition = true
			
			
			
			
			
			
			
			
			
			
				
			}
	    
	    
		
		
		
		
	}

}
