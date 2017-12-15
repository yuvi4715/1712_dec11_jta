package Syntax;

// 6
public class Control {
	public static void main(String[] args) {
		//if-elseif-else
		boolean a = false;
		if (a) {
			//do something
		} else if (a) {
			//do something else
		} else {
			// otherwise do this
		}
		
		//switch
		String season = "winter";
		switch(season) {
			case "fall": System.out.println("it's fall");
			break;
			case "spring": System.out.println("it's spring");
			break;
			case "summer": System.out.println("it's summer");
			break;
			case "winter": System.out.println("it's winter");
			break;
			default: System.out.println("undefined season");
			break;
		}
		
		// for loop
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		//do while
		int i = 0;
		System.out.println(i);
		do {
			i++;
		}
		while (i < 10);
		System.out.println(i);
		
		//while
		while (i > 0) {
			i--;
		}
		System.out.println(i);
	}
}
