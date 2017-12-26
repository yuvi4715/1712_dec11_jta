package com.revature;

import com.revature.model.Customer;
import com.revature.service.CustomerService;

public class TestClass {

	public static void main(String[] args) {

		//**** -- Please don't write all print statements in one attempt 
		//**** -- Please try to run one sysout at a time to understand the permutations

		//Step 1 - Test to insert a new customer with valid
		//System.out.println(CustomerService.getInstance().registerCustomer(new Customer(0, "Test", "Test", "Test", "Test")));

		//Step 2 - Test to insert another new customer with valid credentials
		//System.out.println(CustomerService.getInstance().registerCustomer(new Customer(0, "Yuvaraj", "Damodaran", "yuvi", "1234")));

		//Step 3 - Try to insert an existing credentials - should throw unique key constraint on customer table
		//System.out.println(CustomerService.getInstance().registerCustomer(new Customer(0, "Yuvaraj", "Damodaran", "yuvi", "1234")));
		
		//Step 4 - Test to insert a new customer using stored procedure
		//System.out.println(CustomerService.getInstance().registerCustomerSecure(new Customer(0, "Using Stored", "Procedure", "storedproc", "storedproc")));
	
		//Step 5 - Test to retrieve all the users in the database
		System.out.println(CustomerService.getInstance().listAllUsers());
		
		//Step 6 - Test login
		//System.out.println(CustomerService.getInstance().login(new Customer("yuvi","1234")));
		
	}

}
