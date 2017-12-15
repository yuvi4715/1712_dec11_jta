package com.assignment1.Problem32;

public class PrintNumberInWord {

	public static void printNumberInWord(int x)
	{
		if (x == 1)
			System.out.println("ONE");
		else if(x == 2)
			System.out.println("TWO");
		else if(x == 3)
			System.out.println("THREE");
		else if(x == 4)
			System.out.println("FOUR");
		else if(x == 5)
			System.out.println("FIVE");
		else if(x == 6)
			System.out.println("SIX");
		else if(x == 7)
			System.out.println("SEVEN");
		else if(x == 8)
			System.out.println("EIGHT");
		else if(x == 9)
			System.out.println("NINE");
		else
			System.out.println("OTHER");
	}
	
	public static void printNumberInWord2(int x)
	{
		switch(x)
		{
			case 1:
				System.out.println("ONE");
				break;
			case 2:
				System.out.println("TWO");
				break;
			case 3:
				System.out.println("THREE");
				break;
			case 4:
				System.out.println("FOUR");
				break;
			case 5:
				System.out.println("FIVE");
				break;
			case 6:
				System.out.println("SIX");
				break;
			case 7:
				System.out.println("SEVEN");
				break;
			case 8:
				System.out.println("EIGHT");
				break;
			case 9:
				System.out.println("NINE");
				break;
			default:
				System.out.println("OTHER");
				break;
		}
		
	}
	
	public static void main(String[] args) {
		int number = 1;
		
		printNumberInWord(number);
		number=2;
		
		printNumberInWord(number);
		number=3;
		printNumberInWord(number);
		number=4;
		printNumberInWord(number);
		number=5;
		printNumberInWord(number);
		number=6;
		printNumberInWord(number);
		number=7;
		printNumberInWord(number);
		number=10;
		printNumberInWord(number);
		
		number = 1;
		
		printNumberInWord2(number);
		number=2;
		
		printNumberInWord2(number);
		number=3;
		printNumberInWord2(number);
		number=4;
		printNumberInWord2(number);
		number=5;
		printNumberInWord2(number);
		number=6;
		printNumberInWord2(number);
		number=7;
		printNumberInWord2(number);
		number=10;
		printNumberInWord2(number);
		
	}

}
