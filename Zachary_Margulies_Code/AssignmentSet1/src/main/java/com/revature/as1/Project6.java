package com.revature.as1;


public class Project6 implements TestableProject {
	
	String code;
	
	
	
	public void validate(String input) {
		//Just going to validate random 3 digit numeric codes
		
		if(input.length() != 3 ) {
			System.out.println("Code invalid, must be 3 digits long.");
		}else if(!input.matches("^[0-9]{3}$")) {
			System.out.println("Valid codes only contain numbers between 0 and 9");
		}else {
			switch (input) {
			case "001":
				System.out.println("You validated code 001. Why? Who knows.");
				break;
			case "002":
				System.out.println("Yep, 002 is a code as well.");
				break;
			case "004":
				System.out.println("We skipped 003 intentionally. Don't ask.");
				break;
			case "924":
				System.out.println("Nice job figuring out 924 was a valid code. Unless you looked at the source and knew this would happen.");
				break;
			default:
				System.out.println("Sorry, while that code validated, we can't do anything with it. Blame the funding.");
				break;
			}
			
		}
	}
	
	public void loopsExample() {
		//nothing special here, just basic examples because I was trying way too hard to be fancy
		boolean running = true;
		int counter = 0;
		
		
		while(running) {
			if(counter == 10) {
				System.out.println("Counter is: " + counter);
				running = false;
				continue; //Because goto never caused anyone problems
			}
			counter++;
		}
		
		counter = 0;
		
		do {
			System.out.println("Entering second loop.");
			if(counter != 10) {
				System.out.println("Counter is: " + counter);
				counter++;
				continue;
			} 
		} while(running);
		
		int last = 0, twoBack = 1, cur = 0;
		
		for(int i = 0; i < 10; i++) {
			cur = last + twoBack;
			twoBack = last;
			last = cur;
			
			
		}
		
		System.out.println("10th fibonachi number is: " + cur);
		
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
		KeyboardInputScanner in = new KeyboardInputScanner();
		
		String[] args = in.setStringArgs(1, "Please enter a 3 digit numeric code: ");
		
		code = args[0];
		
		
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		validate(code);
		loopsExample();
	}
	
	
}
