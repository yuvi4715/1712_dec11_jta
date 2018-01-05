package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
			String sql = "CALL insertNewRequest(REQUEST_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(++statementIndex, req.getEmpID());
			p.setString(++statementIndex, req.getReqTitle());
			p.setString(++statementIndex, req.getStatus());
			p.setDouble(++statementIndex, req.getAmount());
			p.setTimestamp(++statementIndex, new Timestamp(System.currentTimeMillis()));
			p.setTimestamp(++statementIndex, null);
			p.setInt(++statementIndex, req.getMgrID());
			p.setString(++statementIndex, req.getDescription());
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
			String sql = "SELECT * FROM REQUESTS R JOIN STATUS S ON R.STATID=S.STATID";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				r.setReqID(rs.getInt(1));
				r.setEmpID(rs.getInt(2));
				r.setReqTitle(rs.getString(3));
				r.setStatus(rs.getString("STATUS"));
				r.setAmount(rs.getDouble(5));
				r.setDateSubmitted(rs.getTimestamp(6));
				r.setDateResolved(rs.getTimestamp(7));
				r.setMgrID(rs.getInt(8));
				r.setDescription(rs.getString(9));
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
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.statid IN (2,3)";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				r.setReqID(rs.getInt(1));
				r.setEmpID(rs.getInt(2));
				r.setReqTitle(rs.getString(3));
				r.setStatus(rs.getString("STATUS"));
				r.setAmount(rs.getDouble(5));
				r.setDateSubmitted(rs.getTimestamp(6));
				r.setDateResolved(rs.getTimestamp(7));
				r.setMgrID(rs.getInt(8));
				r.setDescription(rs.getString(9));
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
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.statid=1";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				r.setReqID(rs.getInt(1));
				r.setEmpID(rs.getInt(2));
				r.setReqTitle(rs.getString(3));
				r.setStatus(rs.getString("STATUS"));
				r.setAmount(rs.getDouble(5));
				r.setDateSubmitted(rs.getTimestamp(6));
				r.setDateResolved(rs.getTimestamp(7));
				r.setMgrID(rs.getInt(8));
				r.setDescription(rs.getString(9));
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
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=? AND r.statid IN (2,3)";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, empID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				r.setReqID(rs.getInt(1));
				r.setEmpID(rs.getInt(2));
				r.setReqTitle(rs.getString(3));
				r.setStatus(rs.getString("STATUS"));
				r.setAmount(rs.getDouble(5));
				r.setDateSubmitted(rs.getTimestamp(6));
				r.setDateResolved(rs.getTimestamp(7));
				r.setMgrID(rs.getInt(8));
				r.setDescription(rs.getString(9));
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
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=? AND r.statid=1";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, empID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				r.setReqID(rs.getInt(1));
				r.setEmpID(rs.getInt(2));
				r.setReqTitle(rs.getString(3));
				r.setStatus(rs.getString("STATUS"));
				r.setAmount(rs.getDouble(5));
				r.setDateSubmitted(rs.getTimestamp(6));
				r.setDateResolved(rs.getTimestamp(7));
				r.setMgrID(rs.getInt(8));
				r.setDescription(rs.getString(9));
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
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, empID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				r.setReqID(rs.getInt(1));
				r.setEmpID(rs.getInt(2));
				r.setReqTitle(rs.getString(3));
				r.setStatus(rs.getString("STATUS"));
				r.setAmount(rs.getDouble(5));
				r.setDateSubmitted(rs.getTimestamp(6));
				r.setDateResolved(rs.getTimestamp(7));
				r.setMgrID(rs.getInt(8));
				r.setDescription(rs.getString(9));
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
			String sql = "UPDATE requests SET statid=2 WHERE reqid=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, r.getReqID());
			int rowsUpdated = p.executeUpdate();
			if (rowsUpdated == 1) {
				return true;
			}
			else {
				System.out.println("Something went wrong or more than one request was approved");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyRequest(Request r) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE requests SET statid=3 WHERE reqid=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, r.getReqID());
			int rowsUpdated = p.executeUpdate();
			if (rowsUpdated == 1) {
				return true;
			}
			else {
				System.out.println("Something went wrong or more than one request was approved");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Request getRequestById(int reqId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM requests WHERE reqId = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, reqId);
			ResultSet rs = p.executeQuery();
			rs.next();
			Request req = new Request();
			req.setReqID(rs.getInt(1));
			req.setEmpID(rs.getInt(2));
			req.setReqTitle(rs.getString(3));
			req.setStatus(rs.getString(4));
			req.setAmount(rs.getDouble(5));
			req.setDateSubmitted(rs.getTimestamp(6));
			req.setDateResolved(rs.getTimestamp(7));
			req.setMgrID(rs.getInt(8));
			req.setDescription(rs.getString(8));
			return req;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getManagerOfRequest(Request r) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT fname,lname FROM employee WHERE empId = (SELECT approvedby FROM requests WHERE reqId = ?)";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, r.getReqID());
			ResultSet rs = p.executeQuery();
			rs.next();
			Employee emp = new Employee();
			emp.setIsManager(true);
			emp.setFirstname(rs.getString(1));
			emp.setLastname(rs.getString(2));
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getRequestsByEmployeeName(String firstname, String lastname) {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=(SELECT empid FROM employee WHERE fname=? AND lname=?);";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, firstname);
			p.setString(2, lastname);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Request r = new Request();
				r.setReqID(rs.getInt(1));
				r.setEmpID(rs.getInt(2));
				r.setReqTitle(rs.getString(3));
				r.setStatus(rs.getString("STATUS"));
				r.setAmount(rs.getDouble(5));
				r.setDateSubmitted(rs.getTimestamp(6));
				r.setDateResolved(rs.getTimestamp(7));
				r.setMgrID(rs.getInt(8));
				r.setDescription(rs.getString(9));
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
