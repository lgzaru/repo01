package functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import conn.ConMysqlLocalhost;

public class DueIn24hrs {
	
	
	
    
public static void main(String[] args) {
		 
    	Connection mysqlConn = null;
		ResultSet rs, rs2 = null;
		String val = "True";
		String email = null;
		String msg,name = null;
		String role = "User";
		
		

		
			
 try {
		 mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		 Statement stmt,stmt2 = null;
		 
		//9. OverDue Tasks
		 stmt = mysqlConn.createStatement();
			rs = stmt.executeQuery("SELECT *  FROM users  where userroles = '"+role+"' AND del_indicator != '"+val+"'  ");
			while(rs.next()){
				 
					System.out.println("--------------------------------Start-------------------------------------------");
				    email = rs.getString("email");
			    	System.out.println("Email address: "+email); 
			    	
			    	name = rs.getString("name");
			    	System.out.println("User Name: "+name);
	
			 
			
			
			String val1 = "1";
			
			 stmt2 = mysqlConn.createStatement();
				rs2 = stmt2.executeQuery("SELECT COUNT(tasks.task_id) AS 'result', users.pnumber FROM tasks"
				+	" INNER JOIN users ON tasks.assignedto=users.email"
				+	" where tasks.todo_status <=  '"+val1+"' AND tasks.assignedto = '"+email+"' AND tasks.duedate < CURDATE() ") ;
				
				
				
				while(rs2.next()){
					 
					 int result = rs2.getInt("result");
					 String cellno = rs2.getString("users.pnumber");
					 
					 msg = "Hi "+name+"! You have ["+result+" task]s that are overdue. Please visit http://projects.contitouch.co.zw";
		
					if(result != 0)
					{
					ContiSMS.SendSMS(cellno, msg, null);
					 }
					
					else {
						System.out.println("No tasks due");
					}
					 
				}
				

			
			//--------------------------------------------------------------------
			
			 }
	

}
 
	catch (Exception e) { 
		e.printStackTrace();	
	}

 
    }
    
}
