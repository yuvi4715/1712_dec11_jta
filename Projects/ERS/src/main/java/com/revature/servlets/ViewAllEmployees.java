package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.dao.ReimbursementDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

/**
 * Servlet implementation class ViewAllEmployees
 */
public class ViewAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	////System.out.println("ViewAllEmployees Servlet Entered");
		
    	Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
    	EmployeeDaoJdbc instance = EmployeeDaoJdbc.getEmployeeDaoJdbc();
		
		List<Employee> employeeList = instance.selectAll();
		
		////System.out.println("employeeList: ");
		for (Employee e : employeeList) {
			////System.out.println(e);
		}
		
		request.getSession().setAttribute("employeeList", employeeList);
		
		request.getRequestDispatcher("ViewEmployee.jsp").forward(request, response);
	
	}

}
