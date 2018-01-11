package com.revature;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

/* Welcome to the Java */
public class Main {
	public static void main(String[] args) {
		//Test insert
		System.out.println(EmployeeService.getEmployeeService().registerEmployee(
				new Employee(0,"Yoshi","Kirishima","yk","1337")));

		//Test insert procedure
		System.out.println(EmployeeService.getEmployeeService().registerEmployeeSecure(
				new Employee(0,"Test","Number2","test2","1234")));

		//Test select all
		System.out.println(EmployeeService.getEmployeeService().listAllUsers());

		//Test login
		System.out.println(EmployeeService.getEmployeeService().login(
				new Employee("yk","1337")));
	}
}
