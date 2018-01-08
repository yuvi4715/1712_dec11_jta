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
import com.ers.util.LogUtil;


public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl employeeDaoImpl;
	
	private EmployeeDaoImpl() {}
	
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
			String sql = "INSERT INTO employee values(EMPLOYEE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";			
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(++statementIndex, employee.getFirstname());
			p.setString(++statementIndex, employee.getLastname());
			p.setString(++statementIndex, employee.getEmail());
			p.setString(++statementIndex, employee.getBirthdate());
			p.setString(++statementIndex, employee.getPhoneNumber());
			p.setString(++statementIndex, employee.getAddress());
			p.setString(++statementIndex, employee.getCity());
			p.setString(++statementIndex, employee.getState());
			p.setString(++statementIndex, employee.getCountry());
			p.setString(++statementIndex, employee.getZip());
			p.setBoolean(++statementIndex, employee.getIsManager());
			//execute the statement
			if (p.executeUpdate() > 0) {
				LogUtil.logger.info("Employee added: "+employee);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Get employee based on user name
	@Override
	public Employee getEmployeeByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employee e JOIN usertable u on e.empid=u.empid WHERE u.username=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, username);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				return new Employee(
						r.getInt(1),    // empId
						r.getString(2), // fname
						r.getString(3), // lname
						r.getString(4), // email
						r.getString(5), // birthdate
						r.getString(6), // phone
						r.getString(7), // address
						r.getString(8), // city
						r.getString(9), // state
						r.getString(10),// country
						r.getString(11),// zip
						r.getBoolean(12)// isManager
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Employee();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employee";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				employeeList.add(new Employee(
						r.getInt(1),    // empId
						r.getString(2), // fname
						r.getString(3), // lname
						r.getString(4), // email
						r.getString(5), // birthdate
						r.getString(6), // phone
						r.getString(7), // address
						r.getString(8), // city
						r.getString(9), // state
						r.getString(10),// country
						r.getString(11),// zip
						r.getBoolean(12)// isManager
						));
			}
			return employeeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	/* Get a employee hash consuming the user defined function we created */
	@Override
	public String getEmployeeHash(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT passhash FROM usertable WHERE empid=?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, employee.getId());
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
			String command = "SELECT * FROM usertable WHERE username = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) { // checks that the username exists
				String db_password = rs.getString(3);
				// String db_salt = rs.getString(4);
				if (password.equals(db_password)) {
					LogUtil.logger.info("User "+username+" authenticated");
					return true;
				}
				else {
					LogUtil.logger.warn("Invalid credentials for "+username);
					return false;
				}
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
		return true;
	}

	@Override
	public boolean updateInfo(Employee emp) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int idx = 0;
			String command = "{CALL updateEmpInfo(?,?,?,?,?,?,?,?)}";
			CallableStatement cs = connection.prepareCall(command);
			cs.setInt(   ++idx, emp.getId());
			cs.setString(++idx, emp.getEmail());
			cs.setString(++idx, emp.getPhoneNumber());
			cs.setString(++idx, emp.getAddress());
			cs.setString(++idx, emp.getCity());
			cs.setString(++idx, emp.getState());
			cs.setString(++idx, emp.getCountry());
			cs.setString(++idx, emp.getZip());
			int rowsAffected = cs.executeUpdate();
			System.out.println("Employee updated: "+emp);
			System.out.println("Rows affected: "+rowsAffected);
			LogUtil.logger.info("Employee " + emp.getId() + " information updated. "+rowsAffected +" rows affected");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee getEmployeeById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employee WHERE empId = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				return new Employee(
						r.getInt(1),    // empId
						r.getString(2), // fname
						r.getString(3), // lname
						r.getString(4), // email
						r.getString(5), // birthdate
						r.getString(6), // phone
						r.getString(7), // address
						r.getString(8), // city
						r.getString(9), // state
						r.getString(10),// country
						r.getString(11),// zip
						r.getBoolean(12)// isManager
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Employee();
	}
}
