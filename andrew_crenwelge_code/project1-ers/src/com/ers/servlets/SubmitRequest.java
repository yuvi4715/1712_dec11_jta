package com.ers.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

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
	
	private static final long serialVersionUID = 6190336207607325032L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the employee
		Employee e1 = (Employee) req.getSession().getAttribute("employee");
		// get the request data
		Request r = new Request(); // make a new request
		// reqId will be set on db via sequence
		r.setEmpID(e1.getId()); // set empid to be the id of the current employee who is logged in
		r.setReqTitle(req.getParameter("title"));
		r.setStatus("Pending"); // all initial requests are pending
		r.setAmount(Double.parseDouble(req.getParameter("amount"))); // get amount from form submission
		r.setDateSubmitted(new Timestamp(System.currentTimeMillis())); // timestamp the request
		r.setDescription(req.getParameter("description")); // get the description from the form
		RequestDao rdao = RequestDaoImpl.getInstance();
		boolean success = rdao.initializeNewRequest(r);
		if (success) {
			req.setAttribute("successMsg", "Your request was submitted successfully");
		}
		else {
			req.setAttribute("errMsg", "An error occurred: The request was not submitted");
		}
		List<Request> list = rdao.getRequestsByEmployee(e1.getId());
		req.setAttribute("allRequests", list);
		req.getRequestDispatcher("EmployeeRequestView.jsp").forward(req,resp);
	}
}