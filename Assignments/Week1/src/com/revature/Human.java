package com.revature;


public class Human extends Mammal{

	@Override
	public void eat() {
		System.out.println("Human is eating");	
	}
	
	public static void walk() {
		System.out.println("Human is walking");	
	}
	
}
