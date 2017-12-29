package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.EmployeeService;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get session Id
		int sessionId = 1;
		// attempt to log user in
		EmployeeService es = EmployeeService.getInstance();
		boolean success = es.logout(sessionId);
		if (success) {
			// celebrate
		}
		else {
			// :(
		}
		req.getRequestDispatcher("index.jsp").forward(req,resp);
	}
}