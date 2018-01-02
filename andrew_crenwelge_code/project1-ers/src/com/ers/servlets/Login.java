package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
 
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get username, password
		String uname = req.getParameter("username");
		String pword = req.getParameter("userpass");
		// attempt to log user in
		// EmployeeService es = EmployeeService.getInstance();
		//boolean success = es.login(e1);
		//
		if (uname.equals("acrenwelge") && pword.equals("abc")) {
			// get user info and store in session
			Employee e1 = new Employee();
			// ResultsSet rs = es.getEmployeeByUsername(uname); 
			e1.setUsername(uname);
			e1.setFirstname("Andrew");
			e1.setLastname("Crenwelge");
			e1.setIsManager(true);
			// put rs -> e1 
			// String fullName = e1.getFirstname() + e1.getLastname();
			req.getSession().setAttribute("employee", e1);
			if (e1.getIsManager()) {
				req.getRequestDispatcher("ManagerHomepage.jsp").forward(req,resp);
			}
			else {
				req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req,resp);
			}
		}
		else {
			req.setAttribute("errMsg", "Incorrect username or password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}