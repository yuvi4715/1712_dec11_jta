package exceptions;

public class CustomExceptionThrower11 {
	public static void main(String[] args) throws CustomException10 {
		someMethod();
	}
	
	private static void someMethod() {
		try {
			System.out.println("Starting try block");
			System.exit(0);
			throw new CustomException10();
		}
		catch(CustomException10 e) {
			System.out.println("Starting catch block");
			e.printStackTrace();
		}
		finally {
			System.out.println("Starting finally block");
			System.out.println("Goodbye...");
		}
	}

}
