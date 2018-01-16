package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.reimbursement.Closed;
import com.revature.reimbursement.ClosedService;
import com.revature.reimbursement.Employee;
import com.revature.reimbursement.EmployeeService;
import com.revature.reimbursement.User;
import com.revature.util.FinalUtil;

public class ManagerController {
	
	public static String manager(HttpServletRequest request) {
		return "ManagerPage.jsp";
	}
	
	
	
	
	//view all pending
	public static String getpending(HttpServletRequest request) {
		
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
	    	return "index.jsp";
	    }
		
		//use request.getParam to obtain EID for use in looking up pendin by eid
				
				List<Closed> pendingReimbursements = ClosedService.getInstance().showAllPending();    //parse EID taken from session attribute loggedUsr, to ClosedService method to retreive all related reimbursements.
								
				
				request.getSession().setAttribute("PendingReimbursements", pendingReimbursements);
		
		return "ManagerViewPending.jsp";
	}
	
	
	
	//view all Resolved
		public static String getresolved(HttpServletRequest request) {
			
			if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
		    	return "index.jsp";
		    }
			
			
					
					List<Closed> resolvedReimbursements = ClosedService.getInstance().showAllResolved();    // retreive all denied and approved reimbursements.
									
					
					request.getSession().setAttribute("ResolvedReimbursements", resolvedReimbursements);
			
			return "ManagerViewResolved.jsp";
		}
		
		
		


public static String approve(HttpServletRequest request) {
		
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
	    	return "index.jsp";
	    }  
		
		int rid = Integer.parseInt(request.getParameter("approvebutton"));
		String managerName = request.getParameter("firstname");
		
		System.out.println(rid);
		System.out.println(managerName);
		
		
		ClosedService.getInstance().approveRem(rid, managerName);	
			
		return "manager.do";
		//return "ManagerViewResolved.jsp";
	}



public static String deny(HttpServletRequest request) {
	
	if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
    	return "index.jsp";
    }  
	
	int rid2 = Integer.parseInt(request.getParameter("denybutton"));
	String managerName2 = request.getParameter("firstname2");
	
	System.out.println(rid2);
	System.out.println(managerName2);
	
	
	ClosedService.getInstance().denyRem(rid2, managerName2);	
		
	return "manager.do";
	//return "ManagerViewResolved.jsp";
}



	
public static String getpendingemp(HttpServletRequest request) { //the taste you know and love; now with more eid!
		
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
	    	return "index.jsp";
	    }
		
		//use request.getParam to obtain EID for use in looking up pendin by eid
				
				List<Closed> pendingReimbursements = ClosedService.getInstance().showAllEid(
						
						Integer.parseInt(request.getParameter("employeeid")
								));    //parse EID taken from session attribute loggedUsr, to ClosedService method to retreive all related reimbursements.
								
				
				request.getSession().setAttribute("PendingReimbursements", pendingReimbursements);
		
		return "ManagerViewPending.jsp";
	}
	
	
	
	
	public static String getallemps(HttpServletRequest request) {
		
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
	    	return "index.jsp";
	    }
		
		
//Employee loggedEmp = (Employee) request.getSession().getAttribute("loggedEmployee"); //we need the EID to parse into the EmployeeService; obtained from session attribute attached in Login Controller
	    
	   List<Employee> empList = EmployeeService.getInstance().ListAll();
	    
	    
	    request.getSession().setAttribute("listedEmployees", empList);
		return "ManagerViewEmployees.jsp";
	}
}

