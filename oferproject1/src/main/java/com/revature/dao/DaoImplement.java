package com.revature.dao;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Request;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class DaoImplement implements Dao{

	private static DaoImplement DaoImpl;
	
	private DaoImplement() {
	}
	
	public static DaoImplement getInstance() {
		if (DaoImpl == null) {
			DaoImpl = new DaoImplement();
		}
		return DaoImpl;
	}

	//Insert into user table using PreparedStatement	
	@Override
	public boolean insertProcedure(User user) {
		try(Connection conn = ConnectionUtil.getConnection()){
		
		//checks if the password contains at least 6 characters, and contains at lest 1 letter and 1 number
		if(user.getPassword().length()<6 || !(user.getPassword().matches("^(?=.*[a-zA-Z])(?=.*\\d).+$"))) {
			System.out.println("Password must be at least 6 characters long"
					+ " and contain at least 1 number and 1 letter!");
			return false;
		}
		//checks that the user name contains at least 4 characters
		else if(user.getUsername().length()<4) {
			System.out.println("Username must be at least 4 characters long!");
			return false;
		}
		else {
			int statementIndex = 0;
			
			//Calling the store procedure
			String storedProc = "{CALL INSERT_USERS(?,?,?,?,?,?,?,?)}";
			
			//Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement c = conn.prepareCall(storedProc);
			//PreparedStatement c = conn.prepareStatement(storedProc);
			
			//Set attributes to insert
			c.setString(++statementIndex, user.getFirstname().toUpperCase());
			c.setString(++statementIndex, user.getLastname().toUpperCase());
			c.setString(++statementIndex, user.getUsername().toUpperCase());
			c.setString(++statementIndex, user.getPassword());
			// The email may be case sensitive and is therefore not converted to uppercase
			c.setString(++statementIndex, user.getEmail());
			c.setInt(++statementIndex, user.getMflag());
			c.setInt(++statementIndex, user.getLflag());
			c.registerOutParameter(++statementIndex, java.sql.Types.NUMERIC); //Output
			
			
			if(c.executeUpdate() > 0) {
			if(c.getInt(8)==1) 
				System.out.println("An identical username already exists!");
			else
				return true;
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Update User Profile
	@Override
	public boolean update(User user) {
		try(Connection conn = ConnectionUtil.getConnection()){
		
		//checks if the new password contains at least 6 characters, and contains at lest 1 letter and 1 number
		if(user.getPassword().length()<6 || !(user.getPassword().matches("^(?=.*[a-zA-Z])(?=.*\\d).+$"))) {
			System.out.println("Password must be at least 6 characters long"
					+ " and contain at least 1 number and 1 letter!");
			return false;
		}
		//checks that the new user name contains at least 4 characters
		else if(user.getUsername().length()<4) {
			System.out.println("Username must be at least 4 characters long!");
			return false;
		}
		else {
			int statementIndex = 0;
			
			//Calling the store procedure
			String storedProc = "{CALL UPDATE_USERS(?,?,?,?,?,?,?)}";
			
			//Using callable statement in itself is not vulnerable to SQL Injection
			CallableStatement c = conn.prepareCall(storedProc);
			//PreparedStatement c = conn.prepareStatement(storedProc);
			
			//Set attributes to insert
			c.setInt(++statementIndex, user.getId());
			c.setString(++statementIndex, user.getFirstname().toUpperCase());
			c.setString(++statementIndex, user.getLastname().toUpperCase());
			c.setString(++statementIndex, user.getUsername().toUpperCase());
			c.setString(++statementIndex, user.getPassword());
			// The email may be case sensitive and is therefore not converted to uppercase
			c.setString(++statementIndex, user.getEmail());
			c.registerOutParameter(++statementIndex, java.sql.Types.NUMERIC); //Output
			
			
			if(c.executeUpdate() > 0) {
			if(c.getInt(7)==1) 
				System.out.println("An identical username already exists!");
			else
				return true;
			}
			
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Login
	@Override
	public User select(User user) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			String un=user.getUsername().toUpperCase();
			//ResultSet result;
			
				
			/*
			CALL LOGIN PROCEDURE
			The User_Login procedure helps reduce network traffic...
			1 callable statement is used instead of multiple prepared statements
			The procedure first checks the validity of the password (using GET_HASH), and then... 
			if the password is valid - it checks if the user is already loggedin
			*/
				String storedProc = "{CALL USER_LOGIN(?,?,?,?,?,?,?,?,?)}";
				
				//Using callable statement in itself is not vulnerable to SQL Injection
				CallableStatement p = conn.prepareCall(storedProc);
				p.setString(++statementIndex, un); 					//Input 1 - username
				p.setString(++statementIndex, user.getPassword()); 	//Input 2 - password
				//p.setInt(++statementIndex, user.getMflag());		//Input 3 - manager flag
				p.registerOutParameter(++statementIndex, java.sql.Types.NUMERIC); //Output 4 - ID
				p.registerOutParameter(++statementIndex, java.sql.Types.VARCHAR); //Output 5 - first name
				p.registerOutParameter(++statementIndex, java.sql.Types.VARCHAR); //Output 6 - last name
				p.registerOutParameter(++statementIndex, java.sql.Types.VARCHAR); //Output 7 - password
				p.registerOutParameter(++statementIndex, java.sql.Types.VARCHAR); //Output 8 - email
				p.registerOutParameter(++statementIndex, java.sql.Types.NUMERIC); //Output 9 - manager flag
				p.registerOutParameter(++statementIndex, java.sql.Types.NUMERIC); //Output 10 - loggedin flag
				p.executeQuery();
						
				
				if(p.getString(4).equals("0")) {
					return new User("Incorrect username!");
				}
				else {
					
			/*	if(p.getInt(9)!=user.getMflag()) {
					if(user.getMflag()==1) {
						return new User("You can't access the Manager Homepage.");
					
					}
					else {
						return new User("You can't access the Employee Homepage.");
					}
				}
				
				else {*/
					if(p.getString(6).equals("0")) {
						return new User("Incorrect password! (The password is case sensitive)");
					}
					else {	
						
						/*This code limits user access to one device at a time
						if(p.getInt(10)==0) {
							
							return new User("You are already logged in!");
						
						}
						
						else */
							return new User(p.getInt(3),p.getString(4),p.getString(5),un,
									p.getString(6),p.getString(7),p.getInt(8),p.getInt(9));
						
					}
				
			}
		}
			
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return new User();
	}
	
	//Logout
	@Override
	public boolean deselect(User user) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE USERS SET U_LOGGEDIN=0 WHERE U_USERNAME = ?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, user.getUsername().toUpperCase());
			
			//execute the statement
			if (p.executeUpdate() > 0) {
				
				System.out.println("You have successfully logged out!");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//View all users
	@Override
	public List<User> selectAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "Select * from users";
			PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			List<User> userList = new ArrayList<>();
			while (rs.next()) {
				userList.add(new User(
						rs.getInt("U_ID"),
						rs.getString("U_FIRSTNAME"),
						rs.getString("U_LASTNAME"),
						rs.getString("U_USERNAME"),
						rs.getString("U_PASSWORD"),
						rs.getString("U_EMAIL"),
						rs.getInt("U_MANAGER"),
						rs.getInt("U_LOGGEDIN"))
						);
			}
						
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	//Submit Request
	@Override
	public boolean submit(Request request) {
		try(Connection conn = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			
			//ResultSet result;
			
			
				String storedProc = "{CALL SUBMIT_REQUEST(?,?,?,?,?,?)}";
				
				//Using callable statement in itself is not vulnerable to SQL Injection
				CallableStatement p = conn.prepareCall(storedProc);
				p.setInt(++statementIndex, request.getEid());		//Input 1 - EmployeeID
				p.setString(++statementIndex, request.getAmount()); //Input 2 - Amount					
				p.setString(++statementIndex, request.getType()); 	//Input 3 - Request Type
				p.setString(++statementIndex, request.getType2()); 	//Input 4 - Details		
				p.setInt(++statementIndex, request.getRflag()); 	//Input 5 - Receipt Attached flag
				p.setString(++statementIndex, request.getRurl()); 	//Input 6 - Receipt URL
				
			//	p.registerOutParameter(++statementIndex, java.sql.Types.VARCHAR); //Output 7 - email
			//	p.registerOutParameter(++statementIndex, java.sql.Types.NUMERIC); //Output 8 - manager flag
				
				p.executeQuery();
						
				return true;
						//	return new Request(p.getInt(4),p.getString(5),p.getString(6),un,
						//			p.getString(7),p.getString(8),p.getInt(9),p.getInt(10));
					
		}
			
		 catch (SQLException e) {
			e.printStackTrace();
		}
		//return new Request();
		return false;
	}

	//View requests
		@Override
		public List<Request> viewRequests(Request request) {
			try(Connection conn = ConnectionUtil.getConnection()){
				
				int id=request.getEid();
				String open=request.getAmount();
				String sql="";
				PreparedStatement p;
				if(id==0) {
					if(open.equals("Pending"))
						sql = "SELECT * FROM O_REQUESTS order by R_ID";
					else if(open.equals("Resolved")) 
						sql = "SELECT * FROM C_REQUESTS order by R_ID";	
					p = conn.prepareStatement(sql);
				}
				else {
					if(open.equals("Pending"))
						sql = "SELECT * FROM O_REQUESTS WHERE E_ID = ? order by R_ID";
					else if(open.equals("Resolved")) 
						sql = "SELECT * FROM C_REQUESTS WHERE E_ID = ? order by R_ID";
					p = conn.prepareStatement(sql);
					p.setInt(1, id);
				}

				ResultSet rs = p.executeQuery();	
				List<Request> requestList = new ArrayList<>();
				while (rs.next()) {
					requestList.add(new Request(
							rs.getInt("R_ID"),
							rs.getInt("E_ID"),
							rs.getString("AMOUNT"),
							rs.getString("SDATE"),
							rs.getString("EDATE"),
							rs.getString("STATUS"),
							rs.getString("RTYPE"),
							rs.getString("RTYPE2"),
							rs.getInt("RES_ID"),
							rs.getInt("RFLAG"),
							rs.getString("RURL"))
							);
				}
							
				return requestList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return new ArrayList<>();
		}
		
		
		//Close Request
		@Override
		public boolean closeRequest(Request request) {
			try(Connection conn = ConnectionUtil.getConnection()){
				int statementIndex = 0;
				
				//ResultSet result;
				
				
					String storedProc = "{CALL CLOSE_REQUEST(?,?,?,?)}";
					
					//Using callable statement in itself is not vulnerable to SQL Injection
					CallableStatement p = conn.prepareCall(storedProc);
					p.setInt(++statementIndex, request.getRid());		//Input 1 - Request ID	
					p.setInt(++statementIndex, request.getResid()); 	//Input 5 - Resolved by ID
					p.setString(++statementIndex, request.getStatus()); 	//Input 6 - Status = Approved/Denied
					p.registerOutParameter(++statementIndex, java.sql.Types.NUMERIC); //Output 4 - fail (used for debugging)
					
					p.executeQuery();
							
					return true;
						
			}
				
			 catch (SQLException e) {
				e.printStackTrace();
			}
			//return new Request();
			return false;
		}

}
