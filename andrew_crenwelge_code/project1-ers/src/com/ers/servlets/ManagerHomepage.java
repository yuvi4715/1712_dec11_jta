package com.ers.servlets;

import java.io.IOException;
import com.ers.model.Employee;
import com.ers.service.EmployeeService;

@WebServlet("/EmployeeHomepage")
public class ManagerHomepage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// somehow send employee data to jsp page
		req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req,resp);
	}
}
