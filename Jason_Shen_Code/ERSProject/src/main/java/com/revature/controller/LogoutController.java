package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;

public class LogoutController {
	public static String logout(HttpServletRequest request) {
	
		Employee loggedEmployee = (Employee) request.getSession(false).getAttribute("loggedEmployee");
		System.out.println("From LogoutController Session Employee: " + loggedEmployee);
		if (loggedEmployee != null) {	
			System.out.println("Invalidating session...");
			return "user/logout.jsp";
		}
		else {
			// Send to login controller
			return "user/login.jsp";
		}
	
	}
}
