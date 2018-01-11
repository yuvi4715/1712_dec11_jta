package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class ManagerHomepageController {

	public static String man(HttpServletRequest request) {
		// Print all employees on manager homepage
		List<Employee> empList = EmployeeService.getEmployeeService().listAllUsers();
		request.setAttribute("displayEmp", empList);	
		return "ManagerHomepage.jsp";
	}
}