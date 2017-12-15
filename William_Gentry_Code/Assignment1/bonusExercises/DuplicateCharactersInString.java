package bonusExercises;

public class DuplicateCharactersInString {

	
	public static char[] alphabet() {
		char[] alphabet = new char[26];
		char c = 'a';
		for (int i = 0; i < 26; i++) {
			alphabet[i] = c;
			c++;
		}
		return alphabet;
	}
	
	public static int[] letterHistogram(String s) {
		char[] alphabet = alphabet();
		int[] histogram = new int[26];
		char[] targetString = s.toCharArray();
		for (int i = 0; i < targetString.length; i++) {
			for (int j = 0; j < alphabet.length - 1; j++) {
				if ((alphabet[j] == targetString[i]) || (Character.toUpperCase(alphabet[j]) == Character.toUpperCase(targetString[i]))){
					histogram[j]++;
				}
			}
		}
		return histogram;
	}
	
	public static void PrintDuplicateCharInString(String s) {
		int[] charCount = letterHistogram(s);
		char[] alphabet = alphabet();
		System.out.println("The provided string '" + s + "' contains the following duplicate characters:");
		for (int i = 0; i < charCount.length; i++) {
			System.out.println(alphabet[i] + ": " + charCount[i]);
		}
	}
	
	public static void main(String[] args) {
		PrintDuplicateCharInString("William");
	}
}
