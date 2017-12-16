import java.util.*;


/**
 * @author Antonio Dotson
 *
 */
public class Problem21 {

	/**
	 * Created HashMap, ArrayList, linkedlist, Hashset and printed its values.
	 * Problems 21 - 23
	 */
	public static void main(String[] args) {
       
		LinkedList llist = new LinkedList<Problem21>();
		
		llist.addFirst("Item1"); 
		llist.addLast("Item2");            
		PrintList(llist);
		
		llist.add(1, "Item1.5");
		PrintList(llist);
		
		List plist = new ArrayList<Problem21>();
		plist.add("Nickels");
		plist.add("Dimes");
		plist.add("Quarters");
		PrintNewList(plist);
		
		HashSet hs = new HashSet<Problem21>();
		hs.add(1);
		hs.add(2);
		hs.add(3);
		PrintNewHash(hs);
		
		HashMap<String,Double> myBalance = new HashMap<String,Double>();
		myBalance.put("Bobby", 25000.09);
		myBalance.put("Ricky", 35025.93);
		myBalance.put("Mike",  75000.76);
		System.out.println(myBalance);
	}

	private static void PrintList(LinkedList<Problem21> linkedList)
	{
		System.out.println(linkedList);
	}
	
	private static void PrintNewList(List<Problem21> ulist)
	{
		System.out.println(ulist);
	}
	private static void PrintNewHash(HashSet<Problem21> mlist) {
		System.out.println(mlist);
	}
	
	//private static void PrintHashMap(HashMap uhash, double y)
//	{
	//	System.out.println(value,key);
//	}
	
	
}



	