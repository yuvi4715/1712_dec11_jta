package question2;

public class ShortCurcuitOperators {

	public static void main(String[] args) {
		int a = 2;
		int b = 4;
		int c = 6;
		
		int greatestNumber = 0;
		
		if(a > b) {
			if(a > c) {
				greatestNumber = a;
			}
		}
		else if(b > c) {
			greatestNumber = b;
		}
		else {
			greatestNumber = c;
		}
		
		System.out.println("The greatest number of the three is" + greatestNumber);
	}

}
