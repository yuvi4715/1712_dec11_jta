package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.util.FinalUtil;

/* AJAX controller that checks if specific username is taken */
public class FindEmployeeController {
	public static Object getEmployeeTicket(HttpServletRequest request, HttpServletResponse response) {	
		//Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		
		return EmployeeService.gettingEmployeeTickets(request.getParameter("id"));		
	}

}
