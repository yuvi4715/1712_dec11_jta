package Bonus;

public class SubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// here we have the initial string
		String name = "Jose Perez";
		//here we are getting the index of the letter e
		int index = name.indexOf("e");
		
		//here we set the new string to new name and get the substring starting from
		// the index that we previous set and to a specified number
		String newName = name.substring(index, 10);
		//printing new name
		System.out.println(newName);
		
		// here we are getting the index of the letter e and the letter r
		int index1 = name.indexOf("e");
		int index2 = name.indexOf("r");
		
		//here we are getting everthing from index1 and index2
		String newName2 = name.substring(index1, index2);
		//printing out the new name 
		System.out.println(newName2);
		
		
		
	}
	

}
