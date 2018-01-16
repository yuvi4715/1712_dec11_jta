package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement getReimbursementByID(int id);
	
	List<Reimbursement> retrieveAllReimbursements();
	
	List<Reimbursement> getReimbursementsByUser(int id);
	
	int addReimbursement(Reimbursement rb);
	
	boolean approveDeny(String choice, int id, int resolverId);
}