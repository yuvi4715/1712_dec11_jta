package com.revature.week1_jason_shen;

import java.util.*;

public class BonusExercises {
	static void swapIntegers(int x, int y) {
		System.out.println("X: " + x + " Y: " + y);
		System.out.println("Swapping...");
		
		// a + b = x + y
		// a = x
		// b = y
		// we want a = y, b = x
		
		x = x + y;  
		y = x - y; 
		x = x - y;
		System.out.println("X: " + x + " Y: " + y); 
	}
	static <T> void findMiddleNode(LinkedList<T> list) {
		System.out.println("The List: " + list);
		T slow = list.getFirst();
		T fast = list.getFirst();
		int slow_index = list.indexOf(slow);
		int fast_index = list.indexOf(fast);
		int size = list.size();
		
		while (slow != null && fast != null && slow_index + 1 < size && fast_index + 2 < size) {
			slow_index++;
			slow = list.get(slow_index);
			System.out.println(slow);
			fast_index += 2;
			fast = list.get(fast_index);
			System.out.println(fast);

		}
		System.out.println("Middle node: " + slow);
	}
}
