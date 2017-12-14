package com.revature.question34;

// Write a program called PrintNumberInWord which prints "ONE", "TWO",... , "NINE", "OTHER" if the int variable "number" is 1, 2,... , 9, or other, 
// respectively. Use (a) a "nested-if" statement; (b) a "switch-case" statement.
public class PrintNumberInWord {

	public void nestedIf(int number) {
		if (number == 1) System.out.println("ONE");
		else if(number == 2) System.out.println("TWO");
		else if(number == 3) System.out.println("THREE");
		else if(number == 4) System.out.println("FOUR");
		else if(number == 5) System.out.println("FIVE");
		else if(number == 6) System.out.println("SIX");
		else if(number == 7) System.out.println("SEVEN");
		else if(number == 8) System.out.println("EIGHT");
		else if(number == 9) System.out.println("NINE");
		else System.out.println("OTHER");
	}
	
	public void switchCase(int number) {;
		
		switch(number) {
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
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintNumberInWord p = new PrintNumberInWord();
		p.nestedIf(5);
		p.switchCase(0);
	}

}
