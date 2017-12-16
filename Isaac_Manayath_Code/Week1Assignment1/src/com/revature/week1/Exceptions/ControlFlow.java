package com.revature.week1.Exceptions;

public class ControlFlow {

	public static void main(String [] args) {
			
		//Starts try execution
		try {
			System.out.println("Starting try block");
			
			int problem = 50/0;
			
			
		//Ends try excution
		}catch(ArithmeticException e){
			
			System.out.println("Ending try block");
			
			System.out.println("Starting catch block");
			
			System.out.println(e);
			
			System.out.println("Ending catch block");
			
		}
			 
			  
	}
	
}
