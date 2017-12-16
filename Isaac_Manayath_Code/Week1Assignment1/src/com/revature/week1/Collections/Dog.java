package com.revature.week1.Collections;

public class Dog implements Comparable<Dog> {

	// Creating the java bean
	private String name;
	private int age;

	public Dog(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Dog d) {
		// TODO Auto-generated method stub
		if (age > d.age) {
			return 1;
		} else if (age < d.age) {
			return -1;
		} else {
			return 0;
		}
	}

}
