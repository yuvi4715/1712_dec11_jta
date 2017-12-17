package part11_AdvancedExercises;

public class StringReversal {

	public static void main(String[] args) {
		reverseString("Joseph Fernandez");
	}
	
	static void reverseString(String s) {
		
		int length = 0;
		boolean done = true;
		String reversed = null;
		
		try {
			do {
				s.charAt(length);
				length++;
			} while (done);
		} catch (Exception e) {
			for (int i = length - 1; i > -1; i--) {
				reversed += s.charAt(i);
			}
		} finally {
			System.out.println(reversed);
		}
		
	}
}
