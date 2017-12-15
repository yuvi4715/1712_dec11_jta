package com.assignment1.problem10thru15;

public class BadWordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		String msg = "Bad Word Exception";
		return msg;
	}

	public static void badWord() throws BadWordException {
		String badWord = "zippo";

		System.out.println("saying badWord");

		if (badWord == "zippo") {
			System.out.println("throwing exception for badword");
			//System.exit(0); stops everything
			throw new BadWordException();
			
			//ducking
		}
	}


	public static void main(String[] args)  {
		System.out.println("Starting try block");
		try {
			System.exit(0); //just stops program
			badWord();
			System.out.println("End try block");
			System.exit(0); //doesn't happen
		} catch (BadWordException a) {
			System.out.println("starting catch block");
			System.out.println("BadWord detected, badWord exception thrown");
			System.out.println("End catch block");
			//handle exception in main
		}finally
		{
			System.out.println("graisfull gudbai");
		}
		
		
	}
}
