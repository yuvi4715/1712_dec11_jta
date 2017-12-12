package com.revature.week1_jason_shen;

// 7. Create a Customer class with:
//    -At least 2 constructors
//    -At least 2 overloaded methods
//    -At least 1 static variable
//    -At least 2 static methods
//    -At least 1 final variable


public class Customer {
	private int age;
	private int shares;
	private static String bank;
	private static int total_funds = 1000;
	private final String company;
	
	// Constructor with age input
	public Customer(int age, String comp) {
		this.age = age;
		this.shares = 0;
		Customer.bank = "Citi";
		company = comp;
		return;
	}
	
	// Blank constructor
	public Customer() {
		this.age = 0;
		this.shares = 0;
		Customer.bank = "Citi";
		company = "Revature";
		return;
	}
	// Static methods for bank and funds
	public static void setBank(String bank) {
		System.out.println("Setting customer bank to: " + bank);
		Customer.bank = bank;
		return;
	}
	
	public static void getBank() {
		System.out.println(bank);
		return;
	}
	
	public static void getTotalFunds() {
		System.out.println(total_funds);
	}
	
	// Various getter and setter methods
	public int getAge() {
		System.out.println("Age: " + this.age);
		return this.age;
	}
	
	public void setAge(int new_age) {
		this.age = new_age;
		System.out.println("Age set to: " + new_age);
		return;
	}
	
	
	public final String getCompany() {
		System.out.println(company);
		return company;
	}
	
	// Method for getting shares
	// We're not gonna make a setter for shares that might be abused
	// Instead we'll use some overloaded methods
	public int getShares() {
		System.out.println("Number of shares owned: " + this.shares);
		return this.shares;
	}
	
	// A method to buy shares with number of shares indicated
	public void buyShares(int num_shares) {
		System.out.println("Bought " + num_shares + " shares");
		this.shares += num_shares;
		total_funds -= (num_shares * 10);
	}
	
	// Overloaded so that if no shares are indicated, 10 are bought by default.
	public void buyShares() {
		System.out.println("Bought 10 shares");
		this.shares += 10;
		total_funds -= 100;
	}
	
	public void sellMyShares() {
		this.shares = 0;
	}
	
}
