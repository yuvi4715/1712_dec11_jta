package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.util.ConnectionUtil;
import com.ers.util.LogUtil;

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
			String sql = "CALL insertNewRequest(?,?,?,?,?,?,?,?)";
			PreparedStatement p = conn.prepareStatement(sql);
			// requestId is set in db using a sequence
			p.setInt(++statementIndex, req.getEmpID());
			p.setString(++statementIndex, req.getReqTitle());
			p.setString(++statementIndex, req.getStatus());
			p.setDouble(++statementIndex, req.getAmount());
			p.setTimestamp(++statementIndex, new Timestamp(System.currentTimeMillis()));
			p.setTimestamp(++statementIndex, null); // initialized requests are not resolved and thus do not have resolved timestamp
			p.setNull(++statementIndex, java.sql.Types.NUMERIC);
			p.setString(++statementIndex, req.getDescription());
			if (p.executeUpdate() >= 0) {
				LogUtil.logger.info("New request created");
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
			String sql = "SELECT * FROM REQUESTS R JOIN STATUS S ON R.STATID=S.STATID ORDER BY r.reqid";
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
		return list;
	}

	@Override
	public List<Request> getAllResolvedRequests() {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.statid IN (2,3) ORDER BY r.reqid";
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
		return list;
	}

	@Override
	public List<Request> getAllPendingRequests() {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.statid=1 ORDER BY r.reqid";
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
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=? AND r.statid IN (2,3) ORDER BY r.reqid";
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
		return list;
	}

	@Override
	public List<Request> getPendingRequestsByEmployee(int empID) {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=? AND r.statid=1 ORDER BY r.reqid";
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
		return list;
	}

	@Override
	public List<Request> getRequestsByEmployee(int empID) {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=? ORDER BY r.reqid";
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
		return list;
	}

	@Override
	public boolean approveRequest(Request r, int mgrID) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE requests SET statid=2, resolvedby=?, endtime=CURRENT_TIMESTAMP WHERE reqid=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, mgrID);
			p.setInt(2, r.getReqID());
			int rowsUpdated = p.executeUpdate();
			if (rowsUpdated == 1) {
				LogUtil.logger.info("Request #"+r.getReqID()+" approved by manager of ID="+mgrID);
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
	public boolean denyRequest(Request r, int mgrID) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE requests SET statid=3, resolvedby=?, endtime=CURRENT_TIMESTAMP WHERE reqid=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, mgrID);
			p.setInt(2, r.getReqID());
			int rowsUpdated = p.executeUpdate();
			if (rowsUpdated == 1) {
				LogUtil.logger.info("Request #"+r.getReqID()+" denied by manager of ID="+mgrID);
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
		return new Request();
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
		return new Employee();
	}

	@Override
	public List<Request> getRequestsByEmployeeName(String firstname, String lastname) {
		List<Request> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM requests r JOIN status s ON r.statid=s.statid WHERE r.empid=(SELECT empid FROM employee WHERE fname=? AND lname=?) ORDER BY r.reqid";
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
		return list;
	}

	@Override
	public Map<Integer, String> getRequestMgrMap() {
		Map<Integer,String> localmap = new HashMap<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT empid,fname,lname FROM employee";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				localmap.put(rs.getInt(1), rs.getString(2) +" "+ rs.getString(3));
			}
			return localmap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localmap;
	}
}
