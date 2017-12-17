package com.revature.day1;

public class Number18 {

	public void computeSUM(int x, int y) {
		//return x + y;
		int result = x + y;
		System.out.println(result);
		System.gc(); //request garbage collection (Number19)
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String one = "23";
		String two = "56";
		
		Runtime r = Runtime.getRuntime();
		
		r.totalMemory(); //three methods for runtime object (Number 20)
		r.freeMemory(); 
		r.gc();
		
		int twentythree = Integer.parseInt(one);
		int fiftysix = Integer.parseInt(two);
		
		
		Number18 sumthing = new Number18();
		
		sumthing.computeSUM(twentythree, fiftysix);
	}

}
