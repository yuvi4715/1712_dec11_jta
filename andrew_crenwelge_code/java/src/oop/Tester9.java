package oop;

public class Tester9 {

	public static void main(String[] args) {
		Animal9 one = new Human();
		one.eat();
		one.move();
		// one.walk(); // this will NOT work - animal9 interface does not have a walk method
		Mammal9 two = new Human();
		two.eat();
		two.move();
		// two.walk(); // this should be called like: Mammal9.walk()
		Human three = new Human();
		three.eat();
		three.move();
		// three.walk(); // this should be called like: Human.walk()
	}

}
