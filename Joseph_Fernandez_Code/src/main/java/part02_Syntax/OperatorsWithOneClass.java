package part02_Syntax;


// Question 04
public class OperatorsWithOneClass {

	public static void main(String[] args) {
		
		int num1 = 5, num2 = 52;

		System.out.println("-------- Sum --------");
		new OperatorsWithOneClass();
		System.out.println(OperatorsWithOneClass.getSum(num1, num2));

		System.out.println("-------- Difference --------");
		new OperatorsWithOneClass();
		System.out.println(OperatorsWithOneClass.getDiff(num1, num2));

		System.out.println("-------- Product --------");
		new OperatorsWithOneClass();
		System.out.println(OperatorsWithOneClass.getProduct(num1, num2));

		System.out.println("-------- Quotient --------");
		new OperatorsWithOneClass();
		System.out.println(OperatorsWithOneClass.getQuotient(num1, num2));
	}
	
	public static int getSum(int a, int b) {
		int sum = a + b;
		return sum;
	}
	
	public static int getDiff(int a, int b) {
		int difference = b - a;
		return difference;
	}
	
	public static int getProduct(int a, int b) {
		int product = a * b;
		return product;
	}
	
	public static int getQuotient(int a, int b) {
		int quotient = b / a;
		return quotient;
	}
	
}
