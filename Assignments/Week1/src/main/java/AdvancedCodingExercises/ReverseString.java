package AdvancedCodingExercises;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		reverse("Hello");
		

	}
	
	private static void reverse(String input) {
		char[] c = new char [input.length()];
		StringBuilder sb = new StringBuilder();
		
		for (int i = c.length - 1; i >= 0; i--) {
			c[i] = input.charAt(i);

		}
		for (int j = c.length - 1; j >= 0 ; j--) {
			sb.append(c[j]);
			
		}
		
		System.out.println(sb.toString());

	}

}
