import java.util.Comparator;

public class Sortbyroll implements Comparator<CompareEmployees>
	{
		// Used for sorting in ascending order of
		// roll number
		public int compare(CompareEmployees a, CompareEmployees b)
		{
			return a.age - b.age;
		}
	}


