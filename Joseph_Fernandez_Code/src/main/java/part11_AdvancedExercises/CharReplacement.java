package part11_AdvancedExercises;

public class CharReplacement {

	private String string;
	private char targetChar;
	private char replacementChar;

	public static void main(String[] args) {
		new CharReplacement("Hercules, Lourdes, Joseph, Joshua, Jonah", 'e', 'X');
	}
	
	public CharReplacement(String str, char a, char b) {
		this.string = str;
		this.targetChar = a;
		this.replacementChar = b;
		
		this.replaceInString(this.string, this.targetChar, this.replacementChar);
	}
	
	
	public void replaceInString(String string, char targetChar, char replacementChar) {
		System.out.println("Original String: " + string);
		char[] stringArray = string.toCharArray();
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i] == (targetChar)) {
				builder.append(replacementChar);
			} else {
				builder.append(stringArray[i]);
			}
		}
		
		System.out.println();
		System.out.println("Replaced Characters: '" + builder.toString() + "'");
	}
	
}
