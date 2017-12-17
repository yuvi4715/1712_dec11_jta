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

public class Mammal implements Animal{

	public void eat(){
		System.out.println("It ate some food");
	}
	
	public static void walk() {
		System.out.println("The Mammal walks somewhere");
	}
	
//I had to implement a move method to test the program but i commented out
//		since you instructions said not to. as is the program throws a error
//		when ever you try to call move().If there is supposed to be some trick 
//		to get around this, I don't know what it is.
	
//	public void move() {
//	}
}
