package com.revature.test;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

import junit.framework.*;

public class Test extends TestCase {
	protected Employee emp1;
	protected Employee emp2;
	
	protected void setUp() {
		emp1 = new Employee(10, "Jason", "Shen", "jshen@gmail.com", "test123", "MANAGER");
		emp2 = new Employee(20, "Steve", "Jobs", "apple2018@gmail.com", "123test", "EMPLOYEE");
	}
	
	public void managerCheck() {
		
		EmployeeService.getEmployeeService().registerCustomer(emp1);
		EmployeeService.getEmployeeService().registerCustomer(emp2);
		
		assertTrue(EmployeeService.getEmployeeService().isManager(emp1));
		assertFalse(EmployeeService.getEmployeeService().isManager(emp2));
	}

}
