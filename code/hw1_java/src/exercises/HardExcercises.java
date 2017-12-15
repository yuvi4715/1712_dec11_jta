package exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HardExcercises {
	public void stringReplace() {	//#38
		InputStreamReader r=new InputStreamReader(System.in);  
		BufferedReader br=new BufferedReader(r);  
		
		try {	//basic error check
			String str = "The dog jumped over the fence";
			System.out.println("The string is :\n" + str + "\nPlease enter a character to replace:");
			String oldchar=br.readLine();
			if (!str.contains(oldchar))
				throw new Exception();
			System.out.println("Enter a new char:");
			String newchar=br.readLine();
			String newstr = str.replace(oldchar, newchar);
			System.out.println("New string:\n" + newstr);  
		}
		catch (Exception e) {
			System.out.println("Input Exception");
		}
	}
	
	public void getAge() {	//#39 using only Calendar class to compute
		Calendar dob = new Calendar(1993, 12, 13);
		LocalDate now = LocalDate.now();
		Calendar today = new Calendar(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
		int age = 0;
		//calc age assuming dob is before current date
		if(today.month > dob.month)	//birthday already passed this year
			age = today.year - dob.year;
		else if (today.month == dob.month && today.day >= dob.day)	//birthday passed this month
			age = today.year - dob.year;
		else						//birthday hasnt happened yet
			age = today.year - dob.year - 1;
		
		System.out.println("Age for DoB " + dob.getString() + " is " + age);
		
		if(today.day == dob.day && today.month == dob.month) {
			System.out.println("Happy Birthday to You\n"
					+"Happy Birthday to You\n"
					+"Happy Birthday Dear Yuvi\n"
					+"Happy Birthday to You.");
		}
	}
	
	public void fibonacciIteration() { //#41
		long n = 100;
		
		if (n==1) System.out.println(1);
		if (n==0) System.out.println(0);
		
		long fn1 = 1, fn2 = 0;	//F_n minus 1, 2
		long fn = 0;
		
		for(int i=2; i<=n; i++) {
			fn = fn1 + fn2;
			fn2 = fn1;
			fn1 = fn;
			System.out.println(fn);
		}
	}
	
	public long fibonacciRecursion(long n) {
		if (n==1) return 1;
		if (n==0) return 0;
		return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
	}
	
	public void fizzbuzz() { //#41
		for (int i=1; i<=50; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				if (i%3 == 0) {
					System.out.print("Fizz");
				}
				if (i % 5 == 0) {
					System.out.print("Buzz");
				}
				System.out.println();
				continue;
			}
			System.out.println(i);
		}
	}
	
	public void compareEmployees() {	//#42
		Employee e1 = new Employee("Alice", "Marketing", 23);
		Employee e2 = new Employee("Pam", "Marketing", 24);
		Employee e3 = new Employee("John", "IT", 29);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		Collections.sort(employees);
		for (Employee e: employees)
			System.out.println(e.name + " " + e.department + " " + e.age); //sorted list of names
		
		System.out.println();
		
		Collections.sort(employees, e3);
		for (Employee e: employees)
			System.out.println(e.name + " " + e.department + " " + e.age); //sorted list of age
	}
	
	public void reverseString(String str) {	//#43
		char[] strReversed = new char[str.length()];
		for(int i=str.length(); i>0; i--) {
			strReversed[str.length()-i] = str.charAt(i-1);
		}
		String newstr = new String(strReversed);
		System.out.println(newstr);
	}
	
	public boolean checkArmstrong(int n) { //#44
		int sum = 0, remainder, digits = 0;
		int temp = n;
		while (temp != 0) {	 //count num of digits
			digits++;
			temp = temp/10;
		}
 
		temp = n;
		while (temp != 0) {
			remainder = temp%10;	//get rightmost digit first
			sum = sum + (int) Math.pow((double)remainder, (double)digits);
			temp = temp/10;
		}
 
		if (n == sum) return true;
		else return false;        
	}
	
	public boolean checkPrime(int n) {	//#45 trivial prime checker
	    //check if num is even
	    if (n%2==0) return false;
	    //if not, then just check the odds up to the square
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	

}
