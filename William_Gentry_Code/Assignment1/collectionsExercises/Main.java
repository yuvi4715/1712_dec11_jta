package collectionsExercises;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> progLanguages = new ArrayList<String>();
		List<String> greekAlphabet = new LinkedList<String>();
		HashMap<Integer, String> collegeFootballRankings = new HashMap<Integer, String>();
		TreeSet<Double> treeSet = new TreeSet<Double>();
		HashSet<String> plantBasedProtein = new HashSet<String>();
		
		progLanguages.add("Java");
		progLanguages.add("Ruby");
		progLanguages.add("Python");
		
		greekAlphabet.add("Alpha");
		greekAlphabet.add("Beta");
		greekAlphabet.add("Gamma");
		
		collegeFootballRankings.put(1, "Clemson");
		collegeFootballRankings.put(2, "Oklahoma");
		collegeFootballRankings.put(3, "Georgia");
		
		treeSet.add(45.0);
		treeSet.add(100.89);
		treeSet.add(45.0);
		
		plantBasedProtein.add("Tofu");
		plantBasedProtein.add(null);
		plantBasedProtein.add("Soy");
		
		
		
		System.out.println("Iterating through ArrayList:");
		for (int i = 0; i < progLanguages.size(); i++) {
			System.out.println(progLanguages.get(i));
		}
		System.out.println("\n");
		
		System.out.println("Iterating through LinkedList:");
		Iterator it = greekAlphabet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("\n");
		
		System.out.println("Iterating through HashMap:");
		Iterator<Map.Entry<Integer, String>> entries = collegeFootballRankings.entrySet().iterator();
		while(entries.hasNext()) {
			HashMap.Entry<Integer, String> entry = entries.next();
			System.out.println("Key: "  + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println("\n");
		
		System.out.println("Iterating through TreeSet:");
		Iterator it2 = treeSet.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println("\n");
		
		System.out.println("Iterating through HashSet:");
		Iterator it3 = plantBasedProtein.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		
	}

}
