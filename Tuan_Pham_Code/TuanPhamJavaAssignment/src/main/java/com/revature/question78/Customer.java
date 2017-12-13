package com.revature.question78;

/*
7.	Create a Customer class with:
a.	At least 2 constructors
b.	At least 2 overloaded methods
c.	At least 1 static variable
d.	At least 2 static methods
e.	At least 1 final variable
 */

public class Customer {

	final int age = 21;
	static int balance = 100;

	public Customer() {
	}
	public Customer(int balance) {
		Customer.balance = balance;
	}
	
	public static void printBalance() {
		System.out.println("balance is " + balance);
	}
	
	public static void addBalance() {
		System.out.println("Adding 100 to balance");
		balance += 100;
		System.out.println("balance is now " + balance);
	}
	public void printBalance(int newBalance) {
		System.out.println("Custom balance is " + newBalance);
	}
	
	public void addbalance(int additionalBalance) {
		System.out.println("Adding " + additionalBalance + " to balance");
		
		balance += additionalBalance;
		System.out.println("balance is now " + balance);
	}
	
	public static void main(String[] args) {
		printBalance();
		addBalance();
		
		Customer c1 = new Customer();
		c1.printBalance(500);
		c1.addbalance(50);
	}
	
}
