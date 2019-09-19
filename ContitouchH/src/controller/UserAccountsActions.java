package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.ConMysqlLocalhost;

/**
 * Servlet implementation class UserAccountsActions
 */
@WebServlet("/UserAccountsActions")
public class UserAccountsActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAccountsActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.sql.Connection mysqlConn = null;

		String jid = request.getParameter("first");
		System.out.println("firstID="+jid);

		
		HttpSession session = request.getSession(true);
		session.setAttribute("mycon1",jid);
		
		

		
		
		
		
		
		
 if (request.getParameter("delete") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				
				//String jid = request.getParameter("first");
				System.out.println("testing id="+jid);
				
				String val = "TRUE";
				
				stmt.executeUpdate("UPDATE users SET del_indicator='"+val+"'   WHERE  id ='"+jid+"'  ");
				System.out.print("Successfull!");
			
				
				PrintWriter out = response.getWriter();
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("allusers.jsp");
				rd.include(request, response);
				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			      PrintWriter out = response.getWriter();
			      out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					response.sendRedirect("allusers.jsp");
			     
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close if condition = true
	    	
	    }
	    
	    
	    
	    else if (request.getParameter("view") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Condition not met");
				response.sendRedirect("allusersv.jsp");
				
			}
	    
	    
	    
	    else if (request.getParameter("update") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Successfull!");
				response.sendRedirect("alluserse.jsp");
				
			}
 
 
 
	    else if (request.getParameter("update1") != null) {
	    	
	    	
			String newid =  session.getAttribute("mycon2").toString();
			System.out.println("newID="+newid);
	    	
	    	String userroles = request.getParameter("userroles");
	    	String email = request.getParameter("email");
	    	String title = request.getParameter("title");

			//from viewuserse.jsp
	    	
			try {

			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				stmt.executeUpdate("UPDATE users SET userroles='"+userroles+"', email='"+email+"',title='"+title+"'   WHERE  id ='"+newid+"'  ");
				System.out.print("Update Successfull!");
			
				
				PrintWriter out = response.getWriter();
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("allusers.jsp");
				rd.include(request, response);
				
				
			}

			catch(Exception e){
			
			      System.out.println(e); 
			      
			      PrintWriter out = response.getWriter();
					out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
					out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
					out.println("<script src='js/alerts.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){  ");
					out.println("  showSwal('error-occured')        ");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher rd = request.getRequestDispatcher("allusers.jsp");
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



}
