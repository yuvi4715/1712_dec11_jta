package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAO implements IReimbursementDAO {
	@Override
	public void insertReimbursement(Reimbursement reimbursement) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement ps = null;
			StringBuilder query = new StringBuilder("insert into ?");
			int placementNumber = 0;
			
			switch (reimbursement.getType()) {
			case "Pending":
				query.append("(creation_date, reason, employee_id) values(?, ?, ?)");
				ps = conn.prepareStatement(query.toString());
				ps.setString(++placementNumber, "rpadmin.pending");
				ps.setDate(++placementNumber, reimbursement.getTime());
				ps.setString(++placementNumber, reimbursement.getReason());
				ps.setInt(++placementNumber, reimbursement.getId());
				break;
			case "Resolved":
				query.append("(creation_date, reason, firstname, lastname) values(?, ?, ?, ?);");
				ps = conn.prepareStatement(query.toString());
				ps.setString(++placementNumber, "rpadmin.resolved");
				ps.setDate(++placementNumber, reimbursement.getTime());
				ps.setString(++placementNumber, reimbursement.getReason());
				ps.setString(++placementNumber, reimbursement.getFirstname());
				ps.setString(++placementNumber, reimbursement.getLastname());

				ps.executeUpdate();
				insertResolvedStatus(reimbursement);
				break;
			default:
				throw new SQLException();
			}

			String sql = query.toString();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertResolvedStatus(Reimbursement reimbursement) {
		// TODO finish method... revoke completed
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement ps = null;
			int placementNumber = 0;
			String query = "insert into rpadmin.resolvedstatus(status, reason, resolved_id) value" 
			+ "(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(++placementNumber, reimbursement.getStatus());
			ps.setString(++placementNumber, reimbursement.getReason());
			ps.setInt(++placementNumber, reimbursement.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsForEmployee(int id, String type) throws SQLException {
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			Statement s = null;
			String query = "select * from rpadmin." + type + " where employee_id = " + id;
			s = conn.createStatement();
			rs = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return createReimbursementSet(rs, type);
	}

	@Override
	public ArrayList<Reimbursement> getReimbursements(String type) throws SQLException {
		ResultSet rs = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "select * from rpadmin." + type;
			Statement s = conn.createStatement();
			rs = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return createReimbursementSet(rs, type);
	}

	
	
	private ArrayList<Reimbursement> createReimbursementSet(ResultSet result, final String type) throws SQLException  {
		ResultSet rs = result;
		ArrayList<Reimbursement> tempList = new ArrayList<Reimbursement>();
		Reimbursement tempReimburse;
			while (rs.next()) {
				switch (type) {
				case "pending":
					tempReimburse = new Reimbursement(rs.getDate("time"), rs.getString("reason"),
							rs.getInt("employee_id"), type);
					tempList.add(tempReimburse);
					break;
				case "resolved":
					tempReimburse = new Reimbursement(rs.getDate("time"), rs.getString("reason"),
							rs.getInt("employee_id"), type);
					tempList.add(tempReimburse);
	
				}
			}
		return tempList;
	}

}
