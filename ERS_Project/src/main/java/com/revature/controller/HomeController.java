package com.revature.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeDao;
import com.revature.dao.ReimbursementDao;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public class HomeController {
	
	public static String home(HttpServletRequest request) {
		
		System.out.println("IN HOME CONTROLLER");
		
	
		
		EmployeeDao employeeDao = EmployeeDao.getInstance();
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		Employee employee = employeeDao.findEmployeeById(loggedEmployee.getEmployeeId());
		
		request.getSession().setAttribute("employee", employee);
		
		
		
		return "EmployeeHome.jsp";
	}
	
	

}
