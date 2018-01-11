package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursement;

/* Contract interface that uses DAO design pattern rules that can be implemented
 * by many types of technologies like JDBC, Hibernate, MongoDB, etc.
 */
public interface ReimbursementDao {
	public boolean insertProcedure(Reimbursement reimbursement);
	
	//public List<Reimbursement> selectAll(Reimbursement reimbursement);
	//public List<Reimbursement> selectPending(Reimbursement reimbursement);
	//public List<Reimbursement> selectResolved(Reimbursement reimbursement);
	
	public List<Reimbursement> getAllByEmployee(int employeeId);
	public List<Reimbursement> getPendingByEmployee(int employeeId);
	public List<Reimbursement> getResolvedByEmployee(int employeeId);
}