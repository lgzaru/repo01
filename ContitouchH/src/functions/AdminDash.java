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
		String stus = "9";
		rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus+"' AND del_indicator != '"+val+"' ");
		 
		while(rs.next()){
			 
			 String countp = rs.getString(1);
			 System.out.println("Total Completed Projects :" +countp);
			 
				HttpSession session = request.getSession(true);
				session.setAttribute("totalcomp",countp);
				
			 
		 }
		 
		//2. Total Pending Projects
			stmt2 = mysqlConn.createStatement();
			String stus1 = "8";
			rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus1+"' AND del_indicator != '"+val+"' ");
			
			while(rs.next()){
				 
				 String countp = rs.getString(1);
				 System.out.println("Total Pending Projects:" +countp);
				 
					
					
					HttpSession session = request.getSession(true);
					session.setAttribute("totalpending",countp);
					
				
			 }
			
			
			 
			//3. Open Tasks
			 
				stmt2 = mysqlConn.createStatement();
				String stus2 = "3";
				rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where todo_status !='"+stus2+"' AND del_indicator != '"+val+"' ");
				
				while(rs.next()){
					 
					 String countp = rs.getString(1);
					 System.out.println("Total Open tasks :" +countp);
					 
						
						
						HttpSession session = request.getSession(true);
						session.setAttribute("totalopen",countp);
				
				 }
				
				 
				//4. Closed TAsks
				 stmt2 = mysqlConn.createStatement();
				    String stus3 = "3";
					rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where todo_status = '"+stus3+"' AND  del_indicator != '"+val+"'   ");
					while(rs.next()){
						 
						 String countp = rs.getString(1);
						 System.out.println("Closed tasks:" +countp);
							
							HttpSession session = request.getSession(true);
							session.setAttribute("totalcompleted",countp);
							
						 
					 }
					
					//5. Overdue Projects
					 stmt2 = mysqlConn.createStatement();
					   String onhold = "11";
						rs = stmt2.executeQuery("SELECT COUNT(id) AS 'result'  FROM projects  where project_end < CURDATE()  AND  del_indicator != '"+val+"' AND status != '"+onhold+"'   ");
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
							    String stus6 = "3";
							    String holdtask = "4";
								rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where todo_status != '"+holdtask+"' AND duedate = CURDATE() AND todo_status != '"+stus6+"' AND  del_indicator != '"+val+"'   ");
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
										    String condition1 = "3";
											rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks  where todo_status != '"+holdtask+"' AND duedate < CURDATE() AND todo_status !='"+condition1+"' AND del_indicator != '"+val+"'   ");
											
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println("Overdue tasks:" +countp);
													
													HttpSession session = request.getSession(true);
													session.setAttribute("overduetasks",countp);
													
												
												 
											 }
											
											
											//10. Projects Pending Action
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus01 = "1";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus01+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println("Projects Pending Action :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("pendingaction",countp);
													
												 
											 }
											
//											11. Projects in Studio
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus02 = "2";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus02+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println(" Projects in studio:" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("instudio",countp);
													
												 
											 }
											
												//12. Projects Waiting Further Details From Client
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus03 = "3";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus03+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println("Projects Waiting Further Details From Client :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("waitingdetails",countp);
													
												 
											 }
											
											
											//13. Projects In Photography
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus04 = "4";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus04+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println(" Projects In Photography :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("inphoto",countp);
													
												 
											 }
											
										//14. Projects Waiting Approval
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus05 = "5";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus05+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println("Projects Waiting Approval :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("waitingapproval",countp);
													
												 
											 }
											
											//15. Projects Waiting Feedback
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus06 = "6";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus06+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println(" Projects Waiting Feedback :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("waitingfeedback",countp);
													
												 
											 }
											
											
//										16. Projects Client Still Reviewing
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus07 = "7";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus07+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println(" Client Still Reviewing :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("clientreview",countp);
													
												 
											 }
											
											
											// 17. Tasks pending approval
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus09 = "2";
											rs = stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where todo_status='"+stus09+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println(" Total tasks pending approval :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("pendingadminappr",countp);
													
												 
											 }
											
											
											//18. Projects In UAT
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus002 = "10";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus002+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println(" Project in UAT :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("projectuat",countp);
													
												 
											 }
											
												//19. Projects On HOld
											 
										    
											stmt2 = mysqlConn.createStatement();
											String stus003 = "11";
											rs = stmt2.executeQuery("SELECT COUNT(status) AS 'result'  FROM projects where status='"+stus003+"' AND del_indicator != '"+val+"' ");
											 
											while(rs.next()){
												 
												 String countp = rs.getString(1);
												 System.out.println(" Project OnHold :" +countp);
												 
													HttpSession session = request.getSession(true);
													session.setAttribute("projectsOnhold",countp);
													
												 
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
