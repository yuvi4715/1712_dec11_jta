package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Ticket;
import com.revature.model.TicketLine;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;

public class TicketLineDaoJDBC implements TicketLineDao {

	private static TicketLineDaoJDBC ticketLineDaoJDBC;
	private TicketLineDaoJDBC() {
		
	}
	public static TicketLineDaoJDBC getTicketLineDaoJDBC() {
		if (ticketLineDaoJDBC == null) {
			ticketLineDaoJDBC = new TicketLineDaoJDBC();
		}
		return ticketLineDaoJDBC;
	}
	
	@Override
	public boolean add(TicketLine ticketline) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			// Statement to insert Employee into table
			String command = "INSERT INTO REIMBURSEMENTLINE (REIMBURSEMENTID, ITEMDESC, AMOUNT, CATEGORYID) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(command);
			
			//Set attributes to be inserted
			statement.setInt(++statementIndex, ticketline.getTicketId());
			statement.setString(++statementIndex, ticketline.getDesc().toUpperCase());
			statement.setDouble(++statementIndex, ticketline.getAmount());
			statement.setInt(++statementIndex, ticketline.getCategoryId());
			
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
	public TicketLine select(TicketLine ticketline) {
//		try(Connection connection = ConnectionUtil.getConnection()) {
//			int statementIndex = 0;
//			String command = "SELECT * FROM REIMBURSEMENTLINE WHERE LINEID = ?";
//			PreparedStatement statement = connection.prepareStatement(command);
//			statement.setString(++statementIndex, ticketline.getEmail());
//			ResultSet result = statement.executeQuery();
//
//			while(result.next()) {
//				
//				return new TicketLine(
//						result.getInt("LINEID"),
//						result.getInt("REIMBURSEMENTID"),
//						result.getString("ITEMDESC"),
//						result.getDouble("AMOUNT"),
//						result.getInt("CATEGORYID")
//						);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return new TicketLine();
		return null;
	}

	@Override
	public List<TicketLine> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean link(TicketLine ticketline, Ticket ticket) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;

			String command = "INSERT INTO REIMBURSEMENTLINE (REIMBURSEMENTID, ITEMDESC, AMOUNT, CATEGORYID) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(command);
			
			//Set attributes to be inserted
			statement.setInt(++statementIndex, ticket.getTicketId());
			statement.setString(++statementIndex, ticketline.getDesc());
			statement.setDouble(++statementIndex, ticketline.getAmount());
			statement.setInt(++statementIndex, ticketline.getCategoryId());
			
			if(statement.executeUpdate() > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logger.warn(e);
		}
		return false;		
	}

}
