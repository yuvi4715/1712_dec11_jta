package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.util.ConnectionUtil;

public class LoginDao {

	private static LoginDao instance = null;

	private LoginDao() {}

	public static LoginDao getInstance() {
		if (instance == null) {
			instance = new LoginDao();
		}
		return instance;
	}

	public boolean verifyCredentials(String username, String password) {
		
		System.out.println("In Verify Credentials");

		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "select * from employee where username= ? and password= ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
		

			if (result.next()) {
				System.out.println(sql + "SUCESSFUL");
				return true;
			}else {
				System.out.println(sql + "NOT SUCESSFUL");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

}
