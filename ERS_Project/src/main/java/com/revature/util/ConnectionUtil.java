package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Final utility class to obtain connections in a modular way */
public final class ConnectionUtil {
	
	/* Make tomcat now which database driver to use */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error");
		}
	}
	
	/* Get connection to JDBC */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@jta1712.cwsnbiukojgq.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "reimbursement_admin";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}
}
