package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConMysqlLocalhost {
	
	public static Connection getMySqlConnection() throws Exception {

		String url="jdbc:mysql://localhost:3306/residents";

		String username="root";
		String password="#pass123";

		Class.forName("com.mysql.jdbc.Driver"); // load MySQL driver
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
		}

}
