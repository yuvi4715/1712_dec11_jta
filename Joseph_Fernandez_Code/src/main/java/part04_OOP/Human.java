package part04_OOP;

public class Human extends Mammal {

	public static void walk() {
		System.out.println("The Human is Walking.");
	}

	public void move() {
		System.out.println("The Human is Moving.");
	}

	@Override
	public void eat() {
		System.out.println("The Human is Eating.");
	}
}
