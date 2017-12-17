package assign_1; // this class contains the code for number 41

public class FizzBuzz {

	public static void main(String[] args) {
		
		for (int n = 1; n <= 50; n++ ) { // created a for loop to iterate through each number, 1-50
			
			if (n % 3 == 0 && n % 5 == 0) { // if n is a multiple of 3 AND 5, print this
				System.out.println("FizzBuzz");
				continue;
			} 
			else if (n % 5 == 0) { // if n is a multiple of 5, print this
				System.out.println("Buzz");
				continue;
			}
			else if (n % 3 == 0) { // if n is a multiple of 3, print this
				System.out.println("Fizz");
				continue;
			} 
			else {
				System.out.println(n); // else, print the number
			}
		}
	}

}
