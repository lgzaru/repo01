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
import functions.OTP;

/**
 * Servlet implementation class CreateProject
 */
@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		
    	System.out.print("Entry!");
		PrintWriter out = response.getWriter();
		
		String pname = request.getParameter("pname");
		
		
		String status = request.getParameter("pstatus");
		String time = request.getParameter("time");
		String company = request.getParameter("company");
	
		
		//String assignedto = request.getParameter("assignedto");
		String lead = request.getParameter("lead");		
		String requester = request.getParameter("requester");
		String rrd = request.getParameter("rrd");
		String red = request.getParameter("red");
		String project_start = request.getParameter("project_start");		
		String project_end = request.getParameter("project_end");
		String cmonth = request.getParameter("cmonth");
		
		String prore = request.getParameter("prore");
		String comments = request.getParameter("comments");		
		String responsibility = request.getParameter("responsibility");
		String rdate = request.getParameter("rdate");
		String priority = request.getParameter("priority");
		
		
		String username =  session.getAttribute("User").toString();	
		String filename =  session.getAttribute("filename").toString();	
		String fileurl =  session.getAttribute("fileurl").toString();	
		
		
		
		int projectid = OTP.getOTP();
		String projectidnew = "PJCT"+projectid;
		System.out.println(projectidnew);
		

		Connection mysqlConn = null;
try{

	
    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

	
	Statement stmt = null;
	stmt = mysqlConn.createStatement();
	int i = stmt.executeUpdate("insert into projects(id, pname, status, time, company, lead,requester,rrd,red,project_start,project_end,cmonth,prore,comments,responsibility,rdate,priority,createdby,regdate,filename,fileurl) "
			+ "values ('"+projectidnew+"','"+pname+"','"+status+"','"+time+"','"+company+"','"+lead+"','"+requester+"','"+rrd+"','"+red+"','"+project_start+"','"+project_end+"','"+cmonth+"','"+prore+"','"+comments+"','"+responsibility+"','"+rdate+"','"+priority+"','"+username+"',CURDATE(), '"+filename+"','"+fileurl+"' ) ");
	

		
		if (i > 0) {
			
			
			System.out.println("Saved successfully");
			
			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('auto-close')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
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
		
		System.out.print("Error!");
		response.sendRedirect("project.jsp");
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