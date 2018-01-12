package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public interface EmployeeDao {
	public boolean insert(Employee employee);
	public boolean insertProcedure(Employee employee);
	public Employee select(Employee employee);
	public List<Employee> selectAll();
	public String getEmployeeHash(Employee employee);
	public boolean checkManager(Employee employee);
	public List<Employee> getInfo(Employee employee);
	public List<Reimbursement> getPending(Employee employee);
	public List<Reimbursement> getResolved(Employee employee);
	public void update(Employee employee);
}
