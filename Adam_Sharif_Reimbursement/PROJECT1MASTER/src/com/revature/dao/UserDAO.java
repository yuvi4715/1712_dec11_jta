package com.revature.dao;

/*
 * Interface: UserDAO
 * Author: Kyle Settles
 * Description: Interface for use with DAO methods in order to easily transfer between databases
 * 		Implemented by UserDAOJdbc
 */

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	User getUserbyId(int id);
	
	List<User> retrieveAllUsers();
	
	int addUser(User u);

	User findByUsernameAndPassword(String username, String password);
}
