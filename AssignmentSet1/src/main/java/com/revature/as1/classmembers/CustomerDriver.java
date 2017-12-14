package com.revature.as1.classmembers;

public class CustomerDriver {
	
	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer(100,200);
		
		c1.setCashOnCard(50);
		c1.setCashOnHand(22);
		
		System.out.println("C1 cash on hand: " + c1.getCashOnHand());
		System.out.println("C2 cash on hand: " + c2.getCashOnHand());
		
		System.out.println("C1 cash on card: " + c1.getCashOnCard());
		System.out.println("C2 cash on card: " + c2.getCashOnCard());

		System.out.println("Does C1 equal C2? " + (c1.equals(c2) ? "Yes" : "No"));
		
		c1.checkout(100);
		c1.checkout(100, "Visa");
		
		c2.checkout(20);
		c2.checkout(100);
		
		Customer.addCustomer();
		
		System.out.println("There are currently " + Customer.getNumCustomers() + " customers shopping.");

		
		
	}

}
