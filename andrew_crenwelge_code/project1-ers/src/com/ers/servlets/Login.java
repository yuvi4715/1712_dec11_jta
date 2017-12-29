package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.service.EmployeeService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get username, password
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// create employee from parameters
		Employee e1 = new Employee(username,password);
		// attempt to log user in
		EmployeeService es = EmployeeService.getInstance();
		boolean success = es.login(e1);
		if (success) {
			// celebrate
			req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req,resp);
		}
		else {
			// :(
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}
	}
}