package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Employee;

public interface IEmployeeDAO {
	
	ArrayList<Employee> getEmployeeNames();
	boolean updateEmployeeInfo(Employee employee);
	Employee getUserInfoByUsername(String username);
	String getUsername(Employee employee);


}
