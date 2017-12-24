package com.ers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.HttpServlet;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Request;

@WebServlet("/EmployeeViewRequests")
public class EmployeeViewRequests extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get Employee ID somehow
		int empID = 1;
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getRequestsByEmployee(empID);
		// add list as a parameter
		req.getRequestDispatcher("EmployeeRequestView.jsp").forward(req,resp);
	}
}