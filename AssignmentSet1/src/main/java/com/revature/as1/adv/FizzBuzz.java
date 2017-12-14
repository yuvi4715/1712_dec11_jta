package com.revature.as1.adv;

public class FizzBuzz {
	
	public static void fizzBuzz() {
		
		for(int i = 1; i <= 50; i++) {
			boolean flip = false;
			if(i%3 == 0) {
				System.out.print("Fizz");
				flip = true;
			}
			if(i%5 == 0) {
				System.out.print("Buzz");
				flip = true;
			}
			if(!flip) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
