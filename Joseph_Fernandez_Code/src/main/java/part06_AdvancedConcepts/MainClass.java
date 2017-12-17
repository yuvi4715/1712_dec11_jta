package part06_AdvancedConcepts;

import java.util.StringTokenizer;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("--------Number 16--------");
		Number16();
		System.out.println("--------Number 17--------");
		Number17();
		System.out.println("--------Number 18--------");
		Number18();
		System.out.println("--------Number 19--------");
		Number19();
		System.out.println("--------Number 20--------");
		Number20();
		
	}

	// Manipulates an object created by StringBuilder
	public static void Number16() {

		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb);
		
		sb.append(" World!");				// Method 01
		System.out.println(sb);
		
		sb.delete(5, 11);					// Method 02
		System.out.println(sb);
		
		sb.reverse();						// Method 03
		System.out.println(sb);
	}
	
	// Parses a string into tokens using StringTokenizer
	public static void Number17() {
		String dcSuperheros = "Superman:Batman:Flash:Aquaman:GreenLantern";
		System.out.println("Original String");
		System.out.println(dcSuperheros);
		System.out.println();
		
		StringTokenizer tokens = new StringTokenizer(dcSuperheros, ":");
		while(tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
		}
	}
	
	// Converts two strings into integers, then adds them.
	public static void Number18() {
		String number1 = "150";
		String number2 = "100";
		
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		int sum = num1 + num2;
		
		System.out.println(sum);
	}
	
	// Requesting The Garbage Collector
	public static void Number19() {
		System.out.println("Requesting The Garbage Collector");
		System.gc();
		System.out.println("Finished Requesting The Garbage Collector");
	}
	
	public static void Number20() {
		Runtime rt = Runtime.getRuntime();
		
		// Method 01
		long totalMemory = rt.totalMemory();
		System.out.println("Total Amount of Memory: " + totalMemory);
		
		// Method 02
		long freeMemory = rt.freeMemory();
		System.out.println("Amount of Free Memory: " + freeMemory);
		
		// Method 03
		long maxMemory = rt.maxMemory();
		System.out.println("Maximum Amount of Memory: " + maxMemory);
	}
	
}
