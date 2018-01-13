package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

/* JDBC implementation for DAO contract for Employee data access */
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
			System.out.println("connecting");
			int statementIndex = 0;
			String command = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
			statement.setInt(++statementIndex, employee.getId());
			statement.setString(++statementIndex, employee.getFirstName().toUpperCase());
			statement.setString(++statementIndex, employee.getLastName().toUpperCase());
			statement.setString(++statementIndex, employee.getEmail());
			statement.setString(++statementIndex, employee.getAddress());
			statement.setString(++statementIndex, employee.getCity());
			statement.setString(++statementIndex, employee.getState());
			statement.setString(++statementIndex, employee.getZip());
			statement.setString(++statementIndex, employee.getPhone());
			statement.setString(++statementIndex, employee.getUsername().toLowerCase());
			statement.setString(++statementIndex, employee.getPassword());

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return false;
	}

	/* Insert an employee using the stored procedure we created */
	@Override
	public boolean insertProcedure(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			String command = "{CALL INSERT_CUSTOMER(?,?,?,?,?,?,?,?,?,?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setInt(++statementIndex, employee.getId());
			statement.setString(++statementIndex, employee.getFirstName().toUpperCase());
			statement.setString(++statementIndex, employee.getLastName().toUpperCase());
			statement.setString(++statementIndex, employee.getEmail());
			statement.setString(++statementIndex, employee.getAddress());
			statement.setString(++statementIndex, employee.getCity());
			statement.setString(++statementIndex, employee.getState());
			statement.setString(++statementIndex, employee.getZip());
			statement.setString(++statementIndex, employee.getPhone());
			statement.setString(++statementIndex, employee.getUsername().toLowerCase());
			statement.setString(++statementIndex, employee.getPassword());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception inerting procedure", e);
		}
		return false;
	}

	/* Select Employee based on his username */
	@Override
	public Employee select(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				
				return new Employee(
						result.getInt("EMPLOYEEID"),
						result.getString("FIRSTNAME"),
						result.getString("LASTNAME"),
						result.getString("EMAILADDRESS"),
						result.getString("ADDRESS"),
						result.getString("CITY"),
						result.getString("STATE"),
						result.getString("ZIP"),
						result.getString("PHONE"),
						result.getString("USERNAME"),
						result.getString("PASSWORD")
						);
						
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting", e);
		}
		return new Employee();
	}
	
	public boolean checkManager(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT ROLETYPEID FROM EMPLOYEEROLE WHERE EMPLOYEEID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			ResultSet result = statement.executeQuery();
		
			while(result.next()) {
				if (result.getInt("ROLETYPEID") == 2) {
					return true;
				}
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting checking manager", e);
		}
		return false;
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
						result.getInt("EMPLOYEEID"),
						result.getString("FIRSTNAME"),
						result.getString("LASTNAME"),
						result.getString("EMAILADDRESS"),
						result.getString("ADDRESS"),
						result.getString("CITY"),
						result.getString("STATE"),
						result.getString("ZIP"),
						result.getString("PHONE"),
						result.getString("USERNAME"),
						result.getString("PASSWORD")
						));	
			}

			return employeeList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting all", e);
		} 
		return new ArrayList<>();
	}

public boolean checkUsername(Employee employee) {
	try(Connection connection = ConnectionUtil.getConnection()) {
		int statementIndex = 0;
		String command = "SELECT USERNAME FROM EMPLOYEE WHERE USERNAME = ?";
		PreparedStatement statement = connection.prepareStatement(command);
		statement.setString(++statementIndex, employee.getUsername());
		
		if(statement.executeUpdate() > 0) {
			return true;
		}

	} catch (SQLException e) {
		e.getStackTrace();
	} 
	return false;
}
	/* Get a employee hash consuming the user defined function we created */
	@Override
	public String getEmployeeHash(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			System.out.println("Running getemployeehash");
			String command = "SELECT GET_CUSTOMER_HASH(?,?) AS HASH FROM DUAL";
			System.out.println("Completed getemployeehash");
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting customer hash", e);
		} 
		return new String();
	}
	
	public List<Employee> getInfo(Employee employee) {	
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex , employee.getId());			
			ResultSet result = statement.executeQuery();
			List<Employee> employeeList = new ArrayList<>();
			while(result.next()) {
				employeeList.add(new Employee(
						result.getInt("EMPLOYEEID"),
						result.getString("FIRSTNAME"),
						result.getString("LASTNAME"),
						result.getString("EMAILADDRESS"),
						result.getString("ADDRESS"),
						result.getString("CITY"),
						result.getString("STATE"),
						result.getString("ZIP"),
						result.getString("PHONE"),
						result.getString("USERNAME"),
						result.getString("PASSWORD")
						));	
			}
		return employeeList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting info", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimbursement> getPending(Employee employee) {	
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS = 'Pending' AND EMPLOYEEID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex , employee.getId());	
			ResultSet result = statement.executeQuery();
			System.out.println("Employee Id : " + employee.getId());
			List<Reimbursement> pending = new ArrayList<>();
			while(result.next()) {
				System.out.println("Entering loop...");
				pending.add( new Reimbursement(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUS"),
						result.getInt("TOTAL"),
						result.getTimestamp("SUBMITTIME"),
						result.getTimestamp("CLOSEDTIME"),
						result.getString("DESCRIPTION"),
						result.getString("CATEGORY"),
						result.getString("RESOLVEDBY")));
			}		
			for (Reimbursement e : pending) {
			System.out.println(e);
			}
		return pending;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting pending", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimbursement> getAllPending() {	
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS = 'Pending'";
			PreparedStatement statement = connection.prepareStatement(command);	
			ResultSet result = statement.executeQuery();
			List<Reimbursement> pending = new ArrayList<>();
			while(result.next()) {
				pending.add( new Reimbursement(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUS"),
						result.getInt("TOTAL"),
						result.getTimestamp("SUBMITTIME"),
						result.getTimestamp("CLOSEDTIME"),
						result.getString("DESCRIPTION"),
						result.getString("CATEGORY"),
						result.getString("RESOLVEDBY")));
			}		
