package assign_1; // this class is for number 33 on assignment 1

public class CheckOddEven {

	public static void main(String[] args) {
		int number = 17; // creates an int named number and assigning a value of 17
		
		if (number % 2 == 1) { // if int number mod 2 equals 1, print ODD. else print even
			System.out.println("ODD");
		} else {
			System.out.println("EVEN");
		}
	}

}
