package advancedcodingexcercises;

public class Problem41 {

	public static void main(String[] args) {
		int maxnumber = 50;
		for(int i=0; i < maxnumber; i++) {
			if(i % 3 == 0) {
				System.out.println("Fizz");
			}
			else if(i % 5 == 0) {
				System.out.println("Buzz");
			}
			else if(i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
				
			}
		}

	}

}
