package CoreJava;

public class Calculator {

	private int c = 6;
	private int d = 7;
	private int e = 5;
	
	//here i am doing a POC for short circuit operators, some may fire some may not.
	
	void message() {
		
		if(c < d && d < e) {	
			System.out.printf("E is the greatest number with a value of %d\n",e);
		}
		
		if(c > d && d <e) {
			System.out.printf("C is the greatest number with a value of %d\n",c);
		}
		
		if(c < d && d > e) {
			System.out.printf("D is the greatest number with a value of %d\n",d);
		}
		
		if(c < d && d > e || c < d && d < e) {
			System.out.printf("D and E are the greater numbers! With values of %d and %d\n",d,e);

		}
				
	}
	
    //double customDivideException(int num1, int num2) throws CustomException {
    //    if (num2 == 0) {
    //        throw new CustomException("");
    //    } else {
    //        return num1 / num2;
    //    }
    // }
    
	//this class has hard coded values that will display their values
	//i did not add a return type to make a little bit more manageable during run time
	
	void hardcodedCalculator() {
		System.out.printf("The answer is: %d\n",(10+5));
		System.out.printf("The answer is: %d\n",(10-5));
		System.out.printf("The answer is: %d\n",(10*5));
		System.out.printf("The answer is: %d\n",(10/5));



	}

	private static Boolean a = true;
	private static Boolean b = false;

	//here we are displaying the boolean values that i set
	void displayBooleanValues() {
		
		System.out.println(!a);
		System.out.printf("%1b | %2b",a,!b);
		System.out.println("");
		System.out.printf("(%1b & %2b) | (%3b & %5b)", !a, !b, a,b);
	}
	
}