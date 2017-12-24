package com.ers.servlets;

import java.io.IOException;
import com.ers.model.Employee;
import com.ers.service.EmployeeService;

@WebServlet("/EmployeeHomepage")
public class EmployeeHomepage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// somehow send manager data to jsp page
		req.getRequestDispatcher("ManagerHomepage.jsp").forward(req,resp);
	}
}
