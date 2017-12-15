package question49;

public class MakeSubstring {
	
	public String getSubstring(String original, int start, int end) throws NullPointerException {
		String temp = "";
		
		if(start < original.length() - 1 || end < original.length()) {
			for(int i = start; i <= end; i++) {
				temp += original.charAt(i);
			}
		}
		else {
			throw new NullPointerException();
		}
		
		return temp;
	}
	

}
