package Exceptions;

// 11, 12, 14, 15
public class Thrower  {
	public static void main(String[] args) {
		try {
			// System.exit(0);
			// system.exit(0) will bypass the finally block
			System.out.println("Starting try block");
			throw new CustomException();
		}
		catch(Exception e) {
			System.out.println("Starting catch block");
			System.out.println(e.getMessage());
			System.out.println("Ending catch block");
		}
		finally {
			System.out.println("Starting finally block");
			System.out.println("Nice message");
			System.out.println("Ending finally block");
		}
	}
}
