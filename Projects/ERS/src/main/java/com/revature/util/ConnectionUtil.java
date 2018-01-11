package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* Final utility class to obtain connections in a modular way */
public final class ConnectionUtil {
	
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultset = null;
	
	/* Make tomcat now which database driver to use */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LogUtil.logger.warn("Exception thrown adding oracle driver.",e);
		}
	}
	
	/* Get connection to JDBC */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@jta1712.co2kqw8m5kkd.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "adriel";
		String password = "yoshi";
		
		System.out.println("Connection getConnection");
		testConnection(url, username, password);
		
		return DriverManager.getConnection(url, username, password);
	}
	
	static void testConnection(String url, String username, String password) {
		System.out.println("testConnection");
		try {
			System.out.println("try block entered");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("DriverManager getConnection");
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * from EMPLOYEE");
			System.out.println("Printing all employees by name");
			while (resultset.next()) {
				System.out.println(resultset.getInt(1) + " : " + resultset.getString(2) + " : " + resultset.getString(3));
			}
			System.out.println("Connection Successful!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				resultset.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
