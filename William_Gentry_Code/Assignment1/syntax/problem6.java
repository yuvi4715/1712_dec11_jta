package syntax;


//Provide an example for each control statement
public class problem6 {
	
	//for if/else statement
	static boolean value = true;
	
	//For if/else if/else statement
	static int number = 0;
	
	
	//to be used with switch statement
	public static enum DAY {MON, TUE, WED, THURS, FRI, SAT, SUN};
	
	
	public static void main(String[] args) {
		System.out.println("Example of if/else statement:");
		if (value) {
			System.out.println("This statement printed because the if condition is true");
		} else {
			System.out.println("This statement printed because the if condition is false");
		}
		System.out.println("\n");
		
		System.out.println("Example of if/else if/else statement: ");
		if (number == 0) {
			System.out.println("The number is 0");
		} else if (number < 0) {
			System.out.println("The number is negative");
		} else {
			System.out.println("The number is positive");
		}
		System.out.println("\n");
		
		System.out.println("Example of a switch statement: ");
		DAY today = DAY.MON;
		switch(today){
		case MON:
			System.out.println("Today is Monday!");
			break;
		case TUE:
			System.out.println("Today is Tuesday!");
			break;
		case WED:
			System.out.println("Today is Wednesday!");
			break;
		case THURS:
			System.out.println("Today is Thursday!");
			break;
		case FRI:
			System.out.println("Hooray! Today is Friday!");
			break;
		case SAT:
			System.out.println("Today is Satruday!");
			break;
		case SUN:
			System.out.println("Yay! NFL plays on Sunday!");
			break;
		default:
			System.out.println("Input not recognized.");
		}
		System.out.println("\n");
		
		System.out.println("Example of a 'for' loop");
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println("\n");
		
		System.out.println("Example of a 'while' loop");
		int j = 0;
		int k = 10;
		while (j < k) {
			System.out.println("Run number " + j + " in the while loop");
			j++;
		}
		System.out.println("\n");
		
		
		System.out.println("Example of a 'do-while' loop");
		int a = 0;
		int b = 10;
		do {
			System.out.println("Do-While loops execute atleast once, and will continue to execute while the 'while' condition is true");
			a++;
		} while (a < b);
	}

}
