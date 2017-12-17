package bonusExercises;

import java.util.LinkedList;
import java.util.ListIterator;

public class FindMiddleNode {

	public static void main(String[] args) {
		/*
		 * Create a Java application that finds the middle node of a LinkedList in one pass.
		 */
		LinkedList<String> lnkd = new LinkedList<>();
		lnkd.add("1");
		lnkd.add("2");
		lnkd.add("3");
		lnkd.add("4");
		lnkd.add("5");
		lnkd.add("6");
		System.out.println(findMiddle(lnkd));
	}
	
	public static int findMiddle(LinkedList<String> list) {
		ListIterator<String> fast = (ListIterator<String>) list.iterator();
		ListIterator<String> slow = (ListIterator<String>) list.iterator();
		int middle=0;
		while (fast.hasNext()) {
			fast.next();
			if (fast.nextIndex() % 2 == 0) {
				slow.next();
				middle = slow.nextIndex();
			}
		}
		return middle;
	}
}
