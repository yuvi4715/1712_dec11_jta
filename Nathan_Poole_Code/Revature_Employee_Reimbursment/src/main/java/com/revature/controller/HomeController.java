package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;

public class HomeController {
	
	public static String home(HttpServletRequest request) {
		
		Employee temp = (Employee) request.getSession().getAttribute("LoggedEmployee");
		if(temp.getManagerState()==1) return "ManagerHome.jsp";
		return "EmployeeHome.jsp";
	}
}
