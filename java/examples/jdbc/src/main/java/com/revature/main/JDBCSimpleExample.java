package com.revature.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSimpleExample {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		loadDrivers(); // step 1
		jdbcExample("jdbc:oracle:thin:@sdetjta.cvoui7q38caj.us-east-2.rds.amazonaws.com:1521:ORCL","jta1712", "jta1712");
	}

	// 1 - load drivers
	static void loadDrivers() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2 - establish the connection, 3 - create sql statements, 4- execute the query
	// 5 - Store the results, 6 - close connection
	static void jdbcExample(String url, String user, String password) {
		try {
			conn = DriverManager.getConnection(url, user, password); //2
			System.out.println("connection should be established, but i donno");
			stmt = conn.createStatement();		//3
			rs = stmt.executeQuery("select * from player");	//4, 5
			while (rs.next()) {
				System.out.println(rs.getString(1) + " : " +  
						rs.getString(2) + " : " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
