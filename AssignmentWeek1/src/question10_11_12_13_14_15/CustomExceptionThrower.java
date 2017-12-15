package question10_11_12_13_14_15;

public class CustomExceptionThrower {
	public void throwCustomException() throws CustomException {
		throw new CustomException();
	} //#11
	
	public void throwCatchCustomException() {//#12
		try {
			System.out.println("Starting try block");
			throw new CustomException();
			//System.out.println("Ending try block");
		} 
		catch (CustomException e) {
			System.out.println("Starting catch block");
			System.out.println("The exception has been caught");
			System.out.println("Ending catch block");
		}
		finally {
			System.out.println("Starting finally block");
			System.out.println("This is a graceful goodbye message"); ///////////#14
			System.out.println("Ending finally block");
		}
	}
	
	public void duckException() throws CustomException{ //#13
		throw new CustomException();
	}
			
	public void sysEnd() { //#15
		try {
			System.exit(0);
		}
		finally {
			System.out.println("finally block still runs");
		}
	}
}
