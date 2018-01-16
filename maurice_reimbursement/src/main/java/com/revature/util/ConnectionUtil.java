package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@jta1712.cebygjoqseri.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "admin";
		String password = "Crescent1";
		
		return DriverManager.getConnection(url, username, password);
	}

}
