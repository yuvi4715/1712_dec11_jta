package advancedConcepts;

public class AdvancedConcepts19 {
	/*
	 * Request garbage collection in your method
	 */
	public static void main(String[] args) {
		String one = new String("I will be garbage collected");
		String two = new String("I will have two reference variables that point to me");
		one = two;
		System.out.println("one is a reference variable to String obj located at "+one.hashCode()+" in memory with value: "+one);
		System.out.println("two is a reference variable to String obj located at "+two.hashCode()+" in memory with value: "+two);
		// garbage collector will now be able remove the String object "I will be garbage collected"
		// in the string pool because there are no reference variables pointing to it
		System.gc();
		// do some more stuff after garbage collection
	}

}
