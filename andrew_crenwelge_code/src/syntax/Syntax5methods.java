package syntax;

public class Syntax5methods {
	/*
	 * In one project, create two classes. One class should contain 
	 * only methods (add, subtract, multiply and divide). The other 
	 * class should contain only the main() method which calls each 
	 * of the methods from the previous class.
	 */
	public static int add(int x, int y) {
		return x + y;
	}
	public static int subtract(int x, int y) {
		return x - y;
	}
	public static int multiply(int x, int y) {
		return x * y;
	}
	public static float divide(int x, int y) {
		// have to cast to float so that return value is accurate
		float x1 = (float) x;
		float y1 = (float) y;
		return x1 / y1;
	}
}
