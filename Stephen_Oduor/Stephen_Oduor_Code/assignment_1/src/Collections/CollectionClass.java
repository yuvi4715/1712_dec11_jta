package Collections;

import java.util.*;

/**
 * Name: Stephen Omondi
 * Date: 12/12/2017
 * Question: 21, 22, 23
 * Description: Create an ArrayList, LinkedList, HashMap, TreeSet and a HashSet.
 *              Iterate over each collection and print each object.
 *              Sort the collections and compare the original to the sorted collection
 */

public class CollectionClass {

    public static void main(String[] args){

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet();

        for(int i = 0; i < 3; i++){
            arrayList.add(i);
            linkedList.add(i);
            hashMap.put(i, Integer.toString(i));
            treeSet.add(i);
            hashSet.add(i);

        }

        System.out.println(arrayList.toString());
        System.out.println(linkedList.toString());
        System.out.println(hashMap.toString());
        System.out.println(treeSet.toString());
        System.out.println(hashSet.toString());

        //Sort the Collections

    }
}


