package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;
	
	//open connection
	public static Connection openConnection() throws SQLException {
		String dburl="jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn=DriverManager.getConnection(dburl, "root", "root123");
		System.out.println("db connection established");
		return cn;
	}
	
	//close connection
	public static void closeConnection() throws SQLException {
		if(cn!=null) 
			cn.close();
		System.out.println("db connection closed");
	}
	
	
	
	
	
	
	

}
