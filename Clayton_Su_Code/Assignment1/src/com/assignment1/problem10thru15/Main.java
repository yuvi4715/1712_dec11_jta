package com.assignment1.problem10thru15;

public class Main {

	public void method()
	{
		try {
			throw new BadWordException();
		} catch (BadWordException e) {
			System.out.println("throwing bad word exception manually");
		}
		
	}
	
	public static void main(String[] args) {
		
	}

}
