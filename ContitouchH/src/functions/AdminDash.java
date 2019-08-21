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
 * Servlet implementation class AdminDash
 */
@WebServlet("/AdminDash")
public class AdminDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDash() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("------------------------------Admin Dashboard Results------------------------------");
        
        
    }
    

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	    
	}
    
    
    public void getAdminDash(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
    	Connection mysqlConn = null;
		ResultSet rs = null;
		String val = "True";

		
			
 try {
		 mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		
		//1. Total Completed Projects
		 
	    Statement stmt2 = null;
		stmt2 = mysqlConn.createStatement();
		String stus = "Completed";
		rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus+"' AND del_indicator != '"+val+"' ");
		 
		while(rs.next()){
			 
			 String countp = rs.getString(1);
			 System.out.println("Total Completed Projects :" +countp);
			 
				HttpSession session = request.getSession(true);
				session.setAttribute("totalcomp",countp);
				
			 
		 }
		 
		//2. Total Pending Projects
			stmt2 = mysqlConn.createStatement();
			String stus1 = "Pending";
			rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus1+"' AND del_indicator != '"+val+"' ");
			
			while(rs.next()){
				 
				 String countp = rs.getString(1);
				 System.out.println("Total Pending Projects:" +countp);
				 
					
					
					HttpSession session = request.getSession(true);
					session.setAttribute("totalpending",countp);
					
				
			 }
			
			
			 
			//3. Open Tasks
			 
				stmt2 = mysqlConn.createStatement();
				String stus2 = "0";
				rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where complete_status='"+stus2+"' AND del_indicator != '"+val+"' ");
				
				while(rs.next()){
					 
					 String countp = rs.getString(1);
					 System.out.println("Total Open tasks :" +countp);
					 
						
						
						HttpSession session = request.getSession(true);
						session.setAttribute("totalopen",countp);
				
				 }
				
				 
				//4. Closed TAsks
				 stmt2 = mysqlConn.createStatement();
				    String stus3 = "1";
					rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where complete_status = '"+stus3+"' AND  del_indicator != '"+val+"'   ");
					while(rs.next()){
						 
						 String countp = rs.getString(1);
						 System.out.println("Closed tasks:" +countp);
							
							HttpSession session = request.getSession(true);
							session.setAttribute("totalcompleted",countp);
							
						 
					 }
					
					//5. Overdue Projects
					 stmt2 = mysqlConn.createStatement();
					    //String stus4 = "Cancelled";
						rs = stmt2.executeQuery("SELECT COUNT(id) AS 'result'  FROM projects  where project_end < CURDATE()  AND  del_indicator != '"+val+"'   ");
						while(rs.next()){
							 
							 String countp = rs.getString(1);
							 System.out.println("Cancelled Projects:" +countp);
								
								HttpSession session = request.getSession(true);
								session.setAttribute("totalcancelled",countp);
								
							 
						 }
						
						//6. OnHold Projects
						 stmt2 = mysqlConn.createStatement();
						    String stus5 = "OnHold";
							rs = stmt2.executeQuery("SELECT COUNT(id) AS 'result'  FROM projects  where status = '"+stus5+"' AND  del_indicator != '"+val+"'   ");
							while(rs.next()){
								 
								 String countp = rs.getString(1);
								 System.out.println("OnHold Projects:" +countp);
									
									HttpSession session = request.getSession(true);
									session.setAttribute("onhold",countp);
									
								 
							 }
							
							
							//7. Tasks due today
							 stmt2 = mysqlConn.createStatement();
							    String stus6 = "0";
								rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where duedate = CURDATE() AND complete_status = '"+stus6+"' AND  del_indicator != '"+val+"'   ");
								while(rs.next()){
									 
									 String countp = rs.getString(1);
									 System.out.println("Tasks Due Today:" +countp);
										
										HttpSession session = request.getSession(true);
										session.setAttribute("duetoday",countp);
										
									 
								 }
								
								
								//8. Assigned Today
								 stmt2 = mysqlConn.createStatement();
								    //String stus7 = "1";
									rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where  assigneddate = CURDATE() AND  del_indicator != '"+val+"'   ");
									while(rs.next()){
										 
										 String countp = rs.getString(1);
										 System.out.println("Tasks assigned today:" +countp);
											
											HttpSession session = request.getSession(true);
											session.setAttribute("assignedtoday",countp);
											
										 
									 }
									
									
									
									//9. All Tasks
									 stmt2 = mysqlConn.createStatement();
									    //String stus7 = "1";
										rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where del_indicator != '"+val+"'   ");
										while(rs.next()){
											 
											 String countp = rs.getString(1);
											 System.out.println("Total tasks:" +countp);
												
												HttpSession session = request.getSession(true);
												session.setAttribute("taskstotal",countp);
												
											 
										 }
										
										
										//9. OverDue Tasks
										 stmt2 = mysqlConn.createStatement();
										    String stus9 = "1";
											rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where duedate < CURDATE() AND complete_status !='"+stus9+"' AND del_indicator != '"+val+"'   ");
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println("Overdue tasks:" +countp);
													
													HttpSession session = request.getSession(true);
													session.setAttribute("overduetasks",countp);
													
													
													
													
												 
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
