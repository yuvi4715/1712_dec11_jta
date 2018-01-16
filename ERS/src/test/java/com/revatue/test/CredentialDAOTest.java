package com.revatue.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.dao.CredentialDAO;
import com.revature.model.Credential;


public class CredentialDAOTest {

	Credential credential1;
	Credential credential2;
	
	@Before
	public void setUp() throws Exception {
		credential1 = new Credential(1, "gtrain", "playboi", "manager");
		credential2 = new Credential(1, "SammyT", "youknow", "manager");
	}

	@Test
	public final void testIsValid() {
		assertNull(CredentialDAO.getInstance().isValid(credential2));
	}

	@Test
	public final void testChangePassword() {
		assertNull(CredentialDAO.getInstance().isValid(credential2));
	}

	

	@Test
	public final void testInsertCredential() {
		assertTrue(CredentialDAO.getInstance().insertCredential(credential1));
	}

}
