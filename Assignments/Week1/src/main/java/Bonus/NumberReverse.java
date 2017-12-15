package Bonus;

public class NumberReverse {

	public static void main(String[] args) {

		reverse(2584);	
	}
	
	private static void reverse(int number) {
		int temp = 1;
		int result = 0;
		while(temp <= number) {
			result = result * 10 + number % 10;
			number = number / 10;
			
		}
		
		System.out.println(result);	
	}
}
