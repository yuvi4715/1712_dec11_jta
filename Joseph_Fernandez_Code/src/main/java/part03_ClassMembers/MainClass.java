package part03_ClassMembers;

public class MainClass {

	public static void main(String[] args) {
				
		Customer c2 = new Customer("Joey");
		c2.changeInfo(25, 'M');
		
		System.out.println("Name: " + Customer.getName());
		System.out.println("Age: " + Customer.getAge());
		System.out.println("Gender: " + Customer.getGender());
		System.out.println("Species: " + Customer.getSpecies());
		
		System.out.println("----------------------------");

		Customer c1 = new Customer();
		c1.changeInfo("Olivia", 30, 'F');	
		Customer.showInfo();
	}	
	
}
