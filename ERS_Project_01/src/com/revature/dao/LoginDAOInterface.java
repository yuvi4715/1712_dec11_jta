package com.revature.dao;

import java.sql.Connection;

import com.revature.beans.Employee;

public interface LoginDAOInterface {
	public boolean checkUsername(Employee emp, Connection con) throws Exception;
	public boolean checkPassword(Employee emp, Connection con) throws Exception;
//	public boolean checkPassword(String pass, Connection con) throws Exception;
	
	public boolean checkTitle(String user, Connection con) throws Exception;

	public void login(String user, Connection con) throws Exception;
	public void logout(String user, Connection con) throws Exception;
}
