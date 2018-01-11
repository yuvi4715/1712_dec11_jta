package com.revature.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.util.FinalUtil;

//public class PendingController {
//
//	public static String emp(HttpServletRequest request) {
//		Employee employeeToPassIn = (Employee) request.getSession().getAttribute("loggedEmployee");
//		
//		List<Reimbursement> penList = EmployeeService.getEmployeeService().getPendingReq(employeeToPassIn);
//		request.setAttribute("displayPen", penList);
//		return "EmployeePending.jsp";
//	}
//	
//}

public class PendingController {
	
	public static Object getPending(HttpServletRequest request, HttpServletResponse response) {	
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		return EmployeeService.gettingPending(loggedEmployee);		
	}
}