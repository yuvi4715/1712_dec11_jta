package bonusExercises;

public class ApproximatingPi {

	
	/*
	 * Scratch work
	 * 
	 * pi / 4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 + .....
	 * 
	 * alternating harmonic series after first term of odd natural integers
	 * 
	 * 
	 * 
	 * For:
	 * i = 1 ==> 1 = -1^(i + 1) / (2i -1) <==> 1 / (2-1) = 1
	 * i = 2 ==> -1/3 = -1^(i + 1) / (2i - 1) <==> -1 / (4-1) = -1/3
	 * ....
	 * i = n ==> Math.pow(-1, n + 1) / (2n - 1) 
	 * 
	 */
	
	final static String percentSign = "%";
	
	static void printMyPiValue(int iterations) {
		double pi = 0;
		for (int i = 1; i < iterations; i++) {
			pi += Math.pow(-1, i + 1) / (2 * i - 1);
		}
		System.out.printf("Pi Approximated (%d iterations): %f\n", iterations, myPiValue(iterations));
	}
	
	static double myPiValue(int iterations) {
		double pi = 0;
		for (int i = 1; i < iterations; i++) {
			pi += Math.pow(-1, i + 1) / (2 * i - 1);
		}
		return pi * 4;
	}
	
	
	static void percentAccuracy(double myPi, double jvmPI) {
		System.out.printf("Accuracy compared to Math.PI: %.5f%s\n\n", ((myPi / jvmPI) * 100), percentSign);
	}
	
	static void computePi(int iterations) {
		double jvmPI = Math.PI;
		printMyPiValue(iterations);
		percentAccuracy(myPiValue(iterations), jvmPI);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("My Pi approximation will always be an over or under estimate");
		System.out.println("based on if the number of iterations is odd or even");
		System.out.println("due to the nature of an alternating harmonic geometric series\n");
//		computePi(5);
//		computePi(10);
		computePi(55);
		computePi(100);
//		computePi(151);
//		computePi(507);
		computePi(999);
		computePi(1000);
	}
}
