package advancedConcepts;

import java.util.StringTokenizer;

public class AdvancedConcepts17 {
	/*
	 * Create a new String with delimited tokens, such as 
	 * “pickles:ketchup:mustard:onion” and use StringTokenizer 
	 * to parse out and print each token.
	 */
	public static void main(String[] args) {
		// implemented with .split
		String str = "pickles:ketchup:mustard:onion";
		String[] arr = str.split(":");
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		// implemented with StringTokenizer
		StringTokenizer st = new StringTokenizer("red:green:yellow:blue",":");
		 while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }
	}

}
