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
 * Servlet implementation class ViewResolvedByEmployee
 */
public class ViewResolvedByEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResolvedByEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//System.out.println("ViewPendingByEmployee Servlet Entered");
		
    	Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		ReimbursementDaoJdbc instance = ReimbursementDaoJdbc.getReimbursementDaoJdbc();
		
		List<Reimbursement> employeeReimbursementList = instance.getResolvedByEmployee(loggedEmployee.getEmployeeId());
		
		//System.out.println("employeeReimbursementList: ");
		for (Reimbursement r : employeeReimbursementList) {
			//System.out.println(r);
		}
		
		request.getSession().setAttribute("employeeReimbursement", employeeReimbursementList);
		
		//request.getRequestDispatcher("RequestReimbursement.jsp").forward(request, response);
	
	}
}
