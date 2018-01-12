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
 * Servlet implementation class ViewAllPending
 */
public class ViewAllPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllPending() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("ManagerReimbursement.jsp").forward(request, response);
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//System.out.println("ViewAllPending Servlet Entered");
		
    	Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		ReimbursementDaoJdbc instance = ReimbursementDaoJdbc.getReimbursementDaoJdbc();
		
		List<Reimbursement> employeeReimbursementList = instance.selectPending();
		
		//System.out.println("employeeReimbursementList: ");
		for (Reimbursement r : employeeReimbursementList) {
			//System.out.println(r);
		}
		
		request.getSession().setAttribute("employeeReimbursement", employeeReimbursementList);
		
		//request.getRequestDispatcher("ManagerReimbursement.jsp").forward(request, response);
	
	}

}
