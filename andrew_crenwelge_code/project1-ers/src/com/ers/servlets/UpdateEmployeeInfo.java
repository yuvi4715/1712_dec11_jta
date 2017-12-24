package com.ers.servlets;

import java.io.IOException;

import javax.servlet.HttpServlet;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.service.EmployeeService;

@WebServlet("/UpdateEmployeeInfo")
public class UpdateEmployeeInfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the employee somehow
		Employee e1 = new Employee();
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		// update the employee in the database
		boolean success = edao.updateInfo(e1);
		if (success) {
			// celebrate!
		}
		else {
			// :(
		}
		req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req,resp);
	}
}