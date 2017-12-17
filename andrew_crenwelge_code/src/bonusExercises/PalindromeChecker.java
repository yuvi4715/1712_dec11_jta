package bonusExercises;

public class PalindromeChecker {

	public static void main(String[] args) {
		String test1 = "racecar";
		String test2 = "palindrome";
		System.out.println(checkPalindrome(test1));
		System.out.println(checkPalindrome(test2));
	}
	
	public static boolean checkPalindrome(String s) {
		String[] arr = s.split("");
		String[] arr2 = new String[s.length()];
		for (int a=0;a<arr.length;a++) {
			arr2[arr.length-1-a] = arr[a];
		}
		String test = String.join("", arr2);
		if (test.equals(s))
			return true;
		else
			return false;
	}

}
