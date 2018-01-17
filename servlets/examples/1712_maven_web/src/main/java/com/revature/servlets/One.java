package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class One extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public One() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		//resp.getWriter().append("print something:").append(req.getMethod());
		resp.getWriter().println(":coming from one.java:");
		
		RequestDispatcher rd = req.getRequestDispatcher("Two");
		//rd.forward(req, resp);
		rd.include(req, resp);
		//resp.sendRedirect("welcome.html");
		//resp.sendRedirect("Two");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
