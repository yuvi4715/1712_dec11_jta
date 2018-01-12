package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {
	/* Make tomcat now which database driver to use */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/* Get connection to JDBC */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@shendb.cggugjc0eoa7.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "ersjason";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}
}
