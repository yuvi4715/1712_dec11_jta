package getasew.assignment1.syntax;
//Create an example for each control statement.
public class ExerciseSix {
	public static void main(String [] str) {
		//Control flow statements example
		int a = 9;
		int b = 10;
		//if
	    if(a>b) {
	    	System.out.println("a is greater than b");
	    }
	    //if else
	    if(a>b) {
	    	System.out.println("a is greater than b");
	    }
	    else {
	    	System.out.println("a is not greater than b");
	    }
	    //if else if
	    if(a>b) {
	    	System.out.println("a is greater than b");
	    }
	    else if(a<b) {
	    	System.out.println("a is less than b");
	    }
	    else {
	    	System.out.println("a is equal to b");
	    }
	    //testing while loop
	    int i= 0;
	    while(i<5) {
	    	System.out.println("testing while loop");
	    	i++;
	    }
	    //testing for loop
	    for(int j=0;j<=4;j++) {
	    	System.out.println("I'm for-loop");
	    }
	    //testing  do-while loop
	    int k=0;
	    do {
	    	System.out.println("do-while loop");
	    	k++;
	     } while(k<5);
	    //switching statements
	    int weekday =6;
	    switch(weekday) {
	    case 1:
	    	System.out.println("Sunday");
	    	break;
	    case 2:
	    	System.out.println("Monday");
	    	break;
	    case 3:
	    	System.out.println("Tuesday");
	    	break;
	    case 4:
	    	System.out.println("Wednesday");
	    	break;
	    case 5:
	    	System.out.println("Thursday");
	    	break;
	    case 6:
	    	System.out.println("Friday");
	    	break;
	    case 7:
	    	System.out.println("Saturday");
	    	break;
	    default:
	    	System.out.print("no input");
	    	break;
	    		
	    }

	     }
	
}
