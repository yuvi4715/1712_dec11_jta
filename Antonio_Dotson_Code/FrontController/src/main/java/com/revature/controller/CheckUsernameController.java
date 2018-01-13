package com.revature.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.ajax.AjaxMessage;
import com.revature.dao.Reimburse;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.util.FinalUtil;

/* AJAX controller that checks if specific username is taken */
public class CheckUsernameController {
	
	public static Object checkUsername(HttpServletRequest request, HttpServletResponse response) {
		
		if(EmployeeService.getEmployeeService().isUsernameTaken(new Employee(
				request.getParameter("username")))) {
			return new AjaxMessage(FinalUtil.USERNAME_TAKEN);
		}
		else {
			return new AjaxMessage(FinalUtil.USERNAME_AVAILABLE);
		}
	}
	
	public static Object returnPending(HttpServletRequest request, HttpServletResponse response) {

		Employee b = (Employee) request.getSession().getAttribute("loggedCustomer");
			List <Reimburse> eAll =  EmployeeService.getEmployeeService().employeePending(b); 
			return eAll;
	    }
	 
	  
}
