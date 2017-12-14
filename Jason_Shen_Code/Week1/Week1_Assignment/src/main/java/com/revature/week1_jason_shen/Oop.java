package com.revature.week1_jason_shen;

public class Oop {
	// 9. Create an Animal interface with two methods: eat() and move(). 
	//    Write a class called Mammal that implements Animal and the eat() but does not implement
	//    move(). Mammal should also have a static method called walk(). Create a Human class that extends Mammal, 
	//    overrides eat() and has a static method called walk(). Create two objects as follows:
	
	//    Animal one = new Human(); 	Mammal two = new Human(); 	Human three = new Human();
	//    Call each of the methods for each of the objects: eat(), move(), walk(). Note the results.

	public class Mammal implements Animal {

		public void eat(String food) {
			System.out.println(food + " is delicious!");
			return;
		}

		public void move() {
			// TODO Auto-generated method stub
			
		}
		
		public void walk(int num_steps) {
			System.out.println("Walked " + num_steps + " steps!");
			return;
		}

	}
	
	public class Human extends Mammal {
		
		public void eat(String food) {
			System.out.println("Overriden - " + food + " is nomz");
			return;
		}
		
		public void walk(int num_steps) {
			System.out.println("I'm a human. Walking " + num_steps + " steps.");
			return;
		}
	}
}
