package sample;

public class Syntax4 {

	public static void main(String[] args) {
		double x = 1;
		double y = 2;
		System.out.println("The sum of "+x+" and "+y+" is "+Syntax4.add(1, 2));
		System.out.println("The difference between "+x+" and "+y+" is "+Syntax4.subtract(1, 2));
		System.out.println("The product of "+x+" and "+y+" is "+Syntax4.multiply(1, 2));
		System.out.println("The division of "+x+" and "+y+" is "+Syntax4.divide(1, 2));
	}
	
	public static double add(double x, double y) {
		return x + y;
	}
	
	public static double subtract(double x, double y) {
		return x - y;
	}

	public static double multiply(double x, double y) {
		return x * y;
	}
	
	public static double divide(double x, double y) {
		return x / y;
	}

}
