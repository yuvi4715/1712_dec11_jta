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
		Employee loggedCustomer = EmployeeService.getEmployeeService().login(
				new Employee(
						request.getParameter("username"),
						request.getParameter("password")
						));
		
		// Wrong Credentials
		if(loggedCustomer.getUsername().equals("")) {
			return "index.html";
		} 
		  
		if(loggedCustomer.getManagerid() > 0) {
			/* Storing loggedCustomer to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("loggedCustomer", loggedCustomer);
			return "/manager.do";
			
	          } else {
	        	  
				request.getSession().setAttribute("loggedCustomer", loggedCustomer);
				return "/home.do";
				
			}
			//Forward user to hit another controller
		
	}
}
