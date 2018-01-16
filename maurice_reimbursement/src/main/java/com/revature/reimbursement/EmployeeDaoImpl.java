package com.revature.reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl employeeDaoImpl;
	
	private EmployeeDaoImpl() {
		
	}
	
	public static EmployeeDaoImpl getInstance() {
		if (employeeDaoImpl == null) {
			employeeDaoImpl = new EmployeeDaoImpl();
		}
		return employeeDaoImpl;
	}
	
	
	
	
	// retreive all Employee in the table 
	public List<Employee> getAllEmployee() {
		//List<Employee> employee = new ArrayList();
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String emp = "Employee";
			
			String sql = "SELECT * FROM EMPLOYEE WHERE roleid = ? ";
			PreparedStatement p = conn.prepareStatement(sql);
			
			p.setString(1, emp);
			
			ResultSet result = p.executeQuery();
			
			List<Employee> employeeList = new ArrayList();
			while (result.next()) {
				employeeList.add(new Employee(
				result.getInt("EID"),
				result.getString("FIRSTNAME"),
				result.getString("LASTNAME"),
				result.getString("EMAIL"),
				result.getString("ROLEID"),
				result.getString("TITLE"))
						);
			}
			
			return employeeList;
		} catch(SQLException e) {
			e.printStackTrace();
			}
		return new ArrayList();
	
	}
	
	//select Employee from table and return to view
	public Employee getEmployee(Employee employee) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			int statementIndex = 0;
			
			
			//System.out.println(employee.getEid()); //test
			
			//int theID = employee.getEid();
			
			String sql = "SELECT * FROM EMPLOYEE WHERE EID = ? ";
			PreparedStatement p = conn.prepareStatement(sql);
			
			p.setInt(1, employee.getEid());  //set the EID of the sql statement 
			
			ResultSet result = p.executeQuery();
			
			while (result.next()) {
				return new Employee(
				result.getInt("EID"),
				result.getString("FIRSTNAME"),
				result.getString("LASTNAME"),
				result.getString("EMAIL"),
				result.getString("ROLEID"),
				result.getString("TITLE")
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			}
		return new Employee();
		

	}
	
	//insert into Closed table
	public boolean insertEmployee(Employee employee) {
		try{
			Connection conn = ConnectionUtil.getConnection();
		
			int statementIndex = 0;
			
			String sql = "insert into employee values(NULL, ?, ?, ?, ?, ?, ?)"; //check SQL statment to make sure the arguments accord
			
			PreparedStatement p = conn.prepareStatement(sql);
			
			p.setInt(++statementIndex, employee.getEid());
			//p.setString(++statementIndex, closed.getRid()); //.toUpperCase());  //figure out how to convert to string for lookup
			//p.setString(++statementIndex, closed.getAmt()); //.toUpperCase()); //ditto
			p.setString(++statementIndex, employee.getFirstname().toUpperCase());
			p.setString(++statementIndex, employee.getLastname().toUpperCase());
			p.setString(++statementIndex, employee.getEmail().toUpperCase());
			p.setString(++statementIndex, employee.getRoleid().toUpperCase());
			p.setString(++statementIndex, employee.getTitle().toUpperCase());
		
			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	//update the user row in the table for a selected employee -- UNDER CONSTRUCTION
	public boolean updateEmployee(Employee employee) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			int statementIndex = 0;
			
			//note: test block ran successfully here; employee object retains attributes
			System.out.println(employee.getFirstname());
			System.out.println(employee.getLastname());
			System.out.println(employee.getEmail());
			System.out.println(employee.getTitle());
			System.out.println(employee.getEid());
			
			//the error seems to occur before this method can return, as the test print in the EmployeeController does not fire
			//end test block
			
			/*String sql = "UPDATE EMPLOYEE SET firstname = ?, lastname = ?, email = ?, title = ? WHERE EID = ?";  //this block of code halts the program
			PreparedStatement p = conn.prepareStatement(sql);
			
			//set strings before execute query
			
		    p.setString(1, employee.getFirstname());
			p.setString(2, employee.getLastname());
			p.setString(3, employee.getEmail());
			p.setString(4, employee.getTitle());
			p.setInt(5, employee.getEid());
			
			
			p.executeQuery();
			//p.close();*/
			
			// EXPERIMENTAL BLOCK
			
			String sql = "UPDATE EMPLOYEE SET firstname = ?, lastname = ?, email = ?, title = ? WHERE EID = ? ";  //this block of code halts the program
			PreparedStatement p = conn.prepareStatement(sql);
			
			//set strings before execute query
			
		    p.setString(++statementIndex, employee.getFirstname());
		    p.setString(++statementIndex, employee.getLastname());
		    p.setString(++statementIndex, employee.getEmail());
		    p.setString(++statementIndex, employee.getTitle());
			p.setInt(++statementIndex, employee.getEid());
			
			
			p.executeQuery();
			//p.close();
			
			//EXPERIMENTAL BLOCK END
			
			
			
		} catch (SQLException e) {
		e.printStackTrace();	
		}
		return true;
	}
	
	
	
	
	//delete employee from table -- UNDERCONSTRUCTION
	public boolean deleteEmployee(Employee employee) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			int statementIndex = 0;
			
			String sql = "DELETE FROM EMPLOYEE WHERE EID = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			
			p.executeQuery();
			
			/*ResultSet result = p.executeQuery();
			
			while (result.next()) {
				return new Closed(
				result.getInt("RID"),
				result.getInt("AMT"),
				result.getInt("EID"),
				result.getString("STATUS"),
				result.getString("STARTTIME"),
				result.getString("ENDTIME"),
				result.getString("DESCRIPTION"));
			}*/
		} catch(SQLException e) {
			e.printStackTrace();
			}
		//return new Closed();
		return true;
		

	
		
	}
	
	
	
}
