package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	public boolean insert(Employee employee);
	public boolean insertProcedure(Employee employee);
	public Employee select(Employee employee);
	public List<Employee> selectAll();
	public String getEmployeeHash(Employee employee);
}
