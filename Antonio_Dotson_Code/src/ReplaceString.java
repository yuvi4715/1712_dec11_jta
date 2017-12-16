//Antonio Dotson

public class ReplaceString {
  
  //Problem 38
	public static void ReplaceMe (String name, char x, char r) {
	//set variables
	String saveName = name;
	char e;
	String newString="";
	int  stringLength = name.length();
	// got string length and looped through word, match the character and replace them one by one and then printed the string again.
	for(int i =0; i< stringLength; i++) {
		e = name.charAt(i);
		if (x == e) {
		newString = name.replace(e, r);
		}
	}
	//print 
		System.out.println("This is the old string" +" "+ saveName);
		System.out.println("This is the new string"  +" "+ newString);
		 
	}
	
	public static void main(String[] args) {
		String realine = "The realest line I ever wrote";
		
		char toReplace = 101;// the letter e  
		char toReplaceWith = 114; // the letter r
		// static method to replace string letter 
		ReplaceMe(realine,toReplace,toReplaceWith);
	}

}
