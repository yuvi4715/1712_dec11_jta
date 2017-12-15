package question47;

import java.util.LinkedList;

public class MiddleLinkedList {

	public static void main(String[] args) {

		LinkedList<Integer> testList = new LinkedList<Integer>();
		testList.add(4);
		testList.add(2);
		testList.add(9);
		testList.add(3);
		testList.add(1);
		testList.add(5);
		
		int index = 0;
		while(testList.get(index) != testList.getLast()) {
			index++;
		}
		System.out.println("The middle node is: " + testList.get(index/2));
	}

}
