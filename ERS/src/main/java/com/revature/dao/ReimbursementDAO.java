package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import java.sql.SQLException;

import com.revature.model.Credential;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.util.FinalUtil;

public class ReimbursementDAO implements IReimbursementDAO {

	private Logger logger = Logger.getLogger(Credential.class);
	private static ReimbursementDAO obj;

	private ReimbursementDAO() {
	}

	public static ReimbursementDAO getInstance() {
		if (obj == null)
			obj = new ReimbursementDAO();
		return obj;
	}

	@Override
	public boolean insertPending(Reimbursement reimbursement) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement ps = null;
			int placementNumber = 0;
			String query = "insert into rpadmin.pending(creation_date, reason, employee_id, amount, firstname, lastname) "
					+ "values(current_timestamp, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(++placementNumber, reimbursement.getReason());
			ps.setInt(++placementNumber, reimbursement.getEid());
			ps.setDouble(++placementNumber, reimbursement.getAmount());
			ps.setString(++placementNumber, reimbursement.getFirstname());
			ps.setString(++placementNumber, reimbursement.getLastname());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	// Update manager name first!!!! The sql trigger will move the pending
	// reimbursement upon status update
	@Override
	public boolean updatePendingStatus(Reimbursement reimbursement) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			CallableStatement cs = null;
			int placementNumber = 0;
			String query = "{call move_pending_to_resolved(?, ?, ?, ?)}";
			cs = conn.prepareCall(query);
			cs.setInt(++placementNumber, reimbursement.getId());
			cs.setInt(++placementNumber, reimbursement.getManid());
			cs.setString(++placementNumber, reimbursement.getStatus());
			cs.registerOutParameter(++placementNumber, java.sql.Types.NUMERIC);
			cs.executeUpdate();
			return cs.getInt(placementNumber) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}

		return false;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsForEmployee(int id, String type) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			Statement s = null;
			String query = null;
			query = "select * from rpadmin." + type + " inner join rpadmin.employee on " + type
					+ ".employee_id = employee.employee_id where employee.employee_id = " + id;
			s = conn.createStatement();
			rs = s.executeQuery(query);
			return createReimbursementSet(rs, type);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursements(String type) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			String query = "select * from rpadmin." + type;
			Statement s = conn.createStatement();
			rs = s.executeQuery(query);

			return createReimbursementSet(rs, type);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	private ArrayList<Reimbursement> createReimbursementSet(ResultSet result, String type) throws SQLException {
		ResultSet rs = result;
		ArrayList<Reimbursement> tempList = new ArrayList<Reimbursement>();
		Reimbursement tempReimburse;
		try {
			while (rs.next()) {
				tempReimburse = new Reimbursement(rs.getString(FinalUtil.FIRSTNAME), rs.getString(FinalUtil.LASTNAME),
						rs.getInt(FinalUtil.PENDING_ID), rs.getString(FinalUtil.STATUS), rs.getLong(FinalUtil.AMOUNT),
						rs.getString(FinalUtil.REASON), rs.getTimestamp(FinalUtil.CREATION_DATE),
						rs.getString(FinalUtil.MANAGER_FIRSTNAME), rs.getString(FinalUtil.MANAGER_LASTNAME),
						rs.getInt(FinalUtil.EMPLOYEE_ID));

				tempList.add(tempReimburse);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			logger.error(e);
			tempReimburse = new Reimbursement(FinalUtil.EMPTY, FinalUtil.EMPTY, 0, FinalUtil.EMPTY, 0, FinalUtil.EMPTY,
					new Timestamp(0), FinalUtil.EMPTY, FinalUtil.EMPTY, 0);
		}
		// System.out.println(tempList);
		return tempList;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		ArrayList<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
		allReimbursements.addAll(getReimbursements(FinalUtil.PENDING));
		allReimbursements.addAll(getReimbursements(FinalUtil.RESOLVED));
		return allReimbursements;
	}

}
