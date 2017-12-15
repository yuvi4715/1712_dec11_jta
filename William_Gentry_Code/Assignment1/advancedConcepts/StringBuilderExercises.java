package advancedConcepts;

import java.util.StringTokenizer;

public class StringBuilderExercises {

	public static double addTwoNumbers(String num1, String num2) {
		return Double.parseDouble(num1) + Double.parseDouble(num2);
	}
	
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		long totalMemory = r.totalMemory();
		System.out.println("Total amount of memory available for current and future objects: " + totalMemory);
		long currentMemory = r.freeMemory();
		System.out.println("Free memory before creation of StringBuilder objects: " + currentMemory);
		
		
		StringBuilder builder = new StringBuilder();
		builder.ensureCapacity(40);
		builder.append("William");
		builder.insert(0, "My name is ");
		builder.insert(builder.length(), ".");
		System.out.println(builder.toString());
		System.out.println("\n");
		
		currentMemory = r.freeMemory();
		System.out.println("Free memory after first StringBuilder exercise: " + currentMemory + "\n");
		
		String meatPizzaToppings = "pepperoni, sausage, beef, ham, bacon";
		StringTokenizer st = new StringTokenizer(meatPizzaToppings, ", ");
		System.out.println("Toppings on the Mighty Meaty Pizza:");
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
		System.out.println("\n");
		
		currentMemory = r.freeMemory();
		System.out.println("Free memory after StringTokenizer exercise: " + currentMemory + "\n");
		
		
		String num1 = "35";
		String num2 = "100";
		System.out.println("Variable num1 = " + num1 + " and is an instance of" + num1.getClass());
		System.out.println("Variable num2 = " + num2 + " and is an instance of " + num2.getClass());
		System.out.println("The sum of these string values is " + addTwoNumbers(num1, num2));
		System.out.println("\n");
		
		currentMemory = r.freeMemory();
		System.out.println("Free memory after string conversion exercise: " + currentMemory + "\n");
		
		System.out.println("Preparing Garbage Collection....\n");
		r.gc();
		currentMemory = r.freeMemory();
		System.out.println("Free memory after garbage collection: " + currentMemory);
		
		
		
	}

}
