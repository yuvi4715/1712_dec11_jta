package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.beans.Employee;

public class LoginDAO implements LoginDAOInterface {

	@Override
	public boolean checkUsername(Employee emp, Connection con) throws Exception {
		
		boolean passORfail;
		String user = emp.getUsername().toLowerCase();
		String getUserSql = "SELECT EMP_USERNAME FROM USER_TBL WHERE EMP_USERNAME = '" + user + "'";
		String retrievedUser;
		
		PreparedStatement ps = con.prepareStatement(getUserSql);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			retrievedUser = rs.getString(1);
		} else {
			retrievedUser = "";
		}
		
		if(retrievedUser.equals(user)) {
			System.out.println("Valid Username");
			passORfail = true;
		} else {
			System.out.println("Username Not Found In Database");
			passORfail = false;
		}

		rs.close();
		ps.close();
		con.close();
		return passORfail;
	}
	
	public boolean checkTitle(String user, Connection con) throws Exception {
		boolean EorM = false;
		
		String retrievedTitle = new EmployeeDAO().getEmployeeTitle(user, con);
		
		System.out.println("-----" + retrievedTitle + "-----");
		
		if(retrievedTitle.equalsIgnoreCase("manager")) {
			EorM = true;
		} else {
			EorM = false;
		}
		
		return EorM;
	}

	public boolean checkPassword(Employee emp, Connection con) throws Exception {
		
		boolean passORfail;
		
		String pass = emp.getPassword();
		String user = emp.getUsername();
		
		String getPassSql = "SELECT EMP_PASSWORD FROM USER_TBL WHERE EMP_PASSWORD = '" + pass + "' AND EMP_USERNAME  = '" + user  + "'";
		String retrievedPass;
		
		PreparedStatement ps = con.prepareStatement(getPassSql);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			retrievedPass = rs.getString(1);
		} else {
			retrievedPass = "";
		}
		
		if(retrievedPass.equals(pass)) {
			System.out.println("Welcome");
			passORfail = true;
		} else {
			System.out.println("Invalid Password");
			passORfail = false;
		}
		
		rs.close();
		ps.close();
		con.close();
		return passORfail;
	}
	
	@Override
	public void login(String user, Connection con) throws Exception {
		String loginSql = "UPDATE USER_TBL SET LOG_STATUS = 1 WHERE EMP_USERNAME = '" + user +"'";
		
		PreparedStatement ps = con.prepareStatement(loginSql);
		
		System.out.println("Login Successful!");
		
		ps.execute();
		ps.close();
	}

	@Override
	public void logout(String user, Connection con) throws Exception {
		String logoutSql = "UPDATE USER_TBL SET LOG_STATUS = 0 WHERE EMP_USERNAME = '" + user +"'";
		
		PreparedStatement ps = con.prepareStatement(logoutSql);
		
		System.out.println("Logout Successful!");
		
		ps.executeQuery();
		ps.close();
		con.close();
	}
}
