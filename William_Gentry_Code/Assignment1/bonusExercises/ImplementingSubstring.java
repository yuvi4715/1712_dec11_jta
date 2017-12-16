package bonusExercises;

public class ImplementingSubstring {

	
	/*
	 * 
	 * the substring methods works in two ways
	 * 
	 * String.substring(startIndex) returns a new string from startIndex on
	 * String.substring(startIndex, endIndex) returns a new string from startIndex to endIndex
	 * 
	 * 
	 */
	
	
	private static final String myString = "Hello, my name is William and I am studying to become the Master of Java";
	
	static void startIndexOnly(String s, int startIndex) {
		System.out.println("The string returned from index " + startIndex + " on is '" + s.substring(startIndex)+"'");
	}
	
	static void startIndexAndEndIndex(String s, int startIndex, int endIndex) {
		System.out.println("The string returned from " + startIndex + " to " + endIndex + " is '" + s.substring(startIndex, endIndex) + "'");
	}
	
	
	public static void main(String[] args) {
		startIndexOnly(myString, 13);
		startIndexAndEndIndex(myString, 13, 45);
	}
	
	
}
