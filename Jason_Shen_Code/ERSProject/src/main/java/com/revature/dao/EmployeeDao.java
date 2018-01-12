package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.RoleType;

public interface EmployeeDao {
	public boolean insert(Employee employee);	
	public boolean setRole(Employee employee, String role);
	public List<RoleType> getRoles(Employee employee);
	public Employee select(Employee employee);
	public String getEmployeeHash(Employee employee);
	public void updatePassword(Employee employee, String password);
	public void updateName(Employee employee, String firstname, String lastname);
	public void updateEmail(Employee employee, String email);
	public List<Employee> selectAll();
}
