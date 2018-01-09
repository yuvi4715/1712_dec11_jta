package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursements;

public interface ReimbursementDAOInterface {
	
	public void newReimbursement(Reimbursements reim, Connection con) throws Exception;
	
	public void approveReimbursement();
	public void denyReimbbursement();
	
	public List<Reimbursements> openList(Connection con) throws Exception;
	public List<Reimbursements> closedList(Connection con) throws Exception;
	
	public List<Reimbursements> openEList(String user, Connection con) throws Exception;
	public List<Reimbursements> closedEList(String user, Connection con) throws Exception;
	
	public List<Reimbursements> rList(Connection con) throws Exception;
}
