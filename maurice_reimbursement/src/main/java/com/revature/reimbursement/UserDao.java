package com.revature.reimbursement;

import java.util.List;

public interface UserDao {
	public List<User> getAllUsers();
	public User getUser(User user);
	public boolean insertUser(User user);
	//public boolean updateUser(User user);  //re-enable these on the DaoImpl as well when needed
	//public boolean deleteUser(User user);
}
