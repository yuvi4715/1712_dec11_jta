package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;

public class EditController {
	
	public static String edit(HttpServletRequest request) {
		
		System.out.println("IN EDIT CONTROLLER");
		
		EmployeeDao employeeDao = EmployeeDao.getInstance();
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		employeeDao.updateEmployee(loggedEmployee, email, password);
	
		
		
		return "EditProfile.jsp";
	}
	

}
