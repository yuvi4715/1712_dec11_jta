package com.revature.week1.Collections;

import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {

		// Creating the hashset
		Set<Dog> dogs = new HashSet<Dog>();

		// Creating the three objects
		Dog d1 = new Dog("Lassie", 10);
		Dog d2 = new Dog("Scooby Doo", 25);
		Dog d3 = new Dog("Snoopy", 5);

		// Added three objects to the hashset
		dogs.add(d1);
		dogs.add(d2);
		dogs.add(d3);

		// Printing out the original hashset
		for (Dog dog : dogs) {
			System.out.println(dog.getName() + " " + dog.getAge());
		}

		// Printing the sorted hashset
		List sortedList = new ArrayList(dogs);
		Collections.sort(sortedList);
		System.out.println(sortedList);
	}
}
