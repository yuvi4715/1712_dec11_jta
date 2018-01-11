package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.util.FinalUtil;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
			return "login.jsp";
		}
		
		//POST logic
		Employee loggedEmployee = EmployeeService.getEmployeeService().login(
				new Employee(
						request.getParameter("username"),
						request.getParameter("password")
						));
		
		// Wrong Credentials
		if(loggedEmployee.getUsername().equals("")) {
			return "login.jsp";
		}
		else {
			/* Storing loggedEmployee to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("loggedEmployee", loggedEmployee);
			
			//Forward user to hit another controller
			return "/home.do";
		}
	}
}
