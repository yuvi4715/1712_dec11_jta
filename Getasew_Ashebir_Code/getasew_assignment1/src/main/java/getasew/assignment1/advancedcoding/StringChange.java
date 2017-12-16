package getasew.assignment1.advancedcoding;
//38.Write a method to replace a given character in a 
//String with another character.

public class StringChange {
	public static void main(String[] args) {
		String st = "It is morning now";
		System.out.println("before function call: "+st);
		replaceChar(st,'m','g');
	}
	public static void replaceChar(String str, char c,char rep) {
		 String s= null;
		for(int i= 0;i<str.length();i++) {
			if(str.charAt(i) == c) {
				s =str.replace(c, rep);
				
				
			}
		}
		System.out.println(s);
	
	}

}
