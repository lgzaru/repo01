package accounts;

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
/*import com.conti.procurement.Signup;*/
import functions.MD5;
/*import functions.SendEmail;*/


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");	
		String pnumber = request.getParameter("pnumber");
		String password = request.getParameter("password");
		String lastLogon = request.getParameter("lastLogon");
		String userroles = "User";
		
		String passwordMD5 =null;
		
		try {
			passwordMD5 = MD5.getMD5(password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	   
		
		

		Connection mysqlConn = null;
try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("insert into users(name, email,pnumber, password, lastLogon,userroles, regdate) values ('"+name+"','"+email+"','"+pnumber+"','"+passwordMD5+"','"+lastLogon+"','"+userroles+"',CURDATE() ) ");
	

		
		if (i > 0) {

		System.out.print("Signup Successfull!");

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
			
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			
		   // response.sendRedirect("register.jsp");
		}
		

		
}

catch(Exception e)
{
      System.out.println(e); 
  /*    out.println("<script type=\"text/javascript\">");  
		out.println("alert('Email already registered!! Check your details and try again');");
		out.println("window.location = 'register.jsp'  ");
		out.println("</script>");*/
      
		out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
		out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
		out.println("<script src='js/alerts.js'></script>");
		out.println("<script>");
		out.println("$(document).ready(function(){  ");
		out.println("  showSwal('warning-message-and-cancel')        ");
		out.println("});");
		out.println("</script>");
		
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.include(request, response);
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
