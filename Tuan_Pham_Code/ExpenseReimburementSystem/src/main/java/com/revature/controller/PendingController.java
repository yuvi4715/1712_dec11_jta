package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class PendingController {
	
	public static Object getPending(HttpServletRequest request, HttpServletResponse response) {	
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		return EmployeeService.gettingPending(loggedEmployee);		
	}
	
	public static Object getAllPending(HttpServletRequest request, HttpServletResponse response) {	
		return EmployeeService.gettingAllPending();		
	}
}