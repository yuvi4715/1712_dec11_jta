package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class LogoutController {
	
	public static String logout(HttpServletRequest request) {
		
		System.out.println("IN LOGOUT CONTROLLER");
		request.getSession().invalidate();
		return "Login.jsp";
	}
}
