package com.revature.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.connection.ConnectionFactory;
import com.revature.dao.EmployeeDAO;
import com.revature.utils.ConstantStrings;

// The Servlet path must be configured. Either by the web.xml OR the annotation

@WebServlet("/Employee")
@SuppressWarnings("serial")
public class NewEmployeeServlet extends HttpServlet {

	String connectionUser = new ConstantStrings().getConnectionUser();
	String connectionPass = new ConstantStrings().getConnectionPass();
	
	String loginPage = new ConstantStrings().getLoginPage();
	String registerPage = new ConstantStrings().getRegisterPage();
	String listPage = new ConstantStrings().getListPage();
	
	// doPost - to register an employee
	// page where the list is, is register.jsp
	// doPost comes from the form on the page
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// The field IDs in the form on the HTML page
		String fname = req.getParameter("emp_fName");
		String lname = req.getParameter("emp_lName");
		String email = req.getParameter("emp_email");
		String role = req.getParameter("emp_role");
		String title = req.getParameter("emp_title");
		String reportsTo = req.getParameter("emp_reportsTo");
		
		String usern = req.getParameter("emp_username");
		String passw = req.getParameter("emp_password");
		
		// Employee object to the register
		Employee emp = new Employee(fname, lname, email, usern, passw, role, title, Integer.parseInt(reportsTo));
		
		Connection con = null;
		
		try {
			// call the BO to validate the business rule and perform operation on the bank
			//EmployeeBO.registerEmployee(emp, con);
			
			EmployeeDAO ed = new EmployeeDAO();
			
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
			ed.addEmployee(emp, con);
			
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
			ed.createUser(emp, con);
			
			// Success Message
			req.setAttribute("typeMessage", "alert alert-success");
			req.setAttribute("message", "Successfully Registered: " + emp.getUsername());
		} catch (Exception e) {
			
			// Fail Message
			req.setAttribute("typeMessage", "alert alert-danger");
			req.setAttribute("message", "Failed To Register Employee");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		// do the registration, or else we cannot send to the HTML page
		//req.getRequestDispatcher(registerPage).forward(req, resp);
		req.getRequestDispatcher(registerPage).include(req, resp);
	}
	
	// doGet - to list
	// page where the list is, is list.jsp
	// doGet grabs the list from the URL
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employee> empList = null;
		
		Connection con = null;
		
		try {
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
			
			// recover the list bank
			empList = new EmployeeDAO().elist(con);
			
			// send the list with attributes to the HTML
			req.setAttribute("empList", empList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher(listPage).forward(req, resp);
		}
	}
}
