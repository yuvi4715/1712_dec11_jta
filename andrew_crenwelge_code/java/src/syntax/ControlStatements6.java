package syntax;

public class ControlStatements6 {
	/*
	 * Create an example for each control statement.
	 */

	public static void main(String[] args) {
		System.out.println("Let's go through some control statements");
		
		// FOR LOOP
		System.out.println("First, a for loop from a=0 to a<3:");
		for (int a=0;a<3;a++) {
			System.out.println("We're in the for loop and a="+a);
		}
		System.out.println("exited the for loop");
		
		// WHILE & DO-WHILE LOOPS
		System.out.println("now starting a while loop from b=5 to b>3");
		int b=5;
		while (b>3) {
			System.out.println("inside the while loop and b="+b);
			b--;
		}
		System.out.println("starting a do-while from c=0 to c<3");
		int c = 0;
		do {
			System.out.println("c=" + ++c);
		} while(c<3);
		
		// IF-ELSE
		System.out.println("Now some conditional statements");
		boolean d = true;
		if (d) {
			System.out.println("If statement block execute when evaluated to true");
		}
		else {
			// won't execute
		}
		d = false;
		if (d) {} else { System.out.println("Else statement block executes when the evaluated expression is false"); }
		
		// SWITCH block
		String var = "a string";
		switch(var) {
			case "a string": System.out.println("code inside a switch block executes when a match is found");
			break; // a break statement is needed here, otherwise we'd go right through
			case "another string": System.out.println("other cases are ignored");
		}
		
		// TRY-CATCH
		try {
			System.out.println("try statements let you safely run code and catch exceptions");
			throw new Exception("this is an exception!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("this always executes last even if an exception is thrown");
		}
	}

}
