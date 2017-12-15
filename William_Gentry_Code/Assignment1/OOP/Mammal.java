package OOP;

abstract class Mammal implements Animal {

	public void eat() {
		System.out.println("I'm a Mammal and I eat to be able to feed my children!");
	}
	
	public static void walk() {
		System.out.println("I can walk, if I am a Mammal that has legs!");
	}
	
	public abstract void move();
}
