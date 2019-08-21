package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.ConMysqlLocalhost;

/**
 * Servlet implementation class CreateJob
 */
@WebServlet("/CreateJob")
public class CreateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	System.out.print("Entry!");
		PrintWriter out = response.getWriter();
		
		String jname = request.getParameter("jname");
		String jobdesc = request.getParameter("jobdesc");		
		String priority = request.getParameter("priority");
		String timetaken = request.getParameter("timetaken");
		String assigneddate = request.getParameter("assigneddate");
		String client = request.getParameter("client");
		String comments = request.getParameter("comments");
		
		
		HttpSession session = request.getSession(true);
		String username =  session.getAttribute("User").toString();	
		
	//	String status = "Completed ";
		

		
	   
		
		

		Connection mysqlConn = null;
try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("insert into jobs(jname, jobdesc, priority, timetaken,assigneddate, client,comments,assignedto,datecompleted) "
			+ "values ('"+jname+"','"+jobdesc+"','"+priority+"','"+timetaken+"','"+assigneddate+"','"+client+"','"+comments+"','"+username+"',CURDATE() ) ");
	

		
		if (i > 0) {


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
		
		System.out.print("Job Successfully saved!");
		response.sendRedirect("job.jsp");
	
} 
		
		
		
		else {
			
		    response.sendRedirect("job.jsp");
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
		out.println("  showSwal('warning-message-and-cancel')        ");
		out.println("});");
		out.println("</script>");
		
		System.out.print("Job Successfully saved!");
		response.sendRedirect("HomeUser.jsp");
      
}

finally {		
	try {
		mysqlConn.close();
	}
	catch (Exception ignore) {
	}
}


	    
	    System.out.print(" All good");
		
	
	}
	
	
	

		
	//-------------------------------

}