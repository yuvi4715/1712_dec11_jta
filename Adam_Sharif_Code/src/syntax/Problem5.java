package syntax;
class MethodClass {
	public static int add(int number3, int number4) {
		int add = number3 + number4;
		return add;
	}

	public static int subtract(int number3, int number4) {
		int subtract = number3 - number4;
		return subtract;
	}

	public static int multiply(int number3, int number4) {
		int multiply = number3 * number4;
		return multiply;
	}

	public static int divide(int number3, int number4) {
		int divide = number4 / number3;
		return divide;
	}

}

public class Problem5 {

	public static void main(String[] args) {
		int num3 = 10;
		int num4 = 30;
		MethodClass.add(num3, num4);
		MethodClass.subtract(num3, num4);
		MethodClass.multiply(num3, num4);
		MethodClass.divide(num3, num4);

	}

}
