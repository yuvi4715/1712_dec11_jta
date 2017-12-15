package question38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharReplace {

	
	
	public static void theReplacement(String word, char letter, char replacer) throws IOException {
		System.out.println("New phrase: " + word.replace(letter, replacer));
	}
	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		System.out.println("Enter phrase, letter to be replaced, and letter to replace");
		String[] keystrokes = br.readLine().split(" ");
		theReplacement(keystrokes[0], keystrokes[1].charAt(0), keystrokes[2].charAt(0));

	}

}
