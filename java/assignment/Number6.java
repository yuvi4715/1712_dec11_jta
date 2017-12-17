package com.revature.day1;

public class Number6 {
	
	public static void main(String args[]) {
	
	//for, while, if, else, switch, do
	 int x = 2, y = 3;
	
	
	if (y != 2) { 
		System.out.println(y);
	}
	
	if (x == 3)
	{
		System.out.println(x);
	}
		else
		{
			System.out.println(y);
		}

	while (x == 3) {
		System.out.println(x);}
	
	do {System.out.println(x);
	x++;
	}
		while (x < 8);
	
	switch (x) {
		case 1:
		System.out.println(x);
		break;
		
		case 2:
		System.out.println(y);
		break;
		
		
		case 3:
		System.out.println(y);
		break;
		
		default :
			System.out.println("end of switch case");
	}
		
	for (x = 0; x < 10; x++)
	{
		System.out.println(x);
	}
		
}

}
