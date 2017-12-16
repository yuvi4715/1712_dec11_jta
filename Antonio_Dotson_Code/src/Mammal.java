
public abstract class Mammal implements Animal {
//A part of problem 9 created two methods and override eat()
	@Override
	public void eat() {		
		System.out.println("I can eat");
	}
   
	static void walk() {
		System.out.println("I can walk");
	}
}
  