import java.util.StringTokenizer;
// Antonio Dotson
public class Problem17 {
	public static void main(String[] args) {
		Problem17.tokenExample();	
	}
// separated string by : using StringTokenizer
	public  static void tokenExample() {
		String s10 = "pickles:ketchup:mustard:onion";
		StringTokenizer tokens = new StringTokenizer (s10, ":");
		//ran through loop printed out values
		while(tokens.hasMoreElements()) {
		System.out.println(tokens.nextElement());
		} 
	}	
}
