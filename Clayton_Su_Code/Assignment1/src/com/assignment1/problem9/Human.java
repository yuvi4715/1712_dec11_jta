package com.assignment1.problem9;

public class Human extends Mammal{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
	}

	@Override
	public void eat() {
		System.out.println("Human eats");
	}
	
	public static void walk()
	{
		System.out.println("Human walks");
	}
	
	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat(); //human eats
		//one.walk();doesn't work
		one.move(); //nothing not implemented
		
		two.eat(); //human eats
		two.walk(); //should be accessed in static way, mammal walks
		two.move(); //nothing
		
		three.eat(); //human eats
		three.walk(); //should be accessed in static way, human walks
		three.move(); //nothing
		
	}
	
}
