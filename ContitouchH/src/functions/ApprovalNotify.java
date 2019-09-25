package functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import conn.ConMysqlLocalhost;

public class ApprovalNotify {
	
	
	
    
public static void main(String[] args) {
		 
    	Connection mysqlConn = null;
		ResultSet rs = null;
		String val = "2";
		//String val2 = "TRUE";
		//String val3 = "Administrator";
		String adminemail = "syndralla.mariza@contitouch.co.zw";
		
		
		
			
 try {
		 mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		 Statement stmt = null;
		 String msg = null;

			  
			 
			 
		 
		//Waiting Approval Tasks
		 stmt = mysqlConn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(tasks.task_id) AS 'result', users.pnumber FROM tasks"
			+	" INNER JOIN users ON tasks.createdby=users.email"
			+	" where tasks.todo_status = '"+val+"' AND tasks.createdby = '"+adminemail+"' AND tasks.duedate < CURDATE() ") ;
			
			
			
			while(rs.next()){
				 
				 int result = rs.getInt("result");
				 String cellno = rs.getString("users.pnumber");
				 
				 msg = "You have ["+result+" task]s waiting for your approval";
	
				if(result != 0)
				{
				ContiSMS.SendSMS(cellno, msg, null);
				 }
				
				else {
					System.out.println("No tasks pending approval");
				}
				 
			}
			
			 
	

}
 
	catch (Exception e) { 
		e.printStackTrace();	
	}

 
    }
    
}
