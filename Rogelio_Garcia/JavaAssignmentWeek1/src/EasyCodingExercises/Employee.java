package EasyCodingExercises;

public class Employee {
	private String name;
	private String dept;
	private int age;
	public Employee(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public int getAge() {
		return age;
	}
}
