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

import conn.ConMysqlLocalhost;
import functions.MD5;

/**
 * Servlet implementation class ResetPass
 */
@WebServlet("/ResetPass")
public class ResetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
		
		String otp = request.getParameter("otp");
		String pass = request.getParameter("password");
			
		String passMD5 = MD5.getMD5(pass);
		String val = "0";
	
	
		Connection mysqlConn = null;
		
		try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("update users set password= '" + passMD5 + "', forgotpass = '"+val+"'  where forgotpass = '" + otp + "'");

		
		if (i > 0) {

		System.out.print("Client Successfully created!");

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
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	
} 
		
		
		
		else {
			
			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('warning-message-and-cancel')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("resetpass.jsp");
			rd.include(request, response);
			
		
		}
		
		
}

catch(Exception e)
{
      System.out.println(e); 
      out.println("<script type=\"text/javascript\">");  
		out.println("alert('OTP not found');");
		out.println("window.location = 'resetpass.jsp'  ");
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
	
	


}