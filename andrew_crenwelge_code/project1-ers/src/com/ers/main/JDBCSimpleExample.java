package com.ers.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSimpleExample {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		loadDrivers(); // step 1
		jdbcExample("jdbc:oracle:thin:@jta1712.cz8wjbq38i1b.us-east-2.rds.amazonaws.com:1521:ORCL","admin", "werdna33");
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
		try(Connection conn = DriverManager.getConnection(url, user, password)) { //2
			System.out.println("connection should be established");
			String sql = "SELECT * FROM employee e join usertable u on e.empid=u.empid WHERE u.username=?";
			PreparedStatement p = conn.prepareStatement(sql);										  //3
			// CallableStatement cs = conn.prepareCall(sql);
			// cs.setString(1, "acrenwelge");
			p.setString(1, "acrenwelge");
			rs = p.executeQuery();	//4, 5
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " : " +  
						rs.getString(2) + " : " + 
						rs.getString(3)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
