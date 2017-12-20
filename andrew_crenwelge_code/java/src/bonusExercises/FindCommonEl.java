package bonusExercises;

import java.util.ArrayList;
import java.util.List;

public class FindCommonEl {

	public static void main(String[] args) {
		String[] arr1 = new String[] {"Hello","Goodbye","a","b"};
		String[] arr2 = new String[] {"Hello","c","d","6","a"};
		List<String> common = findCommon(arr1,arr2);
		System.out.println(common);
	}
	
	// this method works with string arrays but could be overloaded using the same concept
	public static List<String> findCommon(String[] a1, String[] a2) {
		List<String> result = new ArrayList<>();
		for (String s : a1) {
			for (String t : a2) {
				if (s.equals(t))
					result.add(s);
			}
		}
		return result;
	}

}
