package com.revature.tests;

import java.sql.Connection;

import com.revature.connection.ConnectionFactory;

// Testing the Connection
public class TestConnection {

	public static void main(String[] args) {
		Connection con = null;
		String username = "josephrpfernandez";
		String password = "Jorix1994";

		try {
			con = ConnectionFactory.getInstance().getConnection(username, password);
			System.out.println("Connection Successful!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("Connection Closed");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
