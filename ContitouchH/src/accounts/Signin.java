package accounts;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
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
import functions.MD5;


/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
				String email = request.getParameter("email");
				String pass=request.getParameter("password");
				
				String lastLogon = request.getParameter("lastLogon");
				long lastLogonForm = Long.parseLong(lastLogon);
				
				
				
				String passwordMD5 = "null";
				try {
					passwordMD5 = MD5.getMD5(pass);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				ResultSet rs = null;
				
			    Connection mysqlConn = null;
				
				String role =null;
				


				try {				

					
				    mysqlConn = ConMysqlLocalhost.getMySqlConnection();
			
				
					Statement stmt = null;
					stmt = mysqlConn.createStatement();
					String vall = "TRUE";
					rs = stmt.executeQuery("select password,userroles,lastLogon from users where del_indicator != '"+vall+"' AND email = '" + email + "'");	
					if (rs.next()) { //query only returns 1 record in the result set
						//role=rs.getString("role");
						role=rs.getString("userroles");
						if (rs.getString("password").equals(passwordMD5)) { //if valid password
							long lastLogonDB = rs.getLong("lastLogon");
							if (lastLogonForm > lastLogonDB) {
								
								
								if(role.equals("Administrator"))
								{
								
									
									
								HttpSession session = request.getSession();
								session.setAttribute("User", email); //Saves user name string in the session object
								//String unmmme = session.toString().toString();
								
								//rd = request.getRequestDispatcher("HomeAdmin.jsp");
								
								
						/*		out.println("<script type=\"text/javascript\">");  
								out.println("alert('Click OK to continue.');");
								out.println("window.location = 'HomeAdmin.jsp'  ");
								out.println("</script>");
								stmt.executeUpdate("update users set lastLogon= " + lastLogonForm + " where email = '" + email + "'");*/
								
								System.out.println("Testing alerts1...");
								        
								out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
								out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
								out.println("<script src='js/alerts.js'></script>");
								out.println("<script>");
								out.println("$(document).ready(function(){  ");
								out.println("  showSwal('success-message')        ");
								out.println("});");
								out.println("</script>");
								
								System.out.println("Testing alerts2...");
								stmt.executeUpdate("update users set lastLogon= " + lastLogonForm + " where email = '" + email + "'");

								RequestDispatcher rd = request.getRequestDispatcher("HomeAdmin.jsp");
								rd.include(request, response);
								
								
								}
								
																
													
								
								
								if(role.equals("Finance"))
								{
									
								
								HttpSession session = request.getSession();
								session.setAttribute("User", email); //Saves user name string in the session object
								//String unmmme = session.toString().toString();
								
								//rd = request.getRequestDispatcher("Views/Home/Home.jsp");
								/*out.println("<script type=\"text/javascript\">");  
								out.println("alert('Click OK to continue.');");
								out.println("window.location = 'HomeFinance.jsp'  ");
								out.println("</script>");
								*/
								
								
								out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
								out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
								out.println("<script src='js/alerts.js'></script>");
								out.println("<script>");
								out.println("$(document).ready(function(){  ");
								out.println("  showSwal('success-message')        ");
								out.println("});");
								out.println("</script>");
								
								RequestDispatcher rd = request.getRequestDispatcher("HomeFinance.jsp");
								rd.include(request, response);
								
								stmt.executeUpdate("update users set lastLogon= " + lastLogonForm + " where email = '" + email + "'");
								}
								
								
								if(role.equals("User"))
								{
									
								
								HttpSession session = request.getSession();
								session.setAttribute("User", email); //Saves user name string in the session object
								//String unmmme = session.toString().toString();
								
								out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
								out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
								out.println("<script src='js/alerts.js'></script>");
								out.println("<script>");
								out.println("$(document).ready(function(){  ");
								out.println("  showSwal('success-message')        ");
								out.println("});");
								out.println("</script>");
								
								RequestDispatcher rd = request.getRequestDispatcher("HomeUser.jsp");
								rd.include(request, response);
								
								
								stmt.executeUpdate("update users set lastLogon= " + lastLogonForm + " where email = '" + email + "'");
								}
								
								
						
									
							}
							
							
							
							
							
							
							
							else {
								//request.setAttribute("Error", "Session has ended. Kindly login again.");			
								//rd = request.getRequestDispatcher("Views/Account/signin.jsp");
								
								out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
								out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
								out.println("<script src='js/alerts.js'></script>");
								out.println("<script>");
								out.println("$(document).ready(function(){  ");
								out.println("  showSwal('warning-message-and-cancel')        ");
								out.println("});");
								out.println("</script>");
								
								RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
								rd.include(request, response);
								
								
							}
						}
						else	{ 
							out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
							out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
							out.println("<script src='js/alerts.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){  ");
							out.println("  showSwal('warning-message-and-cancel')        ");
							out.println("});");
							out.println("</script>");
							
							RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
							rd.include(request, response);
							
							
						}
					} //no record in the result set,i.e. invalid user name
					
				
					
					else {
						
						out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('warning-message-and-cancel')        ");
						out.println("});");
						out.println("</script>");
						
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.include(request, response);
					}
				}	
				catch (Exception e) { //database problem
					//request.setAttribute("Error", "Problem accessing security realm.");
					//rd = request.getRequestDispatcher("Views/Account/signin.jsp");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Error, Problem accessing security realm. ');");
					out.println("window.location = 'login.jsp'  ");
					out.println("</script>");
					
				
					e.printStackTrace();	
				}
				finally {		
					try {
						mysqlConn.close();
					}
					catch (Exception ignore) {
					}
				}

				//rd.forward(request, response);
	}

	


}