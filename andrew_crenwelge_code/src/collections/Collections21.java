package collections;

import java.util.*;

public class Collections21 {

	public static void main(String[] args) {
		List<String> arrlist = new ArrayList<>();
		List<String> linkedlist = new LinkedList<>();
		Map<String, String> hm = new HashMap<>();
		Set<String> ts = new TreeSet<>();
		Set<String> hs = new HashSet<>();

		String s = "hello";

		// add 3 objects to each
		for (int i = 0; i < 3; i++) {
			String t = s + i;
			arrlist.add(t);
			linkedlist.add(t);
			hm.put(t, new String(t));
			ts.add(t);
			hs.add(t);
		}

		// Iterate over each collection and print each object.
		for (String el : arrlist) {
			System.out.println(el);
		}
		for (String el : linkedlist) {
			System.out.println(el);
		}
		for (String el : hm.values()) {
			System.out.println(el);
		}
		for (String el : ts) {
			System.out.println(el);
		}
		for (String el : hs) {
			System.out.println(el);
		}
		// Sort the collections and compare the original to the sorted collection.
		Collections.sort(arrlist);
		Collections.sort(linkedlist);
		System.out.println(arrlist);
		System.out.println(linkedlist);

		for (String el : hm.values()) {
			
		}
		for (String el : ts) {

		}
		for (String el : hs) {

		}
	}
}
