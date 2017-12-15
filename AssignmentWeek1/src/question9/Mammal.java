package question9;

public class Mammal implements Animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("The mammal is eating");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}
	
	public static void walk() {
		System.out.println("The mammal is walking");
	}

}
