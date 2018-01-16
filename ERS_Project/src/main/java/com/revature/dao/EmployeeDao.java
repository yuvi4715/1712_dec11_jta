package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDao {

	private static EmployeeDao instance = null;

	private EmployeeDao() {
	}

	public static EmployeeDao getInstance() {
		if (instance == null) {
			instance = new EmployeeDao();
		}
		return instance;
	}

	public ArrayList<Employee> selectAllEmployees(String user, String pass) {
		ArrayList<Employee> employees = new ArrayList<Employee>();

		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "select * from employee";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet result = statement.executeQuery();
			result = statement.executeQuery();

			while (result.next()) {
				int id = result.getInt("EmployeeId");
				String lastName = result.getString("LastName");
				String firstName = result.getString("FirstName");
				String title = result.getString("Title");
				int reportsTo = result.getInt("ReportsTo");
				String email = result.getString("Email");
				String username = result.getString("Username");
				String password = result.getString("Password");
				Employee employee = new Employee(id, firstName, lastName, title, reportsTo, email, username, password);
				employees.add(employee);
			}

			result.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	public void updateEmployee(Employee employee, String email, String password) {
		System.out.println("EmployeeDao: updateEmployee()");
	
		try (Connection connection = ConnectionUtil.getConnection()) {

			String command = "UPDATE Employee SET Email= ?, Password= ? WHERE EmployeeId = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setInt(3, employee.getEmployeeId());
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Employee findEmployeeById(String username, String password) {

		Employee employee = null;
		
		System.out.println("EmployeDao: findEmployeeById()");

		try (Connection connection = ConnectionUtil.getConnection()) {
			
			System.out.println("EmployeeDao: CONNECTION SUCCESSFUL");

			String sql = "select * from employee where username= ? and password= ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			
			if(result == null) {
			System.out.println("EmployeeDao: Result Null");
			}
			
			System.out.println("EmployeeDao: Result");

			while (result.next()) {
				
				System.out.println("EmployeeDao: IN WHILE");
				int id = result.getInt("EmployeeId");
				String lastName = result.getString("LastName");
				String firstName = result.getString("FirstName");
				String title = result.getString("Title");
				int reportsTo = result.getInt("ReportsTo");
				String email = result.getString("Email");
				String usrname = result.getString("Username");
				String pswd = result.getString("Password");
				employee = new Employee(id, firstName, lastName, title, reportsTo, email, usrname, pswd);
				
				System.out.println(employee.toString());
			}

			result.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}
	
	
	public Employee findEmployeeById(int employeeId) {

		Employee employee = null;
		
		System.out.println("EmployeDao: findEmployeeById()");

		try (Connection connection = ConnectionUtil.getConnection()) {
			
			System.out.println("EmployeeDao: CONNECTION SUCCESSFUL");

			String sql = "select * from employee where EmployeeId= ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, employeeId);
			
			ResultSet result = statement.executeQuery();
			
			if(result == null) {
			System.out.println("EmployeeDao: Result Null");
			}
			
			System.out.println("EmployeeDao: Result");

			while (result.next()) {
				
				System.out.println("EmployeeDao: IN WHILE");
				int id = result.getInt("EmployeeId");
				String lastName = result.getString("LastName");
				String firstName = result.getString("FirstName");
				String title = result.getString("Title");
				int reportsTo = result.getInt("ReportsTo");
				String email = result.getString("Email");
				String usrname = result.getString("Username");
				String pswd = result.getString("Password");
				employee = new Employee(id, firstName, lastName, title, reportsTo, email, usrname, pswd);
				
				System.out.println(employee.toString());
			}

			result.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
