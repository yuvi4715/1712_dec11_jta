package EasyCodingExercises;
import java.util.*;
public class KeyBoardScanner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyBoardScanner().run();
	}
	
	public void run() {
		Scanner reader = new Scanner(System.in);
		try {
			System.out.println("Please enter a regular number, no decimal: ");
			int number = reader.nextInt();
			System.out.println("You entered: " + number);
			
			System.out.println("Please enter a number, it can decimals if you would like: ");
			double number2 = reader.nextDouble();
			System.out.println("You entered: " + number2);
			
			System.out.println("Enter any values you want, it can be a string or an integer: ");
			String userInput = reader.next();
			System.out.println("You entered: " + userInput);
			
		}catch(InputMismatchException ex) {
			System.out.println("You did not enter a correct value...exiting");
			System.exit(1);;
		}
	}

}
