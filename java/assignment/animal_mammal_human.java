package com.revature.day1;

public class animal_mammal_human {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		
		one.eat();  //interface methods cannot be defined
		one.move();  //ditto
		one.walk(); //no walk method was specified for animal
		
		two.eat();
		two.move();
		two.walk();
		
		three.eat();
		three.move();
		three.walk();
	}

}
