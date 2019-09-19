package functions;

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

/**
 * Servlet implementation class ForgotPass
 */
@WebServlet("/ForgotPass")
public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out = response.getWriter();
			
			System.out.println("Forgot pass test");
					
			String useremail = request.getParameter("fpass");
	
			
			
			int usercode = OTP.getOTP();
			String msg = "Use this OTP to reset your password. OTP = "+usercode;
			System.out.println("My OTP:"+usercode);

			Connection mysqlConn = null;
			try{

				
			    mysqlConn = ConMysqlLocalhost.getMySqlConnection();

				Statement stmt = null;
				ResultSet rs = null;
				stmt = mysqlConn.createStatement();
				rs = stmt.executeQuery("select email, pnumber from users where email = '" + useremail + "'");	
				if (rs.next()) {
					
					String gsm = rs.getString("pnumber");
					
					if (rs.getString("email").equals(useremail)) {
						
						
						stmt.executeUpdate("update users set forgotpass = " + usercode + " where email = '" + useremail + "'");

						
						
						//send email
						try {
							SendEmail.SendMail(useremail,usercode);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							
							out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
							out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
							out.println("<script src='js/alerts.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){  ");
							out.println("  showSwal('no-internet2')        ");
							out.println("});");
							out.println("</script>");
							
							RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
							rd.include(request, response);
							e.printStackTrace();
						}
						
						//send sms
						try {
							ContiSMS.SendSMS(gsm, msg);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
							out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
							out.println("<script src='js/alerts.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){  ");
							out.println("  showSwal('no-internet1')        ");
							out.println("});");
							out.println("</script>");
							
							RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
							rd.include(request, response);
							e.printStackTrace();
						}
						
						
						
						out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
						out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
						out.println("<script src='js/alerts.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){  ");
						out.println("  showSwal('auto-close')        ");
						out.println("});");
						out.println("</script>");
						
						RequestDispatcher rd = request.getRequestDispatcher("resetpass.jsp");
						rd.include(request, response);
						
				
						/*  out.println("<script type=\"text/javascript\">");  
							out.println("alert('A reset link has been sent to your email address');");
							out.println("window.location = 'login.jsp'  ");
							out.println("</script>");*/
						
					    //response.sendRedirect("login.jsp");

						
					}
					
						
					
				}
				
				
				else {
					
					 out.println("<script type=\"text/javascript\">");  
						out.println("alert('Either you have entered a wrong email address or you have lost internet connectivity ');");
						out.println("window.location = 'resetpass.jsp'  ");
						out.println("</script>");
					System.out.println("Email not found");
			   // response.sendRedirect("login.jsp");
			}
				

			}

			catch(Exception e) {
		
			      System.out.println(e); 
			      out.println("<script type=\"text/javascript\">");  
					out.println("alert('Error Error');");
					out.println("window.location = 'resetpass.jsp'  ");
					out.println("</script>");
			}

			finally {		
				try {
					mysqlConn.close();
				}
				catch (Exception ignore) {
				}
			}//close finally


				    
					
				
				} //close service
				
				


			}