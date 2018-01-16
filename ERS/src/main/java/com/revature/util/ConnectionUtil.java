package com.revature.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public final class ConnectionUtil {

	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@jta1712.cxzi6zpn1gnx.us-east-2.rds.amazonaws.com:1521:ORCL";
			String user = "reimburse";
			String password = "reimburse1";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
