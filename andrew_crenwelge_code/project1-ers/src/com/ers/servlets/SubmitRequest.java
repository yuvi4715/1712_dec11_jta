package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;

@WebServlet("/SubmitRequest")
public class SubmitRequest extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the employee somehow
		Employee e1 = new Employee();
		// get the request data
		Request r = new Request();
		RequestDao rdao = RequestDaoImpl.getInstance();
		boolean success = rdao.initializeNewRequest(r);
		if (success) {
			// celebrate!
		}
		else {
			// :(
		}
		req.getRequestDispatcher("EmployeeRequestView.jsp").forward(req,resp);
	}
}