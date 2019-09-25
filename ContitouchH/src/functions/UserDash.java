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
 * Servlet implementation class UserDash
 */
@WebServlet("/UserDash")
public class UserDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDash() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("------------------------------User Dashboard Results------------------------------");

    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    public void getUserDash(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
    	Connection mysqlConn = null;
		ResultSet rs = null;
		String val = "True";
		
		HttpSession session = request.getSession(true);
		String username =  session.getAttribute("User").toString();

		
			
 try {
		 mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		
		//1. Total todo tasks
		 
	    Statement stmt2 = null;
		stmt2 = mysqlConn.createStatement();
		String stus = "0";
		rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where assignedto='"+username+"' AND todo_status='"+stus+"' AND del_indicator != '"+val+"' ");
		 
		while(rs.next()){
			 
			 String todos = rs.getString(1);
			 System.out.println("Total todo tasks :" +todos);
			 
				session.setAttribute("todos_session",todos);
				
			 
		 }
		 
		//2. Total in progress
			stmt2 = mysqlConn.createStatement();
			String stus1 = "1";
			rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where assignedto = '"+username+"' AND todo_status='"+stus1+"'  AND del_indicator != '"+val+"' ");
			
			while(rs.next()){
				 
				 String inprogress = rs.getString(1);
				 System.out.println("Total in progress tasks:" +inprogress);
				 
					
					
					session.setAttribute("inprogress_session",inprogress);
					
				 
			 }
			 
			//3. Total Completed tasks
			 
				stmt2 = mysqlConn.createStatement();
				String stus2 = "3";
				rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where assignedto='"+username+"' AND todo_status = '"+stus2+"'  AND del_indicator != '"+val+"' ");
				
				while(rs.next()){
					 
					 String completed = rs.getString(1);
					 System.out.println("Total completed tasks :" +completed);
					 
						
						session.setAttribute("completed_session",completed);
				
				 }
				
				//4. Tasks Pending Approval
				 
				stmt2 = mysqlConn.createStatement();
				String stuss = "2";
				rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where assignedto='"+username+"' AND todo_status = '"+stuss+"'  AND del_indicator != '"+val+"' ");
				
				while(rs.next()){
					 
					 String totalpaproval = rs.getString(1);
					 System.out.println("Total pending approval :" +totalpaproval);
					 
						
						session.setAttribute("totalpaproval_session",totalpaproval);
				
				 }
				
				//4. Tasks on hold
				 
				stmt2 = mysqlConn.createStatement();
				String stuss1 = "4";
				rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where assignedto='"+username+"' AND todo_status = '"+stuss1+"'  AND del_indicator != '"+val+"' ");
				
				while(rs.next()){
					 
					 String tasksonhold = rs.getString(1);
					 System.out.println("Total pending approval :" +tasksonhold);
					 
						
						session.setAttribute("tasksonhold_session",tasksonhold);
				
				 }
				
				
				 
				//5. Total jobs
				 stmt2 = mysqlConn.createStatement();
				
				 
					rs = stmt2.executeQuery("SELECT COUNT(id) AS 'result'  FROM jobs where assignedto='"+username+"' AND del_indicator != '"+val+"'   ");
					while(rs.next()){
						 
						 String totaljobs = rs.getString(1);
						 System.out.println("Total Jobs:" +totaljobs);
							
							
							session.setAttribute("totaljobs_session",totaljobs);
							
						 
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
