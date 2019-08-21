<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import =  "conn.ConMysqlLocalhost" import="functions.AdminDash"  import="java.util.ArrayList"
import="java.util.List" import="java.util.Arrays" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">



<!DOCTYPE html>
<html>
    <head>
        <title>Display Selected HTML Table TR Values In Input Text</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        
        <style>
            table tr:not(:first-child){
                cursor: pointer;transition: all .25s ease-in-out;
            }
            table tr:not(:first-child):hover{background-color: #ddd;}
        </style>
        
    </head>
    <body>
 

        
        <%   
        
    	
    	
    	Connection mysqlConn = null;
    	
    	try{
       mysqlConn = ConMysqlLocalhost.getMySqlConnection();
		ResultSet rs = null;
		 Statement stmt2 = null;
		 stmt2 = mysqlConn.createStatement();
		    //String stus7 = "1";
		    
		    List<String> names = new ArrayList<String>();
		    
			rs = stmt2.executeQuery("SELECT *  FROM users   ");
			
			while(rs.next()){
				
				
				
				names.add(rs.getString("name"));
				
			}//close while 
			
			
			//System.out.println(Arrays.toString(names.toArray()));
			out.println(names);
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
			
			
        
        
        %>
     
   
       

        
    </body>
</html>