package questions52;

public class reverseNumber {

	public static void main(String[] args) {
		Integer number = 123;
		int newNumber;
		
		String original = number.toString();
		String reverse = new String();
		for(int i = original.length() - 1; i >= 0; i--) {
			reverse += original.charAt(i);
		}
		newNumber = Integer.parseInt(reverse);
		System.out.println(newNumber);
	}

}
