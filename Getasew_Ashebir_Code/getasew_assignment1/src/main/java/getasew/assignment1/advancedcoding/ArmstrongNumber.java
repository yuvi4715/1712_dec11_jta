package getasew.assignment1.advancedcoding;
//43.Write Java program to check if a number is Armstrong or not.
public class ArmstrongNumber {

	public static void main(String[] args) {
		//calling the method that checks if number is Armstrong.
		System.out.println(checkArmstrongNumber(371));

	}
	static int numberofdigit(int n) {
		String st = new Integer(n).toString();
		return st.length();
	}
	static boolean checkArmstrongNumber(int num) {
		int l;
		l= numberofdigit(num);
		int armstrong=0;
		for(int i=0;i<l;i++) {
			//calculate the sum of the cube of each digit.
			armstrong += Math.pow(getDigit(new Integer(num).toString(), i),3);
			
		}
		//checks if the number is Armstrong
		if(num == armstrong) {
			return true;
		} else {
			return false;
		}
	}
	//method that returns individual digits.
	static int getDigit(String st, int ind) {
		return Integer.parseInt(Character.toString(st.charAt(ind)));
	}

}
