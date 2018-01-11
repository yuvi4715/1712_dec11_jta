package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursements;

public class ReimbursementDAO implements ReimbursementDAOInterface {

	@Override
	public void approveReimbursement() {
	
	}

	@Override
	public void denyReimbbursement() {
		
	}
	
	//Method to add a reimbursement
	@Override
	public void newReimbursement(Reimbursements reim, Connection con) throws Exception {
		
		String insertSql = "INSERT INTO OPEN_TBL (CREATED_BY, REIMBURSEMENT_ID, AMOUNT, STATUS, START_TIME, REIMBURSEMENT_DESC)"
				+ " VALUES (?, Reimbursement_SQ.NEXTVAL, ?, 'PENDING', CURRENT_TIMESTAMP, ?)";
			
		System.out.println("insertSql");
		
		PreparedStatement ps = con.prepareStatement(insertSql);
		ps.setInt(1, reim.getCreatedBy());
		ps.setInt(2, reim.getAmount());
		ps.setString(3, reim.getDesc());
		
		System.out.println("insertSql");
		
		ps.executeQuery();
		ps.close();
		con.close();
	}
	
	// Method to get ALL pending reimbursements
	@Override
	public List<Reimbursements> openList(Connection con) throws Exception {
		
		List<Reimbursements> openList = new ArrayList<>();
		
		// SQL Statement - selecting all the employees from the database
		String selectSql = "SELECT CREATED_BY, REIMBURSEMENT_ID, AMOUNT, STATUS, START_TIME, REIMBURSEMENT_DESC FROM OPEN_TBL ORDER BY REIMBURSEMENT_ID DESC";
		
		PreparedStatement ps = con.prepareStatement(selectSql);
		
		// saving the query result in a ResultSet
		ResultSet rs = ps.executeQuery();
		
		// adding the results to the list
		while(rs.next()) {
			openList.add(new Reimbursements(rs.getInt("CREATED_BY"), rs.getInt("REIMBURSEMENT_ID"), rs.getInt("AMOUNT"), rs.getString("STATUS"), 
					rs.getString("START_TIME"), rs.getString("REIMBURSEMENT_DESC")));
		}
		
		rs.close();
		ps.close();
		
		return openList;
	}
	
	// Method to get ALL resolved reimbursements
	@Override
	public List<Reimbursements> closedList(Connection con) throws Exception {
		
		List<Reimbursements> closedList = new ArrayList<>();
		
		// SQL Statement - selecting all the employees from the database
		String selectSql = "SELECT CREATED_BY, REIMBURSEMENT_ID, AMOUNT, STATUS, START_TIME, END_TIME, REIMBURSEMENT_DESC, HANDLED_BY FROM CLOSED_TBL";
		
		PreparedStatement ps = con.prepareStatement(selectSql);
		
		// saving the query result in a ResultSet
		ResultSet rs = ps.executeQuery();
		
		// adding the results to the list
		while(rs.next()) {
			closedList.add(new Reimbursements(rs.getInt("CREATED_BY"), rs.getInt("REIMBURSEMENT_ID"), rs.getInt("AMOUNT"), rs.getString("STATUS"), 
					rs.getString("START_TIME"), rs.getString("END_TIME"), rs.getString("REIMBURSEMENT_DESC"), rs.getInt("HANDLED_BY")));
		}
		
		rs.close();
		ps.close();
		
		return closedList;
	}
	
	// Method to get pending reimbursements for a specific employee
	@Override
	public List<Reimbursements> openEList(String user, Connection con) throws Exception {
		
		List<Reimbursements> openList = new ArrayList<>();
		
		int empID = new EmployeeDAO().getEmpID(user, con);
		
		// SQL Statement - selecting all the employees from the database
		String selectSql = "SELECT CREATED_BY, REIMBURSEMENT_ID, AMOUNT, STATUS, START_TIME, REIMBURSEMENT_DESC FROM OPEN_TBL WHERE CREATED_BY = '" + empID + "' ORDER BY REIMBURSEMENT_ID DESC";
		
		PreparedStatement ps = con.prepareStatement(selectSql);
		
		// saving the query result in a ResultSet
		ResultSet rs = ps.executeQuery();
		
		// adding the results to the list
		while(rs.next()) {
			openList.add(new Reimbursements(rs.getInt("CREATED_BY"), rs.getInt("REIMBURSEMENT_ID"), rs.getInt("AMOUNT"), rs.getString("STATUS"), 
					rs.getString("START_TIME"), rs.getString("REIMBURSEMENT_DESC")));
		}
		
		rs.close();
		ps.close();
		
		return openList;
	}
	// Method to get resolved reimbursements for a specific employee
	@Override
	public List<Reimbursements> closedEList(String user, Connection con) throws Exception {
		
		List<Reimbursements> closedList = new ArrayList<>();
		
		int empID = new EmployeeDAO().getEmpID(user, con);
		
		// SQL Statement - selecting all the employees from the database
		String selectSql = "SELECT CREATED_BY, REIMBURSEMENT_ID, AMOUNT, STATUS, START_TIME, END_TIME, REIMBURSEMENT_DESC, HANDLED_BY FROM CLOSED_TBL WHERE CREATED_BY = '" + empID + "' ORDER BY REIMBURSEMENT_ID DESC";
		
		System.out.println(selectSql);
		PreparedStatement ps = con.prepareStatement(selectSql);
		
		// saving the query result in a ResultSet
		ResultSet rs = ps.executeQuery();
		
		// adding the results to the list
		while(rs.next()) {
			closedList.add(new Reimbursements(rs.getInt("CREATED_BY"), rs.getInt("REIMBURSEMENT_ID"), rs.getInt("AMOUNT"), rs.getString("STATUS"), 
					rs.getString("START_TIME"), rs.getString("END_TIME"), rs.getString("REIMBURSEMENT_DESC"), rs.getInt("HANDLED_BY")));
		}
		
		rs.close();
		ps.close();
		
		return closedList;
	}
		
	// Method to get ALL reimbursements
	@Override
	public List<Reimbursements> rList(Connection con) throws Exception {
		
		List<Reimbursements> rList = new ArrayList<>();
		
		// SQL Statement - selecting all the employees from the database
		String selectSql = "SELECT CREATED_BY, REIMBURSEMENT_ID, AMOUNT, STATUS, START_TIME, TO_TIMESTAMP(NULL, 'DD-MON-RR HH24:MI:SS.FF') AS END_TIME, REIMBURSEMENT_DESC, TO_NUMBER(NULL) AS HANDLED_BY FROM OPEN_TBL" +
							" UNION ALL" + 
							" SELECT CREATED_BY, REIMBURSEMENT_ID, AMOUNT, STATUS, START_TIME, END_TIME, REIMBURSEMENT_DESC, HANDLED_BY FROM CLOSED_TBL";
		
		PreparedStatement ps = con.prepareStatement(selectSql);
		
		// saving the query result in a ResultSet
		ResultSet rs = ps.executeQuery();
		
		// adding the results to the list
		while(rs.next()) {
			rList.add(new Reimbursements(rs.getInt("CREATED_BY"), rs.getInt("REIMBURSEMENT_ID"), rs.getInt("AMOUNT"), rs.getString("STATUS"), 
					rs.getString("START_TIME"), rs.getString("END_TIME"), rs.getString("REIMBURSEMENT_DESC"), rs.getInt("HANDLED_BY")));
		}
		
		rs.close();
		ps.close();
		
		return rList;
	}
}
