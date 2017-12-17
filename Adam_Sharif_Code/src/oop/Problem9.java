package oop;
interface Animal {
	public void eat();

	public void move();

}

abstract class Mammal implements Animal {
	public void eat() {
		System.out.println("Mammal eats");
	}

	static void walk() {
		System.out.println("Mammal is walking");
	}
}

class Human extends Mammal {
	public void move() {
		System.out.println("Human is moving");
	}

	static void walk() {
		System.out.println("Human is walking");
	}

	@Override
	public void eat() {
		System.out.println("Eating");
	}

}

public class Problem9 {

	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		one.eat();
		one.move();
		two.eat();
		two.move();
		two.walk(); 
		three.eat();
		three.move();
		three.walk();
	}

}
