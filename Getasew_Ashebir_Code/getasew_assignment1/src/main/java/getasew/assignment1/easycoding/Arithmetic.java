package getasew.assignment1.easycoding;
/*
 *36. Write a program called Arithmetic that takes three command-line arguments: 
 * two integers followed by an arithmetic operator (+, -, * or /).
 *  The program shall perform the corresponding operation 
 *  on the two integers and print the result.

 */

public class Arithmetic {
	public static void main(String[] args) {
		if(args.length<3) {
			System.out.println("Enter the right number of input");
		}
		performArthimetic(args[0],args[1],args[2]);
		
	}
	public static void performArthimetic(String a,String b,String op) {
		if (op.equals("+")) {
			System.out.println(Integer.parseInt(a)+ Integer.parseInt(b));
		} else if(op.equals("-")){
			System.out.println(Integer.parseInt(a)-Integer.parseInt(b));
		} else if(op.equals("*")) {
			System.out.println(Integer.parseInt(a)*Integer.parseInt(b));
		} else {
			System.out.println(Integer.parseInt(a)/Integer.parseInt(b));
		}
	}

}
