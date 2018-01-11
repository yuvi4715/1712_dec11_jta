package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.util.FinalUtil;

/* Class that executes business logic related to employees */
public class EmployeeService {

	/*Singleton transformation of Employee Service object */
	private static EmployeeService employeeService;
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeService();
		}
		
		return employeeService;
	}
	
	/* Calls the insert method of the DAO */
	public boolean registerEmployee(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().insert(employee);
	}
	
	/* Calls the insert method that uses stored procedure in DAO */
	public boolean registerEmployeeSecure(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().insertProcedure(employee);
	}
	
	/* Calls selectAll method of the DAO */
	public List<Employee> listAllUsers() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectAll();
	}
	
	/* Calls select method of the DAO by username and performs login logic */
	public Employee login(Employee employee) {
		//Get user information without validating
		Employee loggedEmployee = EmployeeDaoJdbc.getEmployeeDaoJdbc().select(employee);
		
		/*
		 * loggedEmployee.getPassword() is the hash we have stored.
		 * We compare that against the hash of the user input.
		 * If credentials are correct we return the full Employee information.
		 * Else, we return a blank object.
		 */
		if(loggedEmployee.getPassword().equals(EmployeeDaoJdbc.getEmployeeDaoJdbc().getEmployeeHash(employee))) {
			return loggedEmployee;
		}
		
		return new Employee();
	}
	
	/* Calls the select method of the DAO, if the user returned is empty, then username is not taken. */
	public boolean isUsernameTaken(Employee employee) {
		if(EmployeeDaoJdbc.getEmployeeDaoJdbc().select(employee).getUsername().equals(FinalUtil.EMPTY_STRING)) {
			return false;
		}
		return true;
	}
}
