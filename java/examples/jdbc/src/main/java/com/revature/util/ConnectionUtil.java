package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@sdetjta.cvoui7q38caj.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "LOGIN_TEST_DB";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
		
	}

	
}
