package com.revature.assignment1.class_members;

public class Customer {
	
	private String name;
	private int orders;
	public static final int maxOrders = 100;
	public static String storeName = "Nathan's Supermarket";
	
	public Customer() {
		this.name = "Bob Martin";
		this.orders = 3;
	}
	
	public Customer(String name, int orders) {
		this.name = name;
		this.orders = orders;
	}
	
	public void setName() {
		this.name = "Richard Martin";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setOrderNumber() {
		this.orders = 1;
	}
	
	public void setOrderNumber(int orders) {
		this.orders = orders;
	}
	
	public int getOrders() {
		return this.orders;
	}
	
	public static int getMaxOrders() {
		return maxOrders;
	}
	
	public static String getStoreName() {
		return storeName;
	}

}
