package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.EmployeeDaoImpl;
import com.ers.model.Employee;
import com.ers.model.User;
 
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = -5134367054314716454L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get username, password
		String uname = req.getParameter("username");
		String pword = req.getParameter("userpass");
		// attempt to log user in
		EmployeeDaoImpl edao = EmployeeDaoImpl.getInstance();
		boolean success = edao.authenticate(uname, pword);
		// boolean success = ((uname.equals("acrenwelge") && pword.equals("abc")) || (uname.equals("admin") && pword.equals("password")));
		if (success) {
			System.out.println("Successfully authenticated user " + uname);
			// get user info and store in session
			Employee e1 = edao.getEmployeeByUsername(uname);
			User u1 = new User();
			u1.setUsername(uname);
			req.getSession().setAttribute("employee", e1);
			req.getSession().setAttribute("user", u1);
			// System.out.println("Employee info: "+e1);
			// System.out.println("User info: "+u1);
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