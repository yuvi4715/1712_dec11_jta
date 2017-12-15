package OOP;
// 9
public class AnimalClient {
	public static void main(String[] args) {
		Animal animal = new Human();
		Mammal mammal = new Human();
		Human human = new Human();
		animal.eat();
		animal.move();
		mammal.eat();
		mammal.move();
		Mammal.walk();
		human.eat();
		human.move();
		Human.walk();
		// The results are an example of dynamic/runtime
		// polymorphism, where the method called is determined
		// at runtime.
	}
}
