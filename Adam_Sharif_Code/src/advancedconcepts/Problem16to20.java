package advancedconcepts;

import java.util.StringTokenizer;

public class Problem16to20 {

	public static void main(String[] args)  {

		StringBuilder string1 = new StringBuilder("Bob the Builder");
		string1.reverse();
		string1.append(" Adam Sharif");
		string1.length();

		String string2 = "pickles:ketchup:mustard:onion";
		StringTokenizer str = new StringTokenizer(string2, ":");
		while (str.hasMoreElements()) {
			System.out.println(str.nextElement());
		}

		String val1 = "5";
		String val2 = "10";
		add(val1, val2);
		System.gc();
		
		Runtime runtime = Runtime.getRuntime();
		System.out.println("The free memory is " + runtime.freeMemory());
		System.out.println("The total memory is " + runtime.totalMemory());

	}
	
	public static void add(String num1, String num2) {
		Integer convertedNum1 = Integer.valueOf(num1);
		Integer convertedNum2 = Integer.valueOf(num2);
		System.out.println(convertedNum1 + convertedNum2);
		convertedNum1 = null;
		convertedNum2 = null;

	}
	
	public void finalize() {
		System.out.println("object is garbage collected");
	}

}
