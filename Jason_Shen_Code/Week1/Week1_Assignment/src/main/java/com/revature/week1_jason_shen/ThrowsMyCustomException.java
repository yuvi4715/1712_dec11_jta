package com.revature.week1_jason_shen;

public class ThrowsMyCustomException {
	// 11. Create a class that manually throws an exception of your custom type
	// 12. Use System.out.println( ) to note where you are in the control flow. Example: 
	//     “Starting try block”, “Ending try block”, “Starting catch block”, etc.

	// 14. Implement a finally block that prints a graceful goodbye message
	// 15. Use the System.exit(0) command in the try block and rerun the application. 
	//     Note the console output to see if the finally block executes.

		public void myTryCatch() {
			try {
				System.out.println("Entering try...");
				// System.exit(0);
				// Nothing will execute after System.exit(0)
				throw new MyCustomException();
			}
			catch (MyCustomException e) {
				System.out.println("Entering catch...");
				System.out.println("Phew, caught, moving on");
			} finally {
				System.out.println("Finally done, moving on");
			}
		}
		
		public void duckMyException() throws MyCustomException {
			System.out.println("Ducking exception...");
			throw new MyCustomException();
		}
	
}