//			for (Reimbursement e : pending) {
//			System.out.println(e);
//			}
		return pending;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting all pending", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimbursement> getResolved(Employee employee) {	
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS != 'Pending' AND EMPLOYEEID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex , employee.getId());	
			ResultSet result = statement.executeQuery();
			//System.out.println("Employee Id : " + employee.getId());
			List<Reimbursement> pending = new ArrayList<>();
			while(result.next()) {
				//System.out.println("Entering loop...");
				pending.add( new Reimbursement(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUS"),
						result.getInt("TOTAL"),
						result.getTimestamp("SUBMITTIME"),
						result.getTimestamp("CLOSEDTIME"),
						result.getString("DESCRIPTION"),
						result.getString("CATEGORY"),
						result.getString("RESOLVEDBY")));
			}		
//			for (Reimbursement e : pending) {
//			System.out.println(e);
//			}
		return pending;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting resolved", e);
		} 
		return new ArrayList<>();
	}
	public List<Reimbursement> getAllResolved() {	
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REIMBURSEMENT WHERE STATUS != 'Pending'";
			PreparedStatement statement = connection.prepareStatement(command);	
			ResultSet result = statement.executeQuery();
			List<Reimbursement> pending = new ArrayList<>();
			while(result.next()) {
				pending.add( new Reimbursement(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUS"),
						result.getInt("TOTAL"),
						result.getTimestamp("SUBMITTIME"),
						result.getTimestamp("CLOSEDTIME"),
						result.getString("DESCRIPTION"),
						result.getString("CATEGORY"),
						result.getString("RESOLVEDBY")));
			}		
//			for (Reimbursement e : pending) {
//			System.out.println(e);
//			}
		return pending;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception getting all resolved", e);
		} 
		return new ArrayList<>();
	}
	
	public void update(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "UPDATE EMPLOYEE SET EMPLOYEEID = ?, FIRSTNAME = ?, LASTNAME = ?, EMAILADDRESS = ?, ADDRESS = ?, CITY = ?, STATE = ?, ZIP = ?, PHONE = ?, USERNAME = ?,  PASSWORD = ? WHERE EMPLOYEEID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex , employee.getId());	
			statement.setString(++statementIndex , employee.getFirstName());	
			statement.setString(++statementIndex , employee.getLastName());	
			statement.setString(++statementIndex , employee.getEmail());	
			statement.setString(++statementIndex , employee.getAddress());	
			statement.setString(++statementIndex , employee.getCity());	
			statement.setString(++statementIndex , employee.getState());	
			statement.setString(++statementIndex , employee.getZip());	
			statement.setString(++statementIndex , employee.getPhone());	
			statement.setString(++statementIndex , employee.getUsername());	
			statement.setString(++statementIndex , employee.getPassword());	
			statement.setInt(++statementIndex , employee.getId());	
			statement.executeQuery();

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception updating", e);
		} 
	}
	
	public void submitTicket(Reimbursement ticket) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			//Pay attention to this syntax
			String command = "{CALL INSERT_REIMBURSEMENT(?, ?, ?, ?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setInt(++statementIndex, ticket.getEmployeeId());
			statement.setInt(++statementIndex, ticket.getTotal());
			statement.setString(++statementIndex, ticket.getDescription());
			statement.setString(++statementIndex, ticket.getCategory());
			statement.executeQuery();
			

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception submitting ticket", e);
		}

	}
	
}
