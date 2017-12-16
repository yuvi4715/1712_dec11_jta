
public class  Human extends Mammal  {

	// Problem number 9 which includes the Animal interface, and the Mammal class

	@Override
	public void move() {
		System.out.println("Humans move slower than most Animals");
		
	}
	
	public void eats() {
		System.out.println("Humans eat slower than Animals");
		
	}
	
	public static void walk() {
		System.out.println("Humans walk slower than most Animals");
	}
	
	public static void main(String[] args) {
		
		Animal One = new Human();
		Mammal two = new Human();
		Human Three = new Human();
		
	One.eat();
	two.eat();
	Three.eat();
	
	One.move();
	two.move();
	Three.move();
	
	//One.walk(); ----- Animal does not have the ability to walk 
	two.walk();
	Three.walk();
		
		
	}

}
