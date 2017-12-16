package getasew.assignment1.advancedcoding;
//44.Write a method to reverse a String without using API functions.

public class StringReversing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///System.out.println("hello".length());
		String stsample = "we are on break now";
		System.out.println(reverseString(stsample));

	}
	public static String reverseString(String str) {
		
		char[] arr = new char[str.length()];
		
		for(int i=str.length()-1,j=0;i>=0;i--,j++) {
			arr[j]= str.charAt(i);
		}
		
		String st = new String(arr);
		return st;
	}

}
