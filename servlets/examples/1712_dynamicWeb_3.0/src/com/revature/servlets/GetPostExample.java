package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/get1")
public class GetPostExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetPostExample() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println("this text is appearing from GetExample servlet");
		response.setContentType("text/html");
		String name = request.getParameter("fullnam");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body><h3> Hello, " + name + "! How are you? </h3></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("this text is appearing from Post Example servlet");
		response.setContentType("text/html");
		String name = request.getParameter("fullnam");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body><h3> Hello, " + name + "! How are you? </h3></body></html>");
				
		//super.doPost(request, response);
	}
}
