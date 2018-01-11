package com.revature.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.util.FinalUtil;
public class ResolvedController {
	
	public static Object getResolved(HttpServletRequest request, HttpServletResponse response) {	
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		return EmployeeService.gettingResolved(loggedEmployee);		
	}
}