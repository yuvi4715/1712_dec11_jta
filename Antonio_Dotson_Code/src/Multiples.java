//Antonio Dotson --- problem 41--- 
public class Multiples {

	public static void main(String[] args) {
		// loop to 50
		for(int i=1; i<=50 ; i++) {
			// find all multiples of 3 and 5 first
            if((i%3==0) && (i%5==0)) {
            	System.out.println("FizzBuzz");
            	continue;
            }   // then multiples of 3--- used continue to remove the number and print the word
            else if(i%3==0) {
            	System.out.println("Fizz");
            	continue;
            } // then multiples of 5
            else if(i%5==0) {
            	System.out.println("Buzz");
            	continue;
            }// actually I had the print statement at the begin of the loop , that didn't work moved to the end. 
            System.out.println(i);
	 }
	}
}
