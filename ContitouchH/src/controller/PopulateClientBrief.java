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

/**
 * Servlet implementation class PopulateClientBrief
 */
@WebServlet("/PopulateClientBrief")
public class PopulateClientBrief extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateClientBrief() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	java.sql.Connection mysqlConn = null;
	HttpSession session = request.getSession(true);
	PrintWriter out = response.getWriter();
	
	String clientbriefid = request.getParameter("clientbrief");
	session.setAttribute("clientbriefid", clientbriefid);
		

		
		
		try {
			
			
			mysqlConn = ConMysqlLocalhost.getMySqlConnection();

			Statement stmt = null;
			stmt = mysqlConn.createStatement();
			ResultSet rs =null;
			int val = 0;
			String query="select * from clientbrief where id = '"+clientbriefid+"' and project_created = '"+val+"'  ";
			rs=stmt.executeQuery(query);
	
			while(rs.next()) {
				
				String datereceived = rs.getString("datereceived");
				String projectname = rs.getString("projectname");
				String summary = rs.getString("summary");
				String fileurl = rs.getString("fileurl");
				String clientid = rs.getString("clientid");
				String filename = rs.getString("filename");
				
				System.out.println("date:"+datereceived);
				System.out.println("project:"+projectname);
				System.out.println("summary"+summary);
				System.out.println("url:"+fileurl);
				System.out.println("clientname"+clientid);
				
				session.setAttribute("datereceived",datereceived);
				session.setAttribute("projectname",projectname);
				session.setAttribute("summary",summary);
				session.setAttribute("fileurl",fileurl);
				session.setAttribute("clientid",clientid);
				session.setAttribute("filename",filename);
				
				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("projectp.jsp");
			rd.include(request, response);
			
			
		}
		
		catch(Exception e)
		{	System.out.println(e); 
			
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
	}

}
