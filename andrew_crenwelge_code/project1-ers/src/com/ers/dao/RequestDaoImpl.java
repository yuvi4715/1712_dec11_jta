package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {
	private static RequestDaoImpl requestDaoImpl;
	
	private RequestDaoImpl() {}
	
	public static RequestDaoImpl getInstance() {
		if (requestDaoImpl == null) {
			requestDaoImpl = new RequestDaoImpl();
		}
		return requestDaoImpl;
	}

	@Override
	public boolean initializeNewRequest(Request req) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			//Simple insert statement to insert into employee table
			String sql = "insert into request values(NULL, ?, ?, ?, ?)";
			
			//Execute an insert statement using prepared statement
			PreparedStatement p = conn.prepareStatement(sql);
			
			//Incrementing the statementIndex helps in ordering the parameters
			p.setInt(++statementIndex, req.getEmpID());
			
			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Request> getAllRequests() {
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequests() {
		return null;
	}

	@Override
	public List<Request> getAllPendingRequests() {
		return null;
	}

	@Override
	public List<Request> getResolvedRequestsByEmployee(int empID) {
		return null;
	}

	@Override
	public List<Request> getPendingRequestsByEmployee(int empID) {
		return null;
	}

	@Override
	public List<Request> getRequestsByEmployee(int empID) {
		return null;
	}

	@Override
	public boolean approveRequest(Request r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean denyRequest(Request r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Request getRequestById(int reqId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getManagerOfRequest() {
		// TODO Auto-generated method stub
		return null;
	}
}
