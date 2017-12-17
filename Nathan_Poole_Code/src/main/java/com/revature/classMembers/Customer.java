package com.revature.classMembers;

/*
 * Nathan Poole
 * Question Seven
 * Create a Customer class with:
 * 		At least 2 constructors
 * 		At least 2 overloaded methods
 * 		At least 1 static variable
 * 		At least 2 static methods
 * 		At least 1 final variable
 */

public class Customer {
	private final String customerName;
	private static int numOfCustomers = 0;
	private int customerTickets;
	
	Customer(String name){
		customerName = name;
		numOfCustomers++;
		customerTickets=0;
	}
	
	Customer(String name, int tickets){
		customerName = name;
		numOfCustomers++;
		customerTickets = tickets;
	}
	
	void totalTickets() {
		System.out.println(customerName + " has "+customerTickets+" tickets.");
	}
	
	void totalTickets(int x) {
		customerTickets += x;
		System.out.println(x+" tickets added to total\n"+customerName+" has "+customerTickets+" tickets.");
	}
	
	static void welcome() {
		System.out.println("Welcome to Ticket Town, the town made entirely out of forgoten tickets!");
	}
	
	static int totalCustomers() {
		return numOfCustomers;
	}
	
	void getCustomerInfo() {
		System.out.println(customerName);
		totalTickets();
	}

}
