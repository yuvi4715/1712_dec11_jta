package Syntax;

//4, 5
public class CalcClient {
	public static void main (String[] args) {
		int a = 6;
		int b = 2;
		System.out.println(BasicCalc.add(a, b));
		System.out.println(BasicCalc.subtract(a, b));
		System.out.println(BasicCalc.multiply(a, b));
		System.out.println(BasicCalc.divide(a, b));
	}
}
