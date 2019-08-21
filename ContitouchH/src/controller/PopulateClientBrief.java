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
		

		
		
		try {
			
			
			mysqlConn = ConMysqlLocalhost.getMySqlConnection();

			Statement stmt = null;
			stmt = mysqlConn.createStatement();
			ResultSet rs =null;
			int val = 0,val1 = 1;
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
			
			
			stmt.executeUpdate("UPDATE clientbrief SET project_created='"+val1+"'  WHERE  id ='"+clientbriefid+"'  ");
			System.out.print("Update Successfull!");
			
			RequestDispatcher rd = request.getRequestDispatcher("projectp.jsp");
			rd.include(request, response);
			
			
		}
		
		catch(Exception e)
		{
		      System.out.println(e); 
		      out.println("<script type=\"text/javascript\">");  
				out.println("alert('Error Error');");
				out.println("window.location = 'addtask.jsp'  ");
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
