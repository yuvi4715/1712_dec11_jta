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
	
	final String company = "Revature";
	public String name;
	public int age;
	static int balance;
	static int customerCount= 0;
	static int hours = 0;
	

	public Customer(String name) {
		this.name = name;
		customerCount++;
	}
	public Customer(String name, int age, int balance) {
		this.name = name;
		this.age = age;
		Customer.balance = balance;
		customerCount++;
		
	}
	
	// Print how many customers there are
	public static void printCustomerCount() {
		System.out.print(customerCount);
	}
	
	// Print a customer's balance
	public static void printBalance() {
		System.out.println("Cash card has " + balance);
	}
	
	// Default add 100 for to cash card during pay
	public void addBalance() {
		System.out.println("Adding 100 to balance");
		balance += 100;
		System.out.println("Cash card now has " + balance);
	}
	
	// Overload addBalance to add extra money from bonus
	public void addbalance(int additionalBalance) {
		System.out.println("Adding " + additionalBalance + " to balance");
		
		balance += additionalBalance;
		System.out.println("Cash card now has " + balance);
	}
	
	// Keep track of hours. Default is 8 hours a day
	public void logHours() {
		hours = 8;
		System.out.println("Worked 8 hours");
	}
	
	// Keep track of overtime hours by overloading logHours() method
	public void logHours(int overtime) {
		hours = 8 + overtime;
		System.out.println("Worked " + hours + " hours including " + overtime+ " hours overtime");
	}
	
	public static void main(String[] args) {
		//printBalance();
		//addBalance();
		
		Customer c1 = new Customer("Jake Perez");
		System.out.println(c1.name);
		printBalance();
		c1.logHours(2);
		c1.addbalance(140);
		System.out.println("");
		
		Customer c2 = new Customer("Jose Rodiguez", 20, 0);
		System.out.println(c2.name);
		printBalance();
		c2.logHours();
		c2.addBalance();
		
		System.out.println("\nTotal number of customers: ");
		printCustomerCount();
	}
	
}
