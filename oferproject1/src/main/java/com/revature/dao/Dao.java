package com.revature.dao;

import java.util.List;

import com.revature.model.Request;
import com.revature.model.User;

public interface Dao {
	
	public boolean insertProcedure(User user); //Insert user
	public User select(User user);				//Login
	public boolean deselect(User user);			//Logout
	public boolean update(User user);			//Update personal information
	public List<User> selectAll();				//View all users
	public boolean submit(Request request);		//Submit Request
	
	public List<Request> viewRequests(Request request);	//View requests
	public boolean closeRequest(Request request);	//Close request
	
}
