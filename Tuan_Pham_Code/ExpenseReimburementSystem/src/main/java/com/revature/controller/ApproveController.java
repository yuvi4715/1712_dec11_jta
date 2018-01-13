package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.service.ManagerService;

public class ApproveController {
	
	public static Object approve(HttpServletRequest request, HttpServletResponse response) {	
		int rid = Integer.parseInt(request.getParameter("reimbursementID"));
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		ManagerService.getManagerService().approve(rid, loggedEmployee.getId());
		return new Object();
		
	}
	
	
}