package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import ers.Connect;

public class UserDaoImpl implements UserDAO
{

	
	
	public List<User> getAllUsers() throws SQLException
	{
		String sql = "Select * from Employee";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.executeQuery(sql);
		ResultSet rs = stmt.executeQuery();

		List<User> users = new ArrayList<User>();

		while (rs.next())
		{
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			users.add(user);
		}

		return users;
	}

	public User getUser(String uname) throws SQLException
	{
		
		String sql = "select * from Employee where username = ?";

		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setString(1, uname);

		ResultSet rs = stmt.executeQuery();
			
		User user = null;
		while (rs.next())
		{
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			
		}

		return user;
	}

	public User getUser(int eid) throws SQLException
	{
		String sql = "select * from Employee where eid = ?";
		String stringeid = Integer.toString(eid);
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setString(1, stringeid);
		
		ResultSet rs = stmt.executeQuery();
		
		User user = null;
		while (rs.next())
		{
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			
		}

		return user;
	}

	public void updateUser(User user)
	{
		// TODO Auto-generated method stub

	}

}
