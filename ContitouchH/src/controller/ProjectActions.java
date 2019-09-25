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
		int onhold = 4;

		
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
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
					rd.include(request, response);
			     
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
	      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('error-occured')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
			rd.include(request, response);
	     
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
					
					
					stmt = mysqlConn.createStatement();
					
					
					
					
			rs=stmt.executeQuery("select * from tasks where projectid = '"+projectid+"'    ");
			if (rs.next()) {
				
	
				String projectselected = rs.getString("project_name");
			
				session.setAttribute("projectselected",projectselected);
			 	System.out.println("The project name is:" +projectselected);
				
				//completed tasks count
			 	String val1="3";
				rs = stmt.executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks  where todo_status ='"+val1+"'  AND  del_indicator != '"+val+"' AND projectid = '"+projectid+"'   ");
				while(rs.next()){
					 
					 	String countp = rs.getString(1);
					 	System.out.println("Completed tasks per project:" +countp);
						
						session.setAttribute("completedtasksp",countp);
				}
				
				
				//onhold tasks count
			 	String val0="4";
				rs = stmt.executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks  where todo_status ='"+val0+"'  AND  del_indicator != '"+val+"' AND projectid = '"+projectid+"'   ");
				while(rs.next()){
					 
					 	String countp = rs.getString(1);
					 	System.out.println("Completed tasks per project:" +countp);
						
						session.setAttribute("onholdtask",countp);
				}
				
				
				
				
				
				
				//overdue tasks count
				
				rs = stmt.executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks where todo_status !='"+onhold+"' AND duedate < CURDATE() AND todo_status !='"+val1+"' AND del_indicator != '"+val+"' AND projectid = '"+projectid+"'    ");
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
				
				//Completed Pending Approval
				int val3 = 2;
				rs = stmt.executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks  where todo_status='"+val3+"'  AND del_indicator != '"+val+"' AND projectid = '"+projectid+"'   ");
				while(rs.next()){
					 
					 	String countp = rs.getString(1);
					 	System.out.println("Inprogress tasks per project:" +countp);
						
						session.setAttribute("pendingapprovaltasksp",countp);
				}
				
				//Assigned tasks but not yet picked by user count
				String vall0="0";
				rs = stmt.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where todo_status ='"+vall0+"'  AND del_indicator != '"+val+"' AND projectid = '"+projectid+"'   ");
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
	    		  out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
					rd.include(request, response);
	    		
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
			String project_start = request.getParameter("project_start");
			String project_end = request.getParameter("project_end");
	    	
	    	String priority = request.getParameter("priority");
			System.out.println("hw far2="+priority);
			//from viewprojectse.jsp
	    	
			try {

			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				stmt.executeUpdate("UPDATE projects SET priority='"+priority+"', status = '"+status+"',project_start = '"+project_start+"', project_end = '"+project_end+"'   WHERE  id ='"+newid+"'  ");
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
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
					rd.include(request, response);
			     
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

	    	
			
			
	    	
			String newid = request.getParameter("mycon2");
			System.out.println("newID="+newid);
			
	    	String tname = request.getParameter("tname");
	    	String assigneddate = request.getParameter("assigneddate");
	    	String duedate = request.getParameter("duedate");
	    	String priority = request.getParameter("priority");
	    	String tdesc = request.getParameter("tdesc");
			System.out.println("hw far2="+priority);
			//from viewprojectse.jsp
	    	
			try {

			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				stmt.executeUpdate("UPDATE tasks SET tname = '"+tname+"',assigneddate='"+assigneddate+"',duedate='"+duedate+"', priority='"+priority+"', tdesc ='"+tdesc+"' "
						+ "  WHERE  task_id ='"+newid+"'  ");
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
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
					rd.include(request, response);
			     
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
	    	
	    	String taskid = request.getParameter("first");
			session.setAttribute("taskid001",taskid); 
		
				System.out.print("Success redirect");
				response.sendRedirect("task_detailsedit.jsp");
				
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
				      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('error-occured')        ");
						out.println("});");
						out.println("</script>");
						
						RequestDispatcher rd = request.getRequestDispatcher("addtask.jsp");
						rd.include(request, response);
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
				String assigneddate = request.getParameter("assigneddate");

				
				String duedate = request.getParameter("duedate");
				
				String projectname =  session.getAttribute("pname_session1").toString();
		    	String projectid =  session.getAttribute("pid_session1").toString();
		    	
				String tdesc = request.getParameter("tdesc");
				String completedstatus = request.getParameter("completedstatus");
				
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
			
			
			switch(String.valueOf(completedstatus)) {
			
			case "3":
				
				
				int i = stmt.executeUpdate("insert into tasks(tname, priority, assignedto,duedate,project_name,projectid,tdesc,assigneddate,createdby,client,leader,filename,fileurl,todo_status) "
						+ "values ('"+tname+"','"+priority+"','"+assignedto+"','"+duedate+"','"+projectname+"','"+projectid+"','"+tdesc+"','"+assigneddate+"','"+username+"','"+client+"','"+lead+"','"+filename+"','"+fileurl+"','"+completedstatus+"' ) ");
				

					
					if (i > 0) {
					
					//Updating 
					int projstatus = 8;	
					stmt.executeUpdate("update projects set status= " + projstatus + " where id = '" + projectid +"' ");	
					
					//Send sms and email to user.
					System.out.println(pnumber);
					
					//JavaSMS.SendSMS(pnumber, messagebody);
					try {
						ContiSMS.SendSMS(pnumber, messagebody, response);
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
						
						RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
						rd.include(request, response);
						e.printStackTrace();
					}
					
					
					//Email to User
					try {
						SendEmail.SendMailTaskAssigned(username, tname, projectname,projectid, assignedto,duedate,tdesc,lead, request, response);
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
						
						RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
						rd.include(request, response);
					}

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
					
					
					break;
					
			case "null":
				
				String val3 = "0";
				
				int x = stmt.executeUpdate("insert into tasks(tname, priority, assignedto,duedate,project_name,projectid,tdesc,assigneddate,createdby,client,leader,filename,fileurl,todo_status) "
						+ "values ('"+tname+"','"+priority+"','"+assignedto+"','"+duedate+"','"+projectname+"','"+projectid+"','"+tdesc+"','"+assigneddate+"','"+username+"','"+client+"','"+lead+"','"+filename+"','"+fileurl+"','"+val3+"' ) ");
				

					
					if (x > 0) {
					
					//Updating 
					int projstatus = 8;	
					stmt.executeUpdate("update projects set status= " + projstatus + " where id = '" + projectid +"' ");	
					
					//Send sms and email to user.
					System.out.println(pnumber);
					
					//JavaSMS.SendSMS(pnumber, messagebody);
					try {
						ContiSMS.SendSMS(pnumber, messagebody, response);
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
						
						RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
						rd.include(request, response);
						e.printStackTrace();
					}
					
					
					//Email to User
					try {
						SendEmail.SendMailTaskAssigned(username, tname, projectname,projectid, assignedto,duedate,tdesc,lead, request, response);
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
						
						RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
						rd.include(request, response);
						e.printStackTrace();
					}

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
					
					
					break;
			
			
			
			}
			

				
				
		}

		catch(Exception e)
		{
		      System.out.println(e); 
		      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('no-internet1')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("addtask.jsp");
				rd.include(request, response);
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
 
 if (request.getParameter("hold") != null) {
	   
	 String gsm = null;
		String msg = null;
		String tname = null;
	

	try{

		
	    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	    Statement stmt = null;
		stmt = mysqlConn.createStatement();
		ResultSet rs =null;
		
		
		
		String query="SELECT users.pnumber, tasks.tname "
				+ "FROM tasks "
				+ "INNER JOIN users "
				+ "ON tasks.assignedto=users.email "
			    + "WHERE tasks.task_id = '"+jid+"'  ";
				rs=stmt.executeQuery(query);

				while(rs.next()) {
					
					//String assignedto = rs.getString("assignedto");
					gsm = rs.getString(1);
					tname = rs.getString(2);
					System.out.println("Phone number: :"+gsm);
					System.out.println("Task name: :"+tname);
				
				}
		

		
		msg = "[Task #"+jid+", Name: "+tname+"] has been put onhold by the Administrator";
		ContiSMS.SendSMS(gsm, msg, response);
		System.out.print("Checking connectivity error!");

		
		String val2 = "4";
		
		stmt.executeUpdate("UPDATE tasks SET todo_status='"+val2+"', duedate = CURDATE() + INTERVAL 1 DAY   WHERE  task_id ='"+jid+"'  ");
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
	      e.printStackTrace();
	      
	      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('error-occured')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("alltasks.jsp");
			rd.include(request, response);
	     
	}

	finally {		
		try {
			mysqlConn.close();
		}
		catch (Exception ignore) {
		}
	}//close if condition = true
	
}
 
 
 if (request.getParameter("resume") != null) {
     //delete button is clicked
     //Do the delete action or forward the request to the servlet to do delete action
	String gsm = null;
	String msg,tname = null;


	try{

		
	    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	    Statement stmt = null;
		stmt = mysqlConn.createStatement();
		ResultSet rs =null;
		
		
		
		String query="SELECT users.pnumber, tasks.tname "
				+ "FROM tasks "
				+ "INNER JOIN users "
				+ "ON tasks.assignedto=users.email "
			    + "WHERE tasks.task_id = '"+jid+"'  ";
				rs=stmt.executeQuery(query);

				while(rs.next()) {
					
					//String assignedto = rs.getString("assignedto");
					gsm = rs.getString(1);
					tname = rs.getString(2);
					System.out.println("Phone number: :"+gsm);
					System.out.println("Task name: :"+tname);
				
				}
		
		
	
		String val = "1";
		
		msg = "[Task #"+jid+", Name: "+tname+"] has been reactivated";
		ContiSMS.SendSMS(gsm, msg, response);
		System.out.print("Testing connectivity error!");
		
		stmt.executeUpdate("UPDATE tasks SET todo_status='"+val+"'   WHERE  task_id ='"+jid+"'  ");
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
	      
      	    out.println("<script type=\"text/javascript\">");  
			out.println("alert('Error occured..');");
			out.println("window.location = 'alltasks.jsp'  ");
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
 

		        
	}



}
