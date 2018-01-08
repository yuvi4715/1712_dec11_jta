package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.model.Credential;
import com.revature.util.ConnectionUtil;

public class CredentialDAO implements ICredentialDAO {

	@Override
	public boolean isValid(String username, String password) throws SQLException {
		Credential temp = getCredential(username);
		if(temp != null && temp.getPassword().equals(password))
			return true;
		return false;
	}

	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		int completed = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			Credential temp = getCredential(username);
			PreparedStatement ps = null;
			String query = "Update rpadmin.logininfo set passwd = ? where username = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setString(2, username);

			if (oldPassword == temp.getPassword())
				completed = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return completed > 0;
	}

	private Credential getCredential(String username) throws SQLException {
		int id = 0;
		String user = null, pass = null, title = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			PreparedStatement ps = null;
			String query = "select * from rpadmin.logininfo"
					+ " inner join rpadmin.jobtitle on rpadmin.logininfo.title_id = rpadmin.jobtitle.title_id"
					+ " where username = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt("login_id");
				user = rs.getString("username");
				pass = rs.getString("passwd");
				title = rs.getString("title");	
			}
			else 
				throw new NullPointerException();
				

		} catch(NullPointerException e) {
			System.out.println("nothing in resultset");
			return null;
		}
		return new Credential(id,user,pass, title);
	}
	
	
}
