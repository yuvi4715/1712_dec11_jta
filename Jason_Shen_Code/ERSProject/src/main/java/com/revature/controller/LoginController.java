package com.revature.controller;


import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals("GET")) {
			return "user/login.jsp";
		}
		
		//POST logic
		Employee loggedEmployee = EmployeeService.getEmployeeService().login(
				new Employee(
						request.getParameter("email"),
						request.getParameter("password")
						));
		
		// Wrong Credentials
		if(loggedEmployee.getEmail().equals("")) {
			System.out.println("Login failed, check credentials again.");
			return "user/login.jsp";
		}
		else {
			/* Storing loggedEmployee to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			System.out.println("Login successful, welcome to Revature ERS!");
			request.getSession().setAttribute("loggedEmployee", loggedEmployee);
			
			// Not sure how to implement redirect on timeout, so we set it to never timeout for now.
			request.getSession().setMaxInactiveInterval(-1);
			//Forward user to hit another controller
			System.out.println("Entering home page...");
			return "home.do";
		}
	}
}
