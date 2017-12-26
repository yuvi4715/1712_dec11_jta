package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDao {

	public boolean insert(Customer customer);
	public boolean insertProcedure(Customer customer);
	public Customer select(Customer customer);
	public List<Customer> selectAll();
	public String getCustomerHash(Customer customer);
}
