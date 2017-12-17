package advancedcodingexcercises;

public class Problem38 {

	public static void main(String[] args) {

		System.out.println(chartoreplace("Mississippi", 5, 'd'));

	}
	
	public static String chartoreplace(String string1, int index, char replace) {
		
		if(string1 == null) {
			return string1;
		}
		else if(index < 0 || index >= string1.length()) {
			return string1;
		}
		char[] arrayofchars = string1.toCharArray();
		arrayofchars[index] = replace;
		return String.valueOf(arrayofchars);
	}
}
