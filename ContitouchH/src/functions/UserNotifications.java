package functions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.ConMysqlLocalhost;

/**
 * Servlet implementation class UserNotifications
 */
@WebServlet("/UserNotifications")
public class UserNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNotifications() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    public void getUserDash(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
    	Connection mysqlConn = null;
		ResultSet rs = null;
		String val = "True";
		
		HttpSession session = request.getSession(true);
		
		String username = "lovemore.zaru@contitouch.co.zw";
		
			
 try {
		 mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		 	Statement stmt2 = null;
							
							
							//7. Tasks due today
							 stmt2 = mysqlConn.createStatement();
							    String stus6 = "0";
								rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where assignedto = '"+username+"' AND duedate = CURDATE() AND complete_status = '"+stus6+"' AND  del_indicator != '"+val+"'   ");
								while(rs.next()){
									 
									 int countp = rs.getInt(1);
									 System.out.println("Tasks Due Today:" +countp);
										
										session.setAttribute("duetoday",countp);
										
										if(countp == 0) {
											
											System.out.println("You have"+countp+" due today");
											
											
										}
										
										else {
											
											System.out.println("You are up to date with your tasks");
										}
										
									 
								 }
								
					
				
										
										
										//9. OverDue Tasks
										 stmt2 = mysqlConn.createStatement();
										    //String stus7 = "1";
											rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where assignedto = '"+username+"' AND duedate < CURDATE() AND del_indicator != '"+val+"'   ");
											while(rs.next()){
												 
												 int countp = rs.getInt(1);
												 System.out.println("Overdue tasks:" +countp);
													
													session.setAttribute("overduetasks",countp);
													
													
													if(countp == 0) {
														
														System.out.println("You have "+countp+" Overdue tasks");
														
														
													}
													
													else {
														
														System.out.println("You are up to date with your tasks="+countp);
													}
													
													
													
													
												 
											 }
					

					
										 
 									}
		
		
								catch (Exception e) { 
									e.printStackTrace();	
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
