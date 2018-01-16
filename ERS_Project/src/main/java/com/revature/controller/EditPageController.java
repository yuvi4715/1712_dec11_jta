package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class EditPageController {
	
	public static String edit(HttpServletRequest request) {
		
		System.out.println("IN EDIT PAGE CONTROLLER");
		return "EditProfile.jsp";
	}

}
