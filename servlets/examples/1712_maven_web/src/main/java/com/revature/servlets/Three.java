package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Three extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Three() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext sc1 = request.getServletContext();
		sc1.setAttribute("RunningBack", "Ezekial Elliott");
		
		RequestDispatcher r2 = request.getRequestDispatcher("ContextConfigExample");
		r2.include(request, response);
	}

}
