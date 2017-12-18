package question56;

public class EvenOrOddNoModulus {

	static int number = -455465643;
	public static void main(String[] args) {
		byte check = (byte) (number & 1);
		String evenOrOdd = "The number is ";
		if(check == 1) {
			evenOrOdd += " odd";
		}
		else {
			evenOrOdd += " even";
		}
			System.out.println(evenOrOdd);
	}

}
