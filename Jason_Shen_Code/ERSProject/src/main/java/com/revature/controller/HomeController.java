package com.revature.controller;


import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class HomeController {
	public static String home(HttpServletRequest request) {
		// if manager, return manager home page, else employee home page 

		// You should not be able to reach a home page if you aren't logged in
		// To address this, we get the session state and check if there's an attribute of a logged user
		// If there isnt' we should direct them to log in.
		Employee loggedEmployee = (Employee) request.getSession(false).getAttribute("loggedEmployee");
		if (loggedEmployee != null) {	
			System.out.println("Valid session state");
			if (EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
				System.out.println(
						"FirstName: " + loggedEmployee.getFirstName() + " " +
						"LastName: " + loggedEmployee.getLastName() + " " +
						"Email: " + loggedEmployee.getEmail()
				);
				return "managerHome.jsp";
			}
			System.out.println(
					"FirstName: " + loggedEmployee.getFirstName() + " " +
					"LastName: " + loggedEmployee.getLastName() + " " +
					"Email: " + loggedEmployee.getEmail()
			);
			return "employeeHome.jsp";
		}
		else {
			// Send to login controller
			System.out.println("Invalid session state, redirecting to login");
			return "user/login.jsp";
		}

	
	}
}
