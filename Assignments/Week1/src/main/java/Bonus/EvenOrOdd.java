package Bonus;

public class EvenOrOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkNumber(2);
		

	}
	
	private static void checkNumber(double number) {
		double answer  = number / 2;
		
		if((answer - (int)answer) != 0) {
			System.out.println("Numebr is odd");
		}
		else {
			System.out.println("Number is even");
		}
	}

}
