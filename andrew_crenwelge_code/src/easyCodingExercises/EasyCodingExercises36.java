package easyCodingExercises;

public class EasyCodingExercises36 {

	public static void main(String[] args) {
		/*
		 * Write a program called Arithmetic that takes three 
		 * command-line arguments: two integers followed by an 
		 * arithmetic operator (+, -, * or /). The program shall 
		 * perform the corresponding operation on the two integers 
		 * and print the result.
		 */
		
		int fstInt = Integer.valueOf(args[0]);
		int sndInt = Integer.valueOf(args[1]);
		String op = args[2];
		switch(op) {
			case "+": System.out.println(fstInt + sndInt); break;
			case "-": System.out.println(fstInt - sndInt); break;
			case "*": System.out.println(fstInt * sndInt); break;
			case "/": float a=(float) fstInt/sndInt; System.out.println(a); break;
			default: System.err.println("Invalid operator");
		}
	}
	

}
