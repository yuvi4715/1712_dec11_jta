package com.revature;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

/* Welcome to the Java */
public class Main {
	public static void main(String[] args) {
		
		//System.out.println(EmployeeService.getEmployeeService().registerEmployee(
			//	new Employee("Dotson","Antonio","Manager",5,"12-May-99","123 Green Mile","Kanas","TX","800999-999","antonio@mypenmail.com")));
/*
		//Test insert procedure
		System.out.println(EmployeeService.getEmployeeService().registerEmployeeSecure(
				new Employee(0,"Test","Number2","test2","1234")));
        */
		//Test select all
		System.out.println(EmployeeService.getEmployeeService().listAllUsers());

		//Test login
	//	System.out.println(EmployeeService.getEmployeeService().login(
		//		new Employee("newUser","EG7IWAEA9S52G291VZ24")));
	}
}
