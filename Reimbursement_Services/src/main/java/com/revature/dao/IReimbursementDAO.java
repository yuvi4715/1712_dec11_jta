package com.revature.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Reimbursement;
public interface IReimbursementDAO extends IMainDAO {

	void insertReimbursement(Reimbursement reimbursement);
	void insertResolvedStatus(Reimbursement reimbursement);
	ArrayList<Reimbursement> getReimbursementsForEmployee(int id, String type) throws SQLException;
	ArrayList<Reimbursement> getReimbursements(String type) throws SQLException;
	
	
}
