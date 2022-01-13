package Util;

import java.sql.*;

//This class contains our DB connectivity code
public class DBUtil {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			String username = "root";
			String password = "1234";
			String url = "jdbc:mysql://localhost:3306/jobsearch";
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, username, password);				
		}
		catch(Exception e) {
			e.getMessage();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
