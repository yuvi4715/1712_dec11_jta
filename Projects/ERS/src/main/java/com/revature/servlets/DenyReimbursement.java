package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDaoJdbc;
import com.revature.model.Employee;

/**
 * Servlet implementation class DenyReimbursement
 */
public class DenyReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Deny doPost entered");
		//get the manager data
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		int RID = Integer.parseInt(request.getParameter("RID"));
		
		//System.out.println("Reimbursement to approve: " + RID + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		ReimbursementDaoJdbc instance = ReimbursementDaoJdbc.getReimbursementDaoJdbc();
		
		// update the employee in the database
		boolean success = instance.deny(RID, loggedEmployee);
		if (success) {
			request.setAttribute("successMessage", "Request denied");
		}
		else {
			request.setAttribute("errorMessage", "Error - Request was not denied");
		}
	}

}
