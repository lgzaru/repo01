package controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.ConMysqlLocalhost;
import functions.ContiSMS;
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
		HttpSession session = request.getSession(true);
		

		
		
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
				String username = session.getAttribute("User").toString();

				//String val2 = "1";
				String todo_status = "2";
				
				System.out.println("taskid is="+taskid);
				
				switch(String.valueOf(statusval)) {
				
				//(String.valueOf(value)
					
				case "1":
					
					stmt.executeUpdate("UPDATE tasks SET usercomments='"+mycomments+"',todo_status='"+todo_status+"', taskenddate=CURDATE()    WHERE  task_id ='"+taskid+"'   ");
					System.out.print("Task completed, pending Approval!");
					
					ResultSet rs = null;
					rs = stmt.executeQuery("select * from tasks where assignedto = '"+username+"'    ");
					if (rs.next()) {
						
						String adminemail = rs.getString("createdby");
						String taskname = rs.getString("tname");
						String projectname = rs.getString("project_name");
						String useremail = rs.getString("assignedto");
						
						try {
							SendEmail.SendMailTaskCompleted(adminemail, taskname, projectname,useremail, request, response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
							out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
							out.println("<script src='js/alerts.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){  ");
							out.println("  showSwal('no-internet2')        ");
							out.println("});");
							out.println("</script>");
							
							RequestDispatcher rd = request.getRequestDispatcher("usertasksinprogress.jsp");
							rd.include(request, response);
							
							
							e.printStackTrace();
						}
					
						out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('task_pending_approval')        ");
						out.println("});");
						out.println("</script>");
						
						RequestDispatcher rd = request.getRequestDispatcher("usertasksinprogress.jsp");
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
						RequestDispatcher rd = request.getRequestDispatcher("usertasksinprogress.jsp");
						rd.include(request, response);
						
					}
					
			
					
					
					break;
					
				case "null":
					
					stmt.executeUpdate("UPDATE tasks SET usercomments='"+mycomments+"'  WHERE  task_id ='"+taskid+"'   ");
					System.out.print("Note Added Successfully!");
										
					out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('auto-close')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("usertasksinprogress.jsp");
					
					break;
				
				
				
				}
				
				

				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("usertasksinprogress.jsp");
			     
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
	    	
	    		String taskid = request.getParameter("first");
	    		session.setAttribute("newtask_id",taskid); 
		
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
				
				response.sendRedirect("usertasksaction.jsp");
				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("usertasks.jsp");
			     
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close if condition = true
			
	
			
				
			}
 
 
	    else if (request.getParameter("approved_tasks") != null) {
	    	
	    	
			String taskid = request.getParameter("first");
			System.out.println("The taskid is :"+taskid);
	    	
			try{
				
				mysqlConn = ConMysqlLocalhost.getMySqlConnection();
				
				String val = "3";
				String cond = "FALSE";
				String gsm = null;
			

				Statement stmt = null;
				stmt = mysqlConn.createStatement();
				ResultSet rs =null;
				
				String query="SELECT users.pnumber "
				+ "FROM tasks "
				+ "INNER JOIN users "
				+ "ON tasks.assignedto=users.email "
			    + "WHERE tasks.task_id = '"+taskid+"'  ";
				rs=stmt.executeQuery(query);

				while(rs.next()) {
					
					//String assignedto = rs.getString("assignedto");
					gsm = rs.getString(1);
					System.out.println("Phone number: :"+gsm);
				
				}

				stmt.executeUpdate("UPDATE tasks SET todo_status='"+val+"'   WHERE  task_id ='"+taskid+"' AND del_indicator = '"+cond+"'  ");
				System.out.print("Approved Successfull!");
				
				String msg = "Task ID-"+taskid+", has been approved";
				try {
					ContiSMS.SendSMS(gsm, msg, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('no-internet1')        ");
						out.println("});");
						out.println("</script>");
						
						
					e.printStackTrace();
				}
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("approve-d.jsp");
				rd.include(request, response);
				
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
 
	    else if (request.getParameter("decline_tasks") != null) {
	    	
	    	String taskid = request.getParameter("first");
			System.out.println("The taskid is :"+taskid);
	    	
			try{
				
				mysqlConn = ConMysqlLocalhost.getMySqlConnection();
				
				String val = "0";
				String cond = "FALSE";
				String gsm = null;
			

				Statement stmt = null;
				stmt = mysqlConn.createStatement();
				ResultSet rs =null;
				
				String query="SELECT users.pnumber "
				+ "FROM tasks "
				+ "INNER JOIN users "
				+ "ON tasks.assignedto=users.email "
			    + "WHERE tasks.task_id = '"+taskid+"'  ";
				rs=stmt.executeQuery(query);

				while(rs.next()) {
					
					//String assignedto = rs.getString("assignedto");
					gsm = rs.getString(1);
					System.out.println("Phone number: :"+gsm);
				
				}

				stmt.executeUpdate("UPDATE tasks SET todo_status='"+val+"'   WHERE  task_id ='"+taskid+"' AND del_indicator = '"+cond+"'  ");
				System.out.print("Approved Successfull!");
				
				String msg = "Task ID-"+taskid+", has been rejected.Please login for more info...";
				try {
					ContiSMS.SendSMS(gsm, msg, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('no-internet1')        ");
						out.println("});");
						out.println("</script>");
						
						e.printStackTrace();
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("approve-d.jsp");
				rd.include(request, response);
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('task_rejected')        ");
				out.println("});");
				out.println("</script>");
				
			}
			
			catch(Exception e){
				
			      System.out.println(e); 
			      
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
			     
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close if condition = true
	    	
	    }
 
 
	    else if (request.getParameter("more_details") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Successfull!");
				response.sendRedirect("task_details.jsp");
				
				String taskid = request.getParameter("first");
				session.setAttribute("sss_taskid",taskid); 
				
				
			}
 
	    else if (request.getParameter("update_taskdesc") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	
	    		String taskid = request.getParameter("taskid");
	    		
	    		System.out.print("taskid = "+taskid);
	    		
	    		String tdesc_update = request.getParameter("tdesc_update");
	    		System.out.print("tdesc_update = "+tdesc_update);
	    		
	    		String val = "TRUE";
		
			
			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
		
				
				
				
				stmt.executeUpdate("UPDATE tasks SET tdesc='"+tdesc_update+"'  WHERE  task_id ='"+taskid+"' AND del_indicator != '"+val+"'  ");
				System.out.print("Update Successfull!");
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')  ");
				out.println("});");
				out.println("</script>");
				
				response.sendRedirect("task_details.jsp");
				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("task_details.jsp");
			     
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close if condition = true
			
	
			
				
			}
 
	    else if (request.getParameter("approve_notify") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	
	    		String taskid = request.getParameter("taskid");
	    		
	    		System.out.print("taskid = "+taskid);
	    		
	    		String msg = request.getParameter("msg");
	    		
	    		String val = "TRUE";
	    		int statusval = 3;
	    		
	    		String name = null, tname = null, projectname = null;
	    		String pnumber = null;
	    		
	    		
		
			
			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
		
				String query="SELECT users.name,users.pnumber, tasks.task_id, tasks.tname, tasks.project_name"
						+ " FROM tasks INNER JOIN users ON tasks.assignedto=users.email "
						+ " where tasks.del_indicator != '"+val+"' AND tasks.task_id = '"+taskid+"'   ";
				ResultSet rs=stmt.executeQuery(query);
				
				while(rs.next()){ 
					
					 name = rs.getString("users.name");
					 pnumber = rs.getString("users.pnumber");
					 tname = rs.getString("tasks.tname");
					 projectname = rs.getString("tasks.project_name");
									
					
				}
				
				String message = "Hi "+name+" Tasks Approved details... [Task name: "+tname+"] [Project name: "+projectname+"] Message: "+msg;
				
				System.out.print("Message: "+message);
				
				ContiSMS.SendSMS(pnumber, message, response);
				
				stmt.executeUpdate("UPDATE tasks SET todo_status ='"+statusval+"'  WHERE  task_id ='"+taskid+"' AND del_indicator != '"+val+"'  ");
				System.out.print("Update Successfull!");
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')  ");
				out.println("});");
				out.println("</script>");
				
				response.sendRedirect("approve-d.jsp");
				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("approve-d.jsp");
			     
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close if condition = true
			
	
			
				
			}
 
	    else if (request.getParameter("decline_notify") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	
	    		String taskid = request.getParameter("taskid");
	    		
	    		System.out.print("taskid = "+taskid);
	    		
	    		String msg = request.getParameter("msg");
	    		
	    		String val = "TRUE";
	    		int statusval = 1;
	    		
	    		String name = null, tname = null, projectname = null;
	    		String pnumber = null;
	    		
	    		
		
			
			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
		
				String query="SELECT users.name,users.pnumber, tasks.task_id, tasks.tname, tasks.project_name"
						+ " FROM tasks INNER JOIN users ON tasks.assignedto=users.email "
						+ " where tasks.del_indicator != '"+val+"' AND tasks.task_id = '"+taskid+"'   ";
				ResultSet rs=stmt.executeQuery(query);
				
				while(rs.next()){ 
					
					 name = rs.getString("users.name");
					 pnumber = rs.getString("users.pnumber");
					 tname = rs.getString("tasks.tname");
					 projectname = rs.getString("tasks.project_name");
									
					
				}
				
				String message = "Hi "+name+". Tasks Declined details... [Task name: "+tname+"] [Project name: "+projectname+"] Message: "+msg;
				
				System.out.print("Message: "+message);
				
				ContiSMS.SendSMS(pnumber, message, response);
				
				stmt.executeUpdate("UPDATE tasks SET todo_status ='"+statusval+"'  WHERE  task_id ='"+taskid+"' AND del_indicator != '"+val+"'  ");
				System.out.print("Update Successfull!");
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')  ");
				out.println("});");
				out.println("</script>");
				
				response.sendRedirect("approve-d.jsp");
				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("approve-d.jsp");
			     
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
