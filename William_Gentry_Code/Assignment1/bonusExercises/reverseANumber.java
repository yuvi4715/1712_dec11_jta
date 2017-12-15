package bonusExercises;

public class reverseANumber {

	static void reverseNum(int n) {
		String reversed = "";
		System.out.println("Original: " + n);
		for (int i = n; i > 0; i/=10) {
			int digit = i%10;
			reversed += digit;
		}
		System.out.println("Reversed: " + Integer.parseInt(reversed));
	}
	
	public static void main(String[] args) {
		reverseNum(1234);
	}
}
