package com.ers.service;

import java.util.List;

import com.ers.dao.EmployeeDaoImpl;
import com.ers.model.Employee;

public class EmployeeService {

	//private instance of EmployeeService variable
	private static EmployeeService EmployeeService;
	//applying singleton singleton pattern
	private EmployeeService() {
	}

	//to access the instance of the EmployeeService using EmployeeService
	public static EmployeeService getInstance() {
		if (EmployeeService == null) {
			EmployeeService = new EmployeeService();
		}
		return EmployeeService;
	}
	
	//calls the insert method of DAO
	public boolean registerEmployee(Employee Employee) {
		return EmployeeDaoImpl.getInstance().insert(Employee);
	}
	
	//calls the insert method which will call the stored procedure named "insert_Employee"
	public boolean registerEmployeeSecure(Employee Employee) {
		return EmployeeDaoImpl.getInstance().insertProcedure(Employee);
	}
	
	//service to call selectAll method in DAO
	public List<Employee> listAllUsers(){
		return EmployeeDaoImpl.getInstance().getAllEmployees();
	}
	
	//
	public boolean login(Employee Employee) {
		//Get user information without validation
		Employee e1 = EmployeeDaoImpl.getInstance().select(Employee);
		/*
		 * c1.getPassword is the hash we stored in database
		 * compare that against the user input
		 * if credentials are correct then return all Employee info
		 * otherwise, return a blank object
		 */
		if (e1.getpasshash().equals(EmployeeDaoImpl.getInstance().getEmployeeHash(Employee))) {
			return true;
		}
		return false;
	}
	
	public boolean logout(int sessionId) {
		return EmployeeDaoImpl.getInstance().logout(sessionId);
	}
}
