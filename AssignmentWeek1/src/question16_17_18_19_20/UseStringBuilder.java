package question16_17_18_19_20;

import java.util.StringTokenizer;

public class UseStringBuilder {

	
	public void modifySB() { // #16
		StringBuilder sb = new StringBuilder("String");
		
		System.out.println(sb.toString());
		sb.setCharAt(3, 'o');
		System.out.println(sb.toString());
		sb.setCharAt(3, 'a');
		System.out.println(sb.toString());
		sb.append('e');
		System.out.println(sb.toString());
		sb.append(2);
		System.out.println(sb.toString());
		sb.deleteCharAt(7);
		System.out.println(sb.toString());
	}
	
	public void stringTokens() {//# 17
		String tokens =  "pickles:ketchup:mustard:onion";
		StringTokenizer st = new StringTokenizer(tokens, ":");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
	public void twoStrings() { // #18
		String a = "21";
		String b = "25";
		StringBuilder sb = new StringBuilder(a + b);
		
		System.out.println(sb.toString());
	}
	
	public void forceGarbageCollect() { // #19
		System.gc();
	}
	
	public void runtimeUse() { //#20
		Runtime r = Runtime.getRuntime();
		r.gc();
		System.out.println(r.totalMemory());
		System.out.println(r.freeMemory());
		System.out.println(r.maxMemory());
	}
}
