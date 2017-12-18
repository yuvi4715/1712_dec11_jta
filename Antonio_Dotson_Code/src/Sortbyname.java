import java.util.Comparator;

public class Sortbyname implements Comparator<CompareEmployees>
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
