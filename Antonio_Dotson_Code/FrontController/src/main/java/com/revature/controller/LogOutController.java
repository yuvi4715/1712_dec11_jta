package com.revature.controller;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;  

public class LogOutController  {
	
	public static String logOut(HttpServletRequest request) {
	       
         HttpSession session=request.getSession();  
         session.invalidate();  
           
         String slogout = "You are successfully logged out!";  
         request.setAttribute("logout", slogout);
 		return "logout.jsp";
           
	}
}
