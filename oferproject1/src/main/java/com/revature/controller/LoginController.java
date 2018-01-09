package com.revature.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.revature.model.User;
import com.revature.service.Service;
import java.util.StringTokenizer;

//@WebServlet("/LoginServlet")
//public class LoginController extends HttpServlet {
public class LoginController {
	
	public static String login(HttpServletRequest request) { 
	

//	protected void doPost(HttpServletRequest request,
 //           HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String manager;
       // StringBuffer utilOutput = new StringBuffer("");
        StringBuilder utilOutput = new StringBuilder("");
        String destination="";
        
    
    utilOutput.append(Service.getInstance().login(new User(username,password)));
        
	    //When the input is incorrect, user will return an error message.
	    //All of the error messages returned by user begin with a letter.
	    if(Character.isLetter(utilOutput.charAt(0)))
	    {
	    	request.setAttribute("utilOutput", utilOutput.toString());
	    	//request.getRequestDispatcher("Login.jsp").forward(request, response);
	    	return "Login.jsp";
	
	    }
	    //When username/password are correct, the user class...
	    //will always return a string beginning with the employee ID.
	    //however if for some reason there is a login failure, ID will be 0
	    else //if(utilOutput.charAt(0)!=0)
	    {
	    	//System.out.println(utilOutput.toString());
	    	//Before tokenizing, utilOutput looks like "ID:firstname:lastname:username:email ....etc"
	    	StringTokenizer tokens = new StringTokenizer(utilOutput.toString(), ":");
	    	request.getSession().setAttribute("eid", tokens.nextToken());
	    	request.getSession().setAttribute("firstname", tokens.nextToken());
	    	request.getSession().setAttribute("lastname", tokens.nextToken());
	    	request.getSession().setAttribute("username", tokens.nextToken());
	    	request.getSession().setAttribute("email", tokens.nextToken());
	    	manager=tokens.nextToken();
	    	request.getSession().setAttribute("mflag",manager);
	    	request.getSession().setAttribute("lflag", tokens.nextToken());
	    	request.getSession().setAttribute("password", password); 
	    	
	        	
	    	if(manager.equals("0"))
	    		return "Employee Homepage.jsp";
	    		//destination="Employee Homepage.jsp";
		    else if(manager.equals("1"))
	    		return "Manager Homepage.jsp";
	    		//destination="Manager Homepage.jsp";
	    	else
	    		return "Login.jsp";     
	          
	    	
	    // request.getRequestDispatcher(destination).forward(request, response);
	
	    }
	    
    }
 
}