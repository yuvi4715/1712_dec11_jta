package com.ers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/EmployeeGetPending")
public class EmployeeGetPending extends HttpServlet {
	
	private static final long serialVersionUID = 3928559648235553534L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get Employee ID and retrieve list of pending requests for that employee
		Employee e1 = (Employee) req.getSession().getAttribute("employee");
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getPendingRequestsByEmployee(e1.getId());
		if (!(list == null)) {
			// return the list as JSON
			resp.setContentType("application/JSON");
			resp.getWriter().write(new ObjectMapper().writeValueAsString(list));
			System.out.println("Returning pending requests for employee " +e1.getId() + ":");
			for (Request r : list) {
				System.out.println(r);
			}
		}
		else {
			resp.setContentType("text/html");
			resp.getWriter().write("Something went wrong, could not get the requests");
		}
	}
}