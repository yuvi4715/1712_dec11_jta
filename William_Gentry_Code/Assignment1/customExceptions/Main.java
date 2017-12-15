package customExceptions;

public class Main {

	public static void main(String[] args) throws TooYoungException {
		try {
			System.out.println("Entering try block....");
			int age = 19;
			if (age < 21) {
				throw new TooYoungException("Must be 21 years of age to purchase alcohol");
			} else {
				System.out.println("All the booze for you, good sir!");
			}
			System.out.println("Exiting try block...");
		} catch(TooYoungException e) {
			System.out.println("Entering catch block...");
			System.out.println(e.getMessage());
			System.out.println("Exiting catch block...");
		} finally {
			System.out.println("Entering finally block...");
			System.out.println("Thank you for coming to your local bottle shop!");
			System.out.println("Exiting finally block..");
		}
	}

}
