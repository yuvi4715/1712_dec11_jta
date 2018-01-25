package com.revature.dao;

import java.util.List;
import com.revature.model.Employee;

public interface EmployeeDao {

	public void insertEmployee(Employee emp);
	public void updateEmployeeName(int id, String name);
	public Employee findById(int id);
	public Employee findByName(String name);
	public List<Employee> getAllEmployees();
	public void hqlExample() ;
}
