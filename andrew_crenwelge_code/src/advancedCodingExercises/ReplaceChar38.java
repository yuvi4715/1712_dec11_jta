package advancedCodingExercises;

public class ReplaceChar38 {

	public static void main(String[] args) {
		System.out.println(replaceCharInStr("hello",2,'y'));
	}
	
	private static String replaceCharInStr(String str, int b, char c) {
		// we want to replace the character at location b in the string with character c
		return str.substring(0, b) + c + str.substring(b+1, str.length());
	}

}
