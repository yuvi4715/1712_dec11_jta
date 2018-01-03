package com.ers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@jta1712.cz8wjbq38i1b.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "testuser";
		String password = "testpass";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);	
	}
}
