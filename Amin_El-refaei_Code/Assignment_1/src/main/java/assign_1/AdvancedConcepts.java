package assign_1; // this class contains the code for questions 16-20

import java.util.StringTokenizer;

public class AdvancedConcepts {

	public static void main(String[] args) {
		stringBuilder(); // statically calling stringBuilder method for number 16

		System.out.println("---------------"); // just a line to separate outputs

		tokenizer(); // statically calling tokenizer method for number 17

		System.out.println("---------------"); // just a line to separate outputs

		addTwoStrings(); // statically calling addTwoStrings method for number 18
		
		System.out.println("---------------"); // just a line to separate outputs
		
		System.gc(); // calling for garbage collection for number 19
		System.out.println("Garbage collection has beenrequested");
		
		System.out.println("---------------"); // just a line to separate outputs
		
		
		getRuntime(); // statically calling getRuntime method for number 20
		

	}

	public static void stringBuilder() { // number 16
		StringBuilder str1 = new StringBuilder("Hello Yuvi"); // create StringBuilder str1 with the text "Hello Yuvi",
																// then print
		System.out.println(str1);
		str1.append(" yerrrr"); // append "yerrrr" to the end of str1, then print
		System.out.println(str1);
		str1.deleteCharAt(15); // delete character at position 15 of str1, then print
		System.out.println(str1);
		str1.setLength(10); // set length to 10, which truncates all of the characters that are after 10,
							// then print
		System.out.println(str1);
	}

	public static void tokenizer() { // number 17
		String str2 = new String("beans%greens%potatoes%tomatoes"); // creates new string called str2
		StringTokenizer tokenizer = new StringTokenizer(str2, "%"); // creates StringTokenizer to tokenize str2
		while (tokenizer.hasMoreTokens()) { // while there are more tokens remaining
			System.out.println(tokenizer.nextToken()); // print the next token
		}
	}

	public static void addTwoStrings() { // number 18
		String x1 = new String("35"); // creates String called x1 with value "35"
		String x2 = new String("12"); // creates String called x2 with value "12"

		int x3 = Integer.parseInt(x1); // uses parseInt on String x1 to turn the string into an int called x3
		int x4 = Integer.parseInt(x2); // uses parseInt on String x2 to turn the string into an int called x4

		int x5 = (x3 + x4); // adds integers x3 and x4 and assigns the sum to a new int caled x5

		System.out.println(x5); // print x5
	}
	
	public static Runtime getRuntime() { // number 20
		
		Runtime.getRuntime(); // gets the run time
		Runtime.version(); // gets the version
		
		return null;
	}

}
