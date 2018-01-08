package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Reimbursement;

public class DAOFactory {

	private static DAOFactory obj;
	private DAOFactory() {}
	public static DAOFactory getInstance() {
		if(obj == null)
			obj = new DAOFactory();
		return obj;
	}
	public boolean validate(String username, String password) throws SQLException {
		
		ICredentialDAO cred = new CredentialDAO();
		return cred.isValid(username, password);
	}
	
	public boolean changePassword(String username, String password, String newPassword) throws SQLException {
		
		ICredentialDAO cred = new CredentialDAO();
		return cred.changePassword(username, password, newPassword);
	}
	
	public ArrayList<Reimbursement> getReimbursements(int id, String type)throws SQLException {
		IReimbursementDAO reim = new ReimbursementDAO();
		return reim.getReimbursementsForEmployee(id, type);
	}
	
	public String getEmployeeInfo(String username) throws SQLException {
		IEmployeeDAO emp = new EmployeeDAO();
		return emp.getEmployeeInfo(username).toString();		
	}
	
}
