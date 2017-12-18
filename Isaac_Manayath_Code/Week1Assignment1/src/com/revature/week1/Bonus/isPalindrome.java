import java.util.*;

public class isPalindrome {
	public static void main(String args[]) {
		{
			String str = "anna";
			String r = "";
			int length = str.toCharArray().length;

			// Reversing an array
			for (int i = length - 1; i >= 0; i--) {
				r = r + str.charAt(i);
			}

			//Checking if the string is a palindrome
			if (str.equals(r)) {
				System.out.println(r + " is a palindrome");
			} else {

				System.out.println(r + " is not a palindrome");
			}

		}
	}
}