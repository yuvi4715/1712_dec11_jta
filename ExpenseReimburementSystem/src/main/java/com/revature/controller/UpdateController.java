package com.revature.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class UpdateController {

	public static String updateEmployee(HttpServletRequest request) {

		Employee updatedEmployee = new Employee(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("fName"),
				request.getParameter("lName"),
				request.getParameter("email"),
				request.getParameter("address"),
				request.getParameter("city"),
				request.getParameter("state"),
				request.getParameter("zip"),
				request.getParameter("phone"),
				request.getParameter("username"),
				request.getParameter("password")
				);
		EmployeeService.getEmployeeService().updateEmployee(updatedEmployee);
		request.getSession().setAttribute("loggedEmployee", EmployeeDaoJdbc.getEmployeeDaoJdbc().select(updatedEmployee));
		List<Employee> empList = EmployeeService.getEmployeeService().getEmployeeInfo(updatedEmployee);
		
		request.setAttribute("displayEmp", empList);
		
	
		return "EmployeeHomepage.jsp";
	}
}
