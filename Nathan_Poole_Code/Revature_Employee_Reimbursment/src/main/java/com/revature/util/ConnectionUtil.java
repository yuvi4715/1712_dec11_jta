package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@jta1712.cdybzeipotxu.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "employeeUser";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
		
	}
}
