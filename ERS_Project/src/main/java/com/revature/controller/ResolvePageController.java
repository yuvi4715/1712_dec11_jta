package com.revature.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Reimbursement;

public class ResolvePageController {
	
	public static String resolve(HttpServletRequest request) {
		
		ReimbursementDao reimbursementDao = ReimbursementDao.getInstance();
		ArrayList<Reimbursement> reimbursements = reimbursementDao.selectAllReimbursements();
		
		request.getSession().setAttribute("reimbursements", reimbursements);
		
		return "ResolveReimbursement.jsp";
		
	}

}
