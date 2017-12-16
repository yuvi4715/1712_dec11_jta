/*
 * @Antonio Dotson 
 * final statement does not execute because of system.exit command 
 */
public class Problem15 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method 
		Problem15 a1 = new Problem15();
		try {
			System.exit(0);
			a1.divide();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("Your Error was caught");
		}finally {
			System.out.println("I caught your error too");
		}

	}
	// throws exception - ducking
	public void divide () throws Exception {
			int x =15;
			int quotient = x / 0;
			System.out.println(quotient);
	}

}
