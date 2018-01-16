package com.revature.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeService {
	
	private static EmployeeService instance = null;

	private EmployeeService() {
	}

	public static EmployeeService getInstance() {
		if (instance == null) {
			instance = new EmployeeService();
		}
		return instance;
	}
	
	public Employee login(String username, String password) {
		//Get user information
		System.out.println("EmployeeService: login()");
		Employee loggedEmployee =  EmployeeDao.getInstance().findEmployeeById(username, password);
		
		return loggedEmployee;
	}
	
	public boolean verifyCredentials(String username, String password) {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "select * from employee where username= ? and password= ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
		

			if (result.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	
	

}
