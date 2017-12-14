package com.revature.as1.advconcepts;

import java.io.IOException;
import java.util.StringTokenizer;

public class AdvancedDriver {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); //Because sometimes StringBuffers are too slow and you need non-immutable strings
		
		sb.append("Initial string");
		System.out.println(sb);
		sb.insert(7, "Inserted ");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		sb = new StringBuilder("happy hardcore:drum and bass:hardstyle:hard trance");
		
		StringTokenizer st = new StringTokenizer(sb.toString(), ":");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		String a = "20", b = "33";
		
		addStrings(a,b);
		
		System.gc();
		
		Runtime rt = Runtime.getRuntime();
		
		try {
			rt.exec("dummycommand"); //can be used to launch deamons, or other such processes on the JVM
			rt.availableProcessors(); //could be used for multi-threading optimization
			rt.addShutdownHook(null); //can be used to set up triggers that fire upon the JVM shutting down. Useful in emergency situations where the JVM terminates unexpectedly as a data-saving tool. Also useful in expected scenarios for clean shutdowns.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //can be used
	}
	
	public static int addStrings(String a, String b) {
		return Integer.parseInt(a) + Integer.parseInt(b);
	}

}
