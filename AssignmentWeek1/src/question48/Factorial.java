package question48;
public class Factorial {
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
	public static int factorial(int f) {
		if(f > 1) {
			f *= factorial(--f);
		}
		return f;
	}
}
