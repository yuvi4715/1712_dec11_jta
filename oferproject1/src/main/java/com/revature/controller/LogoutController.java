package com.revature.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.revature.model.User;
import com.revature.service.Service;

@WebServlet("/LogoutServlet")
public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = -5898386144630257805L;
	
	public static String logout(HttpServletRequest request) {
		
	    HttpSession session = ((HttpServletRequest)request).getSession(false);
		
		String username = (String) session.getAttribute("username");
	        
		Service.getInstance().logout(new User(username));
		
		session.invalidate();
		
		return "Login.jsp";
		//response.sendRedirect("Login.jsp");
		// request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
