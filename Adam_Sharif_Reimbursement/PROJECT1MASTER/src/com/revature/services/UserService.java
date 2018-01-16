package com.revature.services;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDaoJDBC;

public class UserService {

	private UserDAO ud = new UserDaoJDBC();
	
	// logs a user into the system
	public User login(User u) {
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	// registers a new user into the system
	public int register(User u) {
		return ud.addUser(u);
	}
}