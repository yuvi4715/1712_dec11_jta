package EasyCodingExercises;

public class Arithmetic {

	/*
	 * Write a program called Arithmetic that takes three command-line arguments:
	 * two integers followed by an arithmetic operator (+, -, * or /). The program
	 * shall perform the corresponding operation on the two integers and print the
	 * result.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =0,b = 0;
		String operator;

		if (args.length > 3) {
			System.out.println("You need to enter 3 aguments, two numbers and either or (+,-,*, or /)");
		} else {
			
			if(intTryParse(args[0])) {
				a = Integer.parseInt(args[0]);
			}
			if(intTryParse(args[1])) {
				b = Integer.parseInt(args[1]);
			}
			
			operator = args[2];
			
			switch (operator) {
			case "+":
				System.out.println("The answer is: "+ (a+b));		
				break;
			case "-":
				System.out.println("The answer is: "+ (a-b));		
				break;
			case "*":
				System.out.println("The answer is: "+ (a*b));		
				break;
			case "/":
				System.out.println("The answer is: "+ (a/b));		
				break;
			default:
				break;
			}
		}

	}
	
	
	private static boolean intTryParse(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
