package com.revature.assignment1.class_members;

public class CustomerCreator {

	public static void main(String[] args) {

		Customer defaultCustomer = new Customer();
		Customer newCustomer = new Customer("Anthony Martin", 5);

		defaultCustomer.setName();
		newCustomer.setName("Michelle Martin");

		System.out.println("Name for the defaultCustomer object is " + defaultCustomer.getName());
		System.out.println("Name for the newCustomer object is " + newCustomer.getName());

		defaultCustomer.setOrderNumber();
		newCustomer.setOrderNumber(9);

		System.out.println("Orders for the defaultCustomer object is " + defaultCustomer.getOrders());
		System.out.println("Orders for the newCustomer object is " + newCustomer.getOrders());

		int maxOrders = Customer.getMaxOrders();
		String storeName = Customer.getStoreName();
		
		System.out.println("Max orders for a customer is " + maxOrders);
		System.out.println("Store name for the customers is " + storeName);
	}

}
