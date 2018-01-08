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
		System.out.println("The UpdateEmployeeInfo servlet is running...");
		// get the employee data
		Employee oldempobj = (Employee) req.getSession().getAttribute("employee");
		Employee newempobj = new Employee();
		// set new employee with old employee info
		newempobj.setId(oldempobj.getId());
		newempobj.setFirstname(oldempobj.getFirstname());
		newempobj.setLastname(oldempobj.getLastname());
		newempobj.setIsManager(oldempobj.getIsManager());
		newempobj.setBirthdate(oldempobj.getBirthdate());
		// set other fields from submission form
		newempobj.setEmail(req.getParameter("email"));
		newempobj.setAddress(req.getParameter("address"));
		newempobj.setCity(req.getParameter("city"));
		newempobj.setCountry(req.getParameter("country"));
		newempobj.setState(req.getParameter("state"));
		newempobj.setZip(req.getParameter("zip"));
		newempobj.setPhoneNumber(req.getParameter("phoneNumber"));
		System.out.println("Employee info to update: " + newempobj);
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		// update the employee in the database
		boolean success = edao.updateInfo(newempobj);
		if (success) {
			req.setAttribute("successMsg", "Your information was updated successfully");
			req.getSession().setAttribute("employee", newempobj);
		}
		else {
			req.setAttribute("errMsg", "Sorry, there was an error. Your information was not updated");
		}
		if (oldempobj.getIsManager()) {
			req.getRequestDispatcher("ManagerHomepage.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req, resp);
		}
	}
}