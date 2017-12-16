package com.revature.week1.Collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		// Creating the linkedlist
		LinkedList<Dog> dogs = new LinkedList<Dog>();

		// Created three objects
		dogs.add(new Dog("Lassie", 10));
		dogs.add(new Dog("Scooby Doo", 25));
		dogs.add(new Dog("Snoopy", 5));

		System.out.println("Original Collection");

		// Printing out the original collection
		for (Dog dog : dogs) {
			System.out.println(dog);
		}

		System.out.println();

		// Organizing the list by age
		class AgeCompare implements Comparator<Dog> {
			@Override
			public int compare(Dog dog1, Dog dog2) {
				int Dog1Age = dog1.getAge();
				int Dog2Age = dog2.getAge();

				if (Dog1Age < Dog2Age) {
					return 1;
				} else if (Dog1Age > Dog2Age) {
					return -1;
				} else {
					return 0;
				}
			}
		}

		System.out.println("Sorted collection based on dog age.");

		// printing out the collection list
		Collections.sort(dogs, new AgeCompare());
		for (Dog dog : dogs) {
			System.out.println(dog.getName());
		}
	}

}
