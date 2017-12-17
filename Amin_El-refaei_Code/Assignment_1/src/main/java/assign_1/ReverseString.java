package assign_1; // this class contains the code for number 44

public class ReverseString {

	public static void main(String[] args) {

		String str = "Hello Yuvi"; // created string called str containg "Hello Yuvi"
		for (int n = str.length() - 1; n >= 0; n--) { // created a for loop to read each character one by one and reverse them
			System.out.print(str.charAt(n));
		}
	}

}
