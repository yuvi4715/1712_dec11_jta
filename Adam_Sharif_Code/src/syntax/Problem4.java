package syntax;

public class Problem4 {

	public static void main(String[] args) {
		int num3 = 5;
		int num4 = 15;
		add(num3, num4);
		subtract(num3, num4);
		multiply(num3, num4);
		divide(num3, num4);
		
	}
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
