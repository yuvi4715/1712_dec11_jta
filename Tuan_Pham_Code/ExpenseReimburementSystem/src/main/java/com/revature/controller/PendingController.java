package com.revature.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;

public class PendingController {

	public static String emp(HttpServletRequest request) {
		Employee employeeToPassIn = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		List<Reimbursement> penList = EmployeeService.getEmployeeService().getPendingReq(employeeToPassIn);
		request.setAttribute("displayPen", penList);
		return "EmployeePending.jsp";
	}
	
}
