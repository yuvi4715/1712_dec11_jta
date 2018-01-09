package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Two
 */
public class Two extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Two() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>"
				+ "<p> value for name: "+  request.getParameter("fullname") + "</p>"
				+ "</body></html>");
		
		//response.sendRedirect("welcome.html");
		
//		ServletConfig sc2 = getServletConfig();
//		String str2 = sc2.getInitParameter("WideReceiver");
//		
//		pw.println("<p> Current week best wide receiver is : "+  str2 + "</p>"
//				+ "</body></html>");
		
		RequestDispatcher r = request.getRequestDispatcher("default.html");
		//r.forward(request, response);
		r.include(request, response);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
