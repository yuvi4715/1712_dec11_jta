package easycodingexcercises;

import java.util.Scanner;

public class KeyboardScanner {

	public static void main(String[] args) {
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter a String, an integer , and a double");
		String text = input1.nextLine();
		int value1 = input1.nextInt();
		double value2 = input1.nextDouble();
		System.out.println(text + " , " + value1 + " , " + value2);

	}

}
