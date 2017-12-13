package AdvancedCodingExercises;

public class ArmStrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(checkArm(153));

	}
	
	private static String checkArm(int number) {
		int x = 0, y,z = number;
		
	    while(number>0)  
	    {  
	    	y=number%10;  
	    	number=number/10;  
	    	x=x+(y*y*y);  
	    }      
	    return (z == x) ? "armstrong number" : "Not armstrong number";
	}
		
}
