package AdvancedConcepts;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Manipulating Strings!");
		
		ManipulateStrings ms = new ManipulateStrings();
		
		char[] somechar = {'H','e','l','l','o'};
		String first = "10";
		String second = "20";
		
		ms.stringLenght("Hello My Name Is Jose Perez");
		ms.charToString(somechar);
		ms.letterCount("Oh Mcdonald had a farm");
		ms.reverseString("Welcome to Revature!");
		ms.parser("Hello:Captain:Pickles:How:Are:You:Today?", ":");
		ms.addStrings(first, second);
		

		
		
	}

}
