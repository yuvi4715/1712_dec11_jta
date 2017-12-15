package Bonus;

import java.util.regex.*;
public class PalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testreg = "A,car,rac,A";
		String newString = testreg.replaceAll("([.,:'\\?])", testreg);
		isPalindrome(newString.toLowerCase());

	}
	
	private static void isPalindrome(String input) {
		char[] c = new char [input.length()];
		StringBuilder sb = new StringBuilder();
		
		for (int i = c.length - 1; i >= 0; i--) {
			c[i] = input.charAt(i);

		}
		for (int j = c.length - 1; j >= 0 ; j--) {
			sb.append(c[j]);
			
		}
		
		if(input.equals(sb.toString())) {
			System.out.println("String is palindrome");
		}else {
			System.out.println("String is not palindrome");

		}
		
		
		
		
	}
}
