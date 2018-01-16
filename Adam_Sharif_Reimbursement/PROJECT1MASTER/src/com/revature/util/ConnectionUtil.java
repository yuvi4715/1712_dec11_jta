package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
		}
	}
	
	
	/* Get connection to JDBC */
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:oracle:thin:@newjta1712.cbhrrtbhbg36.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "adamsharif";
		String password = "p4ssw0rd";
		
		System.out.println("Connection getConnection");
		
		return DriverManager.getConnection(url, username, password);
	}
	
}
