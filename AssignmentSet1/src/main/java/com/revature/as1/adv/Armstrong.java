package com.revature.as1.adv;

public class Armstrong {
	
	public static boolean checkArmstrong(int in) {
		//only checks for 3 digit Armstrongs
		
		int ones = in % 10;
		int tens = (in/10) % 10;
		int hundreds = (in/100);
		
		if((Math.pow(ones, 3) + Math.pow(tens, 3) + Math.pow(hundreds, 3) == in)) {
			return true;
		}
		
		return false;
	}

}
