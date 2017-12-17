package com.revature.oop;

/*
 * Nathan Poole
 * Question Nine
 * Create an Animal interface with two methods: 
 * 		eat() and move().
 *  
 * Write a class called Mammal that implements Animal and the eat() 
 * 		but does not implement move(). Mammal should also have a 
 * 		static method called walk().
 *  
 * Create a Human class that extends Mammal, overrides eat() and 
 * 		has a static method called walk(). 
 * 
 * Create two objects as follows:
 * 		Animal one = new Human(); 	
 * 		Mammal two = new Human(); 	
 * 		Human three = new Human();
 * 
 * Call each of the methods for each of the objects: 
 * 		eat(), move(), walk(). 
 * 		Note the results.
 */

public class Human extends Mammal{
	
	public void eat() {
		System.out.println("The human eats some food");
	}
	
	public static void walk() {
		System.out.println("The humam walks somewhere");
	}
	
	public static void main(String[] args) {
		animalMammalHumman();
	}
	
	public static void animalMammalHumman() {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();		//The human eats some food
		one.move();		//not implemented
		//one.walk(); can't call walk because the interface dosn't have a walk method 
		
		two.eat();		//The human eats some food
		two.move();		//not implemented
		two.walk();		//The mammal walks somewhere [.walk is static, call should be Mammal.walk();]
		
		three.eat();	//The human eats some food
		three.move();	//not implemented
		three.walk();	//The human walks somewhere [.walk is static, call should be Humman.walk();]
	}
}
