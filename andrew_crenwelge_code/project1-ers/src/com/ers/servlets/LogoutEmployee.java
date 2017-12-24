package com.ers.servlets;

import java.io.IOException;

import javax.servlet.HttpServlet;

import com.ers.model.Employee;
import com.ers.service.EmployeeService;

@WebServlet("/LogoutEmployee")
public class LogoutEmployee extends HttpServlet {
	
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