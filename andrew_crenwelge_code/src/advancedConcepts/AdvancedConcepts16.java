package advancedConcepts;

public class AdvancedConcepts16 {
	/*
	 * Create a StringBuilder object. Use at least three methods to manipulate the String
	 */
	
	public static void main(String[] args) {
		StringBuilder string = new StringBuilder();
		string.append("hello");
		string.append("World!");
		string.insert(5, ", ");
		System.out.println(string);
		string.deleteCharAt(string.indexOf("!"));
		System.out.println(string);
	}
}
