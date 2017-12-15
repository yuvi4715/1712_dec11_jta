package question7_8;

public class customers {
	String[] maleList = {"men's wear"};
	String[] femaleList = {"women's wear"};
	char gender;
	int money;
	static final boolean shopping = true;
	
	customers(char gender, int money) {
		this.gender = gender;
		this.money = money;
		//getShoppingList(gender, money);
		
	}
	
	customers(char gender) {
		this.gender = gender;
		//getShoppingList(gender);
	}

	public void findShoppingList() {
		if (money == 0) {
			getShoppingList(gender);
		}
		else {
			getShoppingList(gender, money);
		}
	}
	public void getShoppingList(char gender, int money) {
			switch(gender) {
			case 'm':
				if(money >= 3) {
					System.out.println(maleList[0]);
				}
				else {
					System.out.println("Sorry, you don't have enough money for the male shopping list");
				}
				break;
			case 'f':
				if(money >= 4) {
					System.out.println(femaleList[0]);
				}
				else {
					System.out.println("Sorry, you don't have enough money for the female shopping list");
				}
				break;
			default :
				System.out.println("Sorry, don't know that gender");
			}
	}
	public void getShoppingList(char gender) {
		System.out.println("There is no given currency but based on your gender, you can buy this: ");
		switch(gender) {
		case 'm':
			System.out.println(maleList[0]);
			break;
		case 'f':
			System.out.println(femaleList[0]);
			break;
		default :
			System.out.println("Sorry, don't know that gender");
		}
	}
	static void checkGender(char gender) {
		switch(gender) {
		case 'm':
			System.out.println("male");
			break;
		case 'f':
			System.out.println("female");
			break;
		default:
			System.out.println("unkown");
		}
	}
	static void checkMoney(int money) {
		System.out.printf("This is%senough money for men and it is%senough money for women",
				money < 3 ? " not " : " ", money < 4 ? " not " : " ");
	}
}
/*At least 2 constructors check
At least 2 overloaded methods check
At least 1 static variable check
At least 2 static methods check
At least 1 final variable check
*/
