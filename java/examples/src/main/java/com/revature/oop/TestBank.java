package com.revature.oop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBank {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Bank BofA = new Bank();
		BofA.setAccountName("Yuvi");
		BofA.setAccountNumber(1234567890);
		BofA.setAccountBalance(1000000000);
		BofA.setAccountType("Checking");
		System.out.println(BofA.getAccountBalance());
		System.out.println(BofA.getAccountName());
		System.out.println(BofA.getAccountNumber());
		System.out.println(BofA.getAccountType());
	}

}
