package dao;

import java.sql.SQLException;
import java.util.List;

import beans.User;

public interface UserDAO
{
	public List<User> getAllUsers() throws SQLException;
	public User getUser(int eid) throws SQLException;
	public User getUser(String uname) throws SQLException;
	public void updateUser(User user) throws SQLException;
}
