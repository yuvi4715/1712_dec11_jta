package advancedconcepts;
import java.util.StringTokenizer;


public class Strings {
	public void stringEdit(String str) {	//#16
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        builder.deleteCharAt(str.length()-1);
        builder.insert(str.length()-1, " inserted portion");
        System.out.println(builder.toString());
	}
	
	public void stringToken(String str) { //#17		
		StringTokenizer st = new StringTokenizer(str, ":");
	     while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }
	}
	
	public void stringadd(String s1, String s2) { //#18
		System.out.println(Integer.parseInt(s1) + Integer.parseInt(s2));
		 System.gc();	//#19 request garbo collection
	}
}
