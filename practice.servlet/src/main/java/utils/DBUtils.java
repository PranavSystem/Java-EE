package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;
	
	public static Connection openConnection(String url,String username,String pass) throws SQLException {
		cn=DriverManager.getConnection(url,username,pass);
		System.out.println("Database connection established");
		return cn;	
	}
	
	public static void closeConnection() throws SQLException {
		if(cn != null)
			cn.close();
		closeConnection();
		System.out.println("Database connection closed");
	}
	
}
