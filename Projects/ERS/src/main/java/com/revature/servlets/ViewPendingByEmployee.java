package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

/**
 * Servlet implementation class ViewPendingByEmployee
 */
public class ViewPendingByEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPendingByEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		ReimbursementDaoJdbc instance = ReimbursementDaoJdbc.getReimbursementDaoJdbc();
		
		List<Reimbursement> employeeReimbursementList = instance.getPendingByEmployee(loggedEmployee.getId());
		
		request.getSession().setAttribute("employeeReimbursement", employeeReimbursementList);
		
		//request.getRequestDispatcher("RequestReimbursement.jsp").forward(request, response);
	
	}
}
