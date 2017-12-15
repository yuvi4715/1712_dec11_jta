package com.assignment1.Problem32thru37;

public class Arithmetic {

	public static void itsMaths(String a, String b, String args)
	{
		int result = 0;
		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		
		//result = x+y;
		
		System.out.println(args);
		
		if(args.equals("+"))
			result = x+y;
		else if(args.equals("/"))
			result = x/y;
		else if(args.equals("-"))
			result = x-y;
		else if(args.equals("*"))
			result = x*y;
		else
			System.out.println("Error and Bug");
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		itsMaths(args[0],args[1],args[2]);
	}

}
