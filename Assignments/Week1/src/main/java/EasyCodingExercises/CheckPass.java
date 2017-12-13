package EasyCodingExercises;

import java.util.*;
public class CheckPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			new CheckPass().checkPass();
		}

	}
	
	
	public void checkPass() {
		Random rand  = new Random();
		int number = rand.nextInt(100) + 1;
		
		if(number < 50) {
			System.out.printf("Passed with %d\n", number);
		}
		else if(number >= 50) {
			System.out.printf("Failed with %d\n", number);
			
		}
	}
	
	
	
}
