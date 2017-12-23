package com.revature.service;

import java.util.List;

import com.revature.dao.CustomerDaoImpl;
import com.revature.model.Customer;

public class CustomerService {

	//private instance of CustomerService variable
	private static CustomerService customerService;
	//applying singleton singleton pattern
	private CustomerService() {
	}

	//to access the instance of the CustomerService using customerService
	public static CustomerService getInstance() {
		if (customerService == null) {
			customerService = new CustomerService();
		}
		return customerService;
	}
	
	//calls the insert method of DAO
	public boolean registerCustomer(Customer customer) {
		return CustomerDaoImpl.getInstance().insert(customer);
	}
	
	//calls the insert method which will call the stored procedure named "insert_customer"
	public boolean registerCustomerSecure(Customer customer) {
		return CustomerDaoImpl.getInstance().insertProcedure(customer);
	}
	
	//service to call selectAll method in DAO
	public List<Customer> listAllUsers(){
		return CustomerDaoImpl.getInstance().selectAll();
	}
	
	//
	public Customer login(Customer customer) {
		//Get user information without validation
		Customer c1 = CustomerDaoImpl.getInstance().select(customer);
		/*
		 * c1.getPassword is the hash we stored in database
		 * compare that against the user input
		 * if credentials are correct then return all customer info
		 * otherwise, return a blank object
		 */
		if (c1.getPassword().equals(CustomerDaoImpl.getInstance().getCustomerHash(customer))) {
			return c1;
		}
		return new Customer();
	}
}
