package assign_1_number_9;

public class MainClass {

	public static void main(String[] args) {
		Animal one = new Human(); // created a human of type Animal
		Mammal two = new Human(); // created a human of type Mammal
		Human three = new Human(); // created a human of type Human
		
		one.eat(); // calls the eat method from Animal
		Human.walk(); // walk method is not defined in Animal interface. The only way this can work is if I make a static call to Human or Mammal
		one.move(); // calls the move method from Animal
		
		two.eat(); // calls the eat method from Mammal
		Mammal.walk(); // statically calls walk method from Mammal class
		two.move(); // calls the move method from Mammal
		
		three.eat(); // calls the eat method from Human
		Human.walk(); // statically calls walk method from Human class
		three.move(); // calls the move method from Human
	}

}
