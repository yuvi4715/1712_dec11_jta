package coreJava;

public class CoreJava3 {
	/*
	 * Write a program – declare two variables a & b and initialize 
	 * them to true and false respectively. Get the output of 
	 * the following computations:
     *   !a
     *   a | b    
     *   (!a & b) | (a & !b)
	 */

	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		System.out.println("!a = " + !a);
		System.out.println("a | b = "+(a | b));
		System.out.println("(!a & b) | (a & !b) = "+((!a & b) | (a & !b)));
	}

}
