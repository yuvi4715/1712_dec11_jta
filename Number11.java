package com.revature.day1;

public class Number11 {

	public static void main(String[] args) throws Number10, Exception{
		ExceptionTest();

	}

	public static void ExceptionTest() throws Number10 {
		throw new Number10();
	}
	
	public void testmethod() {
		
		try {
			//System.exit(0);
			System.out.print("starting try block");
			new ExceptionExample().printObject();
			System.out.print("ending try block");
		}
		catch(ArrayIndexOutOfBoundsException a) {
			System.out.print("catching out of bounds exception");
			a.printStackTrace();
		}
		catch(Exception e) {
			System.out.print("catching the other exception");
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("This is a graceful goodbye message");
		}
	}
	
}
