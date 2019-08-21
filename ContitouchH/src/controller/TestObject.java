package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
/*import com.google.gson.JsonObject;*/
import conn.ConMysqlLocalhost;

/**
 * Servlet implementation class TestObject
 */
@WebServlet("/TestObject")
public class TestObject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestObject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		java.sql.Connection mysqlConn = null;
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		String projectid = session.getAttribute("theprojectid").toString();
		
/*		ReceiveObjectSession obj = new ReceiveObjectSession();
		obj.service(request, response);*/
		

	    	
	    	 
	    	// ArrayList<String> hobbies = (ArrayList<String>)session.getAttribute("hobbies");
				//session.setAttribute("hobbies", hobbies);
	    	
	    	try {
	    		mysqlConn = ConMysqlLocalhost.getMySqlConnection();

					
					Statement stmt = null;
					Statement stmt2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					stmt = mysqlConn.createStatement();
					stmt2 = mysqlConn.createStatement();
					
					List<String> allusers = new ArrayList<String>();
					List<String> taskstotals = new ArrayList<String>();
					String userroles = "User";
					
					
					
					
					
					
			rs=stmt.executeQuery("select * from users where userroles = '"+userroles+"'    ");
			while(rs.next()) {
				
				allusers.add(rs.getString("name"));
				String username = rs.getString("email");
			
				rs2=stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where assignedto='"+username+"' and projectid = '"+projectid+"'    ");
				while(rs2.next()) {
				
					String countp = rs2.getString(1);
					taskstotals.add(countp);
					
					
				    
					}



				}
			
/*			while(rs.next()) {
				
				//allusers.add(rs.getString("name"));
				String username = rs.getString("email");
			
				rs2=stmt2.executeQuery("SELECT COUNT(task_id) AS 'result'  FROM tasks where assignedto='"+username+"' and projectid = '"+projectid+"'    ");
				while(rs2.next()) {
					
					
					String countp = rs2.getString(1);
					int totaltasks = Integer.parseInt(countp);
					 
					if(totaltasks != 0) {
					
					allusers.add(rs.getString("name"));
					taskstotals.add(countp);
					
					 }
					String countp = rs2.getString(1);
					taskstotals.add(countp);
					
					
				    
					}



				}*/
			
		
			
			 Gson gSon = new Gson();
			
			 String allusersjson = gSon.toJson(allusers);
			 String taskstotalsjson = gSon.toJson(taskstotals);
			 
			 session.setAttribute("alluserssession", allusers);
			 session.setAttribute("taskstotalssession", taskstotals);
		
			System.out.println("All users:"+allusers);
			System.out.println("All totals:"+taskstotals);
			
			//obj.getUserDash(request, response); 
			
			
			/*RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
			rd.include(request, response);*/
			
	    }
	    	
	    	catch(Exception e) {
	    		
	    		  System.out.println(e);
	    		
	    	}

		
				
				
			
	    
		
		// TODO Auto-generated method stub
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
