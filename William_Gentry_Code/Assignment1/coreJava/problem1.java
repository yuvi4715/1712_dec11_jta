package coreJava;

public class problem1 {

	public static double add(double a, double b) {
		return a + b;
	}
	
	public static double subtract(double a, double b) {
		return a - b;
	}
	
	public static double multiply(double a, double b) {
		return a * b;
	}
	
	public static double divide(double a, double b) {
		return a / b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 3;
		double b = 14;
		System.out.println("Hardcoded values: a = " + a + " b = " + b);
		System.out.println("Result for add(a, b) is " + add(a, b));
		System.out.println("Result for subtract(a, b) is " + subtract(a,b));
		System.out.println("Result for multiply(a, b) is " + multiply(a, b));
		System.out.println("Result for divide(a, b) is " + divide(a, b));
	}

}
