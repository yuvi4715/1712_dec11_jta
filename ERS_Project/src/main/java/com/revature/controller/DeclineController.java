package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Employee;

public class DeclineController {
	
	public static String decline(HttpServletRequest request) {
		
		System.out.println("IN DECLINE CONTROLLER");
		
		String reimbursementId = request.getParameter("decline");
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		ReimbursementDao reimbursementDao = ReimbursementDao.getInstance();
		reimbursementDao.declineReimbursement(loggedEmployee.getEmployeeId(), Integer.parseInt(reimbursementId));
	
		return "/resolve_page.do";
	}

}
