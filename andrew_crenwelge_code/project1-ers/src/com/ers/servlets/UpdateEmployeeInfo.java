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
		Employee oldempobj = (Employee) req.getSession().getAttribute("employee");
		Employee newempobj = new Employee();
		newempobj.setId(oldempobj.getId());
		// set new employee with old employee info
		newempobj.setFirstname(oldempobj.getFirstname());
		newempobj.setLastname(oldempobj.getFirstname());
		newempobj.setIsManager(oldempobj.getIsManager());
		// set other fields from submission form
		newempobj.setEmail(req.getParameter("email"));
		newempobj.setAddress(req.getParameter("address"));
		newempobj.setCity(req.getParameter("city"));
		newempobj.setCountry(req.getParameter("country"));
		newempobj.setState(req.getParameter("state"));
		newempobj.setZip(req.getParameter("zip"));
		newempobj.setPhoneNumber(req.getParameter("phoneNumber"));
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		// update the employee in the database
		boolean success = edao.updateInfo(newempobj);
		if (success) {
			req.setAttribute("successMsg", "Your information was updated");
		}
		else {
			req.setAttribute("errMsg", "Sorry, there was an error. Your information was not updated");
		}
		resp.setContentType("text/JSON");
		req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req,resp);
	}
}