package question34;

public class PrintNumberInWord {
	static int number = 7;

	public static void printNested() {
		if(number != 1) {
			if(number != 2) {
				if(number != 3) {
					if(number != 4) {
						if(number != 5) {
							if(number != 6) {
								if(number != 7) {
									if(number != 8 ) {
										if(number != 9) {
											System.out.println("OTHER");
										}
										else {
											System.out.println("NINE");
										}
									}
									else {
										System.out.println("EIGHT");
									}
								}
								else {
									System.out.println("SEVEN");
								}
							}
							else {
								System.out.println("SIX");
							}
						}
						else {
							System.out.println("FIVE");
						}
					}
					else {
						System.out.println("FOUR");
					}
				}
				else {
					 System.out.println("THREE");
				 }		
			}
			else {
				 System.out.println("TWO");
			 }
		}
		else {
			System.out.println("ONE");
		}
	}

	public static void printSwitch() {
		switch (number) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		case 6:
			System.out.println("SIX");
			break;
		case 7:
			System.out.println("SEVEN");
			break;
		case 8:
			System.out.println("EIGHT");
			break;
		case 9:
			System.out.println("NINE");
			break;
		default:
			System.out.println("OTHER");
		}
	}
}
