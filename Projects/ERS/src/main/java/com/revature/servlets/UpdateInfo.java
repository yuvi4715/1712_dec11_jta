package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;

/**
 * Servlet implementation class UpdateInfo
 */
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("UpdateInfo doPost entered");
		// get the employee data
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		Employee updated = new Employee();
		
		updated.setEmployeeId(loggedEmployee.getEmployeeId());
		//System.out.println("getID: " + loggedEmployee.getEmployeeId());
		updated.setUsername(loggedEmployee.getUsername());
		//System.out.println("getUsername: " + loggedEmployee.getUsername());
		
		updated.setPassword(loggedEmployee.getPassword());
		updated.setFirstName(loggedEmployee.getFirstName());
		updated.setLastName(loggedEmployee.getLastName());
		updated.setEmail(loggedEmployee.getEmail());
		
		if (!(request.getParameter("password").equals("")))
			updated.setPassword(request.getParameter(""));
		if (!(request.getParameter("firstName").equals("")))
			updated.setFirstName(request.getParameter(""));
		if (!(request.getParameter("lastName").equals("")))
			updated.setLastName(request.getParameter(""));
		if (!(request.getParameter("email").equals("")))
			updated.setEmail(request.getParameter(""));
		
		updated.setPosition(loggedEmployee.getPosition());
		
		//System.out.println("Employee info to update: " + updated);
		EmployeeDaoJdbc instance = EmployeeDaoJdbc.getEmployeeDaoJdbc();
		// update the employee in the database
		boolean success = instance.updateInfo(updated);
		if (success) {
			request.setAttribute("successMessage", "Profile updated");
			request.getSession().setAttribute("loggedEmployee", updated);
		}
		else {
			request.setAttribute("errorMessage", "Error - Profile was not updated");
		}
		if (loggedEmployee.getPosition().equals("employee")) {
			request.getRequestDispatcher("EmployeeHome.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("ManagerHome.jsp").forward(request, response);
		}
		
	}

}
