package com.ers.dao;

import java.util.List;

import com.ers.model.Employee;

public interface EmployeeDao {
	public boolean authenticate(String username, String password);
	public boolean logout(int sessionId);
	public boolean updateInfo(Employee employee);
	public boolean addNewEmployee(Employee Employee);
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByUsername(String username);
	public List<Employee> getAllEmployees();
	public String getEmployeeHash(Employee Employee);
}
