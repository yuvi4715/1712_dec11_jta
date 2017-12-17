package part01_CoreJava;

public class CoreJava {

	public static void main(String[] args) {
		System.out.println("--------Number 01--------");
		Number01();
		
		System.out.println("--------Number 02--------");
		Number02();
		
		System.out.println("--------Number 03--------");
		Number03();
	}
	
	// Add, Subtract, Multiply, and Divide two hard coded numbers
	public static void Number01() {
		
		int num1 = 5, num2 = 10;

		// ADDITION
		int sum = num1 + num2;
		System.out.println("Sum = " + sum);

		// SUBTRACTION
		int difference = num2 - num1;
		System.out.println("Difference = " + difference);

		// MULTIPLICATION
		int product = num1 * num2;
		System.out.println("Product = " + product);

		// DIVISION
		int quotient = num2 / num1;
		System.out.println("Quotient = " + quotient);
	}

	// Search for the highest and lowest number using Short-Circuit Operators
	public static void Number02() {
		
		int x = 3, y = 15, z = 6;
		int greatest, least;

		if (x >= y && x >= z) {
			greatest = x;
		} else if (y >= x && y >= z) {
			greatest = y;
		} else {
			greatest = z;
		}

		if (x <= y && x <= z) {
			least = x;
		} else if (y <= x && y <= z) {
			least = y;
		} else {
			least = z;
		}
		System.out.println("Greatest: " + greatest);
		System.out.println("Least: " + least);
	}
	
	// Bit-Wise Operators
	public static void Number03() {

		boolean a = true, b = false;

		// NOT true
		System.out.println(!a);

		// true OR false
		System.out.println(a | b);

		// (NOT true AND false) OR (true AND NOT false)
		System.out.println((!a & b) | (a & !b));
	}
	
}
