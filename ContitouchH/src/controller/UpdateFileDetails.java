package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
/*import javax.servlet.http.HttpSession;
*/
import conn.ConMysqlLocalhost;

public class UpdateFileDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//public void FileUpdate(String clientid,String projectname,String summary,String datereceived,String myfilepath,String myfilename, String createdby){ 
	public void FileUpdate(HttpServletRequest request, String myfilepath,String myfilename, String userName2, String clientid,String projectname,String summary, String datereceived  ){ 

	String fileurl = "file:///C:/fileuploads/projecttracker/null/"+myfilename;

	    Connection mysqlConn = null;
	    //String userName2 =  session.getAttribute("User").toString();
	    
		
		 try {
		   
		      mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		      Statement stmt = null;

			
			System.out.println("Updating LocalDB Condition....");
			
			stmt = mysqlConn.createStatement();
			stmt.executeUpdate("insert into clientbrief(clientid,projectname,summary,datereceived,createdby,fileurl,filename) values ('"+clientid+"','"+projectname+"','"+summary+"','"+datereceived+"','"+userName2+"','"+fileurl+"','"+myfilename+"' )  ");

			System.out.println("File written to DB successfully");
			

		 
		    }
		
		 catch (Exception e) {
		      // handle the exception
			 
			   System.out.println("Some error occurred");
		      e.printStackTrace();
		      System.exit(1);
		     

		    } 
		 
		 
		 finally {
		      // release database resources
		     
			 try { mysqlConn.close();
		      } 
			 
			 
			 catch (SQLException e) {
				 System.out.println("Error 2");
		        e.printStackTrace();
			   }
		        
		   
		    
		 
		      }  //close finally
		 

			
			 
			} //close method
		 

			
		} //close class


