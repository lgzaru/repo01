/*
 * package functions;
 * 
 * import java.io.PrintWriter; import java.sql.ResultSet; import
 * java.sql.Statement;
 * 
 * import javax.servlet.http.HttpSession;
 * 
 * import conn.ConMysqlLocalhost;
 * 
 * public class CheckOpenTasks {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * 
 * //inprogress count int val2 = 1; java.sql.Connection mysqlConn = null;
 * Statement stmt = null; stmt = mysqlConn.createStatement(); ResultSet rs
 * =null;
 * 
 * PrintWriter out = response.getWriter(); HttpSession session =
 * request.getSession(true);
 * 
 * 
 * 
 * 
 * try { mysqlConn = ConMysqlLocalhost.getMySqlConnection(); rs = stmt.
 * executeQuery("SELECT COUNT(projectid) AS 'result'  FROM tasks  where todo_status='"
 * +val2+"'  AND del_indicator != '"+val+"' AND projectid = '"+projectid+"'   "
 * ); while(rs.next()){
 * 
 * String countp = rs.getString(1);
 * System.out.println("Inprogress tasks per project:" +countp);
 * 
 * session.setAttribute("inprogresstasksp",countp);
 * 
 * }
 * 
 * catch(Exception e){
 * 
 * System.out.println(e);
 * 
 * }
 * 
 * finally { try { mysqlConn.close(); } catch (Exception ignore) { } }
 * 
 * }
 * 
 * 
 * }
 * 
 * }
 */