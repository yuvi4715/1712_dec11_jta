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
import com.ers.model.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ManagerGetAllResolved")
public class ManagerGetAllResolved extends HttpServlet {
	
	private static final long serialVersionUID = -5394234461003030203L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {		
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getAllResolvedRequests();
		// return list as JSON
		resp.setContentType("application/json");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(list));
		System.out.println("Returning all resolved requests");
		for (Request r : list) {
			System.out.println(r);
		}
	}
}