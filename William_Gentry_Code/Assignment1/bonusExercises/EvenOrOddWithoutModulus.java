package bonusExercises;

public class EvenOrOddWithoutModulus {

	
	static void evenOrOdd(int n) {
		if (n > -1) {
			if (n == 1) {
				System.out.println("odd");
			} else if (n == 0) {
				System.out.println("even");
			} else {
				evenOrOdd(n -=2);
			}
		} else {
			if (n == 1) {
				System.out.println("odd");
			} else if (n == 0) {
				System.out.println("even");
			} else {
				evenOrOdd(n +=2);
			}
		}
	}
	
	public static void main(String[] args) {
		evenOrOdd(-23);
	}
}
