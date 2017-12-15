package com.revature.oop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Bank BofA = new Bank();
		BofA.setAccountName("Clayton");
		BofA.setAccountNumber(12456780);
		BofA.setAccountBalance(10000000);
		BofA.setAccountType("Checking");
		
		System.out.println(BofA.getAccountBalance());
		System.out.println(BofA.getAccountName());
		System.out.println(BofA.getAccountNumber());
		System.out.println(BofA.getAccountType());
	}

}
