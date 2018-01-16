package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.model.Credential;
import com.revature.util.ConnectionUtil;

public class CredentialDAO implements ICredentialDAO {
	
	private Logger logger = Logger.getLogger(CredentialDAO.class);
	private static CredentialDAO obj;
	private CredentialDAO() {}
	public static CredentialDAO getInstance() {
		if(obj == null)
			obj = new CredentialDAO();
		return obj;
	}
	
	//Checks if the credentials inserted at login is correct
	@Override
	public Credential isValid(Credential credential) {
		Credential temp;
			temp = getCredential(credential.getUsername());
		if(temp != null && temp.getPassword().equals(credential.getPassword()))
			return temp;
		return null;
	}

	//Changes the password if possible
	@Override
	public boolean changePassword(Credential credential, String newPassword) {
		int completed = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			Credential temp = getCredential(credential.getUsername());
			PreparedStatement ps = null;
			String query = "Update rpadmin.logininfo set passwd = ? where username = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setString(2, credential.getUsername());

			if (credential.getPassword().equals(temp.getPassword())) 
				completed = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}

		return completed == 1;
	}

	//gets the credential for the username provided
	private Credential getCredential(String username) {
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
				return new Credential(id,user,pass, title);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	
	//Manager can insert user into the system
	@Override
	public boolean insertCredential(Credential credential) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = null;
			int placementNumber = 0;
			String query = "insert into rpadmin.logininfo values(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setNull(++placementNumber, java.sql.Types.NUMERIC);
			ps.setString(++placementNumber, credential.getUsername());
			ps.setString(++placementNumber, credential.getPassword());
			ps.setString(++placementNumber, credential.getTitle());
			return ps.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}
	
	
}
