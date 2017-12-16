/**
 * 
 */

/**
 * @author Antonio Dotson
 *
 */
public class Customer {

	/**
	 * problem number 7
	 */

	String name;
	int phoneNumber;
	
	
	final String companyName ="Revature";
	static int idNum;
	
	public Customer (int phoneNumber, String name) {
		System.out.println("Welcome" + " "+ name + " "+phoneNumber);
	}
	
	public Customer(String name, int phoneNumber) {
		System.out.println("Welcome" + " "+ name + " "+phoneNumber);

   }
	public String email(String email) {
		return email;
	}
	
	public int email(int email) {
		return email;
	}
	
	public String address(String addr) {
	  return addr;
	}
	
	public int address(int addr) {
		return addr;
	}
	
	public static void newEmployee() {
		System.out.println("Welcome");
	}
	
	public static void graduatingEmployee() {
		System.out.println("Congrats!!");
	}
}
