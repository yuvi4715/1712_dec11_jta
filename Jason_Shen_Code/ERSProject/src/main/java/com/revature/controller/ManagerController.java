package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class ManagerController {
	public static String getEmployees (HttpServletRequest request) {
		
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		// If the logged user isn't a manager, return to home
		// Can happen if the user just types into URL
		if (!EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
			return "home.do";
		}
		else {
			
		}
		
		return "";
	}

	public static String enterPortal(HttpServletRequest request) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");

		// If valid session
		if (loggedEmployee != null) {
			// If user is a manager
			if(EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
				return "managerPortal.jsp";	
			}
			else {
				return "home.do";
			}
			
		}
		else {
			return "user/login.jsp";
		}

	}
}
