package com.ers.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

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
		// get the employee
		Employee e1 = (Employee) req.getSession().getAttribute("employee");
		// get the request data
		Request r = new Request();
		// reqId will be set on db via sequence
		r.setEmpID(e1.getId());
		r.setApproved(false);
		r.setAmount(Double.parseDouble(req.getParameter("amount")));
		// r.setDateSubmitted() ??? Timestamp?
		r.setDescription(req.getParameter("description"));
		RequestDao rdao = RequestDaoImpl.getInstance();
		boolean success = rdao.initializeNewRequest(r);
		if (success) {
			req.setAttribute("successMsg", "The request was submitted successfully!");
		}
		else {
			req.setAttribute("errMsg", "An error occurred: The request was not submitted");
		}
		req.getRequestDispatcher("EmployeeRequestView.jsp").forward(req,resp);
	}
}