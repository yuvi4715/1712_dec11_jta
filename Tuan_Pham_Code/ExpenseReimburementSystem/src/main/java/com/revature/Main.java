package com.revature;

import java.util.List;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;

/* Welcome to the Java */
public class Main {
	public static void main(String[] args) {
		//Test insert
//		System.out.println(EmployeeService.getEmployeeService().registerEmployee(
//				new Employee(103,"Peter","Alagna", "test@gmail.com", "123 Fake St.", "Westtown", "VA", "92000", "714-735-9000", "petronilo","1234")));
		//Test insert procedure
//		System.out.println(EmployeeService.getEmployeeService().registerEmployeeSecure(
//				new Employee(104,"Test","Number2", "test@gmail.com", "123 Fake St.", "Westtown", "VA", "92000", "714-735-9000", "test2","1234")));

		//Test select all
		System.out.println(EmployeeService.getEmployeeService().listAllUsers());
		
		
		//Test login
//		System.out.println(EmployeeService.getEmployeeService().login(
//				new Employee("petronilo","1234")));
		
//		Employee test = new Employee(103,"Peter","Alagna", "test@gmail.com", "123 Fake St.", "Westtown", "VA", "92000", "714-735-9000", "petrolino","1234");
//		String hash = EmployeeDaoJdbc.getEmployeeDaoJdbc().getEmployeeHash(test);
//		System.out.println(hash);
	}
}
