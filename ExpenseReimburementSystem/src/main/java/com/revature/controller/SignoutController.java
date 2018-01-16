package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignoutController {

	public static String signout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
			if (session != null) {
				request.getSession().invalidate();
				return "Login.html";
			}
			return "";
	}
}