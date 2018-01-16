package com.revature.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

//When the user want to see their reimbursement history
public class HistoryController {
	public static String history(HttpServletRequest request) {
		
		System.out.println("IN HISTORY CONTROLLER");
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		
		ReimbursementDao reimbursementDao = ReimbursementDao.getInstance();
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		reimbursements = reimbursementDao.selectAllReimbursementById(loggedEmployee.getEmployeeId());
		
		request.getSession().setAttribute("reimbursementHistory", reimbursements);
			
		return "ReimbursementHistory.jsp";
	}
}
