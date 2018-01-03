package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImpl;
import com.ers.model.Employee;

@WebServlet("/UpdateEmployeeInfo")
public class UpdateEmployeeInfo extends HttpServlet {
	
	private static final long serialVersionUID = 3267716068595868472L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the employee data
		Employee e1 = new Employee();
		e1.setEmail(req.getParameter("email"));
		e1.setAddress(req.getParameter("address"));
		e1.setCity(req.getParameter("city"));
		e1.setCountry(req.getParameter("country"));
		e1.setState(req.getParameter("state"));
		e1.setZip(req.getParameter("zip"));
		e1.setPhoneNumber(req.getParameter("phoneNumber"));
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		// update the employee in the database
		boolean success = edao.updateInfo(e1);
		if (success) {
			req.setAttribute("successMsg", "Your information was updated");
		}
		else {
			req.setAttribute("errMsg", "Sorry, there was an error. Your information was not updated");
		}
		req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req,resp);
	}
}