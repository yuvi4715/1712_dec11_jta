package com.revature.reimbursement;

import com.revature.reimbursement.EmployeeDaoImpl;
import com.revature.reimbursement.User;
import com.revature.reimbursement.UserDao;
import com.revature.reimbursement.UserDaoImpl;

import java.util.List;

import com.revature.reimbursement.User;

public class UserService {

	//private instance of EmployeeService variable
	private static UserService userService;
	//singleton
	private UserService() {
		
	}
	
	
	//getting instance of EmployeeService
	public static UserService getInstance() {
		if(userService == null) {
			userService = new UserService();
		
	}
	return userService;	
	}

	
	
	
	public User Login(User user) {   //this receives the username and password gathered from index.jsp and passed to LoginController, set to new user object for use in lookup.
		User usr = UserDaoImpl.getInstance().getUser(user);   //place in usr for comparison to DB R_User creds
			
		
		if (usr.getPassword().equals(user.getPassword())) { //now compare to the one in the DB. note: this user object was instantiated with the two string overloaded method; only contains username and password.        
			return usr;
		}
	return new User();
	}
	
	
	
	
	
	
}
