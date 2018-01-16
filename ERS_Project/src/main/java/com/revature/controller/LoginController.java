package com.revature.controller;



import javax.servlet.http.HttpServletRequest;

import com.revature.services.EmployeeService;
import com.revature.model.Employee;


//@WebServlet("/LoginController")
//public class LoginController extends HttpServlet {
public class LoginController {

	public static String login(HttpServletRequest request) {
		// protected void doPost(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException, IOException {

		System.out.println("IN LOGIN CONTROLLER");

		EmployeeService employeeService = EmployeeService.getInstance();

		if (employeeService != null) {
			System.out.println("EMPLOYEESERVICE CREATED");
		} else {
			System.out.println("EMPLOYEESERVICE NOT CREATED");
		}

		// POST logic
		System.out.println("TRYING TO CREATE EMPLOYEE");
		Employee loggedEmployee = employeeService.login(request.getParameter("username"),
				request.getParameter("password"));

		if (loggedEmployee != null) {
			System.out.println("EMPLOYEE CREATED");
		} else {
			System.out.println("EMPLOYEE NOT CREATED");
		}
		
		System.out.println("Employee role: " + loggedEmployee.getTitle());

		// If employee is a manager
		if (employeeService.verifyCredentials(loggedEmployee.getUsername(), loggedEmployee.getPassword())
				&& loggedEmployee.getTitle().equals("Manager")) {

			request.getSession().setAttribute("loggedEmployee", loggedEmployee);
			return "/home.do";
		} else if (employeeService.verifyCredentials(loggedEmployee.getUsername(), loggedEmployee.getPassword())) {
			request.getSession().setAttribute("loggedEmployee", loggedEmployee);
			return "/home.do";
		} else {
			return "login.jsp";
		}
	}
}
