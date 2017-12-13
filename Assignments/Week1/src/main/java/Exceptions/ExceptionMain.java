package Exceptions;

import java.io.IOException;

public class ExceptionMain {

	public static void main(String[] args) throws CustomExceptions, SecurityException, IOException {
		LogLevelClass lc = new LogLevelClass("info");

		// TODO Auto-generated method stub
		double answer = divide(5,2);
		if( answer < 5) {
			lc.errorMessage("This is the Error: " + answer);
			//log.log(Level.INFO,"The answer is wrong!");
			throw new CustomExceptions("Wrong number: " + answer);
		}
		
	}
	
	private static double divide(int x, int y) throws CustomExceptions{
		try {
			//System.out.println((x/y));
			return (x / y);
		}catch (ArithmeticException e) {
			throw new CustomExceptions("Numbers are not divisible");
		}		
	}
}
