package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

/* JDBC implementation for DAO contract for Reimbursements data access */
public class ReimbursementDaoJdbc implements ReimbursementDao {
	
	/*Singleton transformation of JDBC implementation object */
	private static ReimbursementDaoJdbc reimbursementDaoJdbc;
	
	private ReimbursementDaoJdbc() {
		
	}
	
	public static ReimbursementDaoJdbc getReimbursementDaoJdbc() {
		if(reimbursementDaoJdbc == null) {
			reimbursementDaoJdbc = new ReimbursementDaoJdbc();
		}
		
		return reimbursementDaoJdbc;
	}
	
	public boolean insertProcedure(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Pay attention to this syntax
			String command = "{CALL INSERT_REIMBURSEMENT(?,?,?,?)}";
			
			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);
			
			//Set attributes to be inserted
			statement.setInt(++statementIndex, reimbursement.getEmployeeId());
			statement.setDouble(++statementIndex, reimbursement.getAmount());
			statement.setString(++statementIndex, reimbursement.getTitle());
			statement.setString(++statementIndex, reimbursement.getDescription());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception with reimbursement insert procedure", e);
		}
		return false;
	}
	
	/* Select all employees */
	public List<Reimbursement> getAllByEmployee(int employeeId) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REIMBURSEMENT WHERE EmployeeId = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, employeeId);
			ResultSet result = statement.executeQuery();

			int count = 0;
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("reimbursementId"),
						result.getInt("employeeId"),
						result.getInt("managerId"),
						result.getDouble("amount"),
						result.getString("title"),
						result.getString("description"),
						result.getTimestamp("startTime"),
						result.getTimestamp("endTime"),
						result.getString("status")
						));
				count++;
			}
			
			System.out.println("Number of reimbursements for employee: " + count);
			return reimbursementList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception employee reimbursements", e);
		} 
		return new ArrayList<>();
	}
	

	
	public List<Reimbursement> getPendingByEmployee(int employeeId) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REIMBURSEMENT WHERE EmployeeId = ? AND Status = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, employeeId);
			statement.setString(2, "pending");
			ResultSet result = statement.executeQuery();

			int count = 0;
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("reimbursementId"),
						result.getInt("employeeId"),
						result.getInt("managerId"),
						result.getDouble("amount"),
						result.getString("title"),
						result.getString("description"),
						result.getTimestamp("startTime"),
						result.getTimestamp("endTime"),
						result.getString("status")
						));
				count++;
			}
			
			System.out.println("Number of pending reimbursements for employee: " + count);
			return reimbursementList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception employee pending reimbursements", e);
		} 
		return new ArrayList<>();
	}
	
	public List<Reimbursement> getResolvedByEmployee(int employeeId) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REIMBURSEMENT WHERE EmployeeId = ? AND (Status = ? OR Status = ?)";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, employeeId);
			statement.setString(2, "approved");
			statement.setString(3,  "denied");
			ResultSet result = statement.executeQuery();

			int count = 0;
			List<Reimbursement> reimbursementList = new ArrayList<>();
			while(result.next()) {
				reimbursementList.add(new Reimbursement(
						result.getInt("reimbursementId"),
						result.getInt("employeeId"),
						result.getInt("managerId"),
						result.getDouble("amount"),
						result.getString("title"),
						result.getString("description"),
						result.getTimestamp("startTime"),
						result.getTimestamp("endTime"),
						result.getString("status")
						));
				count++;
			}
			
			System.out.println("Number of resolved reimbursements for employee: " + count);
			return reimbursementList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception employee resolved reimbursements", e);
		} 
		return new ArrayList<>();
	}
	
}
