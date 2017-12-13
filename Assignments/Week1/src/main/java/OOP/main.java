package OOP;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal aone = new Human();
		Mammal mone = new Human();
		Human hone = new Human();
		
		Animal atwo = new Mammal();
		Mammal mtwo = new Mammal();
		
		System.out.println("Checking Animal One");
		aone.eat();
		aone.move();
		System.out.println("\nChecking Animal Two");
		atwo.eat();
		atwo.move();
		System.out.println("\nChecking Mammal One");
		mone.eat();
		mone.move();
		mone.walk();
		System.out.println("\nChecking Mammal Two");
		mtwo.eat();
		mtwo.move();
		mtwo.walk();
		System.out.println("\nChecking Human One");
		hone.eat();
		hone.move();
		hone.walk();
		System.out.println("\nHuman Two will not run since Mammal does not extend Human!");
		
	}

}
