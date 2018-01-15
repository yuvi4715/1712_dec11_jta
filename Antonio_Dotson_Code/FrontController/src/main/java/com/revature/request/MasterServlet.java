package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.InsertNewController;

/* Servlet that maps every single request that the client makes */
public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = 1159764852861289598L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
		System.out.println(request.getServletPath());
		if ((request.getServletPath().equals(InsertNewController.updateEmpl(request)))) {
			response.sendRedirect("manager.jsp"); 	
	  }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
		
	  }
	}

