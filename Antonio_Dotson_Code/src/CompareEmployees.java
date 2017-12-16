// Java program to demonstrate working of Comparator
	// interface
	import java.util.*;

	// A class to represent Employees. Problem 42
	class CompareEmployees
	{
		int age;
		String name, department;

		// Constructor
		public CompareEmployees(int age, String name,
								String department)
		{
			this.age = age;
			this.name = name;
			this.department = department;
		}

		// Used to print student details in main()
		public String toString()
		{
			return this.age + " " + this.name +
							" " + this.department;
		}
	}

	class Sortbyroll implements Comparator<CompareEmployees>
	{
		// Used for sorting in ascending order of
		// roll number
		public int compare(CompareEmployees a, CompareEmployees b)
		{
			return a.age - b.age;
		}
	}

	class Sortbyname implements Comparator<CompareEmployees>
	{
		// Used for sorting in ascending order of
		// roll name
		public int compare(CompareEmployees a, CompareEmployees b)
		{
			return a.name.compareTo(b.name);
		}
	}

	class Sortbydepartment implements Comparator<CompareEmployees>
	{
		// Used for sorting in ascending order of
		// roll name
		public int compare(CompareEmployees a, CompareEmployees b)
		{
			return a.department.compareTo(b.department);
		}
	}


	// Driver class
	class Main
	{
		public static void main (String[] args)
		{
			ArrayList<CompareEmployees> ar = new ArrayList<CompareEmployees>();
			ar.add(new CompareEmployees(55, "Richard", "Hr"));
			ar.add(new CompareEmployees(44, "James", "Sales"));
			ar.add(new CompareEmployees(33, "Antonio", "IT"));

			System.out.println("Unsorted");
			for (int i=0; i<ar.size(); i++)
				System.out.println(ar.get(i));

			Collections.sort(ar, new Sortbyroll());

			System.out.println("\nSorted by age");
			for (int i=0; i<ar.size(); i++)
				System.out.println(ar.get(i));

			Collections.sort(ar, new Sortbyname());

			System.out.println("\nSorted by name");
			for (int i=0; i<ar.size(); i++)
				System.out.println(ar.get(i));
			
			Collections.sort(ar, new Sortbydepartment());

			System.out.println("\nSorted by department");
			for (int i=0; i<ar.size(); i++)
				System.out.println(ar.get(i));
		}
	}
