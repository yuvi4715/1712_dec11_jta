package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.services.EmployeeServices;
import com.revature.util.FinalUtil;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		//System.out.println("loginController.login");
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
			return "/login.html";
		}
		
		//POST logic
		//System.out.println("geting Employee Info");
		Employee loggedEmployee = EmployeeServices.getInstance().login(
				new Employee(
						request.getParameter("username"),
						request.getParameter("password")
						));
		//System.out.println(loggedEmployee.toString());
		// Wrong Credentials
		if(loggedEmployee.getUsername().equals("")) {
			return "/login.html";
		}
		else {
			/* Storing loggedCustomer to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("LoggedEmployee", loggedEmployee);
			//Forward user to hit another controller
			return "/home.do";
		}
	}
}
