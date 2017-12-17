package part04_OOP;

public abstract class Mammal implements Animal {

	public static void walk() {
		System.out.println("The Mammal is Walking.");
	}
	
	public void eat() {
		System.out.println("The Mammal is Eating.");
	}
	
	public abstract void move();
	
}
