package exceptions;

class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String message = "Returning message that is overriden";
		return message;
	}

}

class ExceptionClass {
	public String Test(int num) throws MyException {
		if (num == 3) {
			// throw our custom exception
			throw new MyException();
		} else {

			return "Finished";
		}
	}
}

public class Problem10to15 {

	public static void main(String[] args) {
		ExceptionClass exception1 = new ExceptionClass();
		try {
			System.out.println("Starting try block");
			exception1.Test(3); // To duck exception, enter an integer value other than 3
			System.exit(0);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("Starting catch block");
			e.printStackTrace();
			System.out.println("Ending catch block");
			// System.exit(0);
		} finally {
			System.out.println("Goodbye and have a nice day.");

		}

	}
}
