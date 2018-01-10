package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/irrelevantName","/name"})
public class PrintWriterExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrintWriterExample() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><body>");
		pw.println("<h2>Coming from Print Writer example</h2>");
		
		Enumeration<String> myHeaders =  request.getHeaderNames();
		while (myHeaders.hasMoreElements()) {
			String name = myHeaders.nextElement();
			pw.println( "<p>" + name + " : " + request.getHeader(name) + "</p>");
		}
		pw.println("</body></html>");
		
		pw.close();
	}
}
