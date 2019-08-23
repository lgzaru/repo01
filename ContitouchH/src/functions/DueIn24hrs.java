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
		String lead = null, assignedto = null;
		
		

		
			
 try {
		 mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		 Statement stmt,stmt2 = null;
		 
		//9. OverDue Tasks
		 stmt = mysqlConn.createStatement();
			rs = stmt.executeQuery("SELECT *  FROM tasks  where duedate <= CURDATE()  AND del_indicator != '"+val+"'  ");
			while(rs.next()){
				 
				 String pname = rs.getString("project_name");
				 lead = rs.getString("leader");
				 assignedto = rs.getString("assignedto");
				 String duedate = rs.getString("duedate");
				 String projectid = rs.getString("projectid");
				 String tname = rs.getString("tname");
				 
				
				
				System.out.println("Project Name: "+pname); 
				System.out.println("Lead: "+lead);
				System.out.println("Admin:"+assignedto); 
				System.out.println("Due Date: "+duedate);
				System.out.println("Project ID:"+projectid);	
				
				 
			SendEmail.SendMailDue24hrs(pname, lead, assignedto, duedate, projectid,tname, assignedto);
			
			System.out.println("Email lead:"+lead+" sent");
			System.out.println("Email assignedto:"+assignedto+" sent");
			System.out.println("__________________________________________________________________________________________");
			 
			
			
			
			stmt2 = mysqlConn.createStatement();
			
			
			
			rs2 = stmt2.executeQuery("SELECT pnumber  FROM users  where email = '"+lead+"' OR email = '"+assignedto+"'  ");
			while(rs2.next()){
				
				String pnumber = rs2.getString("pnumber");
				System.out.println("Phone number is :"+pnumber);
				
				String msg = "You have overdue tasks on the Project: "+pname+". Please login and clear your tasks. Task Name:"+tname+" Due Date: "+duedate+" "
						+ "Assigned to: "+assignedto+" Project Lead: "+lead;
				
				ContiSMS.SendSMS(pnumber, msg);
				
			     }
			
			 }
	

}
 
	catch (Exception e) { 
		e.printStackTrace();	
	}

 
    }
    
}
