//Antonio Dotson
public class PrintNumberInWord {
//Problem 34
	public static void main(String[] args) {
	// created an array to hold numbers 
		int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10}; 
         // send numbers through a loop 
		
		for (int x=0; x<intArray.length; x++) {
            // got the number 
			int newNum = intArray[x];
			// test value and print out number with a switch statement.
		switch (newNum) {

		case 1 :
		     System.out.println("One");
		     break;

		case 2 :
		     System.out.println("Two");
		     break;

		case 3 :
		     System.out.println("Three");
		     break;

		case 4 :
		     System.out.println("Four");
		     break;

		case 5 :
		     System.out.println("Five");
		     break;

		case 6 :
		     System.out.println("Six");
		     break;

		case 7 :
		     System.out.println("Seven");
		     break;

		case 8 :
		     System.out.println("Eight");
		     break;

		case 9 :
		     System.out.println("Nine");
		     break;


		default:
		     System.out.println("Other");
		}
	  }
	}
}
