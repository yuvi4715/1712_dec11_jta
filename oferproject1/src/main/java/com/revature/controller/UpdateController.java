package com.revature.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.revature.model.User;
import com.revature.service.Service;

//@WebServlet("/UpdateServlet")
//public class UpdateController extends HttpServlet {
public class UpdateController{	
	private static final long serialVersionUID = 7645718332582216986L;

	public static String update(HttpServletRequest request) { 
		
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		
		//response.setContentType("text/html");
		
		int eid = Integer.parseInt((String)session.getAttribute("eid"));
		String firstname = request.getParameter("ufname");
		String lastname = request.getParameter("ulname");
		String username = request.getParameter("uuname");
		String email = request.getParameter("uemail");
		//int lflag = Integer.parseInt(request.getParameter("lflag"));
		int mflag = Integer.parseInt((String)session.getAttribute("mflag"));
		
		String password;
		String password1 = request.getParameter("opass1");
		String password2 = (String)session.getAttribute("password");
		String password3 = request.getParameter("upass1");
		String password4 = request.getParameter("upass2");
		
		String firstname2 = (String)session.getAttribute("firstname");
		String lastname2 = (String)session.getAttribute("lastname");
		String username2 = (String)session.getAttribute("username");
		String email2 = (String)session.getAttribute("email");
		
		boolean utilOutput;

		/*
		String destination="";
		if(mflag==0)
    		destination="Employee Homepage.jsp";
    	if(mflag==1)
    		destination="Manager Homepage.jsp";
		*/
		if(password1.equals(password2))
		{
			if(password3.length()<6 || password3.length()>32 || !(password3.equals(password4)))
				password=password2;
			else
				password=password4;
			
			if(firstname.isEmpty())
				firstname=firstname2;
			if(lastname.isEmpty())
				lastname=lastname2;
			if(email.isEmpty())
				email=email2;
			if(username.length()<4 || username.length()>20)
				username=username2;
			
			 utilOutput=Service.getInstance().newInfo(new User(eid,firstname, lastname, username, password, email));
			
			if (utilOutput==true) {
				request.getSession().setAttribute("firstname",firstname);
				request.getSession().setAttribute("lastname",lastname);
				request.getSession().setAttribute("email",email);
				request.getSession().setAttribute("username",username);
				request.getSession().setAttribute("password",password);
			}
			else
				request.setAttribute("utilOutput", "This username is already taken!");
			    
		}
		
		if(mflag==0)
    		return "Employee Homepage.jsp";
	    else if(mflag==1)
    		return "Manager Homepage.jsp";
    	else
    		return "Login.jsp";   
		
		//request.getRequestDispatcher(destination).forward(request, response);
		//pw.close();
	}

}
