package com.revature.reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.User;
import com.revature.util.ConnectionUtil;
import com.revature.reimbursement.UserDao;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl userDaoImpl;
	
	private UserDaoImpl() {
		
	}
	
	public static UserDaoImpl getInstance() {
		if (userDaoImpl == null) {
			userDaoImpl = new UserDaoImpl();
		}
		return userDaoImpl;
	}
	
	// retreive all user in the table - under construction!
	public List<User> getAllUsers() {
		List<User> user = new ArrayList();
		return user;
	}
	
	//select user from table and return to view - UNDER CONSTRUCTION!
	public User getUser(User user) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			int statementIndex = 0;
			
			String sql = "SELECT * FROM R_USER WHERE USERNAME = ?";    //this method receives the user object with attached attributes from login
			PreparedStatement p = conn.prepareStatement(sql);        
			
			p.setString(++statementIndex, user.getUsername());       //which we then get the username from and set the sql statement for lookup
			
			ResultSet result = p.executeQuery();     //the result will have all the user we need to work with
			
			while (result.next()) {
				return new User(
				result.getInt("EID"),
				result.getString("USERNAME"),
				result.getString("PASSWORD"),
				result.getString("LOGSTATUS"),
				result.getString("ADMIN")
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			}
		return new User();
	}
	
	//insert into user table
	public boolean insertUser(User user) {
		try{
			Connection conn = ConnectionUtil.getConnection();
		
			int statementIndex = 0;
			
			String sql = "insert into user values(NULL, ?, ?, ?, ?)";
			
			PreparedStatement p = conn.prepareStatement(sql);
			
			//p.setString(++statementIndex, user.getEid().toUpperCase()); integer
			p.setString(++statementIndex, user.getUsername().toUpperCase());
			p.setString(++statementIndex, user.getPassword().toUpperCase());
			p.setString(++statementIndex, user.getAdmin().toUpperCase());
			p.setString(++statementIndex, user.getLogstatus().toUpperCase());
		
			//execute the statement
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*//update the user row in the table for a selected user -- UNDER CONSTRUCTION
	public void updateUser(User user) {
		
	}*/
	
	/*//delete user from table -- UNDERCONSTRUCTION
	public void deleteUser(User user) {
		
	}*/
	
	
	
}
