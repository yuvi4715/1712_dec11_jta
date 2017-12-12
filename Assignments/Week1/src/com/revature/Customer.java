package com.revature;

import java.util.Random;

public class Customer {
	final int multiplier = 2;
	private static char sex;
	private static int currency;
	private String name;
	Random rand = new Random();
	
	private int n = rand.nextInt(5) + 1;

	public Customer(char gender, int money) {
		sex = gender;
		currency = money;
	}
	
	public Customer(char gender) {
		sex = gender;
		currency = 0;
		
		if(currency == 0) { 
			System.out.printf("You do not have enough funds!");
			System.exit(0);
		}
	}
	
	public static void displaygender() {
		if(sex == 'f') {
			System.out.println("Gender: Female");
		}
		else {
			System.out.println("Gender: Male");
		}
		
	}
	
	public static void displaymoney() {	
		System.out.printf("Money available: %d\n", currency);
	}
	
	public void name(String firstName, String lastName) {
		name = firstName + " " + lastName;
	}
	
	public void cart(String[] items) {

		if(n == 3) {
			System.out.println("You were randomly selected to double your  money!");
			
			currency = currency * multiplier;
		}
		
		System.out.printf("Hello %s, with the current money that you have ($%d) You can buy\n", name, currency);
		
		for (String i: items) { System.out.println(i);}
		
	}	
}
