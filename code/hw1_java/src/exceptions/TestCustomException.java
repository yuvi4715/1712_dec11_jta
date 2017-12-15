package exceptions;

public class TestCustomException {	//#11
	public void checkException(int a, int b) throws CustomException {	//#13
		if (a!=b) {
			throw new CustomException(	);
		}
		else {
			System.out.println("No Exception");
		}
	}
	public void test(int a, int b){
		try {
			System.out.println("Start try");	//#12
			checkException(a, b);
			System.out.print("End try");
			System.exit(0);		//#15 finally block does execute
		}
		catch (CustomException e) {
			System.out.println("Ducked exception");
			System.out.println(e);
		}
		finally {
			System.out.println("Graceful exit");	//#14
		}
	}
}
