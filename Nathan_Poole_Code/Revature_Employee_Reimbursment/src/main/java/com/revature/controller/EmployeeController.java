package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Employee;
import com.revature.services.EmployeeServices;
import com.revature.util.FinalUtil;

public class EmployeeController {

	public static Object submitNewEmployee(HttpServletRequest request, HttpServletResponse response) {
		int mState = (((boolean) Boolean.parseBoolean(request.getParameter("manager")))? 1: 0);
		if(EmployeeServices.getInstance().createEmployeeSecure(
				new Employee(
						request.getParameter("fullname"),
						request.getParameter("email"),
						request.getParameter("username"),
						request.getParameter("password"),
						request.getParameter("title"),
						mState
						))) {
			return new AjaxMessage(FinalUtil.EMPLOYEE_CREATED);
		}
		else {
			return new AjaxMessage(FinalUtil.EMPLOYEE_FAIL);
		}
	}
	
	public static Object updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		if(EmployeeServices.getInstance().updateEmployee(
				new Employee(
						(int) Integer.parseInt(request.getParameter("empid")),
						request.getParameter("fullname"),
						request.getParameter("email"),
						request.getParameter("username"),
						request.getParameter("password")
						))) {
			return new AjaxMessage(FinalUtil.EMPLOYEE_UPDATED);
		}
		else {
			return new AjaxMessage(FinalUtil.UPDATE_FAIL);
		}
	}
	
	public static Object getEmployee(HttpServletRequest request, HttpServletResponse response) {
		return EmployeeServices.getInstance().selectEmployee(new Employee((int)Integer.parseInt(request.getParameter("empid"))));
	}

	public static Object getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		return EmployeeServices.getInstance().listAllUsers();
	}

}
