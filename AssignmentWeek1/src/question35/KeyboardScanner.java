package question35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardScanner {

	public static void main(String[] args) throws IOException {
		int intNumber;
		double doubleNumber;
		String aWord;
		
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		System.out.println("Please write an int, a double, and a string");
		
		String[] keystrokes = br.readLine().split(" ");
		intNumber = Integer.parseInt(keystrokes[0]);
		doubleNumber = Double.parseDouble(keystrokes[1]);
		aWord = keystrokes[2];
		
		System.out.println("The int that you've written is " + intNumber);
		System.out.println("The double that you've written is " + doubleNumber);
		System.out.println("The word that you've written is " + aWord);
		
		
	}
}
