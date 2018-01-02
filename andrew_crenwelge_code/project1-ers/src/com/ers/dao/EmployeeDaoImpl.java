package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ers.model.Employee;
import com.ers.util.ConnectionUtil;

import oracle.sql.DATE;

public class EmployeeDaoImpl implements EmployeeDao{

	private static EmployeeDaoImpl employeeDaoImpl;
	
	private EmployeeDaoImpl() {
	}
	
	public static EmployeeDaoImpl getInstance() {
		if (employeeDaoImpl == null) {
			employeeDaoImpl = new EmployeeDaoImpl();
		}
		return employeeDaoImpl;
	}
	
	//Insert into employee table using PreparedStatement
	@Override
	public boolean addNewEmployee(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			//Simple insert statement to insert into employee table
			String sql = "insert into employee values(NULL, ?, ?, ?, ?)";
			
			//Execute an insert statement using prepared statement
			PreparedStatement p = conn.prepareStatement(sql);
			
			//Incrementing the statementIndex helps in ordering the parameters
			p.setString(++statementIndex, employee.getFirstname().toUpperCase());
			p.setString(++statementIndex, employee.getLastname().toUpperCase());
			p.setString(++statementIndex, employee.getUsername().toUpperCase());
			p.setString(++statementIndex, employee.getpasshash());
			
			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Select employee based on his user name
	@Override
	public Employee getEmployeeByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employee WHERE username = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, username);
			ResultSet result = p.executeQuery();
			while (result.next()) {
				return new Employee(
				result.getInt("E_ID"),
				result.getString("E_FIRSTNAME"),
				result.getString("E_LASTNAME"),
				result.getString("E_USERNAME"),
				result.getString("E_PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Employee();
	}

	@Override
	public List<Employee> getAllEmployees() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "Select * from employee";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			List<Employee> employeeList = new ArrayList<>();
			while (rs.next()) {
				employeeList.add(new Employee(
						rs.getInt("E_ID"),
						rs.getString("E_FIRSTNAME"),
						rs.getString("E_LASTNAME"),
						rs.getString("E_USERNAME"),
						rs.getString("E_PASSWORD"))
						);
			}
			
			return employeeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	/* Get a employee hash consuming the user defined function we created */
	@Override
	public String getEmployeeHash(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT GET_employee_HASH(?,?) AS HASH FROM DUAL";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getpasshash());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new String();
	}
	
	@Override
	public boolean authenticate(String username, String password) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT * FROM user WHERE username = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) { // checks that the username exists
				String db_password = rs.getString(3);
				// String db_salt = rs.getString(4);
				if (password == db_password)
					return true;
				else
					return false;
			}
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean logout(int sessionId) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "UPDATE sessionlog SET logouttime = ? WHERE sessionId = ?"; // insert record into sessionlog
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setTimestamp(++statementIndex, new Timestamp(System.currentTimeMillis()));
			statement.setInt(++statementIndex, sessionId);

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean updateInfo(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employee WHERE empId = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet result = p.executeQuery();
			while (result.next()) {
				return new Employee(
				result.getInt("E_ID"),
				result.getString("E_FIRSTNAME"),
				result.getString("E_LASTNAME"),
				result.getString("E_USERNAME"),
				result.getString("E_PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Employee();
	}
}
