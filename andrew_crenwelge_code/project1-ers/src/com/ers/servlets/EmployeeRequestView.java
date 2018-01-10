package com.ers.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;

@WebServlet("/EmployeeRequestView")
public class EmployeeRequestView extends HttpServlet {
	
	private static final long serialVersionUID = 3928559648235553534L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get Employee ID and retrieve list of request for that employee
		Employee e1 = (Employee) req.getSession().getAttribute("employee");
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getRequestsByEmployee(e1.getId());
		Map<Integer, String> map = rdao.getRequestMgrMap();
		req.setAttribute("allRequests", list);
		req.setAttribute("mgrMap", map);
		req.getRequestDispatcher("EmployeeRequestView.jsp").forward(req,resp);
	}
}