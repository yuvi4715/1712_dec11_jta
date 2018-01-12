package com.ers.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ers.model.Request;

public class RequestModelTest {
	public static Request r1;
	public int reqID;
	public int empID;
	public int mgrID;
	public double amount;
	public String title;
	public String description;
	public Timestamp submitDate;
	public Timestamp resolveDate;
	public String status;

	@Before
	public void setUp() throws Exception {
		r1 = new Request(reqID, empID, mgrID, title, status, amount, submitDate, resolveDate, description);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBean() {
		assertEquals(reqID,r1.getReqID());
		assertEquals(empID,r1.getEmpID());
		assertEquals(mgrID,r1.getMgrID());
		assertEquals(title,r1.getReqTitle());
		assertEquals(status,r1.getStatus());
		assertEquals(amount, r1.getAmount(), 0.01);
		assertEquals(submitDate,r1.getDateSubmitted());
		assertEquals(resolveDate,r1.getDateResolved());
		assertEquals(description,r1.getDescription());
	}

}
