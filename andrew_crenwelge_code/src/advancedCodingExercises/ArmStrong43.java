package advancedCodingExercises;

public class ArmStrong43 {

	public static void main(String[] args) {
		/*
		 * Write a Java program to check if a number is Armstrong or not.
		 */
		
		// Definition of Armstrong/narcissistic number:
		// a number that is the sum of its own digits each raised to the power of the number of digits
		System.out.println(checkArmstrong(371));
		System.out.println(checkArmstrong(461));
	}
	
	private static boolean checkArmstrong(int n) {
		int sum=0;
		String str = Integer.toString(n);
		String[] arr = str.split("");
		for (int i=0;i<arr.length;i++) {
			int digit = Integer.valueOf(arr[i]);
			sum += Math.pow(digit, arr.length);
		}
		if (n == sum)
			return true;
		else
			return false;
	}
}
