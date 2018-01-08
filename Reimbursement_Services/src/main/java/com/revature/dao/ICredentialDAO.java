package com.revature.dao;

import java.sql.SQLException;

public interface ICredentialDAO extends IMainDAO {

	boolean isValid(String username, String password) throws SQLException;
	boolean changePassword(String username, String oldPassword, String newPassword) throws SQLException;
	String toString();
}
