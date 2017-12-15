package com.assignment1;

public class Problem6 {

	public static void main(String[] args)
	{
		boolean x = true;
		boolean y = false;
		
		//if then else if
		System.out.println("-if else if");

		if(x == true)
		{
			System.out.println("true");
		}
		else if (y == false)
		{
			System.out.println("false");
		}
		
		//if then else
		System.out.println("\n-if else");

		if (x == false)
			System.out.println("false");
		else
			System.out.println("true");
		
		//switch
		System.out.println("\n-switch");

		int s = 2;
		String stuff = "";
		switch(s)
		{
			case 1: 
				stuff = "swtich 1";
				break;
			case 2:
				stuff = "switch 2";
				break;
			case 3:
				stuff = "swtich 3";
				break;
			default:
				stuff = "switch default";
				break;
		}
		System.out.println(stuff);
		
		//while 
		System.out.println("\n-while loop");
		int whi = 5;
		while(whi != 0)
		{
			System.out.println(whi);
			whi--;
		}
		
		//for
		System.out.println("\n-For loop");
		int sum = 0;
		for(int i = 0; i < 5; i++)
		{
			sum = 1 + sum;
			System.out.println(sum);
		}
		
		System.out.println("\n-do while");
		int bia = 10;
		do {
			System.out.println(bia);
			bia--;
		}while (bia > 0);
	}

}
		

