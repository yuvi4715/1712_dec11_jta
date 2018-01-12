package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;
public class ResolvedController {
	
	public static Object getResolved(HttpServletRequest request, HttpServletResponse response) {	
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		return EmployeeService.gettingResolved(loggedEmployee);		
	}
	
	public static Object getAllResolved(HttpServletRequest request, HttpServletResponse response) {	
		return EmployeeService.gettingAllResolved();		
	}
}