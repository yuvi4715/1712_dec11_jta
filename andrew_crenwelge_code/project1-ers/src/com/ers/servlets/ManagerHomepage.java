package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManagerHomepage")
public class ManagerHomepage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// somehow send employee data to jsp page
		req.getRequestDispatcher("EmployeeHomepage.jsp").forward(req,resp);
	}
}
