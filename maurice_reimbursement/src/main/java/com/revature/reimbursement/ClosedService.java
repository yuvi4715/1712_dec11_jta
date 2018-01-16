package com.revature.reimbursement;

import com.revature.reimbursement.ClosedDaoImpl;

import java.util.List;

import com.revature.reimbursement.Closed;

public class ClosedService {

	//private instance of ClosedService variable
	private static ClosedService closedService;
	//singleton
	private ClosedService() {
		
	}
	
	
	//getting instance of ClosedService
	public static ClosedService getInstance() {
		if(closedService == null) {
			closedService = new ClosedService();
		
	}
	return closedService;	
	}
	
	
	
	
	//calls the insert method of DAO 
	public boolean placeClosed(Closed closed) {  

		return ClosedDaoImpl.getInstance().insertClosed(closed);
	}
	
	/*//change status
	public boolean changeStatus(Closed closed) {
		return ClosedDaoImpl.getInstance().changeProceedure(closed);  //must create a proceedure for this
	}*/
	
	//list all reimbursements (manager controller uses this method)
	public List<Closed> showAll() {
		return ClosedDaoImpl.getInstance().getAllClosed();
		
	}
	
	
	public List<Closed> showAllPending() {
		return ClosedDaoImpl.getInstance().getAllPendingClosed();
		
	}
	
	public List<Closed> showAllResolved() {
		return ClosedDaoImpl.getInstance().getAllResolvedClosed();
		
	}
	
	
	
	//list all closed reimbursements, given an EID
		public List<Closed> showAllEid(int eid) {
			if(eid == 0) {
				return ClosedDaoImpl.getInstance().getAllClosed(); //if no eid is entered, retreive all
				
			}
			return ClosedDaoImpl.getInstance().getEidClosed(eid); //otherwise retreive eids for specific employee
		}
	
		
	//approve reimbursement
			public boolean approveRem(int rid, String managername) {
					return ClosedDaoImpl.getInstance().approveClosed(rid, managername);
		}
		
		
	//deny reimbursement
		public boolean denyRem(int rid, String managername) {
			return ClosedDaoImpl.getInstance().denyClosed(rid, managername);
	}
}
