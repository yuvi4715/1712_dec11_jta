package com.revature.as1.adv;

public class PrimeChecker {
	
	public static boolean primeCheck(int in) {
		
		for(int i = 2; i < Math.sqrt(in); i++) {
			if(in%i == 0) {
				return false;
			}
		}
		return true;
	}

}
