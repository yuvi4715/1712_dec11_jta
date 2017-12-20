package syntax;

public class Syntax5controller {
	/*
	 * In one project, create two classes. One class should contain 
	 * only methods (add, subtract, multiply and divide). The other 
	 * class should contain only the main() method which calls each 
	 * of the methods from the previous class.
	 */

	public static void main(String[] args) {
		// declare ints
		int x = 1; int y = 2;
		
		// use Syntax5methods to perform operations
		System.out.println("add: "+Syntax5methods.add(x,y));
		System.out.println("subtract: "+Syntax5methods.subtract(x,y));
		System.out.println("multiply: "+Syntax5methods.multiply(x,y));
		System.out.println("divide: "+Syntax5methods.divide(x,y));
	}

}
