package com.revature.day1;

public class Customer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Customer customer = new Customer();

Customer AngryCustomer = new Customer(true);

AngryCustomer.complain();

customer.request_unlock();

customer.treat_customer();

AngryCustomer.treat_customer(true);

	}

}
