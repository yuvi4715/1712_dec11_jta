package com.revature.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeHomepageController {

	public static String emp(HttpServletRequest request) {

		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		List<Employee> empList = EmployeeService.getEmployeeService().getEmployeeInfo(loggedEmployee);
		
		request.setAttribute("displayEmp", empList);
		return "EmployeeHomepage.jsp";
	}
}
