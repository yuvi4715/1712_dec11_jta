package assign_1_number_5;

public class OnlyMethods { //this class only contains methods, which will be called upon in the main class 

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
