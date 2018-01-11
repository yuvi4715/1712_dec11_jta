package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("Grabbing username: " + user);
		System.out.println("Grabbing username: " + pass);
		EmployeeDaoJdbc instance = EmployeeDaoJdbc.getEmployeeDaoJdbc();
		boolean success = instance.authenticateEmployee(user, pass);
		if (success) {
			System.out.println("Successfully authenticated employee " + user);
			Employee loggedEmployee = instance.getEmployeeByUsername(user);
			request.getSession().setAttribute("loggedEmployee", loggedEmployee);
			System.out.println(loggedEmployee.getUsername() + " employee added to session attributes");
			System.out.println("Position: " + loggedEmployee.getPosition());
			if (loggedEmployee.getPosition().equals("employee")) {
				request.getRequestDispatcher("EmployeeHome.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("ManagerHome.jsp").forward(request, response);
			}
			
		}
		else {
			request.setAttribute("errorMessage", "Invalid username and/or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println("Failed to authenticate employee " + user);
		}
	}

}
