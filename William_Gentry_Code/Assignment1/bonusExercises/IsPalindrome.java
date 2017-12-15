package bonusExercises;

public class IsPalindrome {

	
	public static boolean isPalindrome(String s) {
		boolean palindromeFlag = false;
		int length = s.length() - 1;
		char[] array = s.toLowerCase().toCharArray();
		if (array.length % 2 == 0) {					//case for even letter word
			for (int i = 0; i < length; i++) {
				if (array[i] == array[length-i]) {
					palindromeFlag = true;
				} else {
					palindromeFlag = false;
				}
			}
		} else {										//case for odd letter word
			int midpoint = (length / 2);
			for (int i = 0; i < midpoint; i++) {
				if (array[i] == array[length - i]) {
					palindromeFlag = true;
				} else {
					palindromeFlag = false;
				}
			}
		}
		return palindromeFlag;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("hannah"));
		System.out.println(isPalindrome("a man a plan a canal panama"));
	}
}
