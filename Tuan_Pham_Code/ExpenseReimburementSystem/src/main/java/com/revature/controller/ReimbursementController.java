package com.revature.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;

public class ReimbursementController {

	public static String submit(HttpServletRequest request) {
		
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		Reimbursement ticket = new Reimbursement(
				loggedEmployee.getId(),
				request.getParameter("category"),
				Integer.parseInt(request.getParameter("total")),
				request.getParameter("description")
				);
		System.out.println(loggedEmployee.getId() + request.getParameter("category") +Integer.parseInt(request.getParameter("total"))+
				request.getParameter("description"));
		
		EmployeeService.getEmployeeService().submitRequest(ticket);
		
		request.getSession().setAttribute("loggedEmployee", EmployeeDaoJdbc.getEmployeeDaoJdbc().select(loggedEmployee));
		return "EmployeeHomepage.jsp";
	}
}
