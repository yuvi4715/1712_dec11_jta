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
 * Servlet implementation class ViewAllByEmployee
 */
public class ViewAllByEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllByEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		////System.out.println("ViewAllByEmployee Servlet Entered");
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		String searchID;
		/*
		 * if ((request.getParameter("searchInput")) == null) { searchID = "0"; } else {
		 * searchID = request.getParameter("searchInput"); }
		 */
		ReimbursementDaoJdbc instance = ReimbursementDaoJdbc.getReimbursementDaoJdbc();
		List<Reimbursement> employeeReimbursementList;
		if (loggedEmployee.getPosition().equals("employee")) {
			employeeReimbursementList = instance.getAllByEmployee(loggedEmployee.getEmployeeId());
		} else {
			////System.out.println("Manager ViewAllByEmployee. " + "Searching requests from employeeId: "
				//	+ Integer.parseInt(request.getParameter("searchInput")));
			employeeReimbursementList = instance
					.getAllByEmployee(Integer.parseInt(request.getParameter("searchInput")));
		}

		////System.out.println("employeeReimbursementList: ");
		for (Reimbursement r : employeeReimbursementList) {
			////System.out.println(r);
		}
		request.getSession().setAttribute("employeeReimbursement", employeeReimbursementList);

		// request.getRequestDispatcher("RequestReimbursement.jsp").forward(request,
		// response);

		// If manager is using this function, it means they're submitting a search
		// Employee will not need a page forward since what calls this is just a tab not
		// submit

		if (loggedEmployee.getPosition().equals("manager"))
			request.getRequestDispatcher("ManagerReimbursement.jsp").forward(request, response);
	}

}
