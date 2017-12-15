package AdvancedConcepts;
import java.util.StringTokenizer;
public class AdvancedConcepts {
	public static void main(String[] args) {
		// 16
		String str = "manipulateMe";
		StringBuilder sb = new StringBuilder(str);
		sb.append("Appended");
		sb.insert(10, "Inserted");
		sb.delete(0, 3);
		sb.reverse();
		System.out.println(sb.toString());
		
		// 17
		String tokenize = "pickles:ketchup:mustard:onions";
		StringTokenizer st = new StringTokenizer(tokenize, ":");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		// 18
		String num1 = "20";
		String num2 = "20";
		System.out.println(new Integer(num1) * new Integer(num2));
		
		// 19
		System.gc();
		
		// 20
		Runtime rt = Runtime.getRuntime();
		// returns the number of available free memory left
		System.out.println(rt.freeMemory());
		// runs the garbage collector, it's just a suggestion though
		rt.gc();
		// returns total memory in JVM
		System.out.println(rt.totalMemory());
		
	}
}
