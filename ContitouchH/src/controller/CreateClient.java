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

/**
 * Servlet implementation class CreateClient
 */
@WebServlet("/CreateClient")
public class CreateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String vatreg = request.getParameter("vatreg");
		String email = request.getParameter("email");
		String pnumber = request.getParameter("pnumber");
		String finances = request.getParameter("finances");
	
	
		
		HttpSession session = request.getSession(true);
		String username =  session.getAttribute("User").toString();	
		

		Connection mysqlConn = null;
try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();
    
    String msg = "You have been registered on the Project tracker System";
    
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("insert into clients(name, address,createdby, regdate,vatreg,email,pnumber,finances) "
			+ "values ('"+name+"','"+address+"','"+username+"',CURDATE(),'"+vatreg+"','"+email+"','"+pnumber+"','"+finances+"' ) ");
	

		
		if (i > 0) {


		//Send Email
		//SendEmail.SendMail(fname,lname,email,pass);	n
			System.out.print("Client Successfully created!");

			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('auto-close')        ");
			out.println("});");
			out.println("</script>");
			
			try {
				ContiSMS.SendSMS(pnumber, msg);
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			}
			
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