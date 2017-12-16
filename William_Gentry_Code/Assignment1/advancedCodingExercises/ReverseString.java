package advancedCodingExercises;

public class ReverseString {
	
	
	/*
	 * 
	 * Yuvi, I did it! I reversed the String only using charAt()!!!!!!
	 * Its friday night and I almost slacked you the news, figured I might
	 * just leave you this note instead. Most rewarding problem ever
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		reverseString("William");
	}
	
	
	static void reverseString(String s) {
		int length = 0;
		boolean done = true;
		String reversed = "";
		try {
			do {
				s.charAt(length);
				length++;
			} while (done);
		} catch (Exception e) {
			for (int i = length - 1; i > -1; i--) {
				reversed += s.charAt(i);
			}
		}
		System.out.println(reversed);
	}
}
