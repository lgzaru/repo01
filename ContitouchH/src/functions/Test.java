package functions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.jdbc.Statement;

import conn.ConMysqlLocalhost;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
java.sql.Connection mysqlConn = null;

//JsonObject json = (JsonObject)session.getAttribute("jsonObject");
    	
try{
       mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		ResultSet rs = null;
		 Statement stmt2 = null;
		 stmt2 = (Statement) mysqlConn.createStatement();
		    //String stus7 = "1";
		    
		    List<String> allusers = new ArrayList<String>();
		    
		   
		    
			rs = stmt2.executeQuery("SELECT *  FROM users   ");
			while(rs.next()){
				
				allusers.add(rs.getString("email"));

				
				
			}//close while 
			
			
			//System.out.println(Arrays.toString(names.toArray()));
			//System.out.println("Names to List : "+names);
			
			Gson gSon = new Gson();
			
		     // Covert List to Json
            String allusersjson = gSon.toJson(allusers);
            
            // print Json
            System.out.println("email to Array : "+allusers);
            System.out.println("email to JSON : "+allusersjson);
            
            
        	/*HttpSession session = request.getSession(true);
            session.setAttribute("employeeJson",employeeJson);*/
			
	 }//close try
        
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
