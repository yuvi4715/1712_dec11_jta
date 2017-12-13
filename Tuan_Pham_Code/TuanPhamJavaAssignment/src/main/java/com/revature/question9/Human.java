package com.revature.question9;

public class Human extends Mammal {

	@Override
	public void eat() {
		System.out.println("Human eats");
	}

	@Override
	public void move() {
		System.out.println("Human moves");
	}
	
	public static void walk() {
		System.out.println("Human walks");
	}
	
	public static void main(String[] args) {
		Animal one = new Human(); 	
		Mammal two = new Human(); 	
		Human three = new Human();
		
		one.eat();
		one.move();
		System.out.println("");
		two.eat();
		two.move();
		two.walk();
		System.out.println("");
		three.eat();
		three.move();
		three.walk();
	}
	
}
