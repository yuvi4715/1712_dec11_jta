package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class RequestDaoImp implements RequestDao {

	private static RequestDaoImp requestDaoImp;

	private RequestDaoImp() {
	};

	public static RequestDaoImp getInstance() {
		if (requestDaoImp == null) {
			requestDaoImp = new RequestDaoImp();
		}
		return requestDaoImp;
	}

	
	
	// insert request via preparedStatement
	@Override
	public boolean insertRequest(Request request) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			// Simple insert statement to insert into customer table
			String sql = "INSERT INTO OPENREQUESTS VALUES(REQUESTID_SEQ.NEXTVAL, ?, DEFAULT, ?, ?, SYSTIMESTAMP, (NULL), (NULL), ?, (NULL))";

			// Execute an insert statement using prepared statement
			PreparedStatement p = conn.prepareStatement(sql);

			// Incrementing the statementIndex helps in ordering the parameters
			p.setInt(++statementIndex, request.getEmployeeId());
			p.setDouble(++statementIndex, request.getAmmount());
			p.setString(++statementIndex, request.getRequestDesc());

			// execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception inserting request", e);

		}
		return false;
	}

	
	
	// insert request via procedure
	@Override
	public boolean insertRequestProcedure(Request request) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			// Calling the store procedure
			String storedProc = "{CALL INSERT_REQUEST(?,?,?)}";

			// Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement c = conn.prepareCall(storedProc);

			// Set attributes to insert
			c.setInt(++statementIndex, request.getEmployeeId());
			c.setDouble(++statementIndex, request.getAmmount());
			c.setString(++statementIndex, request.getRequestDesc());

			if (c.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception inserting request with stored Procedure", e);

		}
		return false;
	}

	
//==============GOOD DO NOT TOUCH=====================================================
	// select all pending requests
	public List<Request> selectAllOpen() {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "Select * from OPENREQUESTS";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();

			List<Request> openList = new ArrayList<>();
			while (rs.next()) {
				openList.add(new Request(
						rs.getInt("REQUESTID"), 
						rs.getInt("EMPID"), 
						rs.getString("STATUS"),
						rs.getDouble("AMMOUT"), 
						rs.getString("REQUESTDESC"), 
						rs.getString("OPENDATE"),
						rs.getString("CLOSEDATE"), 
						rs.getString("NOTES"), 
						rs.getInt("MANAGERCLOSEDID")));
			}

			return openList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting All Open request", e);
		}

		return new ArrayList<>();
	}
//====================================================================================

	
//==============GOOD DO NOT TOUCH=====================================================	
	// select all finalized requests
	public List<Request> selectAllClosed() {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "Select * from CLOSEDREQUESTS";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();

			List<Request> openList = new ArrayList<>();
			while (rs.next()) {
				openList.add(new Request(
						rs.getInt("REQUESTID"), 
						rs.getInt("EMPID"), 
						rs.getString("STATUS"),
						rs.getDouble("AMMOUT"), 
						rs.getString("REQUESTDESC"), 
						rs.getString("OPENDATE"),
						rs.getString("CLOSEDATE"), 
						rs.getString("NOTES"), 
						rs.getInt("MANAGERCLOSEDID")));
			}

			return openList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting All Closed request", e);

		}

		return new ArrayList<>();
	}
//====================================================================================
	
	
	// returns a single result based on requestID
	@Override
	public Request select(Request request) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			String sql = "SELECT * FROM OPENREQUESTS WHERE REQUESTID = ?";
			PreparedStatement p = conn.prepareStatement(sql);

			// Incrementing the statementIndex helps in ordering the parameters
			p.setInt(++statementIndex, request.getRequestId());

			ResultSet result = p.executeQuery();

			while (result.next()) {
				return new Request(
						result.getInt("REQUESTID"), 
						result.getInt("EMPID"), 
						result.getString("STATUS"),
						result.getDouble("AMMOUT"), 
						result.getString("REQUESTDESC"), 
						result.getString("OPENDATE"),
						result.getString("CLOSEDATE"), 
						result.getString("NOTES"), 
						result.getInt("MANAGERCLOSEDID"));
			}
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting a pending requests request id ", e);
		}
		return new Request();
	}

	
	// finalizes a request
	@Override
	public boolean finalizeProcedure(Request request) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			// Calling the store procedure
			String storedProc = "{CALL FINALIZE_REQUEST(?,?,?,?)}";

			// Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement c = conn.prepareCall(storedProc);

			// Set attributes to insert
			c.setInt(++statementIndex, request.getRequestId());
			c.setString(++statementIndex, request.getStatus());
			c.setString(++statementIndex, request.getNotes());
			c.setInt(++statementIndex, request.getManagerId());

			if (c.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception Finalizing Request", e);
		}
		return false;
	}

//==============GOOD DO NOT TOUCH=====================================================
	// returns a list of a single user's pending requests 
	@Override
	public List<Request> selectOpen(Employee employee) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			String sql = "SELECT * FROM OPENREQUESTS WHERE EMPID = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(++statementIndex, employee.getEmployeeId());

			ResultSet rs = p.executeQuery();

			List<Request> openList = new ArrayList<>();
			while (rs.next()) {
				openList.add(new Request(
						rs.getInt("REQUESTID"), 
						rs.getInt("EMPID"), 
						rs.getString("STATUS"),
						rs.getDouble("AMMOUT"), 
						rs.getString("REQUESTDESC"), 
						rs.getString("OPENDATE"),
						rs.getString("CLOSEDATE"), 
						rs.getString("NOTES"), 
						rs.getInt("MANAGERCLOSEDID")));
			}

			return openList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting open requests by empid", e);
		}

		return new ArrayList<>();
	}
//====================================================================================
	
//==============GOOD DO NOT TOUCH=====================================================
	// returns a list of a single user's finalized requests
	@Override
	public List<Request> selectClosed(Employee employee) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			String sql = "Select * from CLOSEDREQUESTS WHERE EMPID = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(++statementIndex, employee.getEmployeeId());

			ResultSet rs = p.executeQuery();

			List<Request> openList = new ArrayList<>();
			while (rs.next()) {
				openList.add(new Request(
						rs.getInt("REQUESTID"), 
						rs.getInt("EMPID"), 
						rs.getString("STATUS"),
						rs.getDouble("AMMOUT"), 
						rs.getString("REQUESTDESC"), 
						rs.getString("OPENDATE"),
						rs.getString("CLOSEDATE"), 
						rs.getString("NOTES"), 
						rs.getInt("MANAGERCLOSEDID")));
			}

			return openList;
		} catch (SQLException e) {
			LogUtil.logger.warn("Exception selecting Closed requests by empid", e);

		}

		return new ArrayList<>();
	}
//====================================================================================

}
