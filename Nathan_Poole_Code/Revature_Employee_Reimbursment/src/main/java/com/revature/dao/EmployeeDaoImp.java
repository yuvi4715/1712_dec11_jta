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


public class EmployeeDaoImp implements EmployeeDao {
	
	private static EmployeeDaoImp employeeDaoImp;
	
	private EmployeeDaoImp() {}
	
	public static EmployeeDaoImp getInstance() {
		if (employeeDaoImp == null) {
			employeeDaoImp = new EmployeeDaoImp();
		}
		return employeeDaoImp;
	}
	
//inserts an employee with preparedStatement
	public boolean insert(Employee employee) {

		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;

			//Simple insert statement to insert into customer table
			String sql = "INSERT INTO EMPLOYEES VALUES(NULL, ?, ?, ?, ?, DEFAULT, ?, ?)";

			//Execute an insert statement using prepared statement
			PreparedStatement p = conn.prepareStatement(sql);

			//Incrementing the statementIndex helps in ordering the parameters
			p.setString(++statementIndex, employee.getEmployeeName().toUpperCase());
			p.setString(++statementIndex, employee.getEmail().toLowerCase());
			p.setString(++statementIndex, employee.getUsername());
			p.setString(++statementIndex, employee.getPw());
			p.setString(++statementIndex, employee.getTitleType());
			p.setInt(++statementIndex, employee.getManagerState());

			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception inserting employee", e);
		}
		return false;
	}
	
//inserts an employee with procedure
	public boolean insertProcedure(Employee employee) {

		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;

			//Calling the store procedure
			String storedProc = "{CALL INSERT_EMPLOYEE(?,?,?,?,?,?)}";  
			
			//Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement c = conn.prepareCall(storedProc);

			//Set attributes to insert
			c.setString(++statementIndex, employee.getEmployeeName().toUpperCase());
			c.setString(++statementIndex, employee.getEmail().toLowerCase());
			c.setString(++statementIndex, employee.getUsername());
			c.setString(++statementIndex, employee.getPw());
			c.setString(++statementIndex, employee.getTitleType());
			c.setInt(++statementIndex, employee.getManagerState());

			if(c.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception insering employee using Stored Procedure", e);
		}
		return false;
	}
//============================================================================================
	
//=====================GOOD DO NOT TOUCH======================================================
//selects a given employee by their Username
	public Employee select(Employee employee) {

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEES WHERE USERNAME = ?"; 
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, employee.getUsername());
			ResultSet result = p.executeQuery();
			
			while (result.next()) {
				return new Employee(
				result.getInt("EMPID"),
				result.getString("EMPLOYEENAME"),
				result.getString("EMAIL"),
				result.getString("USERNAME"), 
				result.getString("PW"),
				result.getString("TITLETYPE"),
				result.getInt("ISMANAGER"));
			}
			
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a customer by username", e);
		}
		return new Employee();
	}
//============================================================================================

//returns a lists of all employees in the DB	
	public List<Employee> selectAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEES";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();

			List<Employee> customerList = new ArrayList<>();
			while (rs.next()) {
				customerList.add(
						new Employee(
								rs.getInt("EMPID"),
								rs.getString("EMPLOYEENAME"),
								rs.getString("EMAIL"),
								rs.getString("USERNAME"), 
								rs.getString("PW"),
								rs.getString("TITLETYPE"),
								rs.getInt("ISMANAGER")));
			}

			return customerList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all employees", e);
		}

		return new ArrayList<>();	}

//=====================GOOD DO NOT TOUCH======================================================
//returns the hash of a given username and pw
	public String getCustomerHash(Employee employee) {
		//System.out.println("EmployeeDaoImp.getCustomerHash");
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			//System.out.println("connection good");
			int statementIndex = 0;
			String command = "SELECT GET_EMPLOYEE_HASH(?,?) AS HASH FROM DUAL";
			//System.out.println("Command created");
			PreparedStatement statement = connection.prepareStatement(command);
			//System.out.println("statement Created");
			statement.setString(++statementIndex, employee.getUsername());
			//System.out.println("Username added to statement");
			statement.setString(++statementIndex, employee.getPw());
			//System.out.println("Password added to statement");
			ResultSet result = statement.executeQuery();
			//System.out.println(result.toString());

			if(result.next()) {
				//System.out.println(result.getString("HASH"));
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting employee hash", e);
		}
		return new String();
	}
//============================================================================================
	
//updates an employee record
	@Override
	public boolean update(Employee employee) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			String storedProc = "{CALL UPDATE_EMPLOYEE(?,?,?,?,?)}";
			CallableStatement c = conn.prepareCall(storedProc);
			
			c.setInt(++statementIndex, employee.getEmployeeId());
			c.setString(++statementIndex, employee.getEmployeeName());
			c.setString(++statementIndex, employee.getEmail());
			c.setString(++statementIndex, employee.getUsername());
			c.setString(++statementIndex, employee.getPw());

			if(c.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception updating employee", e);
		}
		return false;
	}
	
	
	public Employee selectId(Employee employee) {

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPID = ?"; 
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, employee.getEmployeeId());
			ResultSet result = p.executeQuery();
			
			while (result.next()) {
				return new Employee(
				result.getInt("EMPID"),
				result.getString("EMPLOYEENAME"),
				result.getString("EMAIL"),
				result.getString("USERNAME"), 
				result.getString("PW"),
				result.getString("TITLETYPE"),
				result.getInt("ISMANAGER"));
			}
			
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a customer by empid", e);
		}
		return new Employee();
	}
	
}
