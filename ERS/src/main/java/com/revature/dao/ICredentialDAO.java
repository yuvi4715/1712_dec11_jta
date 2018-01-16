package com.revature.dao;

import com.revature.model.Credential;

public interface ICredentialDAO {

	Credential isValid(Credential credential);
	boolean insertCredential(Credential credential);
	String toString();
	boolean changePassword(Credential credential, String newPassword);
}
