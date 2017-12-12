package com.revature.as1.oop;

public class Human extends Mammal {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		Mammal.walk();

	}

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("I'm eating leaf me alone.");
	}
	
	public static void walk() {
		System.out.println("I'm walkin'. Christopher Walkin'.");
	}
}
