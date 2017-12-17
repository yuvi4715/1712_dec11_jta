package assign_1;

public class Number4 {
	
	static int x = 15; // creates a static integer x and assigns the value 15
	static int y = 5;

	public static void main(String[] args) {
		new Number4().addNumbers(x, y); // creates a new instance and calls addNumbers method on it
		new Number4().subtractNumbers(x, y);
		new Number4().multiplyNumbers(x, y);
		new Number4().divideNumbers(x, y);
		
		
	}
	
	public void addNumbers (int x, int y) { // takes 2 integers (x and y) and adds them up, printing the sum
		System.out.println("The sum of int x and int y is: " + (x + y));
	}
	
	public void subtractNumbers (int x, int y) { // takes 2 integers (x and y) and finds the difference between them, printing the difference
		System.out.println("The difference between int x and int y is: " + (x - y));
	}
	
	public void multiplyNumbers (int x, int y) { // takes 2 integers (x and y) and multiplies them, printing the product
		System.out.println("The product of int x and int y is: " + (x * y));
	}
	
	public void divideNumbers (int x, int y) { // takes 2 integers (x and y) and divides them, printing the quotient
		System.out.println("The quotient of int x and int y is: " + (x / y));
	}

}
