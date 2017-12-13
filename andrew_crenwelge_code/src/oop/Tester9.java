package oop;

public class Tester9 {

	public static void main(String[] args) {
		Animal9 one = new Human();
		one.eat();
		one.move();
		one.walk();
		Mammal9 two = new Human();
		two.eat();
		two.move();
		two.walk();
		Human three = new Human();
		three.eat();
		three.move();
		three.walk();
	}

}
