package Syntax;

public class Calculator {

	//just a simple calculator with no return types, hate me.
	void add(int x, int y) {
		System.out.printf("The answer is: %d\n",(x+y));
	}
	
	void substract(int x, int y) {
		System.out.printf("The answer is: %d\n",(x-y));
	}
	
	void multiply(int x, int y) {
		System.out.printf("The answer is: %d\n",(x*y));
	}
	
	void divide(float x, float y) {
		//added a check to make sure that the user is not entering an incorrect value
		if(x < y) {
			System.out.println("x cannot be less than y");
		}
		else {
			float answer = x / y;
			System.out.printf("The answer is: %f\n",answer);
		}
	}
	
	
}
