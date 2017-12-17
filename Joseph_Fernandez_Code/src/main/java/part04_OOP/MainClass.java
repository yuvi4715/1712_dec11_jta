package part04_OOP;

public class MainClass {
	
	public static void main(String[] args) {
		
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
//		one.walk();		// -- The method walk() is undefined for the type Animal
		
		System.out.println();
		
		two.eat();
		two.move();
		Mammal.walk();
		
		System.out.println();
		
		three.eat();
		three.move();
		Human.walk();
		
	}
	
}
