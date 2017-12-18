import java.util.HashMap;
import java.util.Map;
import java.util.Set;
 
public class DuplicateCharsacters {
 

	
	public static boolean FindDuplicates(String counting) {
		 char[] chrs = counting.toCharArray();
		 boolean duplicates=false;
		    for (int j=0;j<chrs.length;j++)
		      for (int k=j+1;k<chrs.length;k++)
		        if (k!=j && chrs[k] == chrs[j])
		          duplicates=true;

		    return duplicates;
	}
	
	public static void main(String[] args) {
		String test = "Helo";
		boolean duplicatesFound = FindDuplicates(test);
		if(true == duplicatesFound) {
			System.out.println("Found duplicates to be " + duplicatesFound);
		}else
			{
			System.out.println("Found duplicates to be " + duplicatesFound);
		}
		
	}
}
