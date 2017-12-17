
public class OOP_Question_9 {
	public interface Animal {
		public void eat();
		public void move();
	}
	public static class Mammal implements Animal{
		public void eat(){
			System.out.println("Mammal eats");
		}
		static void walk() {
			System.out.println("Mammal walks");
		}
		public void move() {
		}
	}
	public static class Human extends Mammal{
		public void eat() {
			System.out.println("Human eats");
		}
		static void walk() {
			System.out.println("Human eats");
		}
		public void move() {
		}
	}
	
	public static void main(String[] args) {
		//Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		System.out.println("Animal is not a class so you cannot instantiate an object of Animal.");
		
		two.eat();
		two.walk();
		three.eat();
		three.walk();
		
		System.out.println("two.eat() and three.eat() both call the Human class's method because Mammal two and Human three are both Humans.");
		System.out.println("walk() does not get called because it was not in the interface.");
	}
}
