package com.revature.day2;

public class MultipleVariables {
	public static void main(String[] args) {
		MultipleVariables mv = new MultipleVariables();
		mv.myVariables(10);
		mv.myVariables(10,20);
		mv.myVariables(10,20,30);
		mv.myVariables(10,20,30,40);
		mv.myVariables(10,2,334,34,34,34,3,4534);
		
	}
	
	//multiple variables have to be last argument in method
	void myVariables(int ...y)
	{
//		for (int i = 0; i < y.length; i++) {
//			System.out.println("value of y" + y.i);
//		}
		for(int i:y)
		{
			System.out.println("value of y " + i);
		}
		
	}
}
