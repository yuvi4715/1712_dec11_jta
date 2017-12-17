import java.util.StringTokenizer;

public class Advanced_Concepts {

	//Question 18 and 19
	public static int add_string_numbers(String n1, String n2) {
		int result = Integer.parseInt(n1) + Integer.parseInt(n2);
		System.gc();
		return result;
	}
	
	public static void main(String[] args) {
		//Question 16
		StringBuilder str1 = new StringBuilder("Hello");
		str1.append(" World");
		str1.insert(5, "w");
		str1.deleteCharAt(5);
	
		//Question 17
		String tokens = "Nia:Morag:Poppi";
		StringTokenizer tokenizer = new StringTokenizer(tokens, ":");
		while(tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
		
		//Question 18
		String number1 = "12";
		String number2 = "17";
		System.out.println(add_string_numbers(number1, number2));
		
		//Question 20
		Runtime runtime = Runtime.getRuntime();
		
		//For requesting garbage collector to free up space when possible
		runtime.gc();
		
		//Can print this to see how much free memory the JVM has
		runtime.freeMemory();
		
		//Can print this to see how much memory JVM might take up
		runtime.maxMemory();
	}
	
}
