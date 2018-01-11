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
		System.out.println("UpdateInfo doPost entered");
		// get the employee data
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		Employee updated = new Employee();
		
		updated.setId(loggedEmployee.getId());
		System.out.println("getID: " + loggedEmployee.getId());
		updated.setUsername(loggedEmployee.getUsername());
		System.out.println("getUsername: " + loggedEmployee.getUsername());
		
		if (!(request.getParameter("password").equals("Enter new info")))
			updated.setPassword(request.getParameter("password"));
		if (!(request.getParameter("firstName").equals("Enter new info")))
			updated.setFirstName(request.getParameter("firstName"));
		if (!(request.getParameter("lastName").equals("Enter new info")))
			updated.setLastName(request.getParameter("lastName"));
		if (!(request.getParameter("email").equals("Enter new info")))
			updated.setEmail(request.getParameter("email"));
		
		updated.setPosition(loggedEmployee.getPosition());
		
		System.out.println("Employee info to update: " + updated);
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
