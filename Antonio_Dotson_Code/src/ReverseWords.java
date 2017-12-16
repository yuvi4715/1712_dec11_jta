//Antonio Dotson
public class ReverseWords {
//Problem number 44
	
	    public static void main(String[] args) {
	        String reverse = "Hi, All this is Antonio Dotson";
	        int len = reverse.length();
	        char[] tempCharArray = new char[len];
	        char[] charArray = new char[len];
	        
	        // put original string in an 
	        // array of chars
	        for (int i = 0; i < len; i++) {
	            tempCharArray[i] = reverse.charAt(i);
	        } 
	        
	        // reverse array of chars
	        for (int j = 0; j < len; j++) {
	            charArray[j] = tempCharArray[len - 1 - j];
	        }
	        // //created new String object and printed it out
	        String reverseReverse = new String(charArray);
	        System.out.println(reverseReverse);
	    }
	}


