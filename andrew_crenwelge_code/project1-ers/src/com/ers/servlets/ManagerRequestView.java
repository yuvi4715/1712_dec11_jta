package com.ers.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImpl;
import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;

@WebServlet("/ManagerRequestView")
public class ManagerRequestView extends HttpServlet {
	
	private static final long serialVersionUID = -5394234461003030203L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// retrieve requests and add as attribute
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getAllRequests();
		List<Request> pendingList = rdao.getAllPendingRequests();
		List<Request> resolvedList = rdao.getAllResolvedRequests();
		// retrieve employees and maps for employee ids
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		List<Employee> elist = edao.getAllEmployees();
		Map<Integer, String> map = rdao.getRequestMgrMap();
		req.setAttribute("allRequests", list);
		req.setAttribute("pendingRequests", pendingList);
		req.setAttribute("resolvedRequests", resolvedList);
		req.setAttribute("mgrMap", map);
		req.setAttribute("allEmployees", elist);
		req.getRequestDispatcher("ManagerRequestView.jsp").forward(req,resp);
	}
}