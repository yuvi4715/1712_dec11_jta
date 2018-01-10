package com.ers.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.model.RequestAjaxObj;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/EmployeeGetResolved")
public class EmployeeGetResolved extends HttpServlet {
	
	private static final long serialVersionUID = 3928559648235553534L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get Employee ID and retrieve list of pending requests for that employee
		Employee e1 = (Employee) req.getSession().getAttribute("employee");
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getResolvedRequestsByEmployee(e1.getId());
		// get the map of employee/manager id's to full names
		Map<Integer,String> mgrMap = rdao.getRequestMgrMap();
		// create the object that will be returned as JSON
		RequestAjaxObj rajo = new RequestAjaxObj();
		// add the request and the map
		rajo.setRequestobj(list);
		rajo.setMap(mgrMap);
		// return the list as JSON
		resp.setContentType("application/json");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(rajo));
		System.out.println("Returning resolved requests for employee " +e1.getId() + ":");
		for (Request r : list) {
			System.out.println(r);
		}
	}
}