package advancedCodingExercises;

public class ReplaceCharInString {
	
	
	private String targetString;
	private char targetChar;
	private char replaceChar;
	
	public ReplaceCharInString(String targetString, char targetChar, char replaceChar) {
		this.targetString = targetString;
		this.targetChar = targetChar;
		this.replaceChar = replaceChar;
		this.replaceInString(this.targetString, this.targetChar, this.replaceChar);
	}
	
	
	public void replaceInString(String targetString, char targetChar, char replaceChar) {
		System.out.println("Original String: \"" + targetString + "\"");
		char[] targetArray = targetString.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < targetArray.length; i++) {
			if (targetArray[i] == (targetChar)) {
				builder.append(replaceChar);
			} else {
				builder.append(targetArray[i]);
			}
		}
		System.out.println("=================================");
		System.out.println("String with replaced Charachter: \"" + builder.toString() + "\"");
	}
	
	public static void main(String[] args) {
		new ReplaceCharInString("Hello, my name is William", 'l', 'q');
	}

}
