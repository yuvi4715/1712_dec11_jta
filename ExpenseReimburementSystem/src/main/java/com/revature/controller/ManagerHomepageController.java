package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;

public class ManagerHomepageController {

	public static String man(HttpServletRequest request) {
		// Print all employees on manager homepage
		List<Employee> empList2 = EmployeeService.getEmployeeService().listAllUsers();
		request.setAttribute("displayEmp2", empList2);
		
		List<Reimbursement> reimbursementList = EmployeeService.getEmployeeService().gettingAllPending();
		request.setAttribute("displayReimbursement", reimbursementList);
		return "ManagerHomepage.jsp";
	}
}