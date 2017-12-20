package bonusExercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetDistinctElements {

	public static void main(String[] args) {
		String[] test = new String[] {"a","a","b","c","d","d","e"};
		List<String> l = Arrays.asList(test);
		System.out.println("This set returns the original list but deletes duplicates: "+makeDistinct(l));
		System.out.println("This set should return only elements that appear once: "+getDistinct(l));
	}
	
	public static Set<String> makeDistinct(List<String> arr) {
		Set<String> set = new HashSet<>();
		for (String s : arr) {
			set.add(s);
		}
		return set;
	}
	
	public static Set<String> getDistinct(List<String> arr) {
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (String s : arr) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}
			else {
				map.putIfAbsent(s, 1);
			}
		}
		for (String s : map.keySet()) {
			if(map.get(s)==1) {
				set.add(s);
			}
		}
		return set;
	}
}
