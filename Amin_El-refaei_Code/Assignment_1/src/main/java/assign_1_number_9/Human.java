package assign_1_number_9;

public class Human extends Mammal{ // created class human which extends mammal
	
	@Override 
	public void eat() { // overrides the inherited method eat, and prints something different
		System.out.println("Humans are mammals, therefore they also eat many things");
	}
	
	static void walk() { // created static method walk, and prints something
		System.out.println("Humans only have 2 feet, therefore they can only walk on 2 feet");
	}
}
