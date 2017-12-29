package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImpl;
import com.ers.model.Employee;

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