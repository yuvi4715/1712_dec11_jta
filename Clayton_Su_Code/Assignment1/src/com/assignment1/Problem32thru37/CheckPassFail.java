package com.assignment1.Problem32thru37;

public class CheckPassFail {

	public static void checkPassFail(int x)
	{
		if(x >= 50)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
	}
	
	public static void main(String[] args) {
		int mark = 49;
		
		checkPassFail(mark);
		
		mark = 50;
		checkPassFail(mark);
	}

}
