package com.revature.as1.oop;

public abstract class Mammal implements Animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("I'm eating leaf me alone.");
	}

	@Override
	public abstract void move();
	
	public static void walk() {
		System.out.println("Hey, I'm walkin' here.");
	}
	
}
