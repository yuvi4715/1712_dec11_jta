package oop;

public class Mammal implements Animal{
	public void eat() {
		System.out.println("Mammal eats");
	}
	
	public void move() {
		System.out.println("Move does nothing");
	}
	
	public static void walk() {
		System.out.println("Mammal walks");
	}
}
