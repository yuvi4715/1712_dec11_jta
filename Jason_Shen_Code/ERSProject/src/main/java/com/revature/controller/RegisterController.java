package com.revature.controller;
import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class RegisterController {
	
	public static String register(HttpServletRequest req) {
		
		//If it's a GET we just return the view.
		if(req.getMethod().equals("GET")) {
			return "user/register.jsp";
		}

		//POST LOGIC BELOW
		
		// Get form-submitted data/parameters
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		// Connect to database
		try {
			Employee emp = new Employee(firstname, lastname, email, password);
			if (EmployeeService.getEmployeeService().isEmailTaken(emp)) {
				System.out.println("Email is taken!");
				// Return to register page to try again for now, handled by AJAX later
				return "user/register.jsp";

			}
			else if (EmployeeService.getEmployeeService().registerCustomer(emp)) {
				System.out.println("New employee added!");
				System.out.println("Login to continue, redirecting to login page...");
				return "user/login.jsp";
			}						
			else {
				System.out.println("Error occurred, please try again: ");
				return "user/register.jsp";
			}					

		}
		catch (Exception e) {
			System.out.println("Failed to add new employee...");
			e.printStackTrace();
			return "user/register.jsp";
		}
	}
}
