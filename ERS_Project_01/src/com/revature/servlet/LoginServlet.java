package com.revature.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.connection.ConnectionFactory;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.LoginDAO;
import com.revature.utils.ConstantStrings;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String connectionUser = new ConstantStrings().getConnectionUser();
	String connectionPass = new ConstantStrings().getConnectionPass();

	String loginPage = new ConstantStrings().getLoginPage();
	String registerPage = new ConstantStrings().getRegisterPage();
	String managerPage = new ConstantStrings().getManagerPage();
	String employeePage = new ConstantStrings().getEmployeePage();
	
	String nextPage;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("emp_User").toLowerCase();
		String password = request.getParameter("emp_Pass");
		
		Connection con = null;

		// check if the username and password match an employee in the system
		try {
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
			
			Employee emp = new Employee(username, password);
			
			LoginDAO ld = new LoginDAO();
			
			if(ld.checkUsername(emp, con)) {
				con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
				
				if(ld.checkPassword(emp, con)) {	
					con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
					
					String user = emp.getUsername();
					request.getSession().setAttribute("employeeUsername", user);
					String pass = emp.getPassword();
					request.getSession().setAttribute("employeePassword", pass);
					
					EmployeeDAO ed = new EmployeeDAO();
					
					int empID = ed.getEmpID(user, con);
					request.getSession().setAttribute("employeeID", empID);
					String fname = ed.getEmployeeFirstName(user, con);
					request.getSession().setAttribute("employeeFirstName", fname);
					String lname = ed.getEmployeeLastName(user, con);
					request.getSession().setAttribute("employeeLastName", lname);
					String email = ed.getEmployeeEmail(user, con);
					request.getSession().setAttribute("employeeEmail", email);
					String role = ed.getEmployeeRole(user, con);
					request.getSession().setAttribute("employeeRole", role);
					String title = ed.getEmployeeTitle(user, con);
					request.getSession().setAttribute("employeeTitle", title);					
					int reportsTo = ed.getEmployeeReportsTo(user, con);
					request.getSession().setAttribute("employeeReportsTo", reportsTo);
					
					ld.login(user, con);
					
					if(ld.checkTitle(user, con)) {
												
						// Login Success - Manager Homepage - log4j	
						RequestDispatcher rd = request.getRequestDispatcher(managerPage);
						rd.forward(request, response);
					} else {
						
						// Login Success - Employee Homepage - log4j
						RequestDispatcher rd = request.getRequestDispatcher(employeePage);
						rd.forward(request, response);
					}
				} else {

					// Login Fail - Wrong Password
					request.setAttribute("typeMessage", "alert alert-danger");
					request.setAttribute("message", "Login Failed! Invalid Password. Try Again.");
					request.getRequestDispatcher(loginPage).forward(request, response);
				}
			} else {
				
				// Login Fail - Wrong Username
				request.setAttribute("typeMessage", "alert alert-danger");
				request.setAttribute("message", "Login Failed! Invalid Username. Try Again.");
				request.getRequestDispatcher(loginPage).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
