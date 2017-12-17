package advancedcodingexcercises;

public class Problem44 {
	//charAt is allowed
	public static void main(String[] args) {
		String a="Ravi"; 

		for(int i=0;i<=a.length()-1;i++) 
		{ 
		System.out.print(a.charAt(i)); 
		} 
		System.out.println();
		System.out.println("String in reverse:");
		for(int i = a.length() - 1; i >= 0; --i) 
		{ 
		System.out.println(a.charAt(i)); 
		} 

		}

}
