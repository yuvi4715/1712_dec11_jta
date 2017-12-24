package com.ers.dao;

import java.util.List;

import com.ers.model.Employee;

public interface EmployeeDao {
	public boolean login(Employee employee);
	public boolean logout(int sessionId);
	public boolean updateInfo(Employee employee);
	public boolean insert(Employee Employee);
	public boolean insertProcedure(Employee Employee);
	public Employee select(Employee Employee);
	public List<Employee> getAllEmployees();
	public String getEmployeeHash(Employee Employee);
}
