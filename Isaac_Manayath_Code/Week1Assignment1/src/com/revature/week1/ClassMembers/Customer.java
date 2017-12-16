package com.revature.week1.ClassMembers;

public class Customer {

	String name;
	int age;
	final int customerLimit = 500;
	
	//static variable
	static int count = 0;
	
	//Static method 1
	public static int getCount() {
		return count;
	}
	
	//Static method 2
	public static void printCount(int count) {
		System.out.println(count);
	}
	
	//one overloaded method
	void printInformation(String name) {
		System.out.println(name);
	}
	
	void printInformation(String name, int age) {
		System.out.println(name);
		System.out.println(age);
	}
	
	//second overloaded method
	
	//One Custructor
	Customer(){}
	
	//Second Custructor
	Customer(String n, int a){
		n = name;
		a = age;
	}
	
	
}
