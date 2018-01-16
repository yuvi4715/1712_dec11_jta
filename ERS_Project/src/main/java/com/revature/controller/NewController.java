package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Employee;
//Controller for when the user wants to create a new reimbursement form
public class NewController {
	
	public static String reimbursementForm(HttpServletRequest request) {
		
		System.out.println("IN Reimbursement Form CONTROLLER");
		
		ReimbursementDao reimbursementDao = ReimbursementDao.getInstance();
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		int amount = Integer.parseInt(request.getParameter("amount"));
		String description = request.getParameter("description");
	
		reimbursementDao.insertReimbursement(loggedEmployee, amount, description);

		return "/new_page.do";
	}

}
