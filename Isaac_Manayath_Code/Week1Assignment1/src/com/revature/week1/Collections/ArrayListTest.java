package com.revature.week1.Collections;

import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {

		// Creating the arraylist
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("Lassie", 10));
		dogs.add(new Dog("Scooby Doo", 25));
		dogs.add(new Dog("Snoopy", 5));

		// Printing the original collection
		System.out.println("Original Collection");

		// Printing the dog objects
		for (Dog dog : dogs) {
			System.out.println(dog);
		}

		// Organizing list by age
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
		System.out.println();
		System.out.println("Sorted Collection based on age");
		// Printed the order collection
		Collections.sort(dogs, new AgeCompare());
		for (Dog dog : dogs) {
			System.out.println(dog.getName() + dog.getAge());
		}
	}
}
