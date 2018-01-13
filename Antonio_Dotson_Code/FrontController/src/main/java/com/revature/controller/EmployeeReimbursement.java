package com.revature.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.revature.dao.Reimburse;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeReimbursement {
	
public static String returnApproved(HttpServletRequest request) {

	Employee a = (Employee) request.getSession().getAttribute("loggedCustomer");
	int eid = a.getEid();
	
		List <Reimburse> approvedAll =  EmployeeService.getEmployeeService().employeeAppproved(a);
				
		request.setAttribute("myRequ", approvedAll);
		return "view_approved.jsp";
    }
 
public static String returnDisapprove(HttpServletRequest request) {

	Employee b = (Employee) request.getSession().getAttribute("loggedCustomer");
	int id = b.getEid();
	
		List <Reimburse> eAll =  EmployeeService.getEmployeeService().employeeDisapproved(b);
				
		request.setAttribute("esa", eAll);
		return "denied_approved.jsp";
    }
 

}

