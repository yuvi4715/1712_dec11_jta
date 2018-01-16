package com.revature.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserController { 
	// UserController class will handle the GET and POST requests sent from the dispatcher servlet.
	// Will handle all the functionality for the user in the web application.
	
	private UserService us = new UserService();
	
	// handles all GET requests from the servlet
	public void processGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(actualURL) {
		case "/users/logout":
			logout(request,response);
			break;
		}
	}

	// handles all post requests 
	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(actualURL) {
		case "/users/login":
			login(request,response);
			break;
		case "/users/register":
			register(request,response);
			break;
		}
	}

	// registers a user with the database
	private void register(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();			
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(json, User.class);		
			int newUser = us.register(u);
			u.setId(newUser);
			
			// If user is not added to database, send 401 code
			if(newUser == 0) {
				response.setStatus(401);
			}
			
			// Will set the SessionID to the UserId to keep track of the session
			else {
				request.getSession().setAttribute("user", newUser);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// used to handle the logic for logging into the system, checks database to make sure user exists
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc +curr).get();
			ObjectMapper om = new ObjectMapper();
			User u = om.readValue(json, User.class);
			User actualUser = us.login(u);
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			String jsonUser = ow.writeValueAsString(actualUser);
			
			// if user is not in the database, send a 401 code
			if(actualUser == null) {
				response.setStatus(401);
			}
			
			
			// sets a response header with the user to make check which role they are
			else {
				request.getSession().setAttribute("user", actualUser.getId());
				response.setHeader("user", jsonUser);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Logs the user out of the current session
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", null);
	}
}
