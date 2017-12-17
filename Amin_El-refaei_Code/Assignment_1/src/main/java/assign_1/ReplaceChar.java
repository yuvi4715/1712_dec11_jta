package assign_1; // this class contains the code for number 38


public class ReplaceChar {

	public static void main(String[] args) {
		replaceCharacter(); // statically calls replaceCharacter() method
	}
	
	public static void replaceCharacter() {
		
		String s = "Hello Yuvi"; // created string s that says hello yuvi
		
		System.out.println(s); // print String s
		
		System.out.println(s.replace("l", "w")); // replace l characters in String s with w characters
	}

}
