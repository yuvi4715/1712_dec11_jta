package com.revature.as1.oop;

public class AnimalDriver {
	
	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
	//	one.walk();
		
		two.move();
		two.eat();
		two.walk();
		
		three.move();
		three.eat();
		three.walk();
		
	}

}
