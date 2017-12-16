package getasew.assignment1.easycoding;

public class EasyCodingMain {
	public static void main(String[] args) {
		
	}
	/*
 32.Write a program called CheckPassFail which prints "PASS" 
if the int variable "mark" is more than or equal to 50; 
or prints "FAIL" otherwise.

	 */
	public static void checkPassFail(int mark) {
		if(mark >= 50) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	/*
	 *33. Write a program called CheckOddEven which prints "Odd Number"
	 *  if the int variable “number” is odd, or “Even Number” otherwise. 
	 *  Hint: you may use modulus operator.

	 */
	public static void checkOddEven(int number) {
		if((number % 2)==0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Nubmer");
		}
	}
	/*
	 * 34.Write a program called PrintNumberInWord which prints "ONE", "TWO",... ,
	 *  "NINE", "OTHER" if the int variable "number" is
	 *   1, 2,... , 9, or other, respectively. 
	 *   Use (a) a "nested-if" statement; (b) a "switch-case" statement
	 */
	public static void printNumberInWordIF(int number) {
		if(number==1) {
			System.out.println("ONE");
		} else if(number == 2) {
			System.out.println("TWO");
		} else if(number == 3) {
			System.out.println("THREE");
		}else if(number == 4) {
			System.out.println("FOUR");
		}else if(number == 5) {
			System.out.println("FIVE");
		}else if(number == 6) {
			System.out.println("SIX");
		}else if(number == 7) {
			System.out.println("SEVEN");
		}else if(number == 8) {
			System.out.println("EIGHT");
		}else if(number == 9) {
			System.out.println("NINE");
		} else {
			System.out.println("OTHER");
		}
	}
	public static void printNumberInWordSW(int number) {
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
			break;
				
	   
		
		}
	}

}
