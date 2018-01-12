package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeDaoJDBC;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;


public class UpdateInfoController {
	public static String updateInfo(HttpServletRequest request) {
		
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");

		
//		If it's a GET we just return the view.
		if (loggedEmployee != null && request.getMethod().equals("GET")) {	
			return "user/updateInfo.jsp";
		}
		
		if (loggedEmployee != null && request.getMethod().equals("POST")) {	
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String formPassword = request.getParameter("currentpw");
			String newPassword1 = request.getParameter("newpw1");
			String newPassword2 = request.getParameter("newpw2");
			
			// If changing anything at all, user needs to enter current password
			if (EmployeeService.getEmployeeService().checkPassword(formPassword, loggedEmployee)
					// Check if passwords match, they could be blank, but both need to be blank
					&& newPassword1.equals(newPassword2)) {
				
				// If user is not updating password, we won't ask them to relog, just send them to home page
				if (newPassword1.equals("")) {
					// Call update services
					EmployeeService.getEmployeeService().updateEmail(loggedEmployee, email);
					EmployeeService.getEmployeeService().updateName(loggedEmployee, firstname, lastname);
					
					// Since we are not asking to relog, we need to update the current loggedEmployee session attribute to reflect changes
					request.getSession().setAttribute("loggedEmployee", loggedEmployee);
					return "home.do";

				}
				else {
					// Call update services
					// Need to update email first because hashing password is based on email
					System.out.println("Updating Email...");
					EmployeeService.getEmployeeService().updateEmail(loggedEmployee, email);
					System.out.println("Updating Name...");
					EmployeeService.getEmployeeService().updateName(loggedEmployee, firstname, lastname);
					System.out.println("Updating password...");
					EmployeeService.getEmployeeService().updatePassword(loggedEmployee, request.getParameter("newpw1"));
					
					// Since we are asking to relog, we dont need to update session attribute				
					return "user/login.jsp";
						
				}
				
			}
			else {				
				System.out.println("Bad password, try again...");
				return "user/badPassword.jsp";
			}
		}
		else {
			return "user/login.jsp";
		}

	}

}
