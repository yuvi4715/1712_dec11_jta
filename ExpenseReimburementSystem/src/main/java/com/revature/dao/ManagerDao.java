package com.revature.dao;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public interface ManagerDao {
	public void approve(int id, int managerID);
}
