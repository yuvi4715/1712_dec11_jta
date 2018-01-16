package com.revature.services;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDaoJDBC;

public class ReimbursementService {

	private ReimbursementDAO rd = new ReimbursementDaoJDBC();
	
	// service used to add reimbursements to the database
	// calls the DAO method for adding
	public int add(Reimbursement r) {
		return rd.addReimbursement(r);
	}

	public boolean statusChange(Reimbursement r, String choice, int resolverId) {
		return rd.approveDeny(choice, r.getId(), resolverId);
	}

	public List<Reimbursement> getAllReimb() {
		return rd.retrieveAllReimbursements();
	}
	
	public List<Reimbursement> getByUser(int id) {
		return rd.getReimbursementsByUser(id);
	}
}
