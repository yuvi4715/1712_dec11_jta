package question41;

public class FizzBuzz {

	public static void main(String[] args) {

		for(int i = 1; i <= 50; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				if(i % 3 == 0) {
					System.out.print("Fizz");
				}
				if(i % 5 == 0) {
					System.out.print("Buzz");
				}
			}
			else {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
