package com.assignment1;

public class Problem44 {

	static void reverse(String s) {
		int i = 0;
		try {
			while (true) {
				s.charAt(i);
				i++;
			}
		} catch (Exception e) {
			System.out.println("Found num chars");
		}
		
		char[] temp = new char[i];
		int k = 0;
		for(int j = i-1; j >= 0; j-- )
		{
			//System.out.println(s.charAt(j));
			temp[k] = s.charAt(j);
			k++;
		}
		System.out.println(temp);
		

		
	}

	public static void main(String[] args) {
		String s = "Hello";
		
		reverse(s);
	}

}
