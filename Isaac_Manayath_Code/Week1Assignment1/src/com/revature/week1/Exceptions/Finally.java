package com.revature.week1.Exceptions;

public class Finally {

	public static void main(String [] args) {
		
	try {
		
		int problem = 50/0;
		
	}catch(ArithmeticException e){
		
		System.out.println(e);
		
	}finally {
		
		System.out.println("This is a goodbye exception message");
		 
	}

}
}
