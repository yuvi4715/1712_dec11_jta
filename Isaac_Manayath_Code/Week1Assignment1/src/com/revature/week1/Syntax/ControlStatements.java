package com.revature.week1.Syntax;

public class ControlStatements {

	public static void main( String [] args) {
		
		//If Statement
		if(13 > 5) {
			System.out.println("13 greater than 5");
		}
		
		int a = 13;
		int b = 5;
		
		//If Else Statement
		if(a < b) 
		{
			System.out.println("13 greater than 5");
		}
		else 
		{
			System.out.println("5 is not than 13");
		}
	
		//Switch Statement
		int status = 2;
		switch (status) {
		case 1:
			System.out.println("1 is option");
			break;
		case 2:
			System.out.println("2 is option");
			break;
		default:
			System.out.println("Remaing option");
		}
		
		//While Statement
		int d = 0;
		while (d < 10) {
			System.out.println("while" + d);
			d++;
		}
	
		//Do While Statement
		int i = 0;
		do {
		
			System.out.println("Do while " + i);  
	    	i++;  
			
		}while(i < 10);
		
		//For Statement
		for (int count = 0; count < 10; count++) {
			System.out.println("For " + count);
		}
	
		//Continue Statement
		for (int e = 1; e < 10; e++) {
			if (e % 2 == 0) {
				continue;
			}
			// Rest of loop body skipped when i is even
			System.out.println("Continue " + e + "\t");
		}
	
		//Break Statement
		for (int f = 1; f < 10; f++) {
			if (f % 2 == 0) {
				break;
			}
			System.out.println("Break " + f + "\t");
		}
	
		//For Each Statement
		int [] items = {1, 2, 3, 4, 5};
		for (int element: items) {
			System.out.println(element);
		}
	}
}
