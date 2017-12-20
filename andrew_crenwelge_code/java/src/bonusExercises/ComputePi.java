package bonusExercises;

public class ComputePi {

	public static void main(String[] args) {
		// allows computation of pi using the infinite sum below to a given number of steps
		computePi(100);
	}
	
	public static void computePi(int steps) {
		double myPi=0;
		// using the formula: PI = 4 * (1 - 1/3 + 1/5 + ... + Math.pow(-1, i + 1) / (2 * i - 1));
		for (int i=steps;i>0;i--) {
			myPi += Math.pow(-1, i+1) / (2*i-1);
		}
		myPi *= 4;
		System.out.println("My calculation of Pi: "+ myPi);
		System.out.println("Java Math.PI constant: "+ Math.PI);
		System.out.println("% difference: " + (Math.abs((Math.PI - myPi)/Math.PI*100))+"%");
	}

}
