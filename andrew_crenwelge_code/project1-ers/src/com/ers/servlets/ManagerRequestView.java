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

@WebServlet("/ManagerRequestView")
public class ManagerRequestView extends HttpServlet {
	
	private static final long serialVersionUID = -5394234461003030203L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {		
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getAllRequests();
		// add list as attribute
		req.setAttribute("allRequests", list);
		req.getRequestDispatcher("ManagerRequestView.jsp").forward(req,resp);
	}
}