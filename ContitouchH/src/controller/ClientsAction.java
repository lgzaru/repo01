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
 * Servlet implementation class ClientsAction
 */
@WebServlet("/ClientsAction")
public class ClientsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsAction() {
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

		PrintWriter out = response.getWriter();
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
				
			
				
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				stmt.executeUpdate("UPDATE clients SET del_indicator='"+val+"'   WHERE  id ='"+jid+"'  ");
				System.out.print("Successfull!");
				
				RequestDispatcher rd = request.getRequestDispatcher("allclients.jsp");
				rd.include(request, response);
				

				
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
					
					RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
					rd.include(request, response);;
			     
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
				response.sendRedirect("allclientsv.jsp");
				
			}
	    
	    
	    
	    else if (request.getParameter("update") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
	    	

		
				System.out.print("Successfull!");
				response.sendRedirect("allclientse.jsp");
				
			}
 
 
 
	    else if (request.getParameter("update1") != null) {
	    	
	    	
			String newid =  session.getAttribute("mycon2").toString();
			System.out.println("newID="+newid);
	    	
	    	String name = request.getParameter("name");
	    	String address = request.getParameter("address");
			//from viewclientse.jsp
	    	
			try {

			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				
				java.sql.Statement stmt = null;
				stmt = mysqlConn.createStatement();
				
				out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('auto-close')        ");
				out.println("});");
				out.println("</script>");
				
				stmt.executeUpdate("UPDATE clients SET name='"+name+"',address = '"+address+"'   WHERE  id ='"+newid+"'  ");
				System.out.print("Update Successfull!");
				response.sendRedirect("allclients.jsp");
				
				
				
				
				
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



}
