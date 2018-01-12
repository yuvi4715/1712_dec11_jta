package com.ers.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ers.model.Employee;

public class EmployeeModelTest {
	public static Employee e1;
	public static int id = 100;
	public static String fname = "Andrew";
	public static String lname = "Crenwelge";
	public static String email = "ajc@me.com";
	public static String bday = "01-01-1990";
	public static String phone = "111-111-1111";
	public static String addr = "123 Test St";
	public static String city = "Testcity";
	public static String state = "Teststate";
	public static String ctry = "testcountry";
	public static String zip = "12345";
	public static boolean b = true;

	@Before
	public void setUp() throws Exception {
		e1 = new Employee(id,fname,lname,email,bday,phone,addr,city,state,ctry,zip,b);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBean() {
		assertEquals(id, e1.getId());
		assertEquals(fname, e1.getFirstname());
		assertEquals(lname, e1.getLastname());
		assertEquals(email, e1.getEmail());
		assertEquals(bday, e1.getBirthdate());
		assertEquals(phone, e1.getPhoneNumber());
		assertEquals(addr, e1.getAddress());
		assertEquals(city, e1.getCity());
		assertEquals(state, e1.getState());
		assertEquals(ctry, e1.getCountry());
		assertEquals(zip, e1.getZip());
		assertEquals(b, e1.getIsManager());
	}

}
