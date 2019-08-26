package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import functions.JavaSMS;
import functions.SendEmail;

/**
 * Servlet implementation class ProjectActions
 */
@WebServlet("/ProjectActions")
public class ProjectActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.sql.Connection mysqlConn = null;
		
		PrintWriter out = response.getWriter();
		
		
		String jid = request.getParameter("first");
		System.out.println("firstID="+jid);

		
		HttpSession session = request.getSession(true);
		session.setAttribute("mycon1",jid);
		
		
		

		
		
		
		
		
		
 if (request.getParameter("delete") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				
				//String jid = request.getParameter("first");
				System.out.println("testing id="+jid);
				
				String val = "TRUE";
				
				stmt.executeUpdate("UPDATE projects SET del_indicator='"+val+"'   WHERE  id ='"+jid+"'  ");
				System.out.print("Successfull!");

				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("allprojects.jsp");
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
 
 
 if (request.getParameter("deletetask") != null) {
     //delete button is clicked
     //Do the delete action or forward the request to the servlet to do delete action
	

	try{

		
	    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

		
		java.sql.Statement stmt = null;
		stmt = mysqlConn.createStatement();
		
		
		//String jid = request.getParameter("first");
		System.out.println("testing id="+jid);
		
		String val = "TRUE";
		
		stmt.executeUpdate("UPDATE tasks SET del_indicator='"+val+"'   WHERE  task_id ='"+jid+"'  ");
		System.out.print("Successfull!");

		out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
		out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
		out.println("<script src='js/alerts.js'></script>");
		out.println("<script>");
		out.println("$(document).ready(function(){  ");
		out.println("  showSwal('auto-close')        ");
		out.println("});");
		out.println("</script>");
		
		RequestDispatcher rd = request.getRequestDispatcher("alltasks.jsp");
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
	    
	    
	    
	    else if (request.getParameter("view") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	String projectid = request.getParameter("first");
	    	session.setAttribute("theprojectid",projectid);
	    	System.out.println("Hw far projectid"+projectid);
	    	
	    	try {
	    		mysqlConn = ConMysqlLocalhost.getMySqlConnection();

					
					Statement stmt = null;
					ResultSet rs = null;
					String val = "TRUE";
					String val1="3";
					String val0="0";
					stmt = mysqlConn.createStatement();
					
					
					
					
			rs=stmt.executeQuery("select * from tasks where projectid = '"+projectid+"'    ");
			if (rs.next()) {
				
	
				String projectselected = rs.getString("project_name");
			
				session.setAttribute("projectselected",projectselected);
			 	System.out.println("The project name is:" +projectselected);
				
				//completed tasks count
				rs = stmt.executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks  where todo_status ='"+val1+"'  AND  del_indicator != '"+val+"' AND projectid = '"+projectid+"'   ");
				while(rs.next()){
					 
					 	String countp = rs.getString(1);
					 	System.out.println("Completed tasks per project:" +countp);
						
						session.setAttribute("completedtasksp",countp);
				}
				//overdue tasks count
				rs = stmt.executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks  where duedate < CURDATE() AND todo_status !='"+val1+"' AND del_indicator != '"+val+"' AND projectid = '"+projectid+"'    ");
				while(rs.next()){
					 
					 	String countp = rs.getString(1);
					 	System.out.println("Overdue tasks per project:" +countp);
						
						session.setAttribute("overduetasksp",countp);
				}
				//inprogress count
				int val2 = 1;
				rs = stmt.executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks  where todo_status='"+val2+"'  AND del_indicator != '"+val+"' AND projectid = '"+projectid+"'   ");
				while(rs.next()){
					 
					 	String countp = rs.getString(1);
					 	System.out.println("Inprogress tasks per project:" +countp);
						
						session.setAttribute("inprogresstasksp",countp);
				}
				
				//Assigned tasks but not yet picked by user count
				rs = stmt.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where todo_status ='"+val0+"'  AND del_indicator != '"+val+"' AND projectid = '"+projectid+"'   ");
				while(rs.next()){
					 
					 	String countp = rs.getString(1);
					 	System.out.println("Pending Action:" +countp);
						
						session.setAttribute("pendingactionp",countp);  
				}
				
				
				TestObject obj = new TestObject();
				obj.service(request, response);

				
				System.out.print("Success view");
				response.sendRedirect("projectdetails.jsp");
				
				}
			else {
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('no-records')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("allprojects.jsp");
				rd.include(request, response);
				System.out.print("No records yet!!!");
			}
			
	    	}
	    	
	    	catch(Exception e) {
	    		
	    		  System.out.println(e);
	    		
	    	}

		
				
				
			}
	    
	    
	    
	    else if (request.getParameter("update") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Successfull!");
				response.sendRedirect("allprojectse.jsp");
				
			}
 
 
 
	    else if (request.getParameter("update1") != null) {
	    	
	    	
			String newid =  session.getAttribute("mycon2").toString();
			System.out.println("newID="+newid);
			
			String status = request.getParameter("status");
	    	
	    	String priority = request.getParameter("priority");
			System.out.println("hw far2="+priority);
			//from viewprojectse.jsp
	    	
			try {

			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				stmt.executeUpdate("UPDATE projects SET priority='"+priority+"', status = '"+status+"'   WHERE  id ='"+newid+"'  ");
				System.out.print("Update Successfull!");
		
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("allprojects.jsp");
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
			}
	    	
	    	
	    	
	    	
	    	
	    }
 
 
 
	    else if (request.getParameter("updatetask") != null) {
	    	//	tname, assigneddate,duedate,priority

	    	
			String newid =  session.getAttribute("mycon2").toString();
			System.out.println("newID="+newid);
	    	
	    	String tname = request.getParameter("tname");
	    	String assigneddate = request.getParameter("assigneddate");
	    	String duedate = request.getParameter("duedate");
	    	String priority = request.getParameter("priority");
			System.out.println("hw far2="+priority);
			//from viewprojectse.jsp
	    	
			try {

			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				stmt.executeUpdate("UPDATE tasks SET tname = '"+tname+"',assigneddate='"+assigneddate+"',duedate='"+duedate+"', priority='"+priority+"'   WHERE  task_id ='"+newid+"'  ");
				System.out.print("Update Successfull!");

				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("alltasks.jsp");
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
			}
	    	
	    	
	    	
	    	
	    	
	    }
 
 
 
	    else if (request.getParameter("updatetask1") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Success redirect");
				response.sendRedirect("alltasksedit.jsp");
				
			}
 
 
	    else if (request.getParameter("viewf") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Success viewf");
				response.sendRedirect("fallprojects.jsp");
				
			}
 
	    else if (request.getParameter("viewpv") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Success viewpv");
				response.sendRedirect("allprojectsvu.jsp");
				
				
			}
 
 
	    else if (request.getParameter("addj") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				//uaddjobcreate.jsp
				
				
				try {
					
					
					mysqlConn = ConMysqlLocalhost.getMySqlConnection();

					Statement stmt = null;
					stmt = mysqlConn.createStatement();
					ResultSet rs =null;
					String val = "TRUE";
					String val2 = "9";
					String query="select pname, id,company,leader,filename,fileurl  from projects where del_indicator != '"+val+"' and status != '"+val2+"' and id = '"+jid+"'   ";
					rs=stmt.executeQuery(query);
			
					while(rs.next()) {
						
						String pid = rs.getString("id");
						String pname = rs.getString("pname");
						String client = rs.getString("company");
						String lead = rs.getString("leader");
						String filename = rs.getString("filename");
						String fileurl = rs.getString("fileurl");
						
						session.setAttribute("pname_session",pname);
						session.setAttribute("pid_session",pid);
						session.setAttribute("cclient",client);
						session.setAttribute("llead",lead);
						session.setAttribute("ffilename",filename);
						session.setAttribute("ffileurl",fileurl);
						
						//System.out.println("Testing Project name:"+pname);
						
					}
					
					
				}
				
				catch(Exception e)
				{
				      System.out.println(e); 
				      out.println("<script type=\"text/javascript\">");  
						out.println("alert('Error Error');");
						out.println("window.location = 'addtask.jsp'  ");
						out.println("</script>");
				}

				finally {		
					try {
						mysqlConn.close();
					}
					catch (Exception ignore) {
					}
				}
				
				
				
				System.out.print("Success addj");
				response.sendRedirect("uaddjobcreate.jsp");
	
				
			}
 
 
 
 
	    else if (request.getParameter("addj2") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	
	    	
	    	
	    	//session.setAttribute("pname_session1",project);
	    	//session.setAttribute("pid_session1",project_id);
	    	

		
				System.out.print("Success addj2");
				//response.sendRedirect("uaddjobcreate.jsp");
				
				//String jid = request.getParameter("first");
				//System.out.println("firstID="+jid);
				
		    	System.out.print("Entry!");
				//tname, client, assignedto, priority,duedate, projectname,tdesc
				
				String tname = request.getParameter("tname");
				//String client = request.getParameter("client");		
				String assignedto = request.getParameter("assignedto");
				String priority = request.getParameter("priority");

				
				String duedate = request.getParameter("duedate");
				
				String projectname =  session.getAttribute("pname_session1").toString();
		    	String projectid =  session.getAttribute("pid_session1").toString();
		    	
				String tdesc = request.getParameter("tdesc");
				
				String username =  session.getAttribute("User").toString();	
				String lead =  session.getAttribute("llead").toString();	
				String client =  session.getAttribute("cclient").toString();
				
				String messagebody = "You have being assigned a new task:-"+tname+". Task Details:-"+tdesc;
				String pnumber = null;
				
				String filename =  session.getAttribute("ffilename").toString();
				String fileurl =  session.getAttribute("ffileurl").toString();
				

		try{

			
		    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

			
			Statement stmt = null;
			stmt = mysqlConn.createStatement();
			
			ResultSet rs = null;
			String query="select *  from users where email = '"+assignedto+"'     ";
			rs=stmt.executeQuery(query);
	
			while(rs.next()) {
				
			 pnumber = rs.getString("pnumber");
			}
			
			
			
			
			
			int i = stmt.executeUpdate("insert into tasks(tname, priority, assignedto,duedate,project_name,projectid,tdesc,assigneddate,createdby,client,leader,filename,fileurl) "
					+ "values ('"+tname+"','"+priority+"','"+assignedto+"','"+duedate+"','"+projectname+"','"+projectid+"','"+tdesc+"',CURDATE(),'"+username+"','"+client+"','"+lead+"','"+filename+"','"+fileurl+"' ) ");
			

				
				if (i > 0) {
				
				//Updating 
				int projstatus = 8;	
				stmt.executeUpdate("update projects set status= " + projstatus + " where id = '" + projectid +"' ");	
				
				//Send sms and email to user.
				System.out.println(pnumber);
				
				//JavaSMS.SendSMS(pnumber, messagebody);
				ContiSMS.SendSMS(pnumber, messagebody);
				
				
				//Email to User
				SendEmail.SendMailTaskAssigned(username, tname, projectname,projectid, assignedto,duedate,tdesc,lead, request, response);

				System.out.print("Task Successfully saved!");

				//Send Email
				//SendEmail.SendMail(fname,lname,email,pass);	

				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("uaddjobcreate.jsp");
				rd.include(request, response);
			
		} 
				
				
				
				else {
					
				    response.sendRedirect("job.jsp");
				}
				
				
		}

		catch(Exception e)
		{
		      System.out.println(e); 
		      out.println("<script type=\"text/javascript\">");  
				out.println("alert('Error Error');");
				out.println("window.location = 'addtask.jsp'  ");
				out.println("</script>");
		}

		finally {		
			try {
				mysqlConn.close();
			}
			catch (Exception ignore) {
			}
		}
				
				
				
				
				
				
				
				
				
			}
 
 
 
	    else if (request.getParameter("more") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Success viewpv");
				response.sendRedirect("addtask.jsp");
				
				
			}
 
 
	    else if (request.getParameter("viewtasks") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Success tasks view");
				response.sendRedirect("alltasksview.jsp");
				
				
			}
 
 
	    else if (request.getParameter("viewproject-tasks") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Success view");
				response.sendRedirect("project-tasksv.jsp");
				
			}
 
 
 

	
		        
	}



}
