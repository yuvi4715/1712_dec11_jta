package OOP;

public abstract class Mammal implements Animal {
	public void eat() {
		System.out.println("eating");
	}
	public abstract void move();
	public static void walk() {
		System.out.println("walking");
	}
}
