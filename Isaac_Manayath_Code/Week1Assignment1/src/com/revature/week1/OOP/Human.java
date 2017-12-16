package com.revature.week1.OOP;

public class Human extends Mammal{

	//Overrided method for eat
	@Override
	public void eat() {
		System.out.println("The human eats");
	}
	
	//A walk method that states humans walks
	static void walk() {
		System.out.println("The human walks");
	}
	Animal one = new Human();
	//walk does not work since it is static
	//one.walk();
	//eat does not work because it is overrided
	//one.eat();
	//move does not work due to the fact it is not implemented
	///one.move();
	
	Mammal two = new Human();
	
	//walk does not work since it is static
	//two.walk();
	//eat does not work because it is overrided
	//two.eat();
	//move does not work due to the fact it is not implemented
	//two.move();
	
	Human three = new Human();
	
	//walk does not work since it is static
	//three.walk();
	//eat does not work because it is overrided
	//three.eat();
	//move does not work because the method does not exist
	//three.move();
	
}
