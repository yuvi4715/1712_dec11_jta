package sample;

public class CoreJava1 {
	public static void main(String[] args) {
		mathStuff(13.5d, 15.2d);
	}
	
	public static void mathStuff(double x, double y) {
		System.out.println("The two numbers are " + x + " and " + y);
		System.out.println("The sum of the two numbers is " + (x+y));
		System.out.println("The difference of the two numbers is " + (x-y));
		System.out.println("The product of the two numbers is " + (x*y));
		System.out.println("The division of the two numbers is " + (x/y));
	}

}
