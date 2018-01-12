package com.revature.service;


import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDaoJDBC;
import com.revature.model.Employee;
import com.revature.model.RoleType;


public class EmployeeService {
	// Singleton Stuff
	// ====================================
	private static EmployeeService employeeService;
	private EmployeeService() {
		
	}
	public static EmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeService();
		}
		
		return employeeService;
	}
	// ====================================
	
	
	public boolean registerCustomer(Employee employee) {
		return  EmployeeDaoJDBC.getEmployeeDaoJDBC().insert(employee) && 
				EmployeeDaoJDBC.getEmployeeDaoJDBC().setRole(employee, "EMPLOYEE");
	}	
	

	
	public boolean isEmailTaken(Employee employee) {
		if(EmployeeDaoJDBC.getEmployeeDaoJDBC().select(employee).getEmail().equals("")) {
			return false;
		}
		return true;
	}

	/* Calls select method of the DAO by username and performs login logic */
	public Employee login(Employee employee) {
		//Get user information without validating
		Employee loggedCustomer = EmployeeDaoJDBC.getEmployeeDaoJDBC().select(employee);
		
		/*
		 * loggedCustomer.getPassword() is the hash we have stored.
		 * We compare that against the hash of the user input.
		 * If credentials are correct we return the full Customer information.
		 * Else, we return a blank object.
		 */
		if(loggedCustomer.getPassword().equals(EmployeeDaoJDBC.getEmployeeDaoJDBC().getEmployeeHash(employee))) {
			return loggedCustomer;
		}
		
		return new Employee();
	}
	
	public boolean checkPassword(String s, Employee employee) {
		// Create a new employee object using the password in question and the email of the existing employee
		Employee testEmployee = new Employee(employee.getEmail(), s);
		String curr_pw = employee.getPassword();
		
		// Use this test object to generate a hash for the password in question
		String newhash = EmployeeDaoJDBC.getEmployeeDaoJDBC().getEmployeeHash(testEmployee);
		System.out.println("Checking Hash: " + newhash + " Against...");
		// Compare the hash of the employee in question with this new hash we just created
		System.out.println("Existing Hash: " + curr_pw);
		
		return newhash.equals(curr_pw);
		
		
	}
	
	public boolean isManager(Employee employee) {
		List<RoleType> role_list = new ArrayList<>();
		role_list = EmployeeDaoJDBC.getEmployeeDaoJDBC().getRoles(employee);
		for (RoleType role : role_list) {
			// Could use a constant here
			if (role.getType().equals("MANAGER")) {
				return true;
			}
		}
		return false;
	}

	public void updatePassword(Employee employee, String newPassword) {
		EmployeeDaoJDBC.getEmployeeDaoJDBC().updatePassword(employee, newPassword);
	}
	public void updateName(Employee employee, String firstname, String lastname) {
		EmployeeDaoJDBC.getEmployeeDaoJDBC().updateName(employee, firstname, lastname);
	}
	public void updateEmail(Employee employee, String email) {
		EmployeeDaoJDBC.getEmployeeDaoJDBC().updateEmail(employee, email);
	}
}
