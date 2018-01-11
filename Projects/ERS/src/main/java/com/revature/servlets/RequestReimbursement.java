package com.revature.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

/**
 * Servlet implementation class ReimbursementReimbursement
 */
public class RequestReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletReimbursement request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// get the employee
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		// get the request data
		Reimbursement reimbursement = new Reimbursement(); // make a new request
		// reqId will be set on db via sequence
		reimbursement.setEmployeeId(loggedEmployee.getId()); // set empid to be the id of the current employee who is
																// logged in
		reimbursement.setStatus("pending"); // all initial requests are pending
		reimbursement.setTitle(request.getParameter("title"));
		reimbursement.setAmount(Double.parseDouble(request.getParameter("amount"))); // get amount from form submission
		reimbursement.setStartDate(new Timestamp(System.currentTimeMillis())); // timestamp the request
		reimbursement.setDescription(request.getParameter("description")); // get the description from the form
		ReimbursementDaoJdbc instance = ReimbursementDaoJdbc.getReimbursementDaoJdbc();
		boolean success = instance.insertProcedure(reimbursement);
		if (success) {
			request.setAttribute("successMessage", "Your request was submitted successfully");
		} else {
			request.setAttribute("errorMessage", "An error occurred: The request was not submitted");
		}
		List<Reimbursement> employeeReimbursementList = instance.getAllByEmployee(loggedEmployee.getId());
		request.getSession().setAttribute("employeeReimbursement", employeeReimbursementList);
		request.getRequestDispatcher("RequestReimbursement.jsp").forward(request, response);
	}
}
