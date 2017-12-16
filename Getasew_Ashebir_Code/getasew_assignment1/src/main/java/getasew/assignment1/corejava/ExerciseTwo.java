package getasew.assignment1.corejava;
//Program that gets the greatest of the 3 numbers
//using short-circuit operators.
public class ExerciseTwo {
	public static void main(String [] str) {
		int a, b, c;
		a =5;b = 9; c =1;
		int largest;
		
		if((a>b)&&(a>c)) {
			largest = a;
		}
		else if((b>a)&&(b>c)) {
			largest = b;
		}
		else {
			largest = c;
		}
	   System.out.printf("largest number is: %d",largest);
	}

}
