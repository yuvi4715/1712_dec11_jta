package com.revature.reimbursement;

import java.util.List;

public interface EmployeeDao {
	public List<Employee> getAllEmployee();
	public Employee getEmployee(Employee employee);
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
}
