package com.ers.dao;

import java.util.List;

import com.ers.model.Employee;

public interface EmployeeDao {

	public boolean insert(Employee Employee);
	public boolean insertProcedure(Employee Employee);
	public Employee select(Employee Employee);
	public List<Employee> selectAll();
	public String getEmployeeHash(Employee Employee);
}
