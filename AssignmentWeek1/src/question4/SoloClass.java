package question4;

public class SoloClass {

	public static void main(String[] args) {
		System.out.println(SoloClass.add(3,4));
		System.out.println(SoloClass.subtract(3, 4));
		System.out.println(SoloClass.multiply(3, 4));
		System.out.println(SoloClass.divide(4, 3));

	}

	static int add(int a, int b) {
		return a + b;
	}

	 static int subtract(int a, int b) {
		return a - b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}

	static int divide(int a, int b) {
		return a / b;
	}

}
