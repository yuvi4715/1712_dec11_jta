package com.revature.reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.Closed;
import com.revature.util.ConnectionUtil;

public class ClosedDaoImpl implements ClosedDao {

	private static ClosedDaoImpl closedDaoImpl;
	
	private ClosedDaoImpl() {
		
	}
	
	public static ClosedDaoImpl getInstance() {
		if (closedDaoImpl == null) {
			closedDaoImpl = new ClosedDaoImpl();
		}
		return closedDaoImpl;
	}
	
	
	//get all reimbursements for a given employee eid
	public List<Closed> getEidClosed(int eid) {
		
		try {
			System.out.println(eid + " from geteidclosed daoimpl"); //test
			Connection conn = ConnectionUtil.getConnection();
			
			int statementIndex = 0;
			
			String sql = "SELECT * FROM CLOSED WHERE EID = ? ";
			
				//if no eid was parsed, just conduct a regular lookup to retreive all
			PreparedStatement p = conn.prepareStatement(sql);
			
			
			
			p.setInt(++statementIndex, eid);
			
			ResultSet result = p.executeQuery();
			
			List<Closed> closedList = new ArrayList<>();
			while (result.next()) {
				closedList.add(new Closed(
				result.getInt("RID"),
				result.getInt("AMT"),
				result.getInt("EID"),
				result.getString("STATUS"),
				result.getString("STARTTIME"),
				result.getString("ENDTIME"),
				result.getString("DESCRIPTION"),
				result.getString("RESOLVEDBY"))
						);
			}
			
			return closedList;
		} catch(SQLException e) {
			e.printStackTrace();
			}
		return new ArrayList();
	
	}
	
	
	// retreive all Closed in the table 
	public List<Closed> getAllClosed() {
		//List<Closed> closed = new ArrayList();
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "SELECT * FROM CLOSED ";
			PreparedStatement p = conn.prepareStatement(sql);
			
			ResultSet result = p.executeQuery();
			
			List<Closed> closedList = new ArrayList();
			while (result.next()) {
				closedList.add(new Closed(
				result.getInt("RID"),
				result.getInt("AMT"),
				result.getInt("EID"),
				result.getString("STATUS"),
				result.getString("STARTTIME"),
				result.getString("ENDTIME"),
				result.getString("DESCRIPTION"),
				result.getString("RESOLVEDBY"))
						);
			}
			
			return closedList;
		} catch(SQLException e) {
			e.printStackTrace();
			}
		return new ArrayList();
	
	}
	
	
	//get all pending given an employee id
	 
			public List<Closed> getAllPendingClosedEid(int eid) {
				//List<Closed> closed = new ArrayList();
				try {
					Connection conn = ConnectionUtil.getConnection();
					
					String pend = "PENDING";
					String sql = "SELECT * FROM CLOSED WHERE STATUS = ? AND EID = ? ";
					PreparedStatement p = conn.prepareStatement(sql);
					
					p.setString(1, pend);
					p.setInt(1, eid);
					
					ResultSet result = p.executeQuery();
					
					List<Closed> closedList = new ArrayList();
					while (result.next()) {
						closedList.add(new Closed(
						result.getInt("RID"),
						result.getInt("AMT"),
						result.getInt("EID"),
						result.getString("STATUS"),
						result.getString("STARTTIME"),
						result.getString("ENDTIME"),
						result.getString("DESCRIPTION"),
						result.getString("RESOLVEDBY"))
								);
					}
					
					return closedList;
				} catch(SQLException e) {
					e.printStackTrace();
					}
				return new ArrayList();
			
			}
	
	
	//get all pending
	// retreive all Closed in the table 
		public List<Closed> getAllPendingClosed() {
			
			try {
				Connection conn = ConnectionUtil.getConnection();
				
				String pend = "PENDING";
				String sql = "SELECT * FROM CLOSED WHERE STATUS = ?";
				PreparedStatement p = conn.prepareStatement(sql);
				
				p.setString(1, pend);
				
				ResultSet result = p.executeQuery();
				
				List<Closed> closedList = new ArrayList();
				while (result.next()) {
					closedList.add(new Closed(
					result.getInt("RID"),
					result.getInt("AMT"),
					result.getInt("EID"),
					result.getString("STATUS"),
					result.getString("STARTTIME"),
					result.getString("ENDTIME"),
					result.getString("DESCRIPTION"),
					result.getString("RESOLVEDBY"))
							);
				}
				
				return closedList;
			} catch(SQLException e) {
				e.printStackTrace();
				}
			return new ArrayList();
		
		}
		
		
		// retreive all resolved reimbursements
			public List<Closed> getAllResolvedClosed() {
			
				try {
					Connection conn = ConnectionUtil.getConnection();
					
					String pend1 = "APPROVED";
					String pend2 = "DENIED";
					String sql = "SELECT * FROM CLOSED WHERE STATUS = ? OR STATUS = ? ";
					//String sql = "SELECT * FROM CLOSED WHERE STATUS = ?";
					PreparedStatement p = conn.prepareStatement(sql);
					
					p.setString(1, pend1);
					p.setString(2, pend2);
					
					ResultSet result = p.executeQuery();
					
					List<Closed> closedList = new ArrayList();
					while (result.next()) {
						closedList.add(new Closed(
						result.getInt("RID"),
						result.getInt("AMT"),
						result.getInt("EID"),
						result.getString("STATUS"),
						result.getString("STARTTIME"),
						result.getString("ENDTIME"),
						result.getString("DESCRIPTION"),
						result.getString("RESOLVEDBY"))
								);
					}
					
					return closedList;
				} catch(SQLException e) {
					e.printStackTrace();
					}
				return new ArrayList();
			
			}
	
	//select Closed reimbursment from table and return to view
	public Closed getClosed(Closed closed) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			int statementIndex = 0;
			
			String sql = "SELECT * FROM CLOSED WHERE EID = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			
			ResultSet result = p.executeQuery();
			
			while (result.next()) {
				return new Closed(
				result.getInt("RID"),
				result.getInt("AMT"),
				result.getInt("EID"),
				result.getString("STATUS"),
				result.getString("STARTTIME"),
				result.getString("ENDTIME"),
				result.getString("DESCRIPTION"),
				result.getString("RESOLVEDBY")
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			}
		return new Closed();
		

	}
	
	
	//insert into Closed table
	public boolean insertClosed(Closed closed) {
		try{
			Connection conn = ConnectionUtil.getConnection();
		
			int statementIndex = 0;
			
			String sql = "insert into closed (AMT, EID, STATUS, DESCRIPTION, RESOLVEDBY) values( ?, ?, ?, ?, ?)"; //with an experimental!
			//String sql = "insert into closed values(NULL, ?, ?, ?, NULL, NULL, ?, ?)"; //check SQL statement to make sure the arguments accord
			
			PreparedStatement p = conn.prepareStatement(sql);
			
			//p.setInt(++statementIndex, closed.getRid());
			p.setInt(++statementIndex, closed.getAmt()); //.toUpperCase());
			p.setInt(++statementIndex, closed.getEid());
			p.setString(++statementIndex, closed.getStatus().toUpperCase());  //will be changed from manager controller
			//p.setString(++statementIndex, closed.getStarttime().toUpperCase());
			//p.setString(++statementIndex, closed.getEndtime().toUpperCase());
			p.setString(++statementIndex, closed.getDescription());
			//p.setString(++statementIndex, closed.getResolvedby().toUpperCase());  will be entered from manager controller
			p.setString(++statementIndex, "unresolved"); //all new reimbursement requests are set to unresolved until manager decision
			
			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	//APPROVE the reimbursement row in the table
	public boolean approveClosed(int rid, String managername) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			int statementIndex = 0;
			
			String sql = "UPDATE Closed SET Closed.status = ?, Closed.resolvedby = ? WHERE RID = ? ";
			//String sql2 = "SELECT APPROVE_PROCEDURE(?,?) FROM DUAL";
			
			
			PreparedStatement p = conn.prepareStatement(sql);
			
			p.setString(++statementIndex, "APPROVED");
			p.setString(++statementIndex, managername);
			p.setInt(++statementIndex, rid);
			
			
			p.executeQuery();
			
		} catch (SQLException e) {
		e.printStackTrace();	
		}
		return true;
	}
	
	
	//DENY the reimbursement row in the table
		public boolean denyClosed(int rid, String managername) {
			try {
				Connection conn = ConnectionUtil.getConnection();
				
				int statementIndex = 0;
				
				String sql = "UPDATE Closed SET Closed.status = ?, Closed.resolvedby = ? WHERE RID = ? ";
				//String sql2 = "SELECT DENY_PROCEDURE(?,?) FROM DUAL";
				
				
				PreparedStatement p = conn.prepareStatement(sql);
				
				p.setString(++statementIndex, "DENIED");
				p.setString(++statementIndex, managername);
				p.setInt(++statementIndex, rid);
				
				
				p.executeQuery();
				
			} catch (SQLException e) {
			e.printStackTrace();	
			}
			return true;
		}
	
	
	
}
