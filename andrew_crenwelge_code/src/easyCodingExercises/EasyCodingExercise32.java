package easyCodingExercises;

public class EasyCodingExercise32 {

	public static void main(String[] args) {
		/*
		 * Write a program called CheckPassFail which prints 
		 * "PASS" if the int variable "mark" is more than or equal to 50; 
		 * or prints "FAIL" otherwise.
		 */
		int mark = 51;
		checkPassFail(mark);
	}
	
	private static void checkPassFail(int mark) {
		if (mark >= 50)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
	}

}
