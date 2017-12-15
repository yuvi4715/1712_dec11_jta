package bonusExercises;

public class swapIntegers {

	static void swap(int a, int b) {
		System.out.println("initially, a = " + a + " and b = " + b);
		System.out.println("Swapping......");
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println("Swapped: a = " + a + " and b = " + b );
	}

	
	public static void main(String[] args) {
		swap(1, 3);
	}
}
