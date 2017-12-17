package part11_AdvancedExercises;

public class FibonacciSeq {

	public static void main(String[] args) {

		int n1 = 0;
		int n2 = 1;

		System.out.print(n1 + " " + n2);
		
		// Starts at 2 because first two numbers are already printed above
		for (int i = 2; i < 100; ++i)
		{
			int n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}
	}
}
