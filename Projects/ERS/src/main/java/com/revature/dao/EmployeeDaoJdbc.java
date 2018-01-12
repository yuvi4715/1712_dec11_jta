package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

/* JDBC implementation for DAO contract for Employees data access */
public class EmployeeDaoJdbc implements EmployeeDao {
	
	/*Singleton transformation of JDBC implementation object */
	private static EmployeeDaoJdbc employeeDaoJdbc;
	
	private EmployeeDaoJdbc() {
		
	}
	
	public static EmployeeDaoJdbc getEmployeeDaoJdbc() {
		if(employeeDaoJdbc == null) {
			employeeDaoJdbc = new EmployeeDaoJdbc();
		}
		
		return employeeDaoJdbc;
	}
	
	/* Regular insert statement for Employee */
	@Override
	public boolean insert(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "INSERT INTO EMPLOYEE VALUES(NULL,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
			statement.setString(++statementIndex, employee.getFirstName());
			statement.setString(++statementIndex, employee.getLastName());
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new employee", e);
		}
		return false;
	}

	/* Insert a employee using the stored procedure we created */
	@Override
	public boolean insertProcedure(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			String command = "{CALL INSERT_EMPLOYEE(?,?,?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setString(++statementIndex, employee.getFirstName());
			statement.setString(++statementIndex, employee.getLastName());
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception creating a new employee with stored procedure", e);
		}
		return false;
	}

	/* Select Employee based on his username */
	@Override
	public Employee select(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, employee.getUsername());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				
				return new Employee(
						result.getInt("employeeId"),
						result.getString("username"),
						result.getString("password"),
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("logStatus"),
						result.getString("title"),
						result.getInt("roleId"),
						result.getString("email"),
						result.getString("position")
						);
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a employee", e);
		}
		return new Employee();
	}

	
	@Override
	public Employee getEmployeeByUsername(String username) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				
				return new Employee(
						result.getInt("employeeId"),
						result.getString("username"),
						result.getString("password"),
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("logStatus"),
						result.getString("title"),
						result.getInt("roleId"),
						result.getString("email"),
						result.getString("position")
						);
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a employee", e);
		}
		return new Employee();
	}

	
	/* Select all employees */
	public List<Employee> selectAll() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM EMPLOYEE";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Employee> employeeList = new ArrayList<>();
			while(result.next()) {
				employeeList.add(new Employee(
						result.getInt("employeeId"),
						result.getString("username"),
						result.getString("password"),
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("logStatus"),
						result.getString("title"),
						result.getInt("roleId"),
						result.getString("email"),
						result.getString("position")
						));
			}

			return employeeList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		} 
		return new ArrayList<>();
	}

	/* Get a employee hash consuming the user defined function we created */
	@Override
	public String getEmployeeHash(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT GET_EMPLOYEE_HASH(?,?) AS HASH FROM DUAL";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting employee hash", e);
		} 
		return new String();
	}
	
	@Override
	public boolean authenticateEmployee(String username, String password) {
		//System.out.println("authenticateEmployee entered");
		try(Connection connection = ConnectionUtil.getConnection()){
			//System.out.println("try block entered");
			String command = "SELECT * FROM EMPLOYEE WHERE Username = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()){
				//System.out.println("rs.next() ENTERED");
				String account_password = rs.getString(3);
				//System.out.println("Get string 3 returns: " + rs.getString(3));
				if (password.equals(account_password)) {
					LogUtil.logger.info("Password match");
					return true;
				}
				else {
					LogUtil.logger.warn("Invalid password");
					return false;
				}
			}
			else {
				LogUtil.logger.warn("Invalid username");
				//System.out.println("No resultset");
				return false;
			}
		}
		catch (SQLException e) {
			//System.out.println("exception getting user account");
			LogUtil.logger.warn("Exception getting user account", e);
		}
		//System.out.println("end of function, returning false");
		return false;
	}
	
	@Override
	public boolean updateInfo(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "{CALL UPDATE_INFO(?,?,?,?,?,?)}";
			CallableStatement statement = connection.prepareCall(command);
			//System.out.println("Logged in employee ID being used for UPDATE_INFO: " + employee.getEmployeeId());
			statement.setInt(++statementIndex, employee.getEmployeeId());
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			statement.setString(++statementIndex, employee.getFirstName());
			statement.setString(++statementIndex, employee.getLastName());
			statement.setString(++statementIndex, employee.getEmail());
			//System.out.println(employee.getUsername() + "profile updated");
			
			if(statement.executeUpdate() > 0) {
				//System.out.println("Updated info!");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
