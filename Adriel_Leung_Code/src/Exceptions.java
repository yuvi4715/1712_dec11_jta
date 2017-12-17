import java.io.IOException;

public class Exceptions {
	
	public static class SleepException extends Exception{
		public String getMessage() {
			return "WARNING: You are becoming a zombie!";
		}
	}
	
	public static void stayAwake() throws SleepException{
		if ("tired" != null) {
			System.out.println("Exception thrown! Ending try block");
			throw new SleepException();
		}
		//ducks the sleep exception; 
		//   lets a catch block further up the stack to deal with it
		
	}
	
	public static void payAttention() {
		try {
			//System.exit(0) if put here will skip finally block and end program
			System.out.println("Starting try block");
			stayAwake();
			System.out.println("Ending try block, no exception thrown");
		}
		catch (SleepException s) {
			System.out.println("Starting catch block");
			s.getMessage();
			System.out.println("Ending catch block");
		}
		finally {
			System.out.println("This is a very graceful goodbye message. Goodbye! ~");
		}
	}
	
	public static void main(String[] args) {
		payAttention();
		System.out.println("If System.exit(0) is called in the try block, "
				+ "the finally block will not run, because the program exited");
	}
}
