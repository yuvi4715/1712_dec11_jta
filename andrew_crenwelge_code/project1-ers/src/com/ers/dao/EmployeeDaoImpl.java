package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.model.Employee;
import com.ers.util.ConnectionUtil;

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
	public boolean insert(Employee employee) {
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
			p.setString(++statementIndex, employee.getPassword());
			
			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Insert into employee table using PreparedStatement	
	@Override
	public boolean insertProcedure(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			//Calling the store procedure
			String storedProc = "CALL INSERT_employee(?,?,?,?)";
			
			//Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement c = conn.prepareCall(storedProc);
			
			//Set attributes to insert
			c.setString(++statementIndex, employee.getFirstname().toUpperCase());
			c.setString(++statementIndex, employee.getLastname().toUpperCase());
			c.setString(++statementIndex, employee.getUsername().toUpperCase());
			c.setString(++statementIndex, employee.getPassword());
			
			if(c.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Select employee based on his user name
	@Override
	public Employee select(Employee employee) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			String sql = "SELECT * FROM employee WHERE E_USERNAME = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			
			//Incrementing the statementIndex helps in ordering the parameters
			p.setString(++statementIndex, employee.getFirstname());
			
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
	public List<Employee> selectAll() {
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
			statement.setString(++statementIndex, employee.getPassword());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new String();
	}
}
