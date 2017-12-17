package part03_ClassMembers;

public class Customer {
	
	public static String name; 						// Static Variable 01
	public static int age;							// Static Variable 02
	public static char gender;						// Static Variable 03
	public final static String species = "Human";	// Final Variable

	// Default Constructor
	public Customer() {
		name = "";
		age = 0;
		gender = 'n';
	}
	// Constructor 01
	public Customer(String name) {
		Customer.name = name;
	}
	// Constructor 02
	public Customer(String name, int age) {
		Customer.name = name;
		Customer.age = age;
	}
	// Constructor 03
	public Customer(String name, int age, char gender) {
		Customer.name = name;
		Customer.age = age;
		Customer.gender = gender;
	}

	public void changeInfo(String name, int age, char gender) {
		Customer.name = name;
		Customer.age = age;
		Customer.gender = gender;
	}
	// Overloaded Method 01
	public void changeInfo(int age, char gender) {
		Customer.age = age;
		Customer.gender = gender;
	}
	// Overloaded Method 02
	public void changeInfo(char gender, String name, int age) {
		Customer.name = name;
		Customer.age = age;
		Customer.gender = gender;
	}
	
	// Static Method 01
	public static String getName() {
		return name;
	}
	// Static Method 02
	public static Integer getAge() {
		return age;
	}
	// Static Method 03
	public static char getGender() {
		return gender;
	}
	// Static Method 04
	public static String getSpecies() {
		return species;
	}
	
	public static void showInfo() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Species: " + species);
	}
}
