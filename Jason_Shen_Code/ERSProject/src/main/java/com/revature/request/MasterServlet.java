package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/* Servlet that maps every single request that the client makes */
public class MasterServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6307623822537394288L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String processedRequest = RequestDispatcher.process(request);

		if (processedRequest.equals("user/login.jsp")) {
			response.sendRedirect(processedRequest);
		}
		else {
			request.getRequestDispatcher(processedRequest).forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String processedRequest = RequestDispatcher.process(request);
		
		// This is actually so huge, because you can always just redirect users to login to create a new session.
		// Since it's a sendRedirect, you the current session no longer gets forwarded and a new session is created.
		// Thus our "Logout" is technically just sending them to login.
		if (processedRequest.equals("user/login.jsp")) {
			response.sendRedirect(processedRequest);
		}
		
		else {
			request.getRequestDispatcher(processedRequest).forward(request, response);
		}
		
		
	}
}
