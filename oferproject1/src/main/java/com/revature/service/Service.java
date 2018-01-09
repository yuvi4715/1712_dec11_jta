package com.revature.service;

import java.awt.*;
import java.applet.*;
import javax.swing.JApplet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



import java.util.List;

import com.revature.dao.DaoImplement;
import com.revature.model.Request;
import com.revature.model.User;

public class Service extends HttpServlet{

	private static final long serialVersionUID = -4708140489406577803L;
	//private instance of Service variable
	private static Service Service;
	//applying singleton singleton pattern
	private Service() {
	}

	//to access the instance of the Service
	public static Service getInstance() {
		if (Service == null) {
			Service = new Service();
		}
		return Service;
	}

	
	//calls the insert method which will call the stored procedure named "insert_employee"
	public boolean registerUser(User user) {
		return DaoImplement.getInstance().insertProcedure(user);
	}
	
	//service to call selectAll method in DAO
	public List<User> listAllUsers(){
		return DaoImplement.getInstance().selectAll();
	}
	
	//logout service
	public boolean logout(User user) {
		return DaoImplement.getInstance().deselect(user);
	}
	
	//login service
	public User login(User user) {
		return (DaoImplement.getInstance().select(user));
	}
	
	//update service
	public boolean newInfo(User user) {
		return (DaoImplement.getInstance().update(user));
	}
	
	//submit request service
		public boolean submit(Request request) {
			return (DaoImplement.getInstance().submit(request));
		}
		
		//View all personal pending requests
		public List<Request> viewRequests(Request request){
			return DaoImplement.getInstance().viewRequests(request);
		}
		
		//close request service
				public boolean closeRequest(Request request) {
					return (DaoImplement.getInstance().closeRequest(request));
				}
}
