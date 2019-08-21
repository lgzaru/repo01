package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.ConMysqlLocalhost;

/**
 * Servlet implementation class CreateClientBrief
 */
@WebServlet("/CreateClientBrief")
public class CreateClientBrief extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClientBrief() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out = response.getWriter();
		
		String clientid = request.getParameter("clientid");
		String projectname = request.getParameter("projectname");
		String summary = request.getParameter("summary");
		String datereceived = request.getParameter("datereceived");
		String fileurl = request.getParameter("fileurl");
	
	
		
		HttpSession session = request.getSession(true);
		String username =  session.getAttribute("User").toString();	
		

		Connection mysqlConn = null;
try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("insert into clientbrief(clientid, projectname,summary, datereceived,fileurl,createdby) "
			+ "values ('"+clientid+"','"+projectname+"','"+summary+"','"+datereceived+"','"+fileurl+"','"+username+"' ) ");
	

		
		if (i > 0) {


		//Send Email
		//SendEmail.SendMail(fname,lname,email,pass);	n
			System.out.print("Client brief Successfully created!");

			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('auto-close')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("clientbrief.jsp");
			rd.include(request, response);
		
		
		
		
		
		
		
		
	
} 
		
		
		
		else {
			
		    response.sendRedirect("HomeAdmin.jsp");
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
		
		response.sendRedirect("HomeAdmin.jsp");
		
		
		
		
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
	
	


}