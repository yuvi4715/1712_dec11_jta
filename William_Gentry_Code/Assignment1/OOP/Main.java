package OOP;

public class Main {
	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		System.out.println("Human declared as Animal");
		one.eat();	//Even though declared as Animal, implements the Human method walk
		one.move();
		//one.walk();		Does not work because walk is implemented in Mammal and Human classes, declared as Animal
		System.out.println("\n");
		System.out.println("Human declared as Mammal");
		two.eat();  //Even though declared as Mammal, implements the Human method walk
		two.move();  
		Mammal.walk(); 
		System.out.println("\n");
		System.out.println("Human declared as Human");
		three.eat();
		three.move();
		Human.walk();
	}
}
