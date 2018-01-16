package com.revature.dao;
import java.util.ArrayList;

import com.revature.model.Reimbursement;
public interface IReimbursementDAO {

	boolean insertPending(Reimbursement reimbursement);
	boolean updatePendingStatus(Reimbursement reimbursement);
	ArrayList<Reimbursement> getReimbursementsForEmployee(int id, String type);
	ArrayList<Reimbursement> getReimbursements(String type);
	ArrayList<Reimbursement> getAllReimbursements();
	
	
}
