package com.ers.main;

import org.apache.log4j.Logger;
import com.ers.model.Employee;
import com.ers.service.EmployeeService;

public class TestClass {
	final static Logger logger = Logger.getLogger(Logger.class);

	public static void main(String[] args) {
//		logger.trace(e.getMessage());
//		logger.info(e.getMessage());
//		logger.warn(e.getMessage());
//		logger.fatal(e.getMessage());
		//**** -- Please don't write all print statements in one attempt 
		//**** -- Please try to run one sysout at a time to understand the permutations

		//Step 1 - Test to insert a new Employee with valid
		//System.out.println(EmployeeService.getInstance().registerEmployee(new Employee(0, "Test", "Test", "Test", "Test")));

		//Step 2 - Test to insert another new Employee with valid credentials
		//System.out.println(EmployeeService.getInstance().registerEmployee(new Employee(0, "Yuvaraj", "Damodaran", "yuvi", "1234")));

		//Step 3 - Try to insert an existing credentials - should throw unique key constraint on Employee table
		//System.out.println(EmployeeService.getInstance().registerEmployee(new Employee(0, "Yuvaraj", "Damodaran", "yuvi", "1234")));
		
		//Step 4 - Test to insert a new Employee using stored procedure
		//System.out.println(EmployeeService.getInstance().registerEmployeeSecure(new Employee(0, "Using Stored", "Procedure", "storedproc", "storedproc")));
	
		//Step 5 - Test to retrieve all the users in the database
		System.out.println(EmployeeService.getInstance().listAllUsers());
		
		//Step 6 - Test login
		//System.out.println(EmployeeService.getInstance().login(new Employee("yuvi","1234")));
		
	}

}
