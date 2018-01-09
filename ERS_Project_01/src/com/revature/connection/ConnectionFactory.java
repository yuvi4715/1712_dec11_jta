package com.revature.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionFactory {

	private static ConnectionFactory connection = null;

	public ConnectionFactory() {
	}

	public static ConnectionFactory getInstance() {

		if (connection == null) {
			connection = new ConnectionFactory();
		}

		return connection;
	}

	public Connection getConnection(String username, String password) throws Exception {
		// address for your server
		String url = "jdbc:oracle:thin:@joseph-db.ciuqkvmavnnb.us-east-2.rds.amazonaws.com:1521:ORCL";

		// configure the driver for your database
		Class.forName("oracle.jdbc.OracleDriver");

		return DriverManager.getConnection(url, username, password);
	}
}
