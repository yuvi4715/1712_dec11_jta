package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.util.FinalUtil;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
			return "Login.html";
		}
		
		//POST logic
		Employee loggedEmployee = EmployeeService.getEmployeeService().login(
				new Employee(request.getParameter("username"),request.getParameter("password")));
		
		// Wrong Credentials
		if(loggedEmployee.getUsername().equals("")) {
			return "Login.html";
		}
		else {
			/* Storing loggedEmployee to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("loggedEmployee", loggedEmployee);
			
			
			if (EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
				// grab the employee session and forward it through the servlet again to retain the session
				return "/managerhomepage.do";
			}
			else {
				// grab the employee session and forward it through the servlet again to retain the session
				return "/employeehomepage.do";
			}
		}
	}
}
