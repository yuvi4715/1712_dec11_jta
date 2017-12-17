package com.revature.classMembers;

/*
 * Nathan Poole
 * Question Eight
 * Create a main method in a new class that:
 * 		Creates 2 customers
 * 		Uses each of the Customer class members
 */

public class ServeCustomers {
	
	public static void main(String[] args) {
		
		Customer.welcome();
		System.out.println(Customer.totalCustomers());
		
		Customer bill = new Customer("Bill");
		Customer joy = new Customer("Joy", 100);
		
		System.out.println(Customer.totalCustomers());
		
		joy.totalTickets();
		bill.totalTickets(50);
		
		joy.getCustomerInfo();
		bill.getCustomerInfo();
		
		
	}
	
	
}
