package easyCodingExercises;

public class Arithmetic {
	
	public static void main(String[] args) {
		int firstInt = 0;
		int secondInt = 0;
		String operator = args[2];
		
		
		
		if (testForInt(args[0])) {
			firstInt = Integer.parseInt(args[0]);
		} 
		if (testForInt(args[1])) {
			secondInt = Integer.parseInt(args[1]);
		}
		
		if (operator.equals("+")) {
			System.out.println(firstInt + " + " + secondInt + " = " + (firstInt + secondInt));
		} else if (operator.equals("-")){
			System.out.println(firstInt + " - " + secondInt + " = " + (firstInt - secondInt));
		} else if (operator.equals("*")) {
			System.out.println(firstInt + " * " + secondInt + " = " + (firstInt * secondInt));
		} else if (operator.equals("/")) {
			System.out.println(firstInt + " / " + secondInt + " = " + (firstInt / secondInt));
		} else {
			System.out.println("Operator must be +, -, *, or /");
		}
		
	}
	
	
	public static boolean testForInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
