package question44;

public class ReverseString {

	public static void main(String[] args) {

		String a = "Beater";
		char[] reverse = new char[a.length()];
		
		for(int i = 0; i < a.length(); i++) {
			reverse[i] = a.charAt(a.length() - i - 1);
		}
		System.out.println(reverse);
	}

}
