package com.ers.servlets;

import java.io.IOException;

import javax.servlet.HttpServlet;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.service.EmployeeService;

@WebServlet("/DenyRequest")
public class DenyRequest extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the request data somehow
		int reqId = 1;
		RequestDao rdao = RequestDaoImpl.getInstance();
		Request r = rdao.getRequestById(reqId);
		boolean success = rdao.denyRequest(r);
		if (success) {
			// celebrate!
		}
		else {
			// :(
		}
		req.getRequestDispatcher("ManagerRequestView.jsp").forward(req,resp);
	}
}