package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			String sql = "insert into request values(NULL, ?, ?, ?, ?)";
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
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM open_requests FULL OUTER JOIN closed_requests";
			PreparedStatement p = conn.prepareStatement(sql);
			//execute the statement
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				// insert rs -> r
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequests() {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM closed_requests";
			PreparedStatement p = conn.prepareStatement(sql);
			//execute the statement
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				// insert rs rows -> r
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getAllPendingRequests() {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM open_requests";
			PreparedStatement p = conn.prepareStatement(sql);
			//execute the statement
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				// insert rs -> r
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getResolvedRequestsByEmployee(int empID) {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM closed_requests WHERE empID = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, empID);
			//execute the statement
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				// insert rs -> r
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getPendingRequestsByEmployee(int empID) {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM open_requests WHERE empId = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, empID);
			//execute the statement
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				// insert rs -> r
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getRequestsByEmployee(int empID) {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM open_requests FULL OUTER JOIN closed_requests WHERE empId = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, empID);
			//execute the statement
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				// insert rs -> r
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean approveRequest(Request r) {
		try(Connection conn = ConnectionUtil.getConnection()){
			// need to call stored procedure here
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyRequest(Request r) {
		try(Connection conn = ConnectionUtil.getConnection()){
			// need to call stored procedure here
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Request getRequestById(int reqId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM open_requests FULL OUTER JOIN closed_requests WHERE reqId = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, reqId);
			//execute the statement
			ResultSet rs = p.executeQuery();
			rs.next();
			Request req = new Request();
			req.setReqID(reqId);
			// etc...
			return req;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getManagerOfRequest(Request r) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT firstname,lastname FROM employee WHERE empId = (SELECT approvedby FROM closed_requests WHERE reqId = ?)";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(0, r.getReqID());
			//execute the statement
			ResultSet rs = p.executeQuery();
			rs.next();
			Employee emp = new Employee();
			emp.setIsManager(true);
			emp.setFirstname(rs.getString(0));
			emp.setLastname(rs.getString(1));
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
