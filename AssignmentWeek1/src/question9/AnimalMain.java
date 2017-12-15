package question9;

public class AnimalMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
		// one.walk(); Cannot call walk because it's not part of the interface
		
		two.eat();  //The human eat is called 
		two.move(); //Had to implement. Left empty so no results from method
		two.walk(); // Static method, mammal method called regardless of being part of Animal interface
		
		three.eat(); //The human eat is called
		three.move();
		three.walk(); // Static method, human method called regardless of being part of Animal interface
		//Couldn't fully test these out, move function wasn't implemented.
	}
}
