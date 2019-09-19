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
import functions.ContiSMS;
import functions.MD5;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		Connection mysqlConn = null;
		

		
		
if (request.getParameter("createuser") != null) {
	
	HttpSession session = request.getSession(true);
	String username =  session.getAttribute("User").toString();	
	
	String name = request.getParameter("name");
	String email = request.getParameter("email");		
	String password1 = request.getParameter("password");
	String role = request.getParameter("role");
	String title = request.getParameter("title");
	
	String pnumber = request.getParameter("pnumber");
	
	String passwordMD5 = null;
	passwordMD5 = MD5.getMD5(password1);
	

try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();
    
    String msg = " User account created. Log on to http://projects.contitouch.co.zw. Credentials - Username:"+email+" Password:"+password1;

	
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("insert into users(name, email, password, userroles,createdby, regdate,title,pnumber) "
			+ "values ('"+name+"','"+email+"','"+passwordMD5+"','"+role+"','"+username+"',CURDATE(), '"+title+"','"+pnumber+"' ) ");
	

		
		if (i > 0) {

	
		
			System.out.print("User Successfully created!");

			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('auto-close')        ");
			out.println("});");
			out.println("</script>");
			
			ContiSMS.SendSMS(pnumber, msg);
			
			RequestDispatcher rd = request.getRequestDispatcher("createuser.jsp");
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
		    response.sendRedirect("createuser.jsp");
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
		
		RequestDispatcher rd = request.getRequestDispatcher("createuser.jsp");
		rd.include(request, response);
}

finally {		
	try {
		mysqlConn.close();
	}
	catch (Exception ignore) {
		 System.out.println(ignore); 
			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('warning-message-and-cancel')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("createuser.jsp");
			rd.include(request, response);
	}
}

}

else if (request.getParameter("createrole") != null) {

    //delete button is clicked
    //Do the delete action or forward the request to the servlet to do delete action
	

	try{

			
			String mroles = request.getParameter("mroles");
			String code = request.getParameter("code");
		    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

			
		    Statement stmt = null;
			stmt = mysqlConn.createStatement();
			int i = stmt.executeUpdate("insert into roles (description , code, regdate)  values ('"+mroles+"','"+code+"', CURDATE() )  ");
				
			
			if (i > 0) {
			
	
		System.out.print("Successfull!");

		out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
		out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
		out.println("<script src='js/alerts.js'></script>");
		out.println("<script>");
		out.println("$(document).ready(function(){  ");
		out.println("  showSwal('auto-close')        ");
		out.println("});");
		out.println("</script>");
		
		RequestDispatcher rd = request.getRequestDispatcher("createuser.jsp");
		rd.include(request, response);
		
		}
		
		
		
	}

	catch(Exception e){
		
		 System.out.println(e); 
			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('warning-message-and-cancel')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("createuser.jsp");
			rd.include(request, response);
	
	     
	}

	finally {		
		try {
			mysqlConn.close();
		}
		catch (Exception ignore) {
			
			 System.out.println(ignore); 
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('warning-message-and-cancel')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("createuser.jsp");
				rd.include(request, response);
		}
	}//close if condition = true
	
}



	    
	    System.out.print(" All good");
		
	
	}
	
	


}