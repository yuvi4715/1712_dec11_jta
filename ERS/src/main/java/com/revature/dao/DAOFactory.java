package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.*;
import com.revature.util.FinalUtil;

public class DAOFactory {

	private static DAOFactory obj;
	private DAOFactory() {}
	public static DAOFactory getInstance() {
		if(obj == null)
			obj = new DAOFactory();
		return obj;
	}
	public Credential validate(Credential credential) {
		
		return CredentialDAO.getInstance().isValid(credential);
	}
	
	
	public boolean changePassword(Credential credential, String newPassword) {
		
		return CredentialDAO.getInstance().changePassword(credential, newPassword);
	}
	
	public ArrayList<Reimbursement> getAllReimbursements(){
		return ReimbursementDAO.getInstance().getAllReimbursements();
	}
	public ArrayList<Reimbursement> getAllReimbursementsInType(Reimbursement reimbursement){
		return ReimbursementDAO.getInstance().getReimbursements(reimbursement.getType());
	}
	
	public ArrayList<Reimbursement> getEmployeeReimbursements(String username, String type) {
		int id = EmployeeDAO.getInstance().getUserInfoByUsername(username).getEid();
		return ReimbursementDAO.getInstance().getReimbursementsForEmployee(id, type);
	}
	public ArrayList<Reimbursement> getEmployeeReimbursementsById(int id, String type) {
		
		return ReimbursementDAO.getInstance().getReimbursementsForEmployee(id, type);
	}
	public ArrayList<Reimbursement> getAllEmployeeReimbursementsById(int id) {
		ArrayList<Reimbursement> tempList = new ArrayList<Reimbursement>();
		tempList.addAll(getEmployeeReimbursementsById(id, FinalUtil.PENDING));
		tempList.addAll(getEmployeeReimbursementsById(id, FinalUtil.RESOLVED));
		return tempList;
	}
	//Getting info for the user
	public Employee getUserInfo(String username) {
		return EmployeeDAO.getInstance().getUserInfoByUsername(username);		
	}
	//Getting info for the chosen employee
	public Employee getEmployeeInfo(Employee employee) {
		String username = EmployeeDAO.getInstance().getUsername(employee);
		return EmployeeDAO.getInstance().getUserInfoByUsername(username);
	}
	public ArrayList<Employee> getNames() {
		return EmployeeDAO.getInstance().getEmployeeNames();
	}
	public boolean movePendingToResolved(Reimbursement reimbursement, String username) {
		reimbursement.setManid(EmployeeDAO.getInstance().getUserInfoByUsername(username).getEid());
		return ReimbursementDAO.getInstance().updatePendingStatus(reimbursement);
	}
	public boolean addReimbursementToPending(Reimbursement reimbursement) {
		return ReimbursementDAO.getInstance().insertPending(reimbursement);
	}
}
