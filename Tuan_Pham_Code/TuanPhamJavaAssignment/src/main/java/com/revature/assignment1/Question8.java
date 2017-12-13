package com.revature.assignment1;

/*
8.	Create a main method in a new class that:
a.	Creates 2 customers
b.	Uses each of the Customer class members

*/
public class Question8 {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		
		c1.printBalance(10);
		System.out.println("Customer 1's original balance was " + c1.balance);
		
		Customer c2 = new Customer();
		System.out.println("Customer 2's balance is " + c2.balance);
		c2.addbalance(50);

		
		
		

	}

}
