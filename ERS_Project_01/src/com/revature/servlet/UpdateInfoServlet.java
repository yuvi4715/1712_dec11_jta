package com.revature.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.connection.ConnectionFactory;
import com.revature.dao.EmployeeDAO;
import com.revature.utils.ConstantStrings;

@WebServlet("/UpdateInfo")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String connectionUser = new ConstantStrings().getConnectionUser();
	String connectionPass = new ConstantStrings().getConnectionPass();
	
	String updatePage = new ConstantStrings().getUpdateInfoPage();
	
    public UpdateInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String prevPage = (String) request.getSession().getAttribute("previousPage");
		System.out.println(prevPage);
		request.getRequestDispatcher(prevPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);

		Connection con = null;
		
		String prevPage = (String) request.getSession().getAttribute("previousPage");
		
		int empID = (int) request.getSession().getAttribute("employeeID");
		String fname = (String)request.getSession().getAttribute("employeeFirstName");
		String lname = (String)request.getSession().getAttribute("employeeLastName");
		
		String email = request.getParameter("emp_email");
		String username = request.getParameter("emp_username");
		String password = request.getParameter("emp_password");
		String confirmedPassword = request.getParameter("emp_confirmedPassword");
		String role = request.getParameter("emp_role");
		String reportsTo = request.getParameter("emp_reportsTo");
		
		if(password.equals(confirmedPassword)) {
			
			try {
				con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
				
				// set new attributes
				request.getSession().setAttribute("employeeEmail", email);
				request.getSession().setAttribute("employeeUsername", username);
				request.getSession().setAttribute("employeePassword", confirmedPassword);
				request.getSession().setAttribute("employeeRole", role);
				request.getSession().setAttribute("employeeReportsTo", Integer.parseInt(reportsTo));
				
				String newEmail = (String) request.getSession().getAttribute("employeeEmail");
				String newUser = (String) request.getSession().getAttribute("employeeUsername");
				String newPass = (String) request.getSession().getAttribute("employeePassword");
				String newRole = (String) request.getSession().getAttribute("employeeRole");
				int newReportsTo = (int) request.getSession().getAttribute("employeeReportsTo");
				
				System.out.println(newEmail);
				System.out.println(newUser);
				System.out.println(newPass);
				System.out.println(newRole);
				System.out.println(newReportsTo);
				
				Employee emp = new Employee(empID, newEmail, newUser, newPass, newRole, newReportsTo);
				EmployeeDAO ed = new EmployeeDAO();
				
				ed.updateUser(emp, con);

				// Success Message
				request.setAttribute("typeMessage", "alert alert-success");
				request.setAttribute("message", "Successfully Changed Your Information");
				request.getRequestDispatcher(updatePage).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();

				// Fail Message
				request.setAttribute("typeMessage", "alert alert-danger");
				request.setAttribute("message", "Server Could Not Update Your Information. Try Again.");
				request.getRequestDispatcher(updatePage).forward(request, response);
			}
		} else {

			// Fail Message
			request.setAttribute("typeMessage", "alert alert-danger");
			request.setAttribute("message", "Passwords Don't Match! Try Again.");
			request.getRequestDispatcher(updatePage).forward(request, response);
		}
	}

}
