package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.dao.EmployeeDaoImp;
import com.revature.model.Employee;

public class TestEmployeeDaoImp {

	@Ignore
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsertProcedure() {
		Employee TestDummy = new Employee("Test Dummy", "test.dummy@revature.com", "TestDummy", "CarCrash", "Impact Expert", 0);
		assertEquals(true, EmployeeDaoImp.getInstance().insertProcedure(TestDummy));
	}

	@Ignore
	@Test
	public void testSelect() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetCustomerHash() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSelectId() {
		fail("Not yet implemented");
	}

}
