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
 * Servlet implementation class CreateDesigner
 */
@WebServlet("/CreateDesigner")
public class CreateDesigner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDesigner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String email = request.getParameter("email");
	
	
		
		HttpSession session = request.getSession(true);
		String username =  session.getAttribute("User").toString();	
		

		Connection mysqlConn = null;
try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("insert into designers(name, title,email,createdby, regdate) "
			+ "values ('"+name+"','"+title+"','"+email+"','"+username+"',CURDATE() ) ");
	

		
		if (i > 0) {

		System.out.print("designer Successfully created!");

		//Send Email
		//SendEmail.SendMail(fname,lname,email,pass);	
		
		out.println("<script type=\"text/javascript\">");  
		out.println("alert(' designer successfully created');");
		out.println("window.location = 'designer.jsp'  ");
		out.println("</script>");
	
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
	
	


}