package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Ticket;
import com.revature.model.TicketLine;
import com.revature.service.EmployeeService;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class TicketDaoJDBC implements TicketDao {

	private static TicketDaoJDBC ticketDaoJDBC;
	private TicketDaoJDBC() {
		
	}
	public static TicketDaoJDBC getTicketDaoJDBC() {
		if (ticketDaoJDBC == null) {
			ticketDaoJDBC = new TicketDaoJDBC();
		}
		return ticketDaoJDBC;
	}
	
	@Override
	public boolean add(Ticket ticket, Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
//			System.out.println(employee.getId());
//			System.out.println(ticket.getStatus());
			// Statement to insert Employee into table
			String command = "INSERT INTO REIMBURSEMENT (EMPLOYEEID, STATUSID, RESOLUTIONID, TOTAL) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(command);
			
			//Set attributes to be inserted
			statement.setInt(++statementIndex, employee.getId());
			statement.setInt(++statementIndex, ticket.getStatusId());
			statement.setInt(++statementIndex, ticket.getResolutionId());
			statement.setDouble(++statementIndex, ticket.getTotal());
			
			if(statement.executeUpdate() > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return false;
	}

	@Override
	public int selectNewestTicketId(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT MAX(TICKETID) AS NEWESTKEY FROM REIMBURSEMENT WHERE EMPLOYEEID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				
				return new Integer(
						result.getInt("NEWESTKEY")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return 0;
	}
	
	@Override
	public Ticket selectNewestTicket(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT * FROM REIMBURSEMENT WHERE "
					+ "(EMPLOYEEID = ? AND TICKETID = (SELECT MAX(TICKETID) FROM REIMBURSEMENT))";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				
				return new Ticket(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getInt("STATUSID"),
						result.getInt("RESOLUTIONID"),
						result.getDouble("TOTAL")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return new Ticket();
	}

	@Override
	public boolean updateTotal(Ticket ticket, double newTotal) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			String command = "UPDATE REIMBURSEMENT SET TOTAL = ? WHERE TICKETID = ?";
			PreparedStatement statement = connection.prepareStatement(command);

			//Set attributes to be inserted
			statement.setDouble(++statementIndex, newTotal);
			statement.setInt(++statementIndex, ticket.getTicketId());
			
			if(statement.executeUpdate() > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return false;
	}
	
	@Override
	public List<Ticket> selectAll(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			String command = "SELECT * FROM ((REIMBURSEMENT "
					+ "INNER JOIN RESOLUTION "
						+ "ON REIMBURSEMENT.RESOLUTIONID = RESOLUTION.RESOLUTIONID) "
					+ "INNER JOIN STATUS "
						+ "ON REIMBURSEMENT.STATUSID = STATUS.STATUSID) "
					+ "WHERE EMPLOYEEID = ? ORDER BY TICKETID DESC";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			ResultSet result = statement.executeQuery();
			
			List<Ticket> ticket_list = new ArrayList<>();
			
			while(result.next()) {
				
				ticket_list.add(new Ticket(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUSDESC"),
						result.getString("RESOLUTIONDESC"),
						result.getDouble("TOTAL") 
				));
			}
			return ticket_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return new ArrayList<>();
	}
	@Override
	
	public Ticket select(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Ticket> selectPending(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			String command = "SELECT * FROM ((REIMBURSEMENT "
					+ "INNER JOIN RESOLUTION "
						+ "ON REIMBURSEMENT.RESOLUTIONID = RESOLUTION.RESOLUTIONID) "
					+ "INNER JOIN STATUS "
						+ "ON REIMBURSEMENT.STATUSID = STATUS.STATUSID) "
					+ "WHERE RESOLUTIONDESC = 'PENDING' AND EMPLOYEEID = ? ORDER BY TICKETID DESC";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			ResultSet result = statement.executeQuery();
			
			List<Ticket> ticket_list = new ArrayList<>();
			
			while(result.next()) {
				
				ticket_list.add(new Ticket(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUSDESC"),
						result.getString("RESOLUTIONDESC"),
						result.getDouble("TOTAL") 
				));
			}
			return ticket_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return new ArrayList<>();
	}
	public List<Ticket> selectResolved(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			String command = "SELECT * FROM ((REIMBURSEMENT "
					+ "LEFT JOIN RESOLUTION "
						+ "ON REIMBURSEMENT.RESOLUTIONID = RESOLUTION.RESOLUTIONID) "
					+ "LEFT JOIN STATUS "
						+ "ON REIMBURSEMENT.STATUSID = STATUS.STATUSID) "
					+ "WHERE STATUSDESC = 'CLOSED' AND EMPLOYEEID = ? ORDER BY TICKETID DESC";
			
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			ResultSet result = statement.executeQuery();
			
			List<Ticket> ticket_list = new ArrayList<>();
			
			while(result.next()) {
				
				ticket_list.add(new Ticket(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUSDESC"),
						result.getString("RESOLUTIONDESC"),
						result.getDouble("TOTAL") 
				));
			}
			return ticket_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return new ArrayList<>();
	}
	public List<Ticket> selectAllResolved() {
		try(Connection connection = ConnectionUtil.getConnection()) {			
			String command = "SELECT * FROM REIMBURSEMENT "
					+ "LEFT JOIN RESOLUTION "
						+ "ON REIMBURSEMENT.RESOLUTIONID = RESOLUTION.RESOLUTIONID "
					+ " LEFT JOIN STATUS "
						+ "ON REIMBURSEMENT.STATUSID = STATUS.STATUSID "
					+ "WHERE RESOLVEDBY IS NOT NULL ORDER BY TICKETID DESC";
			
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();
			
			List<Ticket> ticket_list = new ArrayList<>();
			
			while(result.next()) {
				
				ticket_list.add(new Ticket(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUSDESC"),
						result.getString("RESOLUTIONDESC"),
						result.getDouble("TOTAL"),
						result.getInt("RESOLVEDBY")
				));
			}
			return ticket_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return new ArrayList<>();
	}
	public List<Ticket> selectAllPending() {
		try(Connection connection = ConnectionUtil.getConnection()) {			
			String command = "SELECT * FROM REIMBURSEMENT "
					+ "LEFT JOIN RESOLUTION "
						+ "ON REIMBURSEMENT.RESOLUTIONID = RESOLUTION.RESOLUTIONID "
					+ " LEFT JOIN STATUS "
						+ "ON REIMBURSEMENT.STATUSID = STATUS.STATUSID "
					+ "WHERE RESOLVEDBY IS NULL ORDER BY TICKETID DESC";
			
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();
			
			List<Ticket> ticket_list = new ArrayList<>();
			
			while(result.next()) {
				
				ticket_list.add(new Ticket(
						result.getInt("TICKETID"),
						result.getInt("EMPLOYEEID"),
						result.getString("STATUSDESC"),
						result.getString("RESOLUTIONDESC"),
						result.getDouble("TOTAL")
				));
			}
			return ticket_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return new ArrayList<>();
	}
	public String approve(int ticketid, Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {		
			
			int statementIndex = 0;
			String command = "UPDATE REIMBURSEMENT SET STATUSID = 2, RESOLUTIONID = 1, RESOLVEDBY = ? WHERE TICKETID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			statement.setInt(++statementIndex, ticketid);
			if (statement.executeUpdate() > 0) {
				return "APPROVED";
			};			
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return "";
	}
	public String deny(int ticketid, Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()) {		
			
			int statementIndex = 0;
			String command = "UPDATE REIMBURSEMENT SET STATUSID = 2, RESOLUTIONID = 2, RESOLVEDBY = ? WHERE TICKETID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employee.getId());
			statement.setInt(++statementIndex, ticketid);
			if (statement.executeUpdate() > 0) {
				return "DENIED";
			};			
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return "";
	}
	public List<TicketLine> selectTicketLines(int ticketid) {
		try(Connection connection = ConnectionUtil.getConnection()) {			
			String command = "SELECT * FROM REIMBURSEMENTLINE "
					+ "LEFT JOIN ITEMCATEGORY ON "
						+ "REIMBURSEMENTLINE.CATEGORYID = ITEMCATEGORY.CATEGORYID "
					+ "WHERE REIMBURSEMENTID = ? ORDER BY LINEID ASC";
			
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(1,  ticketid);
			ResultSet result = statement.executeQuery();
			
			List<TicketLine> ticketline_list = new ArrayList<>();
			
			while(result.next()) {
				
				ticketline_list.add(new TicketLine(
						result.getInt("LINEID"),
						result.getInt("REIMBURSEMENTID"),
						result.getString("CATEGORYDESC"),
						result.getDouble("AMOUNT"),
						result.getString("ITEMDESC")
				));
			}
			return ticketline_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return new ArrayList<>();
	}

}
