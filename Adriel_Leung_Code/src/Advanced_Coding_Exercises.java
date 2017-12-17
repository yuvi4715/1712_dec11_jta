import java.util.Calendar;
import java.util.Comparator;

public class Advanced_Coding_Exercises {
	
	public static void replaceChar(String s, char target, char replacement) {
		
		char[] temp = s.toCharArray();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == target) {
				temp[i] = replacement;
			}
		}
		
		String result = new String(temp);
		System.out.println("Replaced all letters of "+ target 
				+ " in the string with " + replacement + ".");
	}
	
	public static int findAge(Calendar birthday) {
		Calendar today = Calendar.getInstance();
		today.set(2017, 12, 17);
		int age = today.YEAR - birthday.YEAR;
		if (birthday.MONTH > today.MONTH) {
			age--;
		}
		else if (birthday.MONTH == today.MONTH && birthday.DAY_OF_MONTH > today.DAY_OF_MONTH){
			age--;
		}
		System.out.println("Your age is: " + age + ".");
		
		if (birthday.MONTH == today.MONTH && birthday.DAY_OF_MONTH == today.DAY_OF_MONTH) {
			System.out.println("Happy birthday to you!");
			System.out.println("Happy birthday to you!");
			System.out.println("Happy birthday dear Adriel,");
			System.out.println("Happy birthday to you!");
		}
		
		return age;
	}
	
	public static void fibonacciIteration() {
		int n = 100;
		int a = 1;
		int b = 1;
		int sum = 0;
		System.out.println(a);
		System.out.println(b);
		for (int i = 0; i < n; i++) {
			sum = a + b;
			System.out.println(sum);
			a = b;
			b = sum;
		}
	}
	public static int fibonacciRecursion(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			int sum = fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
			System.out.println(sum);
			return (sum);
		}
	}
	
	public static void fizzBuzz() {
		for (int i = 1; i <= 50; i++) {
			if ((i % 3 == 0) && (i % 5 == 0)) {
				System.out.println("FizzBuzz");
			}
			else if (i % 3 == 0){
				System.out.println("Fizz");
			}
			else if (i % 5 == 0){
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
	
	public static class Employee{
		String name;
		String department;
		int age;
		
		public Employee(String n, String d, int a){
			name = n;
			department = d;
			age = a;
		}
		
		public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.name.compareTo(e2.name);
			}
		};
		
		public static Comparator<Employee> DepartmentComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.department.compareTo(e2.department);
			}
		};
		
		public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.age - e2.age;
			}
		};
		
	}
	
	public static void isArmstrong(int n) {
		int temp = n;
		int sum_of_cubes = 0;
		while (temp != 0) {
			int digit = temp % 10;
			sum_of_cubes += digit * digit * digit;
			temp /= 10;
		}
		if (sum_of_cubes == n) {
			System.out.println(n + " is an Armstrong number.");
		}
		else {
			System.out.println(n + " is not an Armstrong number.");
		}
	}
	
	public static void reverseString(String s) {
		char result[] = s.toCharArray();
		char temp;
		for (int i = 0; i < result.length / 2; i++) {
			//swaps the chars between beginning and end
			temp = result[i];
			result[i] = result[result.length - 1 - i];
			result[result.length - 1 - i] = temp;
		}
		String reversed = new String(result);
		System.out.println("The reversed string is: " + reversed);
	}
	
	public static void isPrime(int n) {
		if (n % 2 == 0) {
			System.out.println("Number is multiple of 2 so is not prime.");
			return;
		}
		for (int i = 3; i*i <= n; i += 2) {
			if (n % i == 0) {
				System.out.println("Number is multiple of an odd number so is not prime.");
				return;
			}
		}
		System.out.println(n + " is prime.");
	}
	
	public static void main(String args[]) {
		replaceChar("Hello World", 'o', 'z');
		
		Calendar adriel_birth = Calendar.getInstance();
		//My birthday is Dec 17!
		adriel_birth.set(1994, 12, 17);
		findAge(adriel_birth);
		
		
		fizzBuzz();
		
		isArmstrong(371);
		
		reverseString("Hello World");
		
		isPrime(137);
	}
}
