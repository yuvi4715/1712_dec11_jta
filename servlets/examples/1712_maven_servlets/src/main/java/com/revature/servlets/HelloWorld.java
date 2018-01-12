package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
    }

//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init");
//	}
//
//	public void destroy() {
//		System.out.println("destroy");
//	}
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet");
		String user = request.getParameter("username");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html> <body> <p> Happy new year, " + user + "</p></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String user = request.getParameter("anotheruser");
		pw.println("<html> <body> <p> Happy new year, " + user + " from post method</p></body></html>");
	}

}
