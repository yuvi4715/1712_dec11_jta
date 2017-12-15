package com.revature.question47;

import java.util.LinkedList;

// Create a Java application that finds the middle node of a LinkedList in one pass.
public class MidLinkedList {

	public static void findMid() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		//list.add(6);
		
		System.out.println("The elements inside the list are: ");
		for (int e : list) {
			System.out.print(e + " ");
		}
		
		int length = list.size();	
		// Case for when the list might be empty
		if (length == 0) {
			System.out.println("List is empty");
			System.exit(0);
		}
		// Case for when there is an even number of nodes inside the linked list
		else if (length % 2 == 0) {
			System.out.print("\nThe middle two nodes are: ");
			System.out.print(list.get((length/2)-1)+ " ");
			System.out.print(list.get(length/2));
		} else {
			System.out.print("\nThe middle node is: ");
			System.out.print(list.get(length/2));
		}
	}
	
	public static void main(String[] args) {
		findMid();
	}

}
