package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDao {

	private static ReimbursementDao instance = null;

	private ReimbursementDao() {
	}

	public static ReimbursementDao getInstance() {
		if (instance == null) {
			instance = new ReimbursementDao();
		}
		return instance;
	}

	// New Reimbursement
	public void insertReimbursement(Employee employee, int amount, String description) {
		
		int nextId = 0;
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		
		try (Connection connection = ConnectionUtil.getConnection()) {

			String command = "INSERT INTO Reimbursement (ReimbursementId, Amount, Status, Description, OpenDate, EmployeeId)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			String sequenceCommand = "SELECT seq_reimbursement.nextval FROM DUAL";
			
			PreparedStatement ps = connection.prepareStatement(sequenceCommand);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				nextId = rs.getInt(1);
			
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, nextId);
			statement.setInt(2, amount);
			statement.setString(3, "Pending");
			statement.setString(4, description);
			statement.setDate(5, sqlDate);//open date
			statement.setInt(6, employee.getEmployeeId());
			

			statement.executeUpdate();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// New Reimbursement
	public void approveReimbursement(int managerId, int reimbursementId) {
		
		System.out.println("ReimbursementDao: approveReimbursement");
	
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		
		try (Connection connection = ConnectionUtil.getConnection()) {

			String command = "UPDATE Reimbursement SET Status= ?, CloseDate= ?, ManagerId= ? WHERE ReimbursementId= ?";
					
			
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, "Approved");
			statement.setDate(2, sqlDate);//close date
			statement.setInt(3, managerId);//close date
			statement.setInt(4, reimbursementId);
			statement.executeUpdate();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// New Reimbursement
	public void declineReimbursement(int managerId, int reimbursementId) {
		

		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		
		try (Connection connection = ConnectionUtil.getConnection()) {

			String command = "UPDATE Reimbursement SET Status= ?, CloseDate= ?, ManagerId= ? WHERE ReimbursementId= ?";
					
			
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(1, "Declined");
			statement.setDate(2, sqlDate);//close date
			statement.setInt(3, managerId);
			statement.setInt(4, reimbursementId);
			statement.executeUpdate();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// All reimbursements submitted
	public ArrayList<Reimbursement> selectAllReimbursements() {

		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection connection = ConnectionUtil.getConnection()) {

			String command = "select * from reimbursement";
			PreparedStatement statement = connection.prepareStatement(command);

			ResultSet result = statement.executeQuery();
			result = statement.executeQuery();

			while (result.next()) {
				int id = result.getInt(1);
				int amount = result.getInt(2);
				String status = result.getString(3);
				String description = result.getString(4);
				Date openDate = result.getDate(5);
				Date closeDate = result.getDate(6);
				int employeeId = result.getInt(7);
				int managerId = result.getInt(8);
				Reimbursement reimbursement =
						new Reimbursement(id, amount, status, description, openDate, closeDate, employeeId, managerId);
				reimbursements.add(reimbursement);
			}

			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	// All reimbursements by employee
	public ArrayList<Reimbursement> selectAllReimbursementById(int EmployeeId) {
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Reimbursement reimbursement = null;

		try (Connection connection = ConnectionUtil.getConnection()) {

			String command = "select * from reimbursement where EmployeeId = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1, EmployeeId);

			ResultSet result = statement.executeQuery();
			result = statement.executeQuery();
			

			while (result.next()) {
				int id = result.getInt("ReimbursementId");
				int amount = result.getInt("Amount");
				String status = result.getString("Status");
				String description = result.getString("Description");
				Date openDate = result.getDate("OpenDate");
				Date closeDate = result.getDate("CloseDate");
				int employeeId = result.getInt("EmployeeId");
				int managerId = result.getInt("ManagerId");
				reimbursement =
						new Reimbursement(id, amount, status, description, openDate, closeDate, employeeId, managerId);
				reimbursements.add(reimbursement);
				
			}

			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reimbursements;
		
	}

	// All pending reimbursements

	// All resolved reimbursements

}
