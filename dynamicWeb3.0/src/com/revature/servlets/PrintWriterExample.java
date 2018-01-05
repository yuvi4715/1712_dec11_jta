package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/name")
public class PrintWriterExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PrintWriterExample() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		// p.append("Served at: ").append(request.getContextPath());
		//response.setContentType("text/html");
		p.println("Hello, world!");
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			p.println(headers.nextElement());
		}
	}

}
