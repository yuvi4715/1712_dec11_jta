package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import com.revature.dao.ReimbursementDao;
import com.revature.model.Employee;


public class ApproveController {
	
	public static String approve(HttpServletRequest request) {
		
		//Fixed resolved by = loggedEmployee.getId();
		
		String reimbursementId = request.getParameter("approve");
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		ReimbursementDao reimbursementDao = ReimbursementDao.getInstance();
		reimbursementDao.approveReimbursement(loggedEmployee.getEmployeeId(),Integer.parseInt(reimbursementId));
	
		return "/resolve_page.do";
	}
}
